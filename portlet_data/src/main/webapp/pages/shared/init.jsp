<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.Constants"%>
<%@page contentType="text/html; charset=UTF-8"  isELIgnored="false" pageEncoding="UTF-8"%>

<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui"%>
<%@ taglib prefix="liferay-util" uri="http://liferay.com/tld/util"%>

<%@ taglib prefix="bform" tagdir="/WEB-INF/tags"%>

<%@ taglib prefix="liferay-theme" uri="http://liferay.com/tld/theme"%>

<%@ page import="java.util.ResourceBundle"%>

<%@ page import="java.util.Locale"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%


  // prepare demo mode (used as class and for input fields)
	String demoDisabled = "";
	if (Constants.RESTRICT_TO_DEMO)
	  demoDisabled = "disabled";
		  
	// disable console if not in development mode
	if (Constants.PORTAL_MODE != Constants.PORTAL_MODE_DEV) {
		%>
		<script>
		  console.log = function() {}
		</script>
		<%
	}
%>
