<%@ include file="/init.jsp" %>
<%@ include file="/nav-bar.jsp" %>

<%-- <portlet:actionURL name="<%= MVCCommandNames.SAVE_CART_LIST_PRODUCT %>" var="addProductToCartURL" >
    <portlet:param name="productId" value="${product.id}" />
    <portlet:param name="wishlistId" value="${wishlistId}" />
    <portlet:param name="moveToCart" value="true" />
    <portlet:param name="jspPage" value="/wishlist-products.jsp" />
</portlet:actionURL> --%>



<portlet:renderURL var="viewCategoryURL" >
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_CATEGORY %>"/>
</portlet:renderURL>



<div id="errorDiv">
    <c:if test='<%=SessionMessages.contains(renderRequest, "deleted-from-wishlist") %>'>
        <liferay-ui:success key="deleted-from-wishlist" message="Moved to Bag"/>
    </c:if>
	<c:if test='<%=SessionErrors.contains(renderRequest, "user-not-found") %>'>
		<liferay-ui:error key="user-not-found" message="User not found" />
	</c:if>
	<c:if test='<%=SessionErrors.contains(renderRequest, "no-product-exists") %>'>
        <liferay-ui:error key="no-product-exists" message="Requested item not found" />
    </c:if>
    <c:if test='<%=SessionErrors.contains(renderRequest, "no-user-wishlist-exists") %>'>
        <liferay-ui:error key="no-user-wishlist-exists" message="User wishlist not found" />
    </c:if>
    <c:if test='<%=SessionErrors.contains(renderRequest, "select-size") %>'>
        <liferay-ui:error key="select-size" message="Please select size" />
    </c:if>
</div>



<div class="wishlist-box-1" >

    <c:if test="${empty wishlistProducts || SessionErrors.contains(renderRequest, 'no-product-exists')}">
    <%-- <c:if test="${empty wishlistProducts}">
    <c:if test='<%=SessionErrors.contains(renderRequest, "no-product-exists") %>'>  --%>
        <div class="empty-wish-cart-box-1" >
            <div class="empty-wish-box-2" >
                <div class="empty-wish-cart-box-3">
                    <div class="emty-wish-image-div"> <img class="empty-wish-cart-img" src="https://www.digitalwelkin.com/images/emptywishlist.jpg" ></div>
                    <p class="empty-wish-cart-hdng" >Hey, your wishlist is empty!</p>
                    <p class="empty-wish-cart-txt" >Add items that you like to your wishlist. Review them anytime and easilymove them to the bag.</p>
                    <%-- <aui:button cssClass="empty-cart-btn" href="${viewCategoryURL}" type="button" value="CONTINUE SHOPPING" /> --%>
                    <a class="a-go-to-crt" href="${viewCategoryURL}" >
                        <button class="empty-prds-btn rm-btn-brd" type="button" >CONTINUE SHOPPING</button>
                    </a>
                </div>
            </div>
        </div>
    </c:if>

    <c:if test="${not empty wishlistProducts}">
        <div class="wishlist-box-2" >

            <p class="wishlist-head-txt"><b>MY WISHLISTS<b class="items-count"> (${productsCount} items)</p>
            <div class="wishlist-row" >

                <c:forEach items="${wishlistProducts}" var="jsonProduct" >
                    <c:set var="product" value="${jsonProduct.get('product')}"/>

                    <div class="wishlist-prd" >

                        <div class="wishlist-prd-img-div" >
                            <img class="wishlist-prd-img" src="${jsonProduct.getString('image')}" >
                        </div>

                        <div class="wishlist-prd-txt-div" >

                            <c:choose>
                                <c:when test="${fn:length(product.productInfo) > 22}">
                                    <c:set var="truncatedInfo" value="${fn:substring(product.productInfo, 0, 22)}" />
                                    <p class="wishlist-text-2" >${truncatedInfo}...</p>
                                </c:when>
                                <c:otherwise>
                                    <p class="wishlist-text-2" >${product.productInfo}</p>
                                </c:otherwise>
                            </c:choose>

                            <div class="wishlist-price-row" >
                                <p class="wishlist-rating-col-1">Rs.${product.finalPrice}</p>
                                <%-- <p class="wishlist-rating-col-2">MRP <del>${product.price}</del></p>
                                <p class="wishlist-rating-col-3">(${product.discountPercentage}% OFF)</p> --%>
                            </div>

                            <portlet:actionURL name="<%= MVCCommandNames.DELETE_WISHLIST_PRODUCT %>" var="addToCartAndDeleteFromWishlistURL" >
                                <portlet:param name="wishlistId" value="${wishlistId}" />
                                <portlet:param name="productId" value="${product.id}" />
                                <portlet:param name="moveToCart" value="true" />
                                <portlet:param name="jspPage" value="/wishlist-products.jsp" />
                                <portlet:param name="redirectURL" value="${redirectURL}" />
                            </portlet:actionURL>

                            <div class="wish-form" >

                                <div class="wishlist-button-row">
                                    <div class="button-1">
                                        <button class="move-to-crt-btn" type="button" onclick="showWishPrdSizePopup('${product.id}')">MOVE TO BAG</button>
                                    </div>
                                </div>
                                <form id="form_${product.id}" action="${addToCartAndDeleteFromWishlistURL}" method="post" >
                                    <div class="wish-prd-sz-popup" id="wishPrdPopup_${product.id}">
                                        <div class="wishlist-rdo-btn-div" >
                                            <label class="wish-lbl" for="${product.id}">Select Size :</label>
                                            <select class="wish-slct" id="${product.id}" name="<portlet:namespace/>size" onchange="checkAndSubmit(this)">
                                             <option value="">Select</option>
                                                <c:forEach items="${jsonProduct.getString('sizes')}" var="size">
                                                    <option value="${size}">${size}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </form>

                            </div>
                        </div>
                        <div class="cart-button-row" >

                            <portlet:actionURL name="<%= MVCCommandNames.DELETE_WISHLIST_PRODUCT %>" var="deleteProductFromWishlistURL" >
                                <portlet:param name="wishlistId" value="${wishlistId}" />
                                <portlet:param name="productId" value="${product.id}" />
                                <portlet:param name="jspPage" value="/wishlist-products.jsp" />
                                <portlet:param name="redirectURL" value="${redirectURL}" />
                            </portlet:actionURL>

                            <a class="cart-close-icon" href="${deleteProductFromWishlistURL}" value="Remove" >
                               &#10006;
                            </a>
                        </div>

                    </div>
                </c:forEach>
            </div>

        </div>
    </c:if>
</div>



<script>

    function showWishPrdSizePopup(productId) {
        var productSizePopup = document.getElementById('wishPrdPopup_' + productId);

        var allPopups = document.querySelectorAll('.wish-prd-sz-popup');
        for (var i = 0; i < allPopups.length; i++) {
            allPopups[i].classList.remove('active');
        }
        productSizePopup.classList.add('active');
    }

    function checkAndSubmit(selectElement) {
        var selectedSize = selectElement.value;

        if (selectedSize === "") {
            alert("Please select a size before moving to cart.");
            return false;
        }

        selectElement.form.submit();
    }

    setTimeout(function () {
        $('#errorDiv').fadeOut(1000, 'linear');
    }, 5000);

</script>