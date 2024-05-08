<%@ include file="/init.jsp" %>
<%@ include file="/nav-bar.jsp" %>


<portlet:actionURL name="<%= MVCCommandNames.SAVE_PRODUCT_ORDER %>" var="savePlacedProductsURL" >
    <portlet:param name="addressId" value="${addressId}" />
</portlet:actionURL>


<div class="pmyt-div" >
    <div class="form-box" >
        <aui:form action="${savePlacedProductsURL}" method="post">

            <div class="form-data" >
                <div class="form-head" >
                    <h2>Payment Details</h2>
                </div>

                <div class="form-field" >
                    <aui:fieldset>
                        <aui:input label="Card number" name="cardNumber" type="text" required="true" >
                            <aui:validator errorMessage="Enter a valid card number." name="custom" >
                                  function(val, fieldNode, ruleValue) {
                                     var regex = new RegExp(/^[0-9]{13,19}$/);
                                     return regex.test(val);
                                  }
                           </aui:validator>
                        </aui:input>
                    </aui:fieldset>
                </div>

                <div class="form-field" >
                    <aui:fieldset>
                        <aui:input label="Name on Card" name="cardName" type="text" required="true" >
                            <aui:validator errorMessage="Enter name with alphabets and spaces only." name="custom">
                                function(val, fieldNode, ruleValue) {
                                    var regex = new RegExp(/^[A-Za-z\s]+$/);
                                    return regex.test(val);
                                }
                            </aui:validator>
                        </aui:input>
                    </aui:fieldset>
                </div>

                <div class="form-field" >
                    <aui:fieldset>
                        <aui:input label="Valid Thru/Upto" name="expiryMonth" type="text" required="true" placeholder="MM/YY">
                            <aui:validator name="custom" errorMessage="Enter a valid expiry date.">
                                function(val, fieldNode, ruleValue) {
                                    var regex = new RegExp(/^(0[1-9]|1[0-2])\/\d{2}$/);
                                    if (!regex.test(val)) {
                                        console.log("Stage 1");
                                        return false;
                                    }

                                    var parts = val.split('/');
                                    var expiryMonth = parseInt(parts[0], 10);
                                    var expiryYearYY = parseInt(parts[1], 10);

                                    /*if (expiryYearYY < 0 || expiryYearYY > 99) {
                                        console.log("Stage 2");
                                        return false;
                                    }*/

                                    var currentYear = new Date().getFullYear();
                                    var currentCentury = Math.floor(currentYear / 100);
                                    var currentCenturyPrefix = currentCentury * 100;
                                    var expiryYear = currentCenturyPrefix + expiryYearYY;

                                    var currentMonth = new Date().getMonth() + 1;

                                    if (expiryYear < currentYear) {
                                        console.log("Stage 3");
                                        return false;
                                    } else if (expiryYear === currentYear && expiryMonth < currentMonth) {
                                        console.log("Stage 4");
                                        return false;
                                    }

                                    return true;
                                }
                            </aui:validator>
                        </aui:input>
                    </aui:fieldset>
                </div>

                <div class="form-field" >
                    <aui:fieldset>
                        <aui:input label="CVV" name="cvv" type="text" required="true" >
                            <aui:validator errorMessage="Please enter a valid 3 or 4-digit CVV." name="custom">
                                function(val, fieldNode, ruleValue) {
                                    var regex = new RegExp(/^\d{3,4}$/);
                                    return regex.test(val);
                                }
                            </aui:validator>
                        </aui:input>
                    </aui:fieldset>
                </div>

                <div class="form-field" >
                    <button class="save-adrs-btn rm-btn-brd" type="submit" >MAKE PAYMENT</button>
                </div>

            </div>
        </aui:form>
    </div>
</div>
