<%@ include file="/init.jsp" %>


<portlet:renderURL var="viewCategoryURL" >
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_CATEGORY %>"/>
</portlet:renderURL>

<portlet:renderURL var="viewMenClothsURL" >
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_PRODUCTS %>"/>
	<portlet:param name="gender" value="Men" />
</portlet:renderURL>

<portlet:renderURL var="viewWomenClothsURL" >
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_PRODUCTS %>"/>
	<portlet:param name="gender" value="Women" />
</portlet:renderURL>

<portlet:renderURL var="viewBoysClothsURL" >
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_PRODUCTS %>"/>
	<portlet:param name="gender" value="Boys" />
</portlet:renderURL>

<portlet:renderURL var="viewGirlsClothsURL" >
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_PRODUCTS %>"/>
	<portlet:param name="gender" value="Girls" />
</portlet:renderURL>

<portlet:renderURL var="viewWishlistProductURL" >
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_WISHLIST_PRODUCT %>"/>
</portlet:renderURL>

<portlet:renderURL var="viewCartListProductURL" >
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_CART_LIST_PRODUCT %>"/>
</portlet:renderURL>

<portlet:renderURL var="viewProductOrderURL" >
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_PRODUCT_ORDER %>"/>
</portlet:renderURL>

<%
    ThemeDisplay portletInfo = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
    //String signIn1 = portletInfo.getURLSignIn();
    //String signIn2 = signIn.split("\\?")[0];
    String signIn = portletInfo.getURLSignIn().split("\\?")[0];

    User appUser = null;
    if (Validator.isNotNull(themeDisplay)) {
        appUser = themeDisplay.getUser();
    }

    int wishCount = 0;
    Wishlist wishlist = WishlistLocalServiceUtil.getWishlistByUserId(appUser.getUserId());
    List<Long> wishlistProducts = WishlistProductLocalServiceUtil.getUserWishlistProducts(Validator.isNotNull(wishlist) ? wishlist.getId() : 0L);
    if (!wishlistProducts.isEmpty()) {
        wishCount = wishlistProducts.size();
    }

    int baggedItems = 0;
    CartList cartList = CartListLocalServiceUtil.getCartListByUserId(appUser.getUserId());
    List<CartListProduct> cartListProducts = CartListProductLocalServiceUtil.getUserCartListProducts(Validator.isNotNull(cartList) ? cartList.getId() : 0L);
    if (cartListProducts != null || !cartListProducts.isEmpty()) {
        baggedItems = cartListProducts.size();
    }
%>



<nav class="nav-bar">
    <div class="nav-first-div">
        <div class="nav-icn-div">
            <a  href="${viewCategoryURL}" >
                <img class="nav-logo" border="0" alt="Online-Shopping" src="https://aartisto.com/wp-content/uploads/2020/11/myntra.png" >
            </a>
        </div>

        <div class="home-cat-div">
            <a class="nav-link" href="${viewMenClothsURL}" >MEN</a>
            <a class="nav-link" href="${viewWomenClothsURL}" >WOMEN</a>
            <a class="nav-link" href="${viewBoysClothsURL}" >BOYS</a>
            <a class="nav-link" href="${viewGirlsClothsURL}" >GIRLS</a>
        </div>
    </div>
    <div class="home-div nav-info-div">

        <a class="nav-info-icon-div" href="${viewWishlistProductURL}">
            <div>
                <i class="fa-regular fa-heart"></i>
            </div>
            <span class="nav-link nav-info-link">Wishlist</span>
            <c:if test="<%= wishCount > 0 %>">
                <div class="show-numb show-wish-numb" >
                    <p class="wish-numb"><%= wishCount %></p>
                </div>
            </c:if>
        </a>

        <a class="nav-info-icon-div" href="${viewCartListProductURL}">
            <div>
                <clay:icon symbol="suitcase"/>
            </div>
            <span class="nav-link nav-info-link">Bag</span>
            <c:if test="<%= baggedItems > 0 %>">
                <div class="show-numb show-bgd-numb" >
                    <p class="wish-numb"><%= baggedItems %></p>
                </div>
            </c:if>
        </a>

        <a class="nav-info-icon-div" href="${viewProductOrderURL}">
            <div>
                <clay:icon symbol="select-from-list" />
            </div>
            <span class="nav-link nav-info-link" >Orders</span>
        </a>

        <%-- <a class="nav-info-icon-div" href="http://localhost:8080/c/portal/login?">
        <a class="nav-info-icon-div" href="http://16.171.139.49/c/portal/login?">
        <a class="nav-info-icon-div" href="<%= signIn1 %>">
            <div>
                <clay:icon symbol="user"/>
            </div>
            <span class="nav-link nav-info-link" >Sign In1</span>
        </a> --%>

        <a class="nav-info-icon-div" href="<%= signIn %>">
            <div>
                <clay:icon symbol="user"/>
            </div>
            <span class="nav-link nav-info-link" >Sign In</span>
        </a>
    </div>

</nav>
