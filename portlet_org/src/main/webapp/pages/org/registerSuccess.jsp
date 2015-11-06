<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@ include file="../shared/init.jsp"%>

<% 
  Log log = LogFactoryUtil.getLog(this.getClass().getName());
 
  %>

<div class="container">


	<div class="jumbotron">
		<h1>
			<spring:message code="org.registration.success.title" />
		</h1>
		<p>
			<spring:message code="org.registration.success.descr" />
		</p>
		<a class="btn btn-lg btn-primary" href="/"><span
			class="glyphicon glyphicon-home"></span>&nbsp;<spring:message
				code="org.registration.success.btn" /></a>
	</div>

</div>