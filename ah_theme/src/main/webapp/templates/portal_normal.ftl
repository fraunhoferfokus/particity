<!DOCTYPE html>

<#include init />


<html class="${root_css_class} no-js" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} | Engagement </title>

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="author" content="Freiwilligen Freiburg">
	<meta name="viewport" content="initial-scale=1.0,  user-scalable=no, minimal-ui" />
	<meta content="index, follow" name="robots">
	<meta content="${the_title}" property="og:title">
	<meta content="government" property="og:type">

	<meta content="${images_folder}/oefit_webapp.png" property="og:image">
	<meta content="${the_title}" property="og:site_name">
	<meta content="${images_folder}/oefit_webapp.png" name="twitter:image">
	<meta content="DE-BE" name="geo.region">
	<meta content="Berlin" name="geo.placename">
	<meta content="52.525909;13.314292" name="geo.position">
	<meta content="52.525909, 13.314292" name="ICBM">
	<meta content="yes" name="apple-mobile-web-app-capable">
	<meta content="black-translucent" name="apple-mobile-web-app-status-bar-style">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-title" content="${the_title}">
	<link rel="apple-touch-startup-image" href="${images_folder}/oefit_webapp.png"/>
	<link rel="apple-touch-icon-precomposed" href="${images_folder}/oefit_webapp.png">
	<link rel="stylesheet" type="text/css" href="${css_folder}/shariff.complete.css">	
	<script src="${javascript_folder}/jquery-1.11.js" type="text/javascript"></script>
	${theme.include(top_head_include)}
	<link rel="stylesheet" type="text/css" href="${css_folder}/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="${css_folder}/bootstrap-theme.css">
	<script type="text/javascript" src="${javascript_folder}/modernizr.js"></script>
	<script type="text/javascript" src="${javascript_folder}/bootstrap.min.js"></script>
	<script type="text/javascript" src="${javascript_folder}/bootstrap-hover-dropdown.min.js"></script>
  <#if is_signed_in && permissionChecker.isOmniadmin()>
    <link rel="stylesheet" type="text/css" href="${css_folder}/custom-navbar.css">
  </#if>

	<link href="${images_folder}/favicon.ico" rel="Shortcut Icon">
<!--[if lt IE 9]>	
	<script src="${javascript_folder}/respond.min.js" type="text/javascript"></script>
<![endif]-->	
		
</head>

<body class="${css_class}">

<#if is_signed_in && permissionChecker.isOmniadmin()>
	<@liferay.dockbar />
</#if>


<#if is_signed_in>
    <#include "${full_templates_path}/navigation_custom.ftl" />
</#if>


<main class="container-fluid">

		<!--<div class="row"><@liferay.breadcrumbs /></div>-->
	
			<#if selectable>
				${theme.include(content_include)}
			<#else>
				${portletDisplay.recycle()}
	
				${portletDisplay.setTitle(the_title)}
	
				${theme.wrapPortlet("portlet.ftl", content_include)}
			</#if>

</main>


  <footer>
  
   <div class="row">
     <div class="col-md-4 col-xs-6">
      <#if !is_signed_in>
        <div class="shariff" data-services="[&quot;facebook&quot;,&quot;googleplus&quot;,&quot;twitter&quot;]" data-theme="grey" ></div>
      </#if>
     </div>
     <div class="col-md-4 col-xs-6 text-center">
      ${theme.runtime("ahlogin_WAR_adhocdataportlet")}
     </div>
     <div class="col-md-2 col-xs-6 text-right" style="border-right: 1px solid white;">
      Copyright © 2015<br/>
      Freiwillige Agentur Test 
     </div>
     <div class="col-md-2 col-xs-6">
      <a href="/datenschutz">Datenschutz</a><br/>
      <a href="/impressum">Impressum</a>
     </div>
   </div>
    
  
  
  </footer>

  <script src="${javascript_folder}/shariff.complete.js" type="text/javascript"></script>

  ${theme.include(body_bottom_include)}

  ${theme.include(bottom_include)}

</body>

</html>