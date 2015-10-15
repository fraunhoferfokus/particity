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

  String parentClass = request.getParameter("parentClass");

  PortletPreferences prefs = renderRequest.getPreferences();
  String rCatParam = prefs.getValue("categoryId", "-1");
  
  String ctxPth = request.getContextPath();
    
    if (parentClass != null) {
      %>
<div class="<%=parentClass%>">
	<%
    }
  %>

  <script>
     setMarkerBase("<%= ctxPth %>");
  </script>
	<div class="panel panel-default searchpanel">
		<div class="panel-heading" role="tab" id="heading1">
			<h4 class="panel-title">
				<a data-toggle="collapse" href="#collapseSearchRadial" aria-expanded="true"
					aria-controls="collapseSearchRadial"> <spring:message
						code="search.jsp.radialTitle" />&nbsp;&nbsp;<small><spring:message
							code="search.jsp.radialDescr" /></small>
				</a>
			</h4>
		</div>
		<div id="collapseSearchRadial" class="panel-collapse collapse <%= rCatParam.equals("-1") ? "in" : ""%>" role="tabpanel"
			aria-labelledby="heading1" style="padding: 25px 15px;">
			 
			  <div class="row">
			   <div class="col-xs-8">
				   <div class="form-group">
	          <input type="text" class="input-lg form-control" id="radialSearchAddr" placeholder="Adresse">
	          <input type="hidden" name="radialSearchLon">
	          <input type="hidden" name="radialSearchLat">
	        </div>
			   </div>
			   <div class="col-xs-4">
			     <select class="form-control input-lg" name="radialSearchDist" onchange="searchRadial()">
			       <option value="5">+5km</option>
			       <option value="10">+10km</option>
			       <option value="20">+20km</option>
			       <option value="50">+50km</option>
			     </select>
			   </div>
			  </div>
			   <div id="radialMap"></div>
			
		</div>
	</div>

	<%
  if (parentClass != null) {
    %>
</div>
<%
  }
%>