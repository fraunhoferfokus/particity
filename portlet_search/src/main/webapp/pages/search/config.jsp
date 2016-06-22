<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomCategoryServiceHandler"%>
<%@page import="de.particity.model.I_CategoryModel"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@ include file="../shared/init.jsp"%>

<% 
  Log log = LogFactoryUtil.getLog(this.getClass().getName());
 
  String catIds = GetterUtil.getString(portletPreferences.getValue("categoryId", "-1"));
  catIds = ","+catIds+",";

  List<I_CategoryModel> cats = CustomCategoryServiceHandler.getCategoryByType(E_CategoryType.SEARCH);
  
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
for (I_CategoryModel cat: cats) {
	selected = false;
	if (catIds.contains(","+Long.toString(cat.getId())+",")) {
		selected = true;
	}
	%>

		<aui:option value="<%= Long.toString(cat.getId()) %>"
			selected="<%= selected %>"><%= cat.getName() %></aui:option>
		<%
}
%>
	</aui:select>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>