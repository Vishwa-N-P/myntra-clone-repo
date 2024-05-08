<%@ include file="/init.jsp" %>
<%@ include file="/nav-bar.jsp" %>


<%
    List<JSONObject> productsList = (List<JSONObject>) portletSession.getAttribute("productsList");
    List<Brand> brands = (List<Brand>) portletSession.getAttribute("brands");
    String gender = (String) portletSession.getAttribute("gender");
    //List<Long> wishlistProducts = (List<Long>) renderRequest.getAttribute("wishlistProducts");
%>



<%-- <portlet:renderURL var="viewProductURL" >
    <portlet:param name="mvcRenderCommandName" value="<%= MVCCommandNames.VIEW_PRODUCT %>" />
    <portlet:param name="productId" value="${product.id}" />
    <portlet:param name="isWishlisted" value="${isWishlisted}" />
    <portlet:param name="gender" value="${gender}" />
</portlet:renderURL> --%>

<portlet:renderURL var="productFilterURL" >
    <portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_PRODUCTS %>" />
    <portlet:param name="filter" value="true" />
    <portlet:param name="gender" value="<%= gender %>" />
</portlet:renderURL>

<portlet:renderURL var="viewCategoryURL" >
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_CATEGORY %>" />
</portlet:renderURL>




<div id="errorDiv">
    <c:if test='<%=SessionMessages.contains(renderRequest, "added-to-wishlist") %>'>
        <liferay-ui:success key="added-to-wishlist" message="Added To Wishlist Successfully"/>
    </c:if>
    <c:if test='<%=SessionMessages.contains(renderRequest, "deleted-from-wishlist") %>'>
        <liferay-ui:success key="deleted-from-wishlist" message="Deleted From Wishlist Successfully"/>
    </c:if>
	<c:if test='<%=SessionErrors.contains(renderRequest, "user-not-found") %>'>
		<liferay-ui:error key="user-not-found" message="User not found" />
	</c:if>
	<c:if test='<%=SessionErrors.contains(renderRequest, "no-category-found") %>'>
        <liferay-ui:error key="no-category-found" message="Requested category not found" />
    </c:if>
    <c:if test='<%=SessionErrors.contains(renderRequest, "no-product-exists") %>'>
        <liferay-ui:error key="no-product-exists" message="Requested item not found" />
    </c:if>
    <c:if test='<%=SessionErrors.contains(renderRequest, "no-user-wishlist-exists") %>'>
        <liferay-ui:error key="no-user-wishlist-exists" message="User wishlist not found" />
    </c:if>
</div>

<%
    String[] filterBrands = (String[]) request.getAttribute("checkedBrands");
    List<String> checkedBrands = filterBrands != null ? Arrays.asList(filterBrands) : new ArrayList<>();
    boolean isBrandsExists = checkedBrands.isEmpty();

    String[] filterPrices = (String[]) request.getAttribute("checkedPrices");
    List<String> checkedPrices = filterPrices != null ? Arrays.asList(filterPrices) : new ArrayList<>();
    boolean isPricesExists = checkedPrices.isEmpty();

    String[] filterDiscounts = (String[]) request.getAttribute("checkedDiscounts");
    List<String> checkedDiscounts = filterDiscounts != null ? Arrays.asList(filterDiscounts) : new ArrayList<>();
    boolean isDiscountsExists = checkedDiscounts.isEmpty();
%>

<div class="row-box" >

    <%-- <c:set var="productsList" value="${sessionScope.productsList}" />
    <c:if test='<%=SessionErrors.contains(renderRequest, "no-products-exists") %>'> --%>
    <c:if test='<%=SessionErrors.contains(renderRequest, "no-products-exists") || productsList.isEmpty() %>'>
    <%-- <c:if test="${empty sessionScope.productsList}">
    <c:if test="${empty productsList}"> --%>
        <div class="empty-wish-cart-box-1" >
            <div class="empty-wish-box-2" >
                <div class="empty-wish-cart-box-3">
                    <div class="empty-prds-image-div"> <img class="empty-wish-cart-img" src="https://constant.myntassets.com/web/assets/img/11488523304066-search404.png" ></div>
                    <p class="empty-wish-cart-hdng" >Sorry, there is no items</p>
                    <p class="empty-wish-cart-txt" >We will make requested items available soon..</p>
                    <%-- <aui:button cssClass="empty-prds-btn " href="${viewCategoryURL}" type="button" value="CONTINUE SHOPPING" /> --%>
                    <a class="a-go-to-crt" href="${viewCategoryURL}" >
                        <button class="empty-prds-btn rm-btn-brd" type="button" >CONTINUE SHOPPING</button>
                    </a>
                </div>
            </div>
        </div>
    </c:if>

    <c:if test='<%= !SessionErrors.contains(renderRequest, "no-products-exists") %>'>
    <c:if test="<%= !productsList.isEmpty() %>">
        <%-- <c:if test="<%= !brands.isEmpty() %>">
    <c:if test="${not empty sessionScope.productsList}">
        <c:if test="${not empty sessionScope.brands}">
    <c:if test="${not empty productsList}">
        <c:if test="${not empty brands}"> --%>
        <hr>

        <div class="filter-block" >

            <div class="filter-form" >
                <form action="${productFilterURL}" method="post">

                    <div class="submit-div">
                       <button class="submit-btn" type="submit">FILTER</button>
                    </div>

                    <hr>

                    <div class="filter-box" >
                        <p class="filter-head" >BRANDS</p>
                        <%-- <c:set var="checkedBrands" value="${checkedBrands}" /> --%>

                        <%
                            for (Brand brand : brands) {
                        %>
                        <%-- <c:forEach items="<%= brands %>" var="brand">
                        <c:forEach items="${sessionScope.brands}" var="brand">
                        <c:forEach items="${brands}" var="brand"> --%>
                            <%-- <c:set var="brandId" value="${brand.id}"/>
                            <c:set var="isChecked" value="${fn:contains(checkedBrands, brand.id)}"/>
                            <c:set var="isChecked" value="${checkedBrands.contains(String.valueOf(brand.id))}"/> --%>
                            <div class="check-box" >
                                <input id="<%= brand.getId() %>" class="chk-bx" type="checkbox" name="<portlet:namespace/>selectedBrand" value="<%= brand.getId() %>" <%= !isBrandsExists && checkedBrands.contains(String.valueOf(brand.getId())) ? "checked" : "" %> />
                                <%-- <input id="${brand.id}" class="chk-bx" type="checkbox" name="<portlet:namespace/>selectedBrand" value="${brand.id}" /> --%>
                                <label for="<%= brand.getId() %>" class="lbl-txt"><%= brand.getBrandName() %></label>
                            </div>
                        <%-- </c:forEach> --%>
                        <%
                            }
                        %>
                    </div>

                    <hr>

                    <div class="filter-box" >
                        <p class="filter-head" >PRICE</p>
                        <div class="check-box" >
                            <input id="prc1" class="chk-bx" type="checkbox" name="<portlet:namespace/>selectedPrice"
                            value="100 - 500" <%= !isPricesExists && checkedPrices.contains("100 - 500") ? "checked" : "" %>/>
                            <label for="prc1" class="lbl-txt"> Rs. 100 to 500</label>
                        </div>
                        <div class="check-box" >
                            <input id="prc2" class="chk-bx" type="checkbox" name="<portlet:namespace/>selectedPrice"
                            value="501 - 1000" <%= !isPricesExists && checkedPrices.contains("501 - 1000") ? "checked" : "" %>/>
                            <label for="prc2" class="lbl-txt"> Rs. 501 to 1000</label>
                        </div>
                            <div class="check-box" >
                            <input id="prc3" class="chk-bx" type="checkbox" name="<portlet:namespace/>selectedPrice"
                            value="1001 - 1500" <%= !isPricesExists && checkedPrices.contains("1001 - 1500") ? "checked" : "" %>/>
                            <label for="prc3" class="lbl-txt"> Rs. 1001 to 1500</label>
                        </div>
                        <div  class="check-box" >
                            <input id="prc4" class="chk-bx" type="checkbox" name="<portlet:namespace/>selectedPrice"
                            value="1501 - 7500" <%= !isPricesExists && checkedPrices.contains("1501 - 7500") ? "checked" : "" %>/>
                            <label for="prc4" class="lbl-txt"> Rs. 1501 to 7500</label>
                        </div>
                    </div>

                    <hr>

                    <div class="filter-box" >
                        <p class="filter-head" >DISCOUNTS</p>
                        <div class="check-box" >
                            <input id="ten" class="chk-bx" type="checkbox" name="<portlet:namespace/>selectedDiscount"
                            value="10 - 19" <%= !isDiscountsExists && checkedDiscounts.contains("10 - 19") ? "checked" : "" %>/>
                            <label for="ten" class="lbl-txt"> 10% to 19%</label>
                        </div>
                        <div class="check-box" >
                            <input id="twenty" class="chk-bx" type="checkbox" name="<portlet:namespace/>selectedDiscount"
                            value="20 - 29" <%= !isDiscountsExists && checkedDiscounts.contains("20 - 29") ? "checked" : "" %>/>
                            <label for="twenty" class="lbl-txt"> 20% to 29%</label>
                        </div>
                            <div class="check-box" >
                            <input id="thirty" class="chk-bx" type="checkbox" name="<portlet:namespace/>selectedDiscount"
                            value="30 - 39" <%= !isDiscountsExists && checkedDiscounts.contains("30 - 39") ? "checked" : "" %>/>
                            <label for="thirty" class="lbl-txt"> 30% to 39%</label>
                        </div>
                        <div  class="check-box" >
                            <input id="forty" class="chk-bx" type="checkbox" name="<portlet:namespace/>selectedDiscount"
                            value="40 - 49" <%= !isDiscountsExists && checkedDiscounts.contains("40 - 49") ? "checked" : "" %>/>
                            <label for="forty" class="lbl-txt"> 40% to 49%</label>
                        </div>
                        <div  class="check-box" >
                            <input id="fifty" class="chk-bx" type="checkbox" name="<portlet:namespace/>selectedDiscount"
                            value="50 - 59" <%= !isDiscountsExists && checkedDiscounts.contains("50 - 59") ? "checked" : "" %>/>
                            <label for="fifty" class="lbl-txt"> 50% to 59%</label>
                        </div>
                        <div  class="check-box" >
                            <input id="sixty" class="chk-bx" type="checkbox" name="<portlet:namespace/>selectedDiscount"
                            value="60 - 69" <%= !isDiscountsExists && checkedDiscounts.contains("60 - 69") ? "checked" : "" %>/>
                            <label for="sixty" class="lbl-txt"> 60% to 69%</label>
                        </div>
                        <div  class="check-box" >
                            <input id="seventy" class="chk-bx" type="checkbox" name="<portlet:namespace/>selectedDiscount"
                            value="70 - 90" <%= !isDiscountsExists && checkedDiscounts.contains("70 - 90") ? "checked" : "" %>/>
                            <label for="seventy" class="lbl-txt"> 70% to 90%</label>
                        </div>
                    </div>
                </form>
            </div>


        </div>

        <div class="product-box" >
            <c:forEach items="<%= productsList %>" var="jsonProduct" >
            <%-- <c:forEach items="${sessionScope.productsList}" var="jsonProduct" >
            <c:forEach items="${productsList}" var="jsonProduct" > --%>
                <c:set var="product" value="${jsonProduct.get('product')}"/>

                    <div class="product-div" >

                        <c:if test="${empty wishlistProducts}">
                            <c:set var="isWishlisted" value="false" />
                        </c:if>
                        <c:if test="${not empty wishlistProducts}">
                            <c:set var="isWishlisted" value="${wishlistProducts.contains(product.id)}" />
                        </c:if>

                        <portlet:renderURL var="viewProductURL" >
                            <portlet:param name="mvcRenderCommandName" value="<%= MVCCommandNames.VIEW_PRODUCT %>" />
                            <portlet:param name="productId" value="${product.id}" />
                            <portlet:param name="isWishlisted" value="${isWishlisted}" />
                            <portlet:param name="gender" value="${gender}" />
                        </portlet:renderURL>

                        <a href="${viewProductURL}">
                            <div class="product-img-div" >
                                <img class="product-img" src="${jsonProduct.getString('image')}" >
                            </div>
                            <div class="product-content-div" >
                                <p class="brand-name">${jsonProduct.getString('brand')}</p>
                                <c:choose>
                                    <c:when test="${fn:length(product.productInfo) > 32}">
                                        <c:set var="truncatedInfo" value="${fn:substring(product.productInfo, 0, 32)}" />
                                        <p class="product-dscrptn">${truncatedInfo}...</p>
                                    </c:when>
                                    <c:otherwise>
                                        <p class="product-dscrptn">${product.productInfo}</p>
                                    </c:otherwise>
                                </c:choose>

                                <div class="product-price-div" >
                                     <span class="brand-name" >Rs.${product.finalPrice}</span>
                                     <span class="product-mrp" ><del>Rs.${product.price}</del></span>
                                     <span class="product-discunt">(${product.discountPercentage}% OFF)</span>
                                </div>
                            </div>

                            <div class="wishlist-icon-div" >

                                <c:if test="${!isWishlisted}">
                                    <portlet:actionURL name="<%= MVCCommandNames.SAVE_WISHLIST_PRODUCT %>" var="addProductToWishlistURL" >
                                        <portlet:param name="productId" value="${product.id}" />
                                        <portlet:param name="jspPage" value="/products.jsp" />
                                        <%-- <portlet:param name="gender" value="${gender}" /> --%>
                                        <portlet:param name="redirectURL" value="${redirectURL}" />
                                        <portlet:param name="productsPage" value="true" />
                                    </portlet:actionURL>
                                    <a class="icon-not-wishlisted" href="${addProductToWishlistURL}">
                                        &#9825;
                                    </a>
                                </c:if>

                                <c:if test="${isWishlisted}">
                                    <portlet:actionURL name="<%= MVCCommandNames.DELETE_WISHLIST_PRODUCT %>" var="deleteProductFromWishlistURL" >
                                        <portlet:param name="productId" value="${product.id}" />
                                        <portlet:param name="jspPage" value="/products.jsp" />
                                        <%-- <portlet:param name="wishlistId" value="${wishlistId}" />
                                        <portlet:param name="gender" value="${gender}" /> --%>
                                        <portlet:param name="redirectURL" value="${redirectURL}" />
                                        <portlet:param name="productsPage" value="true" />
                                    </portlet:actionURL>
                                    <a class="icon-wishlisted" href="${deleteProductFromWishlistURL}">
                                        <i class="fa fa-heart prds-hrt"></i>
                                    </a>
                                </c:if>

                            </div>
                        </a>

                    </div>
            </c:forEach>
        </div>
    </c:if>
    </c:if>

</div>



<script>

    <%-- var productFilterURL = '<%= productFilterURL %>';

    window.addEventListener("beforeunload", function () {
        // Navigate to the stored URL
        window.location.href = productFilterURL;
        console.log("window.location.href = productFilterURL;");
    }); --%>

    setTimeout(function () {
        $('#errorDiv').fadeOut(1000, 'linear');
    }, 5000);

</script>

<%-- <script type="text/javascript">
    // Define the URL you want to load after refresh
    var targetUrl = "${redirectURL}";
    console.log("window.11111");

    window.addEventListener('beforeunload', function(event) {
        console.log("window.2222");

            // Check if the user is refreshing using Ctrl+R or browser refresh button
            if ((event || window.event).ctrlKey) {
                // Navigate to the target URL
                console.log("window.3333");
                window.location.href = targetUrl;
                console.log("window.4444");

            }
        });
</script> --%>








