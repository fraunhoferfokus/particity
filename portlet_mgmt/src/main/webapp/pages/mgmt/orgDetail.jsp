
<%@page import="de.fraunhofer.fokus.oefit.adhoc.forms.RegistrationForm"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHCatEntries"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHCatEntriesLocalServiceUtil"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHCategories"%>
<%@page import="java.util.List"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHCategoriesLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ include file="../shared/init.jsp"%>

<% 
  Log log = LogFactoryUtil.getLog(this.getClass().getName());
 
  RegistrationForm data = (RegistrationForm) request.getAttribute("data");
  
  String actionType = request.getParameter("actionType");
  
  %>


<div class="container-fluid">

	<portlet:renderURL var="backUrl">
		<portlet:param name="jspPage" value="mgmt" />
	</portlet:renderURL>

	<div class="page-header">
		<h1>
			<spring:message code="mgmt.jsp.title" />
			&nbsp;&nbsp;<small><spring:message code="mgmt.jsp.descr" /></small>
		</h1>
	</div>

	<hr />
	<a class="btn btn-lg btn-default" href="${backUrl}"><spring:message
			code="mgmt.orgDetail.back" /></a>
	<hr />


	<h2><%= data.getName()  %>&nbsp;&nbsp;<small><a
			href="<%= data.getContactWeb() %>">Website</a></small>
	</h2>

	<portlet:actionURL var="approveUrl">
		<portlet:param name="action" value="approveOrg" />
		<portlet:param name="orgId"
			value="<%= Long.toString(data.getOrgId()) %>" />
	</portlet:actionURL>

	<form:form modelAttribute="data" id="approveOrganisationForm"
		data-ajax="false" method="post" action="${approveUrl}">

		<div class="row">
			<h3>
				<spring:message code="org.form.addOrg.form.title.common" />
			</h3>
			<div class="col-xs-12">
				<div class="row">
					<div class="col-md-4">
						<bform:bffield path="name" label="org.form.addOrg.field.name"
							type="text" required="true" disabled="true" />
						<bform:bffield path="holder" label="org.form.addOrg.field.holder"
							type="text" required="true" disabled="true" />
					</div>
					<div class="col-md-8">
						<bform:bffield path="descr" label="org.form.addOrg.field.descr"
							type="textarea" required="true" disabled="true" cssClass="wysiwyg" />
					</div>
				</div>
				<div class="row">
					<div class="col-xs-4">
						<bform:bffield path="legalState"
							label="org.form.addOrg.field.legalState" type="text"
							required="true" disabled="true" />
					</div>
					<div class="col-xs-4">
						<% if (data.getLogoFilename() != null && data.getLogoFilename().trim().length() >0 ) { %>
						<img src="<%= data.getLogoFilename() %>"
							style="height: 100px; width: auto;">
						<% } %>
					</div>
				</div>
			</div>

		</div>

		<div class="row">
			<h3>
				<spring:message code="org.form.addOrg.form.title.contact" />
			</h3>
			<div class="col-md-6">
				<div class="row"></div>
				<div class="col-xs-8">
					<bform:bffield path="addrStreet"
						label="org.form.addOrg.field.addrStreet" type="text"
						required="true" disabled="true" />
				</div>
				<div class="col-xs-4">
					<bform:bffield path="addrNum" label="org.form.addOrg.field.addrNum"
						type="text" required="true" disabled="true" />
				</div>
				<div class="row">
					<div class="col-md-4">
						<bform:bffield path="regionZip"
							label="org.form.addOrg.field.regionZip" type="text"
							required="true" disabled="true" />
					</div>
					<div class="col-md-4">
						<bform:bffield path="regionCity"
							label="org.form.addOrg.field.regionCity" type="text"
							required="true" disabled="true" />
					</div>
					<div class="col-md-4">
						<bform:bffield path="regionCountry"
							label="org.form.addOrg.field.regionCountry" type="text"
							required="true" disabled="true" />
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="row">
					<div class="col-xs-8">
						<bform:bffield path="contactPhone"
							label="org.form.addOrg.field.contactPhone" type="text"
							required="true" disabled="true" />
					</div>
					<div class="col-xs-4">
						<bform:bffield path="contactFax"
							label="org.form.addOrg.field.contactFax" type="text"
							required="true" disabled="true" />
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12">
						<bform:bffield path="contactMail"
							label="org.form.addOrg.field.contactMail" type="email"
							required="true" disabled="true" />
						<bform:bffield path="contactWeb"
							label="org.form.addOrg.field.contactWeb" type="text"
							required="true" disabled="true" />
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<h3>
				<spring:message code="org.form.addOrg.form.title.access" />
			</h3>
			<div class="col-xs-12">
				<bform:bffield path="mail" label="org.form.addOrg.field.mail"
					type="email" required="true" disabled="true" />
			</div>
		</div>

		<hr />

		<%
  if (actionType != null && actionType.equals("approve")) {
  %>
		<div class="row">
			<div class="col-xs-12" style="text-align: center;">
				<button type="submit" class="btn btn-lg btn-success">
					<span class="glyphicon glyphicon-ok"></span>&nbsp;
					<spring:message code="mgmt.orgDetail.approve" />
				</button>
			</div>
		</div>
		<%
  }
  %>

	</form:form>

</div>