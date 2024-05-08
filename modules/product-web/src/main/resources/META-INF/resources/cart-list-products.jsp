<%@ include file="/init.jsp" %>
<%@ include file="/nav-bar.jsp" %>




<portlet:renderURL var="placeProductOrderURL" >
    <portlet:param name="mvcRenderCommandName" value="<%= MVCCommandNames.VIEW_ADDRESS %>" />
</portlet:renderURL>

<portlet:renderURL var="viewWishlistProductURL" >
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_WISHLIST_PRODUCT %>"/>
</portlet:renderURL>



<div id="errorDiv">
    <c:if test='<%=SessionMessages.contains(renderRequest, "deleted-from-bag") %>'>
        <liferay-ui:success key="deleted-from-bag" message="Deleted from Bag"/>
    </c:if>
	<c:if test='<%=SessionErrors.contains(renderRequest, "user-not-found") %>'>
		<liferay-ui:error key="user-not-found" message="User not found" />
	</c:if>
	<c:if test='<%=SessionErrors.contains(renderRequest, "no-product-exists") %>'>
        <liferay-ui:error key="no-product-exists" message="Requested item not found" />
    </c:if>
    <c:if test='<%=SessionErrors.contains(renderRequest, "no-user-cart-exists") %>'>
        <liferay-ui:error key="no-user-cart-exists" message="User bag not found" />
    </c:if>
</div>



<div class="cart-div" >

    <c:if test="${empty cartListProducts || SessionErrors.contains(renderRequest, 'no-products-exists')}">
    <%-- <c:if test="${empty cartListProducts}">
    <c:if test='<%=SessionErrors.contains(renderRequest, "no-products-exists") %>'> --%>
        <div class="empty-wish-cart-box-1" >
            <div class="empty-wish-cart-box-2">
                <div class="empty-wish-cart-box-3">
                   <div class="emty-cart-image-div"> <img class="empty-wish-cart-img" src="https://assets.materialup.com/uploads/66fb8bdf-29db-40a2-996b-60f3192ea7f0/preview.png" ></div>
                    <p class="empty-wish-cart-hdng" >Hey, your cart is empty!</p>
                    <p class="empty-wish-cart-txt" >There is nothing in your cart. Add some items</p>
                    <%-- <aui:button cssClass="empty-cart-btn" href="${viewWishlistProductURL}" type="button" value="ADD ITEMS FROM WISHLIST" /> --%>
                    <a class="a-go-to-crt" href="${viewWishlistProductURL}" >
                        <button class="empty-cart-btn rm-btn-brd" type="button" >ADD ITEMS FROM WISHLIST</button>
                    </a>
                </div>
            </div>
        </div>
    </c:if>

    <c:if test="${not empty cartListProducts}">
        <div class="cart-row" >

            <c:forEach items="${cartListProducts}" var="jsonProduct" >
                <c:set var="product" value="${jsonProduct.get('product')}"/>
                <c:set var="totalMrp" value="${totalMrp + product.price}" />
                <c:set var="totalFinalPrice" value="${totalFinalPrice + product.finalPrice}" />

                <div class="cart-col-1" >
                    <div class="cart-prd" >

                        <portlet:actionURL name="<%= MVCCommandNames.DELETE_CART_LIST_PRODUCT %>" var="deleteProductFromCartURL" >
                            <portlet:param name="cartListId" value="${cartListId}" />
                            <portlet:param name="productId" value="${product.id}" />
                            <portlet:param name="size" value="${jsonProduct.getString('size')}" />
                            <portlet:param name="redirectURL" value="${redirectURL}" />
                        </portlet:actionURL>

                        <div class="cart-prd-img-div" >
                            <img class="cart-prd-img" src="${jsonProduct.getString('image')}" >
                        </div>

                        <div class="cart-prd-txt" >
                            <p class="cart-text-1"><b>${jsonProduct.getString('brand')}</b></p>
                            <p class="cart-text-2" >${product.productInfo}</p>
                            <p class="cart-text-3" >Selected Size : <span style="color:black;">${jsonProduct.getString('size')}</span></p>

                            <div class="cart-price-row" >
                                <p class="cart-price-col-1">Rs.${product.finalPrice}</p>
                                <p class="cart-price-col-2">MRP <del>${product.price}</del></p>
                                <p class="cart-price-col-3">${product.discountPercentage}% OFF</p>
                            </div>

                            <p class="cart-info-txt">Coupon Discount Rs.99</p>
                            <p><span class="cart-info-txt2">10 Days<span class="cart-info-txt2-1" > return available</span></span></p>

                            <div class="cart-button-row" >
                                <a class="cart-close-icon" href="${deleteProductFromCartURL}" value="Remove" >
                                   &#10006;
                                </a>
                            </div>

                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="cart-col-2" >

            <p class="cart-prg-txt" >PRICE DETAILS <span style="color: red;" >(${productsCount} items)</span></p>

            <div class="cart-prg-row-1" >
                <p class="cart-prg-row-1col-1" >Total MRP</p>
                <p class="cart-prg-row-1col-1" ><i class="fa-solid fa-indian-rupee-sign crt-rupee"></i>${totalMrp} </p>
            </div>

            <div class="cart-prg-row-1" >
                <p class="cart-prg-row-1col-1" >Discount On MRP</p>
                <p class="prg-row-1col-2" >- <i class="fa-solid fa-indian-rupee-sign crt-rupee"></i>${totalMrp - totalFinalPrice} </p>
            </div>

            <div class="cart-prg-row-1" >
                <p class="cart-prg-row-1col-1" >Convience Fee</p>
                <p class="prg-row-1col-2" >FREE</p>
            </div>

            <div style="width: 100%; height: 2px; background-color: grey;" ></div>

            <div class="cart-prg-row-1" >
                <p class="cart-prg-row-1col-3" >Total Amount</p>
                <p class="cart-prg-row-1col-3" ><i class="fa-solid fa-indian-rupee-sign crt-rupee"></i>${totalFinalPrice} </p>
            </div>

            <div class="cart-button-2" >
                <%-- <aui:button cssClass="place-ordr-btn" type="button" href="${placeProductOrderURL}" value="PLACE ORDER" /> --%>
                <a class="a-go-to-crt" href="${placeProductOrderURL}" >
                    <button class="place-ordr-btn rm-btn-brd" type="button" >PLACE ORDER</button>
                </a>
            </div>

        </div>
    </c:if>
</div>


<script>

    setTimeout(function () {
        $('#errorDiv').fadeOut(1000, 'linear');
    }, 5000);

</script>
