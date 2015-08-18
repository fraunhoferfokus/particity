<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@ include file="../shared/init.jsp"%>

<% 
  Log log = LogFactoryUtil.getLog(this.getClass().getName());
 
	  %>

<portlet:actionURL var="saveUrl">
	<portlet:param name="action" value="saveProfile" />
</portlet:actionURL>

<div class="container" style="margin-top: 50px;">
	<div class="jumbotron">
		<h1>
			<spring:message code="common.profile.title" />
		</h1>
		<p>
			<spring:message code="common.profile.descr" />
		</p>

		<form:form modelAttribute="profileData" id="saveProfileForm"
			data-ajax="false" method="post" action="<%= saveUrl %>">
			<bform:bffield path="mail" label="common.form.profile.field.mail"
				type="text" required="true" />
			<bform:bffield path="pass1" label="common.form.profile.field.pass1"
				type="password" required="true" />
			<bform:bffield path="pass2" label="common.form.profile.field.pass2"
				type="password" required="true" />
			<button type="submit" class="btn btn-lg btn-primary">
				<span class="glyphicon glyphicon-ok"></span>&nbsp;
				<spring:message code="common.form.profile.submit" />
			</button>
		</form:form>

	</div>
</div>
