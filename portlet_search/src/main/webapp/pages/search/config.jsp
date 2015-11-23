<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHCategories"%>
<%@page import="java.util.List"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHCategoriesLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@ include file="../shared/init.jsp"%>

<% 
  Log log = LogFactoryUtil.getLog(this.getClass().getName());
 
  String catIds = GetterUtil.getString(portletPreferences.getValue("categoryId", "-1"));
  catIds = ","+catIds+",";

  List<AHCategories> cats = AHCategoriesLocalServiceUtil.getCategories(E_CategoryType.SEARCH.getIntValue());
  
  %>

<liferay-portlet:actionURL portletConfiguration="true"
	var="configurationURL" />


<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:input name="<%= com.liferay.portal.kernel.util.Constants.CMD %>" type="hidden"
		value="<%= com.liferay.portal.kernel.util.Constants.UPDATE %>" />

	<aui:select name="preferences--categoryId--" multiple="true">
		<aui:option value="-1" selected="false">-</aui:option>

		<%
boolean selected;
for (AHCategories cat: cats) {
	selected = false;
	if (catIds.contains(","+Long.toString(cat.getCatId())+",")) {
		selected = true;
	}
	%>

		<aui:option value="<%= Long.toString(cat.getCatId()) %>"
			selected="<%= selected %>"><%= cat.getName() %></aui:option>
		<%
}
%>
	</aui:select>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>