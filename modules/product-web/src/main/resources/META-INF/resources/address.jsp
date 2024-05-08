<%@ include file="/init.jsp" %>
<%@ include file="/nav-bar.jsp" %>


<%
    String redirectURL = (String) portletSession.getAttribute("redirectURL");
    System.out.println(redirectURL);
%>


<portlet:renderURL var="makePaymentToProductsURL" >
	<portlet:param name="mvcRenderCommandName" value="<%= MVCCommandNames.MAKE_PAYMENT %>"/>
</portlet:renderURL>

<portlet:renderURL var="addAddressURL">
    <portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_ADDRESS %>"/>
    <portlet:param name="addNewAddress" value="true" />
    <portlet:param name="redirectURL" value="<%= redirectURL %>" />
</portlet:renderURL>


<div id="errorDiv">
    <c:if test='<%=SessionMessages.contains(renderRequest, "address-deleted") %>'>
        <liferay-ui:success key="address-deleted" message="Address Deleted Successfully"/>
    </c:if>
	<c:if test='<%=SessionErrors.contains(renderRequest, "user-not-found") %>'>
		<liferay-ui:error key="user-not-found" message="User not found" />
	</c:if>
	<c:if test='<%=SessionErrors.contains(renderRequest, "user-address-not-found") %>'>
        <liferay-ui:error key="user-address-not-found" message="Address not found" />
    </c:if>
</div>


<div class="address-div" >
    <div class="address-block-1" >
        <div class="address-block-2" >

        <div class="address-txt-box" >
            <p class="address-txt"><b>Select Delivery Address<b></p>
            <a class="a-go-to-crt" href="${addAddressURL}" >
                <button class="save-adrs-btn-1 rm-btn-brd" type="button" >ADD NEW ADDRESS</button>
            </a>
        </div>
        <c:if test="${not empty addressList}">
            <div class="address-block-3" >

                <c:forEach items="${addressList}" var="address">

                <portlet:renderURL var="makePaymentToProductsURL" >
                    <portlet:param name="mvcRenderCommandName" value="<%= MVCCommandNames.MAKE_PAYMENT %>"/>
                    <portlet:param name="addressId" value="${address.addressId}"/>
                </portlet:renderURL>

                <%-- <form action="<%= makePaymentToProductsURL %>" method="post"> --%>
                    <div class="address-info" >
                        <div class="address-info-1" >
                            <div class="address-info-rdo-div">
                                <input id="${address.addressId}" class="address-info-rdo" type="radio" name="<portlet:namespace/>selectedAddress" value="${address.addressId}" onclick="showButtons(${address.addressId});"/>
                            </div>
                            <div class="address-info-text">
                                <div class="address-1" >Name : ${address.userName}</div>
                                <div class="address-1-2">
                                    <div class="address-2" >${address.street2}</div>
                                    <div class="address-2" >${address.city}, ${address.street3} - ${address.regionId}</div>
                                </div>
                                <div class="address-2" >Mobile : <span class="address-3">${address.street1}</span></div>
                            </div>
                        </div>

                        <portlet:actionURL name="<%= MVCCommandNames.SAVE_ADDRESS %>" var="deleteUserAddressURL" >
                            <portlet:param name="addressId" value="${address.addressId}" />
                            <portlet:param name="deleteAddress" value="true" />
                            <portlet:param name="redirectURL" value="<%= redirectURL %>" />
                        </portlet:actionURL>

                        <div class="address-btn" >
                            <div class="address-button" id="continueButton_${address.addressId}" style="display:none;">
                                <%-- <aui:button cssClass="continue-adrs-btn" type="button" value="CONTINUE" onClick="showContinueConfirmation();" /> --%>
                                <button class="continue-adrs-btn rm-btn-brd" type="button" onClick="showContinueConfirmation();" >CONTINUE</button>
                            </div>

                            <div class="address-button-row" id="deleteButtonRow_${address.addressId}" style="display:none;">
                                <button class="remove-adrs-btn rm-btn-brd" type="button"onClick="showRemoveConfirmation();" >REMOVE</button>
                            </div>
                       </div>

                    </div>
            <%-- </form> --%>
                </c:forEach>
            </div>
        </c:if>
            <%-- <div class="address-add-button">
                <aui:button href="${addAddressURL}" cssClass="save2-adrs-btn" type="button"  value="ADD NEW ADDRESS" />
            </div> --%>
            <div class="address-add-button">
                <a class="a-go-to-crt" href="${addAddressURL}" >
                    <button class="save2-adrs-btn rm-btn-brd" type="button" ><p class="save2-adrs-btn-lbl">+Add New Address</p></button>
                </a>
            </div>
        </div>
    </div>
</div>


<script>

        function showRemoveConfirmation() {
            if (confirm("Are you sure you want to delete Address?")) {
                location.href = "${deleteUserAddressURL}";
            }
        }

        function showContinueConfirmation() {
            if (confirm("Are you sure you want to continue?")) {
                location.href = "${makePaymentToProductsURL}";
            }
        }

        function showButtons(addressId) {
            var deleteButtonRow = document.getElementById("deleteButtonRow_" + addressId);
            var continueButton = document.getElementById("continueButton_" + addressId);

            var allDeleteButtonRows = document.querySelectorAll('.address-button-row');
            var allContinueButtons = document.querySelectorAll('.address-button');
            for (var i = 0; i < allDeleteButtonRows.length; i++) {
                allDeleteButtonRows[i].style.display = 'none';
                allContinueButtons[i].style.display = 'none';
            }

            deleteButtonRow.style.display = 'block';
            continueButton.style.display = 'block';
        }

</script>

