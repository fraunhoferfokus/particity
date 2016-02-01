<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_Role"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.portlet.init.E_ContextPath"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.Constants"%>
<%@page contentType="text/html" isELIgnored="false"%>
<%@page pageEncoding="UTF-8"%>

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

<div class="container-fluid">

  <div class="page-header">
    <h1><img style="height: 50px; width: auto;" src="/painit-portlet/images/logo.png">&nbsp;Particity - Setup</h1>
  </div>
  
  <portlet:actionURL var="initParticityUrl">
     <portlet:param name="action" value="initParticity" />
  </portlet:actionURL>
  
  <form data-ajax="false" method="post" action="${initParticityUrl}">
      <div class="content">
	  <div class="row">
	    <h2>Rollen&nbsp;<small>Über Rollen werden unterschiedliche Funktionalitäten des Portals voneinander abgegrenzt. Neue Nutzer bekommen eine dieser Rollen zugewiesen.</small></h2>
	    <div class="col-xs-10 col-xs-offset-1">
	      <div class="row" style="margin-top: 20px;">
	        <div class="col-sm-6"><strong>Rollenbeschreibung</strong></div>
	        <div class="col-sm-6"><strong>Rollenname im System</strong></div>
	      </div>
	      <div class="row" style="margin-top: 20px;">
	        <div class="col-sm-6"><strong>Administration</strong><br/><i>Die Administration verwaltet die grundlegenden Datenlisten (Suchkategorien, Länder, etc.)</i></div>
	        <div class="col-sm-6"><input type="text" class="form-control input-lg" name="role_<%= E_Role.ADMIN.toString() %>" value="<%= CustomPortalServiceHandler.getRoleName(E_Role.ADMIN) %>"></div>
	      </div>
	      <div class="row" style="margin-top: 20px;">
          <div class="col-sm-6"><strong>Organisation</strong><br/><i>Organisationen können sich am Portal anmelden und Angebote einstellen, die für Nutzer sichtbar sind</i></div>
          <div class="col-sm-6"><input type="text" class="form-control input-lg" name="role_<%= E_Role.ORG.toString() %>" value="<%= CustomPortalServiceHandler.getRoleName(E_Role.ORG) %>"></div>
        </div>
        <div class="row" style="margin-top: 20px;">
          <div class="col-sm-6"><strong>Verwaltung</strong><br/><i>Die Verwaltung moderiert neue Organisationen und deren Angebote und kann grundlegende inhaltliche Einstellungen vornehmen</i></div>
          <div class="col-sm-6"><input type="text" class="form-control input-lg" name="role_<%= E_Role.MGMT.toString() %>" value="<%= CustomPortalServiceHandler.getRoleName(E_Role.MGMT) %>"></div>
        </div>
	    </div>
	  </div>
	  <div class="row" style="margin-top: 40px;">
      <h2>Portlets&nbsp;<small>Das Portal setzt sich aus einzelnen Bausteinen (Portlets) zusammen, die jeweils einen Teil der Basisfunktionalität von Particity ausmachen. Diese Bausteine werden Seiten zugeordnet, die über eine URL erreichbar sind.</small></h2>
      <div class="col-xs-10 col-xs-offset-1">
        <div class="row"  style="margin-top: 20px;">
          <div class="col-sm-6"><strong>Seite</strong></div>
          <div class="col-sm-6"><strong>URL der Zielseite</strong></div>
        </div>
        <div class="row" style="margin-top: 20px;">
          <div class="col-sm-6"><strong>Willkommen</strong><br/><i>Die Startseite ist der Einstiegspunkt für Besucher Ihrer Seite.</i></div>
          <div class="col-sm-6"><input type="text" class="form-control input-lg" name="page_<%= E_ContextPath.HOME.toString() %>" value="<%= E_ContextPath.HOME.getPath() %>"></div>
        </div>
        <div class="row" style="margin-top: 20px;">
          <div class="col-sm-6"><strong>Suche</strong><br/><i>Über die Suche können Nutzer die von Organisationen eingetragenen Gesuche ansehen und nach Kategorien filtern.</i></div>
          <div class="col-sm-6"><input type="text" class="form-control input-lg" name="page_<%= E_ContextPath.SEARCH.toString() %>" value="<%= E_ContextPath.SEARCH.getPath() %>"></div>
        </div>
        <div class="row" style="margin-top: 20px;">
          <div class="col-sm-6"><strong>Administration</strong><br/><i>Über das Administrations-Portlet können Datenlisten gepflegt und Import/Export des Datenbestandes durchgeführt werden.</i></div>
          <div class="col-sm-6"><input type="text" class="form-control input-lg" name="page_<%= E_ContextPath.ADM.toString() %>" value="<%= E_ContextPath.ADM.getPath() %>"></div>
        </div>
        <div class="row" style="margin-top: 20px;">
          <div class="col-sm-6"><strong>Organisation</strong><br/><i>Über das Organisations-Portlet können Organisationen ihre Angaben verwalten, Benutzer verwalten und Gesuche einstellen.</i></div>
          <div class="col-sm-6"><input type="text" class="form-control input-lg" name="page_<%= E_ContextPath.ORG.toString() %>" value="<%= E_ContextPath.ORG.getPath() %>"></div>
        </div>
        <div class="row" style="margin-top: 20px;">
          <div class="col-sm-6"><strong>Verwaltung</strong><br/><i>Über das Verwaltungs-Portlet kann die Verwaltung Organisationen und Angebote einsehen und moderieren, Newsletter-Nutzer auflisten und inhaltliche Konfigurationseinstellungen vornehmen.</i></div>
          <div class="col-sm-6"><input type="text" class="form-control input-lg" name="page_<%= E_ContextPath.MGMT.toString() %>" value="<%= E_ContextPath.MGMT.getPath() %>"></div>
        </div>
        <div class="row" style="margin-top: 20px;">
          <div class="col-sm-6"><strong>Newsletter</strong><br/><i>Über das Newsletter-Portlet kann ein eingetragener Nutzer seine aktuellen abonnierten Newsletter verwalten.</i></div>
          <div class="col-sm-6"><input type="text" class="form-control input-lg" name="page_<%= E_ContextPath.USR_NEWSLETTER.toString() %>" value="<%= E_ContextPath.USR_NEWSLETTER.getPath() %>"></div>
        </div>
        <div class="row" style="margin-top: 20px;">
          <div class="col-sm-6"><strong>Registrierung - Organisation</strong><br/><i>Über das Portlet zur Registrierung von Organisationen wird das Formular zur Anmeldung neuer Organisationen angezeigt.</i></div>
          <div class="col-sm-6"><input type="text" class="form-control input-lg" name="page_<%= E_ContextPath.ORG_REGISTRATION.toString() %>" value="<%= E_ContextPath.ORG_REGISTRATION.getPath() %>"></div>
        </div>
        <div class="row" style="margin-top: 20px;">
          <div class="col-sm-6"><strong>Registrierung - Newsletter</strong><br/><i>Über das Portlet zur Registrierung von Newslettern wird das Formular zum Eintragen eines Newsletters angezeigt.</i></div>
          <div class="col-sm-6"><input type="text" class="form-control input-lg" name="page_<%= E_ContextPath.USR_REGISTRATION.toString() %>" value="<%= E_ContextPath.USR_REGISTRATION.getPath() %>"></div>
        </div>
        <div class="row" style="margin-top: 20px;">
          <div class="col-sm-6"><strong>Nutzer - Profil</strong><br/><i>Die Profileinstellungen erlauben das Ändern von E-Mail-Adresse und Passwort für angemeldete Nutzer (Organisationen, Verwaltung)</i></div>
          <div class="col-sm-6"><input type="text" class="form-control input-lg" name="page_<%= E_ContextPath.PROFILE.toString() %>" value="<%= E_ContextPath.PROFILE.getPath() %>"></div>
        </div>
        <div class="row" style="margin-top: 20px;">
          <div class="col-sm-6"><strong>Datenschutz</strong><br/><i>Auf dieser Seite könenn Sie Ihre Richtlinien zum Datenschutz hinterlegen</i></div>
          <div class="col-sm-6"><input type="text" class="form-control input-lg" name="page_<%= E_ContextPath.DATAPOLICY.toString() %>" value="<%= E_ContextPath.DATAPOLICY.getPath() %>"></div>
        </div>
        <div class="row" style="margin-top: 20px;">
          <div class="col-sm-6"><strong>Impressum</strong><br/><i>Auf dieser Seite könenn Sie Ihr Impressum hinterlegen</i></div>
          <div class="col-sm-6"><input type="text" class="form-control input-lg" name="page_<%= E_ContextPath.LEGALDETAILS.toString() %>" value="<%= E_ContextPath.LEGALDETAILS.getPath() %>"></div>
        </div>
      </div>
    </div>
    <div class="row" style="margin-top: 40px;">
        <h2>Beispielinhalte hinzufügen&nbsp;<small>Über Beispielinhalte erhalten Sie sofort eine erste Orientierung für die Strukturierung Ihrer Seite</small></h2>
        <div class="col-xs-10 col-xs-offset-1">
          <div class="checkbox">
            <label>
              <input type="checkbox" name="opt_SAMPLECONTENT" checked> Kategorien hinzufügen (Suchkategorien, Länder, Arbeitszeiten)
            </label>
          </div>
        </div>
        <div class="col-xs-10 col-xs-offset-1">
          <div class="checkbox">
            <label>
              <input type="checkbox" name="opt_SAMPLEUSER" checked> Verwaltungszugang einrichten (Voreinstellung: User <i>mgmt@particity.de</i>, Passwort <i>test</i>)
            </label>
          </div>
        </div>
        <div class="col-xs-4 col-xs-offset-2">
         <div class="form-group">
           <label for="mgmtMail">E-Mail Adresse</label>
           <input type="email" name="opt_SAMPLEUSERNAME" class="form-control input-lg" id="mgmtMail" value="mgmt@particity.de">
         </div>
        </div>
        <div class="col-xs-4">
         <div class="form-group">
           <label for="mgmtPass">Passwort</label>
           <input type="password" name="opt_SAMPLEUSERPASS" class="form-control input-lg" id="mgmtPass" value="test">
         </div>
        </div>
      </div>
    </div>
    <div class="row footer">
      <div class="col-xs-10 col-xs-offset-1 text-right">
        <button class="btn btn-adhoc btn-lg" type="submit">Konfiguration abschließen</button>
      </div>
    </div>
  </form>
</div>
