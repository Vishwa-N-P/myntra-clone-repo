<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.ArrayList" %>


<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page import="com.shopping.product.web.constants.MVCCommandNames"%>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@ page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>

<%@ page import="com.onlineshopping.product.service.model.Highlights" %>
<%@ page import="com.onlineshopping.product.service.model.Product" %>
<%@ page import="com.onlineshopping.product.service.model.Image" %>
<%@ page import="com.onlineshopping.product.service.model.Brand" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="com.onlineshopping.product.service.model.Wishlist" %>
<%@ page import="com.onlineshopping.product.service.service.WishlistLocalServiceUtil" %>
<%@ page import="com.onlineshopping.product.service.service.WishlistProductLocalServiceUtil" %>
<%@ page import="com.onlineshopping.product.service.model.CartList" %>
<%@ page import="com.onlineshopping.product.service.service.CartListLocalServiceUtil" %>
<%@ page import="com.onlineshopping.product.service.model.CartListProduct" %>
<%@ page import="com.onlineshopping.product.service.service.CartListProductLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>

<script src="https://kit.fontawesome.com/5c61ab48e3.js" crossorigin="anonymous"></script>

<liferay-theme:defineObjects />

<portlet:defineObjects />