<%@ include file="/init.jsp" %>
<%@ include file="/nav-bar.jsp" %>

<portlet:renderURL var="viewMenProductURL" >
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_PRODUCTS %>"/>
	<portlet:param name="gender" value="Men" />
</portlet:renderURL>

<portlet:renderURL var="viewWomenProductURL" >
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_PRODUCTS %>"/>
	<portlet:param name="gender" value="Women" />
</portlet:renderURL>

<portlet:renderURL var="viewKidsProductURL" >
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_PRODUCTS %>"/>
	<portlet:param name="gender" value="Boys" />
</portlet:renderURL>

<portlet:renderURL var="viewKidsProductURL" >
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_PRODUCTS %>"/>
	<portlet:param name="gender" value="Girls" />
</portlet:renderURL>



<div id="errorDiv">
    <c:if test='<%=SessionMessages.contains(renderRequest, "added-to-wishlist") %>'>
        <liferay-ui:success key="added-to-wishlist" message="Product Added To Wishlist Successfully"/>
    </c:if>
	<c:if test='<%=SessionErrors.contains(renderRequest, "user-not-found") %>'>
		<liferay-ui:error key="user-not-found" message="User not found" />
	</c:if>
	<c:if test='<%=SessionErrors.contains(renderRequest, "no-category-found") %>'>
        <liferay-ui:error key="no-category-found" message="Requested category not found" />
    </c:if>
    <c:if test='<%=SessionErrors.contains(renderRequest, "no-product-exists") %>'>
        <liferay-ui:error key="no-product-exists" message="Requested item not found" />
    </c:if>
    <c:if test='<%=SessionErrors.contains(renderRequest, "no-user-wishlist-exists") %>'>
        <liferay-ui:error key="no-product-exists" message="User wishlist not found" />
    </c:if>
</div>



<%
    String advertiseImage = "https://blog.myntra.com//wp-content/uploads/2016/09/Myntra_TryAndBuy2.jpg";
    List<String> menCloths = Arrays.asList("https://assets.myntassets.com/f_webp,w_98,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/1/cddb0841-215b-42a7-b6cd-c8513709d9001675229607338-Top_casual_Styles-_Levi-s-_Tommy_Min_40.png", "https://assets.myntassets.com/f_webp,w_98,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/1/3cd73abd-624b-45b6-aa79-3c1f620a63f01675229606903-Casio-Titan_and_Fastrack_.png", "https://assets.myntassets.com/f_webp,w_98,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/1/016bf74a-80ba-42ae-aa60-d874aba48d6a1675229607420-USPA-_FM_Min_60.png", "https://assets.myntassets.com/f_webp,w_98,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/1/cee0660f-2915-435a-a8af-7721988975d51675229607324-Timewear_favourites_from_Fossil-_Tommy_Hilfiger.png", "https://assets.myntassets.com/f_webp,w_98,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/1/bad877b3-5569-431f-b6d9-f69de6b854931675229606976-Gant-_Nautica_Min_50.png", "https://assets.myntassets.com/f_webp,w_98,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/1/772170ac-df5f-4647-a0d2-f281a4bfc9da1675229607065-JJ-_Highlander_Min_60.png", "https://assets.myntassets.com/f_webp,w_98,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/1/bad877b3-5569-431f-b6d9-f69de6b854931675229606976-Gant-_Nautica_Min_50.png", "https://assets.myntassets.com/f_webp,w_98,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/1/cddb0841-215b-42a7-b6cd-c8513709d9001675229607338-Top_casual_Styles-_Levi-s-_Tommy_Min_40.png", "https://assets.myntassets.com/f_webp,w_122,c_limit,fl_progressive,dpr_2.0/assets/images/2023/1/31/e3ea1717-8443-414b-9174-19908a7638d41675145921238-Wardrobe_Must_Haves_from_H-M_.jpg", "https://assets.myntassets.com/f_webp,w_98,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/1/016bf74a-80ba-42ae-aa60-d874aba48d6a1675229607420-USPA-_FM_Min_60.png");
    List<String> womenCloths = Arrays.asList("https://assets.myntassets.com/f_webp,w_98,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/1/636672ea-4202-4d63-9a44-3b0e6b5b32a31675229607277-Runaway_Icons_-_Upto_50_off.png", "https://assets.myntassets.com/f_webp,w_98,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/1/f87815ef-a410-4a4f-a33c-ec07844c31961675229607085-Kurta_Sets_-_Libas-_BIBA_-_more.png", "https://assets.myntassets.com/f_webp,w_98,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/1/6f91a52e-4f79-4b60-bc76-fc496a110d0a1675229607448-Wear_It_to_Work_Ethnic_Collection_-min_60.png", "https://assets.myntassets.com/f_webp,w_98,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/1/d065ae87-639a-48a5-9755-c38a2793bbfd1675229607382-Traditional_Sarees_to_cherish_for_your_lifetime_Min_60_off_from_Mitera-__Vastranand_-_more.png", "https://assets.myntassets.com/f_webp,w_98,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/1/4b459f9e-e92c-4be9-8609-c55811be45301675229607183-Myntra_unique_ethnic_wear_from_Anouk-_Sangria_at_Min_65.png", "https://assets.myntassets.com/f_webp,w_122,c_limit,fl_progressive,dpr_2.0/assets/images/2023/1/31/e1308430-93f1-4196-a5e0-c787ad6ab9501675145920991-Flowy_Romance_Ethnic_Dresses.jpg", "https://assets.myntassets.com/f_webp,w_98,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/1/21e67122-80a4-4954-a05e-381363e88ba71675229606986-Get_Kurta_Sets_under_1299_-2299-_from_Vishudh-_Inddus_-more.png", "https://assets.myntassets.com/f_webp,w_98,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/1/099c3404-6676-4c42-8de9-e8b12812fd901675229607350-Top_Curated_Ethnic_Wear_from_Aurelia-_Global_Desi_-_more_-_60-80_off.png", "https://assets.myntassets.com/f_webp,w_98,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/1/21e67122-80a4-4954-a05e-381363e88ba71675229606986-Get_Kurta_Sets_under_1299_-2299-_from_Vishudh-_Inddus_-more.png", "https://assets.myntassets.com/f_webp,w_122,c_limit,fl_progressive,dpr_2.0/assets/images/2023/1/31/e1308430-93f1-4196-a5e0-c787ad6ab9501675145920991-Flowy_Romance_Ethnic_Dresses.jpg");
    List<String> boysCloths = Arrays.asList("https://assets.myntassets.com/f_webp,w_98,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/1/772170ac-df5f-4647-a0d2-f281a4bfc9da1675229607065-JJ-_Highlander_Min_60.png", "https://assets.myntassets.com/f_webp,w_98,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/1/cddb0841-215b-42a7-b6cd-c8513709d9001675229607338-Top_casual_Styles-_Levi-s-_Tommy_Min_40.png", "https://assets.myntassets.com/f_webp,w_98,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/1/016bf74a-80ba-42ae-aa60-d874aba48d6a1675229607420-USPA-_FM_Min_60.png", "https://assets.myntassets.com/f_webp,w_122,c_limit,fl_progressive,dpr_2.0/assets/images/2023/1/31/e3ea1717-8443-414b-9174-19908a7638d41675145921238-Wardrobe_Must_Haves_from_H-M_.jpg", "https://assets.myntassets.com/f_webp,w_98,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/1/bad877b3-5569-431f-b6d9-f69de6b854931675229606976-Gant-_Nautica_Min_50.png", "https://assets.myntassets.com/f_webp,w_122,c_limit,fl_progressive,dpr_2.0/assets/images/2023/1/31/d79b0988-da93-40c5-9484-14d4edffcfa81675145920948-Date_nigh_ready_curation.jpg", "https://assets.myntassets.com/f_webp,w_98,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/1/772170ac-df5f-4647-a0d2-f281a4bfc9da1675229607065-JJ-_Highlander_Min_60.png");
    List<String> girlsCloths = Arrays.asList("https://assets.myntassets.com/f_webp,w_98,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/1/cf2a81d8-142f-427a-826d-2ad9a17c497e1675229607311-Stylish_Western_Wear_Collection_from_Tommy_-_CK.png", "https://assets.myntassets.com/f_webp,w_122,c_limit,fl_progressive,dpr_2.0/assets/images/2023/1/31/758912a4-b45c-443b-94bc-0e1723779cfb1675145921115-Premium_Collection_from_Tommy_Hilifiger-_Aldo_-_More.jpg", "https://assets.myntassets.com/f_webp,w_98,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/1/6f91a52e-4f79-4b60-bc76-fc496a110d0a1675229607448-Wear_It_to_Work_Ethnic_Collection_-min_60.png", "https://assets.myntassets.com/f_webp,w_98,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/1/23f10ae5-d903-4415-a287-1c1727571e721675229607164-Most_Popular_Brands_-Min_50_off_from_Levis-_MANGO_-_more.png", "https://assets.myntassets.com/f_webp,w_122,c_limit,fl_progressive,dpr_2.0/assets/images/2023/1/31/877c025f-3c3f-4594-a965-cd11d22e2be81675145920940-Comfort_Collection_by_Freakins_-_Forever.jpg", "https://assets.myntassets.com/f_webp,w_98,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/1/636672ea-4202-4d63-9a44-3b0e6b5b32a31675229607277-Runaway_Icons_-_Upto_50_off.png", "https://assets.myntassets.com/f_webp,w_122,c_limit,fl_progressive,dpr_2.0/assets/images/2023/1/31/e1308430-93f1-4196-a5e0-c787ad6ab9501675145920991-Flowy_Romance_Ethnic_Dresses.jpg", "https://assets.myntassets.com/f_webp,w_98,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/1/cf2a81d8-142f-427a-826d-2ad9a17c497e1675229607311-Stylish_Western_Wear_Collection_from_Tommy_-_CK.png");
%>

<div class="show-img" >
    <div class="advertise">
        <img class="advertise-img" src="https://assets.myntassets.com/f_webp,w_980,c_limit,fl_progressive,dpr_2.0/assets/images/2022/7/25/9be788ff-39a4-4214-99d0-fc97505aae5a1658752545685-USPA_Desk_Banner.jpg" >
    </div>

    <div class="first-heading" >
    <img class="advertise-img" src="https://assets.myntassets.com/f_webp,w_980,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/1/d0e5f138-7f70-4ae6-a5c9-e42eb05890821675247942225-Trendiest-Picks--2-.jpg" >
        <a href="${viewMenProductURL}">
            <div class="home-img-row">
            <%
                for(String image : menCloths) {
            %>
                <div class="home-cloth-col" >
                    <div class="cards">
                        <img class="img-copy" border="0" src="<%=image %>" >
                    </div>
                </div>
            <%
               }
            %>
            </div>
        </a>
    </div>

    <div class="heading" >
        <img class="advertise-img" src="https://assets.myntassets.com/f_webp,w_980,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/1/72888de3-70c1-432f-af4d-edfa3b91c6121675247093554-Top-Brands-At-Best-Prices--3-.jpg" >
        <a href="${viewWomenProductURL}">
            <div class="home-img-row">
            <%
                for(String image : womenCloths) {
            %>
                <div class="home-cloth-col" >
                    <div class="cards">
                        <img class="img-copy" border="0" src="<%=image %>" >
                    </div>
                </div>
            <%
                }
            %>
            </div>
        </a>
    </div>

    <div class="heading" >
         <img class="advertise-img" src="https://assets.myntassets.com/f_webp,w_980,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/2/497e281d-cb37-4827-82db-0dbeee65915f1675335686020-WhatsApp-Image-2023-02-02-at-4.28.15-PM--1-.jpeg" >
         <a href="${viewBoysProductURL}">
              <div class="home-img-row">
              <%
                  for(String image : boysCloths) {
              %>
                  <div class="home-cloth-col" >
                      <div class="cards">
                           <img class="img-copy" border="0" src="<%=image %>" >
                      </div>
                  </div>
              <%
                  }
              %>
              </div>
         </a>
    </div>

    <div class="heading" >
         <img class="advertise-img" src="https://assets.myntassets.com/f_webp,w_980,c_limit,fl_progressive,dpr_2.0/assets/images/2023/2/2/497e281d-cb37-4827-82db-0dbeee65915f1675335686020-WhatsApp-Image-2023-02-02-at-4.28.15-PM--1-.jpeg" >
         <a href="${viewGirlsProductURL}">
              <div class="home-img-row">
              <%
                  for(String image : girlsCloths) {
              %>
                  <div class="home-cloth-col" >
                      <div class="cards">
                           <img class="img-copy" border="0" src="<%=image %>" >
                      </div>
                  </div>
              <%
                  }
              %>
              </div>
         </a>
    </div>

</div>
