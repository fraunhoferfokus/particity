<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@ include file="../shared/init.jsp"%>

<% 
  Log log = LogFactoryUtil.getLog(this.getClass().getName());
 
  Object o = renderRequest.getAttribute("redirect");
  String redirectUrl = null;
  if (o != null)
	  redirectUrl = o.toString();
  
  if (redirectUrl != null) {
	  %>

<div class="container" style="margin-top: 50px;">
	<div class="jumbotron text-center">
		<h1>Willkommen</h1>
		<p>Sollten Sie nicht automatisch weitergeleitet werden, klicken
			Sie bitte hier:</p>
		<a href="<%= redirectUrl %>" class="btn btn-lg btn-primary">Weiter&nbsp;<span
			class="glyphicon glyphicon-arrow-right"></span></a>
	</div>
</div>
<script>
		  window.location = "<%= redirectUrl %>";
	  </script>
<%
  } else {
	  %>

<div class="container" style="margin-top: 50px;">
	<div class="jumbotron text-center">
		<h1>Willkommen</h1>
		<p>Sie müssen sich anmelden, um auf interne Seiten zugreifen zu
			können!</p>
		<a href="/c/portal/login" class="btn btn-lg btn-primary"><span
			class="glyphicon glyphicon-log-in"></span>&nbsp;Zur Anmeldung</a>
	</div>
</div>

<%
  }
  %>
