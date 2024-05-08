<%@ include file="/init.jsp" %>
<%@ include file="/nav-bar.jsp" %>


<portlet:renderURL var="viewCategoryURL" >
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_CATEGORY %>"/>
</portlet:renderURL>


<div id="errorDiv">
	<c:if test='<%=SessionErrors.contains(renderRequest, "user-not-found") %>'>
		<liferay-ui:error key="user-not-found" message="User not found" />
	</c:if>
</div>


<div class="order-parent-div" >

    <c:if test='<%=SessionErrors.contains(renderRequest, "no-ordered-products-exists") %>'>
        <div class="empty-wish-cart-box-1" >
            <div class="empty-wish-box-2" >
                <div class="empty-wish-cart-box-3">
                    <p class="empty-wish-cart-hdng" >Currently, there are no orders..</p>
                    <p class="empty-wish-cart-txt" >Explore our amazing selection and start ordering your favorite items? Discover exciting offers and shop now!</p>
                    <%-- <aui:button cssClass="empty-prds-btn " href="${viewCategoryURL}" type="button" value="CONTINUE SHOPPING" /> --%>
                    <a class="a-go-to-crt" href="${viewCategoryURL}" >
                        <button class="empty-prds-btn rm-btn-brd" type="button" >CONTINUE SHOPPING</button>
                    </a>
                </div>
            </div>
        </div>
    </c:if>

    <c:if test="${not empty productOrders}">

        <div class="order-prds-box">
            <div class="prd-order-hd">
                <p class="prd-order-hd-1">All Orders <p class="prd-order-hd-2">from anytime</p></p>
            </div>

            <c:forEach items="${productOrders}" var="jsonProduct" >
                <c:set var="product" value="${jsonProduct.get('productOrder')}"/>

                <portlet:renderURL var="viewProductURL" >
                    <portlet:param name="mvcRenderCommandName" value="<%= MVCCommandNames.VIEW_PRODUCT %>" />
                    <portlet:param name="productId" value="${product.productId}" />
                    <portlet:param name="orderedProduct" value="true" />
                </portlet:renderURL>

                <a href="${viewProductURL}">
                    <div class="order-prds-div" >

                        <div class="order-prd-img" >
                            <img class="order-img" border="0" src="${jsonProduct.getString('image')}" >
                        </div>

                        <div class="order-prd-txt" >
                            <p class="order-text-1"><b>${jsonProduct.getString('brand')}</b></p>

                            <c:choose>
                                <c:when test="${fn:length(jsonProduct.getString('productName')) > 62}">
                                    <c:set var="truncatedName" value="${fn:substring(jsonProduct.getString('productName'), 0, 62)}" />
                                    <p class="order-text-2">${truncatedName}...</p>
                                </c:when>
                                <c:otherwise>
                                    <p class="order-text-2">${jsonProduct.getString('productName')}</p>
                                </c:otherwise>
                            </c:choose>

                            <%-- <p class="order-text-2" >${jsonProduct.getString('productName')}</p> --%>
                            <p class="order-text-2">Size : <span class="order-span1">${product.size}</span></p>
                            <p class="order-text-2">price :  <span class="order-span">${product.cost}</span></p>
                        </div>
                    </div>
                </a>
            </c:forEach>
        </div>
    </c:if>
</div>


