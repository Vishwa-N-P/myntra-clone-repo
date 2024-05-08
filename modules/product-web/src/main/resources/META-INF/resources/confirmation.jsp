<%@ include file="/init.jsp" %>
<%@ include file="/nav-bar.jsp" %>


<portlet:renderURL var="viewCategoryURL" >
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_CATEGORY %>"/>
</portlet:renderURL>


<div class="confirm-msg-div" >
    <div class="msg-box" >
        <div class="msg-box-txt" >

            <p class="confirm-txt-1 font-style">Order Confirmation</p>
            <p class="confirm-txt font-style">Dear ${address.userName}</p>
            <p class="confirm-txt-2 font-style" >You have successfully placed the order.</p>
            <%-- <aui:button cssClass="empty-prds-btn " href="${viewCategoryURL}" type="button" value="CONTINUE SHOPPING" /> --%>
            <a class="a-go-to-crt" href="${viewCategoryURL}" >
                <button class="empty-prds-btn rm-btn-brd" type="button" >CONTINUE SHOPPING</button>
            </a>
        </div>

    </div>
</div>
