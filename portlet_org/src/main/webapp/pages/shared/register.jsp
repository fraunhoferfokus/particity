
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.forms.RegistrationForm"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey"%>
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

<portlet:actionURL var="addUrl">
	<portlet:param name="action" value="addOrganisation" />
</portlet:actionURL>

<portlet:actionURL var="saveUrl">
	<portlet:param name="action" value="saveOrganisation" />
</portlet:actionURL>

<portlet:actionURL var="approveUrl">
	<portlet:param name="action" value="approveOrganisation" />
</portlet:actionURL>



<% 
  Log log = LogFactoryUtil.getLog(this.getClass().getName());
 
 RegistrationForm data = (RegistrationForm) request.getAttribute("orgData");
 
 
 
 boolean isOrgOwner = themeDisplay.isSignedIn() && data != null && data.getMail() != null && data.getMail().trim().toLowerCase().equals(user.getEmailAddress().trim().toLowerCase());
 //log.info("Got user mail: "+user.getEmailAddress()+", got organisation owner: "+data.getMail());
 
 String actionType = request.getParameter("actionType");
 if (actionType == null) {
	 Object o = request.getAttribute("actionType");
	 if (o != null)
		 actionType = o.toString();
 }
 if (actionType == null)
	 actionType = "create";
 
 String disabled = "false";
 
 String formUrl = addUrl;
 if (actionType != null) {
	 if (actionType.equals("edit") && !isOrgOwner)
		 actionType = "view";
	 else if (actionType.equals("edit")) {
     formUrl = saveUrl;
   }
   else if (actionType.equals("approve")) {
       formUrl = approveUrl;
       disabled = "true";
   } else if (actionType.equals("view")) {
       disabled = "true";
   }
 }
 
  %>

<div class="container-fluid">

  <!-- if demo-mode enabled, notify about denied actions -->
  <liferay-ui:error key="common.demo.denied">
       <spring:message code="common.demo.denied" />
   </liferay-ui:error>


	<%
  if (actionType.equals("create")) {
 %>
	<div class="page-header">
		<h1>
			<spring:message code="org.registration.jsp.title" />
			&nbsp;&nbsp;<small><spring:message
					code="org.registration.jsp.descr" /></small>
		</h1>
	</div>
	<%
  }
 %>


	<form:form modelAttribute="orgData" id="addOrganisationForm"
		data-ajax="false" method="post" action="<%=formUrl %>"
		enctype="multipart/form-data">

		<liferay-ui:error key="org.form.addOrg.failed.user">
			<spring:message code="org.form.addOrg.failed.user" />
		</liferay-ui:error>
		<liferay-ui:error key="org.form.addOrg.failed.org">
			<spring:message code="org.form.addOrg.failed.org" />
		</liferay-ui:error>

		<div class="row">
			<h2>
				<spring:message code="org.form.addOrg.form.title.common" />
			</h2>
			<div class="col-xs-12">
				<div class="row">
					<div class="col-md-4">
						<bform:bffield path="name" label="org.form.addOrg.field.name"
							type="text" required="true" disabled="<%= disabled %>" />
						<bform:bffield path="holder" label="org.form.addOrg.field.holder"
							type="text" required="true" disabled="<%= disabled %>" />
						<bform:bffield path="legalState"
              label="org.form.addOrg.field.legalState" type="text"
              required="true" disabled="<%= disabled %>" />
					</div>
					<div class="col-md-8">
						<bform:bffield path="descr" label="org.form.addOrg.field.descr"
							type="textarea" required="true" disabled="<%= disabled %>" cssClass="wysiwyg" />
					</div>
				</div>
				<div class="row">
					<div class="col-xs-4">						
					</div>
					<div class="col-xs-4">
						<%
        if (data.getLogoFilename() != null && data.getLogoFilename().trim().length() > 0) {
        	%>
						<img src="<%= data.getLogoFilename() %>"
							style="height: 100px; width: auto;">
						<%
        }
        %>
					</div>
					<div class="col-xs-4">
					 <fieldset <%= demoDisabled %>>
						<liferay-ui:error key="org.form.addOrg.field.logoFile.exceed">
							<spring:message code="org.form.addOrg.field.logoFile.exceed" />
						</liferay-ui:error>
						<% if (actionType.equals("edit"))  { %>
						<bform:bffield path="logoFile"
							label="org.form.addOrg.field.logoFile" type="file"
							required="false"/>
						<% 
            }
          %>
            </fieldset>
					</div>
				</div>
			</div>

		</div>

		<div class="row">
			<h2>
				<spring:message code="org.form.addOrg.form.title.contact" />
			</h2>
			<div class="col-md-6">
				<div class="row"></div>
				<div class="col-xs-8">
					<bform:bffield path="addrStreet"
						label="org.form.addOrg.field.addrStreet" type="text"
						required="true" disabled="<%= disabled %>" />
				</div>
				<div class="col-xs-4">
					<bform:bffield path="addrNum" label="org.form.addOrg.field.addrNum"
						type="text" required="true" disabled="<%= disabled %>" />
				</div>
				<div class="row">
					<div class="col-md-4">
						<bform:bffield path="regionZip"
							label="org.form.addOrg.field.regionZip" type="text"
							required="true" disabled="<%= disabled %>" />
					</div>
					<div class="col-md-4">
						<bform:bffield path="regionCity"
							label="org.form.addOrg.field.regionCity" type="text"
							required="true" disabled="<%= disabled %>" />
					</div>
					<div class="col-md-4">
						<%
        if (disabled.equals("true")) {
        	%>
						<bform:bffield path="regionCountry"
							label="org.form.addOrg.field.regionCountry" type="text"
							required="true" disabled="<%= disabled %>" />
						<%
        } else {
        	%>
						<bform:bffield items="${countries}" path="regionCountry"
							label="org.form.addOrg.field.regionCountry" type="select"
							required="true" disabled="<%= disabled %>" />
						<%
        }
        %>

					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="row">
					<div class="col-xs-8">
						<bform:bffield path="contactPhone"
							label="org.form.addOrg.field.contactPhone" type="text"
							required="true" disabled="<%= disabled %>" />
					</div>
					<div class="col-xs-4">
						<bform:bffield path="contactFax"
							label="org.form.addOrg.field.contactFax" type="text"
							required="false" disabled="<%= disabled %>" />
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12">
						<bform:bffield path="contactMail"
							label="org.form.addOrg.field.contactMail" type="email"
							required="true" disabled="<%= disabled %>" />
						<bform:bffield path="contactWeb"
							label="org.form.addOrg.field.contactWeb" type="text"
							required="true" disabled="<%= disabled %>" />
					</div>
				</div>
			</div>
		</div>

		<% if (!actionType.equals("edit")) { %>
		<div class="row">
			<h2>
				<spring:message code="org.form.addOrg.form.title.access" />
			</h2>
			<div class="col-xs-12">
				<bform:bffield path="mail" label="org.form.addOrg.field.mail"
					type="email" required="true" disabled="<%= disabled %>" />
			</div>
		</div>
		<%
  } else {
	  %>
		<bform:bffield path="mail" type="hidden" value="<%= data.getMail() %>"></bform:bffield>
		<%
  }
  %>
		<hr />

		<div class="row">
			<div class="col-xs-12" style="text-align: center;">
				<%
	    if (actionType.equals("create")) {
	    %>
				<button type="submit" class="btn btn-lg btn-primary">
					<span class="glyphicon glyphicon-ok"></span>&nbsp;&nbsp;
					<spring:message code="org.form.addOrg.submit" />
				</button>
				<%
      } else if (actionType.equals("edit")) {
   	  %>
				<div class="modal fade" id="deleteModal" tabindex="-1"
					data-backdrop="false" role="dialog"
					aria-labelledby="deleteModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="deleteModalLabel">
									<spring:message code="org.form.addOrg.deleteLabel" />
								</h4>
							</div>
							<div class="modal-body">
								<spring:message code="org.form.addOrg.deleteBody" />
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">
									<span class="glyphicon glyphicon-ok"></span>&nbsp;&nbsp;
									<spring:message code="org.form.addOrg.deleteAbort" />
								</button>
								<a
									href="<portlet:actionURL>
                    <portlet:param name="action" value="deleteOrganisation" />
                    <portlet:param name="orgId" value="<%= Long.toString(data.getOrgId()) %>" />
                    </portlet:actionURL>"
									class="btn btn-danger"><span class="glyphicon glyphicon-ok"></span>&nbsp;&nbsp;<spring:message
										code="org.form.addOrg.deleteSubmit" /></a>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-6" style="text-align: center;">
						<button type="submit" class="btn btn-lg btn-primary">
							<span class="glyphicon glyphicon-save"></span>&nbsp;&nbsp;
							<spring:message code="org.form.addOrg.editSubmit" />
						</button>
					</div>
					<div class="col-xs-6" style="text-align: center;">
						<a href="#" data-toggle="modal" data-target="#deleteModal"
							class="btn btn-lg btn-danger <%= demoDisabled %>"><span
							class="glyphicon glyphicon-remove"></span>&nbsp;&nbsp;<spring:message
								code="org.form.addOrg.deleteSubmit" /></a>
					</div>

				</div>
				<%
      } else if (actionType.equals("approve")) {
      %>
				<div class="row">
					<div class="col-xs-6" style="text-align: center;">
						<button type="submit" class="btn btn-lg btn-primary">
							<span class="glyphicon glyphicon-ok"></span>&nbsp;&nbsp;
							<spring:message code="org.form.addOrg.approveSubmit" />
						</button>
					</div>
					<div class="col-xs-6" style="text-align: center;">
						<a class="btn btn-lg btn-info"
							href="mailto:<%= data.getMail() %>,<%= data.getContactMail() %>?subject=<spring:message code="mgmt.orgDetail.form.contact.subject"/>&body=<spring:message code="mgmt.orgDetail.form.contact.opening"/>%0A%0A<spring:message code="mgmt.orgDetail.form.contact.footer"/>%0A<%= CustomPortalServiceHandler.getConfigValue(E_ConfigKey.MGMT_CONTACT_NAME) %>"><span
							class="glyphicon glyphicon-envelope"></span>&nbsp;<spring:message
								code="mgmt.orgDetail.form.contact" /></a>
					</div>


				</div>
				<%
        }
      %>
			</div>
		</div>


	</form:form>

</div>

