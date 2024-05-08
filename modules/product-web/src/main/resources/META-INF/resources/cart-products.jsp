<%@ include file="/init.jsp" %>
<%@ include file="/nav-bar.jsp" %>


<%
    List<String> images = Arrays.asList(
        "http://assets.myntassets.com/assets/images/10341699/2022/8/25/c23fd879-a9b3-4515-a181-558523a71b9b1661423122029-LOCOMOTIVE-Men-Black--Grey-Slim-Fit-Checked-Casual-Shirt-342-1.jpg",
        "http://assets.myntassets.com/assets/images/2050688/2018/2/5/11517823120338-HIGHLANDER-Men-White-Slim-Fit-Solid-Casual-Shirt-5911517823120124-1.jpg",
         "http://assets.myntassets.com/assets/images/1364628/2016/8/31/11472636737718-Roadster-Men-Blue-Regular-Fit-Printed-Casual-Shirt-6121472636737160-1.jpg",
          "http://assets.myntassets.com/assets/images/8889597/2019/4/8/8dc49bf7-181d-4d8d-80d7-e624ef85e3651554718288714-Roadster-Men-Navy-Blue--Grey-Regular-Fit-Checked-Casual-Shir-1.jpg",
           "http://assets.myntassets.com/assets/images/2414313/2022/4/18/c08becf1-36fc-4c1f-a3c9-92542d3ef8221650284958075HERENOWMenRedBlackCheckedPureCottonCasualShirt1.jpg",
            "http://assets.myntassets.com/assets/images/12654912/2020/12/1/de506269-8ef1-483c-8e5f-6b96b7fb32d01606827797403-HERENOW-Men-Shirts-1731606827794754-1.jpg");
%>


<div class="cart-block">
    <div class="cart-row">

        <div class="cart-col-1">

        <%
            for (String image : images) {
        %>

            <div class="cart-prd">
                <div class="cart-prd-img-div" >
                    <img class="cart-prd-img"  src="<%= image %>" >
                </div>

                <div class="cart-prd-txt" >
                    <p class="cart-text-1"><b>Roadster</b></p>
                    <p class="cart-text-2" >Printed Casual Shirt</p>
                    <p class="cart-text-3" style="color:#c2185b;">Selected Size : <span style="color:black;">42</span></p>

                    <div class="cart-price-row" >
                        <p class="cart-price-col-1">Rs 500</p>
                        <p class="cart-price-col-2" style="color:grey;">MRP <del>600</del></p>
                        <p class="cart-price-col-3" style="color:orange;">(20% OFF)</p>
                    </div>

                    <p class="cart-info-txt" style="color:green;">Coupon Discount Rs.99</p>
                    <p class="cart-info-txt2" ><b>10 Days return Avilable<b></p>

                    <div class="cart-button-row" >
                         <a class="cart-close-icon" href="${deleteProductFromCartURL}" value="Remove" >
                           &#10006;
                          </a>
                    </div>
                </div>
            </div>

        <%
            }
        %>

        </div>

        <div class="cart-col-2">
            <p class="cart-prg-txt" >PRICE DETAILS <span style="color: red;" >(5 items)</span></p>
            <div class="cart-prg-row-1" >
                <p class="cart-prg-row-1col-1" >Total MRP</p>
                <p class="cart-prg-row-1col-1" >Rs.600 </p>
            </div>

            <div class="cart-prg-row-1" >
                <p class="cart-prg-row-1col-1" >Discount On MRP</p>
                <p class="prg-row-1col-2" >Rs.100 </p>
            </div>
            <div class="cart-prg-row-1" >
                <p class="cart-prg-row-1col-1" >Convience Fee</p>
                <p class="prg-row-1col-2" >FREE</p>
            </div>

            <div style="width: 100%; height: 2px; background-color: grey;" ></div>

            <div class="cart-prg-row-1" >
                <p class="cart-prg-row-1col-3" >Total Amount</p>
                <p class="cart-prg-row-1col-3" >Rs.800 </p>
            </div>

            <div class="cart-button-2" >
                 <aui:button cssClass="place-ordr-btn" type="button" href="${placeProductOrderURL}" value="PLACE ORDER" />
            </div>
        </div>
    </div>
</div>