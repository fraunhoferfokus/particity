<%@page import="de.particity.model.I_CategoryEntryModel"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomCategoryServiceHandler"%>
<%@page import="de.particity.model.I_CategoryModel"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.forms.RegistrationForm"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferWorkType"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferType"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.LinkedList"%>
<%@page import="org.springframework.ui.Model"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@ include file="../shared/init.jsp"%>

<% 
  Log log = LogFactoryUtil.getLog(this.getClass().getName());

  PortletPreferences prefs = renderRequest.getPreferences();
  String rCatParam = prefs.getValue("categoryId", "-1");

  String[] rCats = rCatParam != null ? rCatParam.split(",") : null;
  
  String parentClass = request.getParameter("parentClass");
  
  String[] paramValues = request.getParameterValues("items");
  StringBuffer paramSb = new StringBuffer(" ");
  if (paramValues != null) {
    for (String paramValue: paramValues) {
      paramSb.append(paramValue).append(" ");
    }
  }
  String itemStr = paramSb.toString();
    
        List<I_CategoryModel> rootcats = CustomCategoryServiceHandler.getCategoryByType(E_CategoryType.SEARCH);
        
        List<I_CategoryEntryModel> childs;
        String rCatId;
        I_CategoryModel rootcat;
        boolean isMore = false;
        for (int i=0; i<rootcats.size();i++) {
          //if (i < rootcats.size())
            rootcat = rootcats.get(i);
          //else {
            //rootcat = morecats.get(i-rootcats.size());
          //log.info(rootcat.getCatId()+" =? "+rCatParam);
          isMore = !Long.toString(rootcat.getId()).equals(rCatParam);
          //}
          //if (rootcat.getType() != E_CategoryType.SEARCH.getIntValue())
            //continue;
          childs = CustomCategoryServiceHandler.getCategoryEntriesByCategoryIdSorted(rootcat.getId());
          rCatId = Long.toString(rootcat.getId());
          if (childs != null && childs.size() > 0) {
        	  
        	  if (parentClass != null) {
        		  %>
<div class="<%=parentClass%>">
	<%
        	  }
            %>


	<div class="panel panel-default searchpanel">
		<div class="panel-heading" role="tab" id="heading<%= rCatId %>">
			<h4 class="panel-title">
				<a data-toggle="collapse" href="#collapse<%= rCatId %>"
					aria-expanded="true" aria-controls="collapseOne"> <%= rootcat.getName() %>&nbsp;&nbsp;<small><%= rootcat.getDescription() %></small>
				</a>
			</h4>
		</div>
		<div id="collapse<%= rCatId %>"
			class="panel-collapse collapse <%= isMore ? "" : "in"%>"
			role="tabpanel" aria-labelledby="heading<%= rCatId %>">
			<ul class="list-group">

				<!-- start childs -->
				<%
            List<I_CategoryEntryModel> innerChilds;
            boolean isActive = false;
            for (I_CategoryEntryModel child: childs) {
              innerChilds = CustomCategoryServiceHandler.getChildCategoryEntriesByCategoryEntryId(child.getId());
              if (innerChilds == null || innerChilds.size() == 0) {
                  isActive = itemStr.contains(" "+child.getId()+" ");

              %>

				<li class="list-group-item search"><label> <input
						type="checkbox" name="items"
						value="<%= Long.toString(child.getId()) %>"
						class="form-control input-lg pull-left"
						<%= isActive ? "checked" : "" %> /> <%= child.getName() %>
				</label></li>


				<%
              } else {
                %>
				<li class="list-group-item"><%= child.getName() %></li>
				<%
                   
                   for (I_CategoryEntryModel innerChild: innerChilds) {
                       isActive = itemStr.contains(" "+innerChild.getId()+" ");
                     %>

				<li class="list-group-item search inner"><label> <input
						type="checkbox" name="items"
						value="<%= Long.toString(innerChild.getId()) %>"
						class="form-control input-lg pull-left"
						<%= isActive ? "checked" : "" %> /> <%= innerChild.getName() %>
				</label></li>

				<%
                   }
                   
                   %>
				<%  
              }
              
            }
            
            %>
			</ul>
		</div>
	</div>
	<!-- end childs -->
	<%
          if (parentClass != null) {
        	  %>
</div>
<%
          }
          
          }
        }
      %>