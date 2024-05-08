<%@ include file="/init.jsp" %>
<%@ include file="/nav-bar.jsp" %>

<%
    String gender = (String) portletSession.getAttribute("gender");
%>

<portlet:renderURL var="viewCartListProductURL" >
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_CART_LIST_PRODUCT %>"/>
	<portlet:param name="isWishlisted" value="${isWishlisted}" />
</portlet:renderURL>

<portlet:renderURL var="viewProductsURL" >
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_PRODUCTS %>"/>
	<portlet:param name="gender" value="${gender}" />
</portlet:renderURL>

<portlet:renderURL var="viewProductURL" >
    <portlet:param name="mvcRenderCommandName" value="<%= MVCCommandNames.VIEW_PRODUCT %>" />
    <portlet:param name="productId" value="${productId}" />
    <portlet:param name="isWishlisted" value="${isWishlisted}" />
    <portlet:param name="gender" value="${gender}" />
</portlet:renderURL>


<div id="errorDiv">
    <c:if test='<%=SessionMessages.contains(renderRequest, "added-to-bag") %>'>
        <liferay-ui:success key="added-to-bag" message="Added to Bag"/>
    </c:if>
    <c:if test='<%=SessionMessages.contains(renderRequest, "already-added-to-bag") %>'>
        <liferay-ui:success key="already-added-to-bag" message="You have this item in your bag"/>
    </c:if>
    <c:if test='<%=SessionErrors.contains(renderRequest, "user-not-found") %>'>
    		<liferay-ui:error key="user-not-found" message="User not found" />
    </c:if>
    <c:if test='<%=SessionMessages.contains(renderRequest, "added-to-wishlist") %>'>
        <liferay-ui:success key="added-to-wishlist" message="Added to Wishlist"/>
    </c:if>
</div>



<%
    //String selectedSize = (String) portletSession.getAttribute("selectedSize");

    //PortletSession session = request.getPortletSession();
    //Highlights highlights = (Highlights) session.getAttribute("highlights");

    //String gender = (String) portletSession.getAttribute("gender");
    /*Product product = (Product) portletSession.getAttribute("product");
    List<Image> images  = (List<Image>) portletSession.getAttribute("images");
    String brand  = (String) portletSession.getAttribute("brand");
    Highlights highlights = (Highlights) portletSession.getAttribute("highlights");*/

    //Highlights highlights = (Highlights) request.getAttribute("highlights");
    /*String[] sizes = null;
    String[] features = null;
    if (Validator.isNotNull(highlights)) {
        sizes = highlights.getSize().split(",");
        features = highlights.getFeatures().split(",");
    }*/
%>

<div class="display" >

    <c:if test='${SessionErrors.contains(renderRequest, "no-product-exists") || empty product}'>
    <%-- <c:if test='<%= SessionErrors.contains(renderRequest, "no-product-exists") || Validator.isNull(product) %>'>
    <c:if test='<%=SessionErrors.contains(renderRequest, "no-product-exists") %>'>
    <c:if test="${empty sessionScope.product}"> --%>
    <%-- <c:if test="${empty product}"> --%>
        <div class="empty-wish-cart-box-1" >
            <div class="empty-wish-box-2" >
                <div class="empty-wish-cart-box-3">
                    <div class="empty-prds-image-div"> <img class="empty-wish-cart-img" src="https://constant.myntassets.com/web/assets/img/11488523304066-search404.png" ></div>
                    <p class="empty-wish-cart-hdng" >Sorry, there is no requested item</p>
                    <p class="empty-wish-cart-txt" >We will make it available soon..</p>
                    <%-- <aui:button cssClass="empty-cart-btn" href="${viewProductsURL}" type="button" value="CONTINUE SHOPPING" /> --%>
                    <a class="a-go-to-crt" href="${viewProductsURL}" >
                        <button class="empty-cart-btn rm-btn-brd" type="button" >CONTINUE SHOPPING</button>
                    </a>
                </div>
            </div>
        </div>
    </c:if>

    <%-- <c:if test="<%= Validator.isNotNull(product) %>">
        <c:set var="productId" value="<%= product.getId() %>"/>
    <c:if test="${not empty sessionScope.product}">
        <c:set var="product" value="${sessionScope.product}"/> --%>

    <c:if test="${not empty product}">
        <c:set var="productId" value="${product.id}"/>

            <div class="col-img">
                <%-- <c:if test="<%= !images.isEmpty() %>">
                    <c:forEach items="<%= images %>" var="image" > --%>
                <c:if test="${not empty images}">
                    <c:forEach items="${images}" var="image" >
                        <div class="img-card">
                            <img class="img-copy" src="${image.imageUrl}" >
                        </div>
                    </c:forEach>
                </c:if>
            </div>

            <div class="col-text">
                <div class="box-1" >

                    <%-- <p class="text-1"><b>${sessionScope.brand}</b></p> --%>
                    <p class="text-1"><b>${brand}</b></p>
                    <p class="text-2" >${product.productName}</p>
                    <%-- <p class="text-1"><b><%= brand %></b></p>
                    <p class="text-2" ><%= product.getProductName() %></p> --%>
                    <div class="rating-row" >
                        <fmt:formatNumber value="${product.rating}" pattern="#0.0" var="formattedRating" />
                        <fmt:formatNumber value="${product.ratingCount / 1000}" pattern="#0.0" var="formattedCount" />
                        <p class="rating-star">${formattedRating} <i class="fa-solid fa-star"></i></p>
                        <p class="rating-star"> | </p>
                        <p class="rating-star">Ratings ${formattedCount}k</p>

                        <%-- <fmt:formatNumber value="<%= product.getRating() %>" pattern="#0.0" var="formattedRating" />
                        <fmt:formatNumber value="<%= product.getRatingCount() / 1000 %>" pattern="#0.0" var="formattedCount" />
                        <p class="rating-star">${formattedRating} <i class="fa-solid fa-star"></i></p>
                        <p class="rating-star"> | </p>
                        <p class="rating-star">Ratings ${formattedCount}k</p> --%>
                    </div>

                </div>
                <hr>

                <div class="box-2" >
                    <div class="price-row" >
                        <p class="price-col-1">Rs ${product.finalPrice}</p>
                        <p class="price-col-1 price-col-1-clr " style="color:grey;">MRP <del>${product.price}</del></p>
                        <p class="price-col-1 price-col-1-clr2" style="color:orange;">(${product.discountPercentage}% OFF)</p>

                        <%-- <p class="price-col-1">Rs <%= product.getFinalPrice() %></p>
                        <p class="price-col-1 price-col-1-clr " style="color:grey;">MRP <del><%= product.getPrice() %></del></p>
                        <p class="price-col-1 price-col-1-clr2" style="color:orange;">(<%= product.getDiscountPercentage() %>% OFF)</p> --%>
                    </div>

                    <p class="info-txt" style="color:green;">Inclusive of all taxes</p>

                    <p class="sz-col-1" >SELECT SIZE..</p>

                    <%-- <div class="size-row" >
                        <c:forEach items="<%= sizes %>" var="size" >
                            <div class="size-col" >
                                <input id="${size}" class="select-sz-rdo" type="radio" name="<portlet:namespace/>size" value="${size}"/>
                                 <label for="${size}" class="select-sz-rdo-lbl" >${size}</label>
                            </div>
                        </c:forEach>
                    </div>

                    <div class="button-row" >
                        <div class="a-button-1"  >
                            <c:if test="${!isCartListed}">

                                <portlet:actionURL name="<%= MVCCommandNames.SAVE_CART_LIST_PRODUCT %>" var="addProductToCartURL" >
                                    <portlet:param name="productId" value="${productId}" />
                                    <portlet:param name="isWishlisted" value="${isWishlisted}" />
                                    <portlet:param name="jspPage" value="/product.jsp" />
                                </portlet:actionURL>

                                <aui:button  href="${addProductToCartURL}" cssClass="crt-btn-wish add-to-crt-btn" type="button" value="ADD TO CART" onclick="checkSize(event)" />
                            </c:if>
                            <c:if test="${isCartListed}">
                                <aui:button  href="${viewCartListProductURL}" cssClass="crt-btn-wish go-to-crt-btn" type="button"value="Go to Cart" />
                            </c:if>
                        </div>
                        <div class="a-button-2" >
                              <c:if test="${!isWishlisted}">

                                  <portlet:actionURL name="<%= MVCCommandNames.SAVE_WISHLIST_PRODUCT %>" var="addProductToWishlistURL" >
                                      <portlet:param name="productId" value="${productId}" />
                                      <portlet:param name="isCartListed" value="${isCartListed}" />
                                      <portlet:param name="jspPage" value="/product.jsp" />
                                  </portlet:actionURL>

                                  <aui:button cssClass="crt-btn-wish add-to-wish-btn" href="${addProductToWishlistURL}"  type="button" value="ADD TO WISHLIST" />
                              </c:if>
                              <c:if test="${isWishlisted}">
                                  <aui:button cssClass="crt-btn-wish go-to-wish-btn" href="${viewWishlistProductURL}"  type="button" value="GO TO WISHLIST" />
                              </c:if>
                        </div>
                    </div> --%>

                    <portlet:actionURL name="<%= MVCCommandNames.SAVE_CART_LIST_PRODUCT %>" var="addProductToCartURL" >
                        <portlet:param name="productId" value="${productId}" />
                        <portlet:param name="isWishlisted" value="${isWishlisted}" />
                        <portlet:param name="jspPage" value="/product.jsp" />
                        <portlet:param name="redirectURL" value="${redirectURL}" />
                    </portlet:actionURL>

                    <c:if test="${not empty highlights}">
                        <c:set var="sizes" value="${fn:split(highlights.size, ',')}" />

                        <form action="${addProductToCartURL}" method="post">
                            <div class="size-row" >
                                <c:if test="${not empty selectedSize}">
                                <%-- <c:if test="<%= selectedSize != null %>">
                                <c:if test="${not empty param.selectedSize}">
                                    <c:set var="clothSize" value="<%= selectedSize %>" /> --%>
                                    <c:set var="isSize" value="true" />
                                </c:if>
                                <%-- <c:forEach items="<%= sizes %>" var="size" > --%>
                                <c:forEach items="${sizes}" var="size" >
                                    <div class="size-col" >
                                        <%-- <input id="${size}" class="select-sz-rdo" type="radio" name="<portlet:namespace/>size" value="${size}"/> --%>
                                        <input id="${size}" class="select-sz-rdo" type="radio" name="<portlet:namespace/>size" value="${size}" <c:if test="${isSize}"><c:if test="${size eq selectedSize}">checked</c:if></c:if>/>
                                        <label for="${size}" class="select-sz-rdo-lbl" >${size}</label>
                                    </div>
                                </c:forEach>
                            </div>
                            <div class="button-row" >
                                <div class="a-button-1"  >
                                    <c:if test="${!isSize}">
                                    <%-- <c:if test="${!isCartListed}"> --%>
                                        <button class="crt-btn-wish add-to-crt-btn" type="submit" onclick="checkSize(event)" ><i class="fa-solid fa-bag-shopping"></i> ADD TO BAG</button>
                                    </c:if>
                                    <c:if test="${isSize}">
                                    <%-- <c:if test="${isCartListed}">
                                        <aui:button  href="${viewCartListProductURL}" cssClass="crt-btn-wish go-to-crt-btn" type="button"value="Go to Bag ->" /> --%>
                                        <a class="a-go-to-crt" href="${viewCartListProductURL}" >
                                            <button class="crt-btn-wish add-to-crt-btn" type="button" >GO TO BAG <span class="wish-cart-arw"><i class="fa-solid fa-arrow-right"></i></span></button>
                                        </a>
                                    </c:if>
                                </div>
                                <div class="a-button-2" >
                                      <c:if test="${!isWishlisted}">

                                          <portlet:actionURL name="<%= MVCCommandNames.SAVE_WISHLIST_PRODUCT %>" var="addProductToWishlistURL" >
                                              <portlet:param name="productId" value="${productId}" />
                                              <portlet:param name="isCartListed" value="${isCartListed}" />
                                              <portlet:param name="jspPage" value="/product.jsp" />
                                              <portlet:param name="redirectURL" value="${redirectURL}" />
                                          </portlet:actionURL>

                                          <%-- <aui:button cssClass="crt-btn-wish add-to-wish-btn" href="${addProductToWishlistURL}"  type="button" value="ADD TO WISHLIST" /> --%>
                                          <a class="a-go-to-crt" href="${addProductToWishlistURL}" >
                                               <button class="add-to-wish-btn" type="button" > <span class="wish-cart-arw">&#9825;</span> ADD TO WISHLIST</button>
                                          </a>
                                      </c:if>
                                      <c:if test="${isWishlisted}">
                                          <%-- <aui:button cssClass="crt-btn-wish go-to-wish-btn" href="${viewWishlistProductURL}"  type="button" value="Go to Wishlist ->" /> --%>
                                          <a class="a-go-to-crt" href="${viewWishlistProductURL}" >
                                              <button class="add-to-wish-btn go-to-wish-btn" type="button" ><i class="fa fa-heart prds-hrt"></i> WISHLISTED</button>
                                          </a>
                                      </c:if>
                                </div>
                            </div>
                        </form>
                    </c:if>

                    <hr>

                    <div class="prd-txt" >
                        <p class="prd-txt-1 price-col-1" >DELIVERY OPTIONS</p>
                        <p class="prd-txt-2" >100% Original Products</p>
                        <p class="prd-txt-2" >Pay on delivery might be available</p>
                        <p class="prd-txt-2" >Easy 30 days returns and exchanges</p>
                        <p class="prd-txt-2" >Try & Buy might be available</p>
                    </div>
                    <hr>

                    <c:if test="${not empty highlights}">
                        <c:set var="features" value="${fn:split(highlights.features, ',')}" />
                        <div class="prd-txt2" >
                            <p class="prd-txt-1 price-col-1" >PRODUCT DETAILS</p>
                            <c:forEach items="${features}" var="feature" >
                            <%-- <c:forEach items="<%= features %>" var="feature" > --%>
                                <p class="prd-txt-2" >${feature}</p>
                            </c:forEach>
                        </div>
                    </c:if>
                    <hr>

                </div>
            </div>
    </c:if>
</div>


<script>

    function checkSize(event) {
      var selectedSize = document.querySelector('input[name="<portlet:namespace/>size"]:checked');

      if (!selectedSize) {
        alert("Please select a size before adding to cart.");
        event.preventDefault();
      }
    }

    setTimeout(function () {
        $('#errorDiv').fadeOut(1000, 'linear');
    }, 5000);


    <%-- var productURL = '<%= viewProductURL %>';

        window.addEventListener("beforeunload", function () {
            // Navigate to the stored URL
            window.location.href = productURL;
            console.log("window.location.href = productURL;");
        }); --%>


</script>
