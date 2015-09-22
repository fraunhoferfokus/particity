<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.forms.RegistrationForm"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.model.AHAddr"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.service.AHAddrLocalServiceUtil"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalServiceUtil"%>
<%@page
	import="org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.model.AHOrg"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.service.AHOrgLocalServiceUtil"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferWorkType"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferType"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.LinkedList"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.model.AHOffer"%>
<%@page import="org.springframework.ui.Model"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.service.AHCatEntriesLocalServiceUtil"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.service.AHCategoriesLocalServiceUtil"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.model.AHCategories"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ include file="../shared/init.jsp"%>

<% 
  Log log = LogFactoryUtil.getLog(this.getClass().getName());

  String parentClass = request.getParameter("parentClass");

  PortletPreferences prefs = renderRequest.getPreferences();
  String rCatParam = prefs.getValue("categoryId", "-1");

  String[] paramValues = request.getParameterValues("types");
  StringBuffer paramSb = new StringBuffer(" ");
  if (paramValues != null) {
    for (String paramValue: paramValues) {
      paramSb.append(paramValue).append(" ");
    }
  }
  String typesStr = paramSb.toString();
    
    if (parentClass != null) {
      %>
<div class="<%=parentClass%>">
	<%
    }
  %>

	<div class="panel panel-default searchpanel">
		<div class="panel-heading" role="tab" id="heading1">
			<h4 class="panel-title">
				<a data-toggle="collapse" href="#collapse1" aria-expanded="true"
					aria-controls="collapseOne"> <spring:message
						code="search.jsp.typeTitle" />&nbsp;&nbsp;<small><spring:message
							code="search.jsp.typeDescr" /></small>
				</a>
			</h4>
		</div>
		<div id="collapse1" class="panel-collapse collapse <%= rCatParam.equals("-1") ? "in" : ""%>" role="tabpanel"
			aria-labelledby="heading1">
			<ul class="list-group">
				<%
                
                boolean isActive = false;
                for (E_OfferType type: E_OfferType.values()) {
                  
                  isActive = typesStr.contains(" "+type.toString()+" ");
                  
                  %>

				<li class="list-group-item search"><label> <input
						type="checkbox" name="types" value="<%= type.getIntValue() %>"
						class="form-control input-lg pull-left"
						<%= isActive ? "checked" : "" %> /> <spring:message
							code="<%= type.getMsgProperty() %>" />
				</label></li>

				<%
                  
                }
                %>


			</ul>
		</div>
	</div>

	<%
  if (parentClass != null) {
    %>
</div>
<%
  }
%>