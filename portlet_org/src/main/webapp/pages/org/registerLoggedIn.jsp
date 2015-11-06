<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@ include file="../shared/init.jsp"%>

<% 
  Log log = LogFactoryUtil.getLog(this.getClass().getName());
 
  %>

<div class="container">


	<div class="jumbotron">
		<h1>
			<spring:message code="org.registration.loggedin.title" />
		</h1>
		<p>
			<spring:message code="org.registration.loggedin.descr" />
		</p>
		<a class="btn btn-lg btn-primary" href="/c/portal/logout"><span
			class="glyphicon glyphicon-log-out"></span>&nbsp;<spring:message
				code="org.registration.loggedin.btn" /></a>
	</div>

</div>