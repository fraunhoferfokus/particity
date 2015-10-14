<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.forms.RegistrationForm"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHAddr"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHAddrLocalServiceUtil"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHOfferLocalServiceUtil"%>
<%@page
	import="org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHOrg"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHOrgLocalServiceUtil"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferWorkType"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferType"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.LinkedList"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHOffer"%>
<%@page import="org.springframework.ui.Model"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHCatEntriesLocalServiceUtil"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHCatEntries"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHCategoriesLocalServiceUtil"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHCategories"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
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
    
  %>

<%
      
        List<AHCategories> rootcats = AHCategoriesLocalServiceUtil.getCategories(E_CategoryType.SEARCH);
        //List<AHCategories> rootcats = AHCategoriesLocalServiceUtil.getCategoriesByIdStr(rCatParam);
        //List<AHCategories> morecats = AHCategoriesLocalServiceUtil.getCategoriesByInverseIdStr(rCatParam);
        
        List<AHCatEntries> childs;
        String rCatId;
        AHCategories rootcat;
        boolean isMore = false;
        for (int i=0; i<rootcats.size();i++) {
          //if (i < rootcats.size())
            rootcat = rootcats.get(i);
          //else {
            //rootcat = morecats.get(i-rootcats.size());
          //log.info(rootcat.getCatId()+" =? "+rCatParam);
          isMore = !Long.toString(rootcat.getCatId()).equals(rCatParam);
          //}
          //if (rootcat.getType() != E_CategoryType.SEARCH.getIntValue())
            //continue;
          childs = AHCatEntriesLocalServiceUtil.getCategoryEntriesChildsSorted(rootcat.getCatId());
          rCatId = Long.toString(rootcat.getCatId());
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
					aria-expanded="true" aria-controls="collapseOne"> <%= rootcat.getName() %>&nbsp;&nbsp;<small><%= rootcat.getDescr() %></small>
				</a>
			</h4>
		</div>
		<div id="collapse<%= rCatId %>"
			class="panel-collapse collapse <%= isMore ? "" : "in"%>"
			role="tabpanel" aria-labelledby="heading<%= rCatId %>">
			<ul class="list-group">

				<!-- start childs -->
				<%
            List<AHCatEntries> innerChilds;
            boolean isActive = false;
            for (AHCatEntries child: childs) {
              innerChilds = AHCatEntriesLocalServiceUtil.getChildEntriesById(child.getItemId());
              if (innerChilds == null || innerChilds.size() == 0) {
                  isActive = itemStr.contains(" "+child.getItemId()+" ");

              %>

				<li class="list-group-item search"><label> <input
						type="checkbox" name="items"
						value="<%= Long.toString(child.getItemId()) %>"
						class="form-control input-lg pull-left"
						<%= isActive ? "checked" : "" %> /> <%= child.getName() %>
				</label></li>


				<%
              } else {
                %>
				<li class="list-group-item"><%= child.getName() %></li>
				<%
                   
                   for (AHCatEntries innerChild: innerChilds) {
                       isActive = itemStr.contains(" "+innerChild.getItemId()+" ");
                     %>

				<li class="list-group-item search inner"><label> <input
						type="checkbox" name="items"
						value="<%= Long.toString(innerChild.getItemId()) %>"
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