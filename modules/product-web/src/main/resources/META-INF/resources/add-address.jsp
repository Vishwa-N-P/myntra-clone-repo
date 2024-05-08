<%@ include file="/init.jsp" %>
<%@ include file="/nav-bar.jsp" %>


<%
    String redirectURL = (String) portletSession.getAttribute("redirectURL");
    System.out.println(redirectURL);
%>


<portlet:actionURL name="<%= MVCCommandNames.SAVE_ADDRESS %>" var="saveAddressURL" >
    <portlet:param name="redirectURL" value="<%= redirectURL %>" />
</portlet:actionURL>

<div class="adrs-div" >
    <div class="form-box" >
        <aui:form action="${saveAddressURL}" method="post">

            <div class="form-data" >
                <div class="form-head" >
                    <p class="add-adrs-txt">ADD NEW ADDRESS</p>
                </div>

                <div class="form-field" >
                    <aui:fieldset>
                        <aui:input label="Name" name="name" type="text" required="true" >
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
                        <aui:input label="Phone Number" name="phone" type="text" required="true">
                             <aui:validator errorMessage="Enter a valid 10-digit phone number." name="custom">
                                function(val, fieldNode, ruleValue) {
                                        var regex = new RegExp(/^[0-9]{10}$/);
                                        return regex.test(val);
                                }
                            </aui:validator>
                        </aui:input>
                    </aui:fieldset>
                </div>

                <div class="form-field" >
                    <aui:fieldset>
                        <aui:input label="Address" name="address" type="text" required="true" placeholder="Enter (house no/house name/street)" />
                    </aui:fieldset>
                </div>

                <div class="form-field" >
                    <aui:fieldset>
                        <aui:input label="PIN Code" name="pinCode" type="text" required="true" >
                            <aui:validator errorMessage="Enter a 6-digit Pin Code." name="custom">
                                function(val, fieldNode, ruleValue) {
                                    var regex = new RegExp(/^[0-9]{6}$/);
                                    return regex.test(val);
                                }
                            </aui:validator>
                        </aui:input>
                    </aui:fieldset>
                </div>

                <div class="form-field" >
                    <aui:fieldset>
                        <aui:input label="City" name="city" type="text" required="true" >
                            <aui:validator errorMessage="Enter city with alphabets and spaces only." name="custom">
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
                        <aui:input label="State" name="state" type="text" required="true" >
                            <aui:validator errorMessage="Enter State with alphabets and spaces only." name="custom">
                                function(val, fieldNode, ruleValue) {
                                    var regex = new RegExp(/^[A-Za-z\s]+$/);
                                    return regex.test(val);
                                }
                            </aui:validator>
                        </aui:input>
                    </aui:fieldset>
                </div>

                <div class="form-field" >
                     <button class="save-adrs-btn rm-btn-brd" id="submit" type="submit" value="SAVE ADDRESS" >SAVE ADDRESS</button>
                </div>

            </div>
        </aui:form>
    </div>
</div>


<script>

 /*console.log("Form Submitted");
  document.getElementById('submit').addEventListener("click", function(event){
   event.preventDefault();
   console.log("Form Submitted");
   }*/

   <script>
   document.addEventListener("DOMContentLoaded", function () {
       var form = document.querySelector(".adrs-div form");
       console.log("Form submit attempted");

       form.addEventListener("submit", function (event) {
           // Check the form's validity using AUI.FormValidator
           var isFormValid = AUI.FormValidator.test();
           console.log("AUI.FormValidator.test()");

           if (!isFormValid) {
               // Prevent form submission if it's not valid
               event.preventDefault();

               // Scroll to the top of the form to show validation errors
               scrollToTop(form);
           }
       });

       function scrollToTop(element) {
           // Scroll to the top of the specified element
           element.scrollIntoView({ behavior: "smooth", block: "start" });
       }
   });
   </script>

</script>



