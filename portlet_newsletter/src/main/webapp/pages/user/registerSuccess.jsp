<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@ include file="../shared/init.jsp"%>

<% 
  Log log = LogFactoryUtil.getLog(this.getClass().getName());
 
  %>

<div class="container" style="margin-top: 20px;">

	<div class="jumbotron">
		<h1>
			<spring:message code="user.registration.success.title" />
		</h1>
		<p>
			<spring:message code="user.registration.success.descr" />
		</p>
		<a class="btn btn-lg btn-primary" href="/"><span
			class="glyphicon glyphicon-home"></span>&nbsp;<spring:message
				code="user.registration.succes.btn" /></a>
	</div>

</div>