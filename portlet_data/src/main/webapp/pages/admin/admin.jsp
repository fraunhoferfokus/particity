
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="de.particity.impexp.ExportWriter"%>
<%@page import="org.springframework.ui.Model"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.Constants"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHOfferLocalServiceUtil"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.portlet.admin.AdminController"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHCatEntries"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHCatEntriesLocalServiceUtil"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.model.impl.AHCategoriesImpl"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHCategories"%>
<%@page import="java.util.List"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHCategoriesLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@include file="../shared/init.jsp"%>

<% 
  Log log = LogFactoryUtil.getLog(this.getClass().getName());
 
 
  String requestedTab = request.getParameter("tab");
  if (requestedTab == null)
	    requestedTab = E_CategoryType.SEARCH.name();
  
  String requestCatId = request.getParameter("catId");
  if (requestCatId == null)
	  requestCatId = "-1";
  
  String exportFilename = request.getParameter("exportFilename");
  String errorCode = request.getParameter("errorCode");
  
  Map<String, String> exportLogs = (Map<String, String>) request.getAttribute("exportLogs");
  Map<String, String> importLogs = (Map<String, String>) request.getAttribute("importLogs");
  
  %>

<div class="container-fluid">

  <!-- if demo-mode enabled, notify about denied actions -->
    
	<div class="page-header">
	 <div class="row">
	   <div class="col-sm-12">
		   <h1>
	      <spring:message code="admin.jsp.title" />
	      &nbsp;&nbsp;<small><spring:message code="admin.jsp.descr" /></small>
	    </h1>
	   </div>
	 </div>
	</div>
	
	<liferay-ui:error key="common.demo.denied">
       <spring:message code="common.demo.denied" />
   </liferay-ui:error>
    <% if (errorCode != null && errorCode.trim().length() > 0) { 
        String emsg = LanguageUtil.get(portletConfig,locale,errorCode);
    %>
      <div class="alert alert-error">
       <%= emsg %>
      </div>
    <% } %>

	
	<div role="tabpanel">

		<!-- Nav tabs -->
		<ul class="nav nav-tabs" role="tablist">
			<%
    E_CategoryType[] ctypes = E_CategoryType.values();
    String activeFlag;
    E_CategoryType ctype;
    for (int i=0; i<ctypes.length; i++) {
    	activeFlag="";
    	ctype = ctypes[i];
    	if (ctype.name().equals(requestedTab))
    		activeFlag="active";
    %>
			<li role="presentation" class="<%= activeFlag %>"><a
				href="#<%=  ctype.name() %>" aria-controls="<%=  ctype.name() %>" role="tab"
				data-toggle="tab"><span class="glyphicon glyphicon-th-list"></span>&nbsp;<spring:message
						code="<%= ctype.getMsgProperty() %>" /></a></li>

			<% } %>
			<li role="presentation"><a
        href="#dbtools" aria-controls="dbtools" role="tab"
        data-toggle="tab"><span class="glyphicon glyphicon-floppy-disk"></span>&nbsp;<spring:message
            code="admin.tabs.dbimpexp" /></a></li>
		</ul>

		<!-- Tab panes -->
		<div class="tab-content">
			<%
	    for (int i=0; i<ctypes.length; i++) {
	      ctype = ctypes[i];
	      activeFlag="";
	      if (ctype.name().equals(requestedTab))
	          activeFlag="active";
	    %>

			<div role="tabpanel" class="tab-pane <%= activeFlag %>"
				id="<%= ctype.name() %>">
				<div class="panel-group" id="accordion" role="tablist"
					aria-multiselectable="true" style="margin-top: 20px;">
					<%
			  List<AHCategories> categories = AHCategoriesLocalServiceUtil.getCategories(ctype.getIntValue());
			  String disabledStr = "";
			  String activeStr = "";
			  String catId;
			  List<AHCatEntries> childs;
			  for (AHCategories category: categories) {
				  disabledStr = "";
				  catId = Long.toString(category.getCatId());
				  activeStr = catId.equals(requestCatId) ? "in" : "";
				  childs = AHCatEntriesLocalServiceUtil.getCategoryEntries(category.getCatId());
				  if (childs.size() > 0)
					  disabledStr = "disabled";
				%>

					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="heading<%= catId %>">
							<div class="row">
								<div class="col-xs-8">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion"
											href="#collapse<%= catId %>" aria-expanded="true"
											aria-controls="collapse<%= catId %>"> <%= category.getName() %>
										</a>&nbsp;&nbsp; <small>(ID: <%= Long.toString(category.getCatId()) %>)<%= category.getDescr() %></small>
									</h4>
								</div>
								<div class="col-xs-4" style="text-align: right;">
									<a
										href="<portlet:actionURL>
                         <portlet:param name="action" value="removeCategory" />
                         <portlet:param name="catId" value="<%= Long.toString(category.getCatId()) %>" />
                       </portlet:actionURL>"
										class="btn btn-default <%=demoDisabled %>" <%= disabledStr %>><spring:message
											code="admin.panel.category.delete" /></a>
								</div>
							</div>
						</div>
						<% if (ctype.getLevel() > 1) { %>
						<div id="collapse<%= catId %>"
							class="panel-collapse collapse <%= activeStr %>" role="tabpanel"
							aria-labelledby="heading<%= catId %>">
							<div class="panel-body">
								<portlet:actionURL var="addCategoryEntryUrl">
									<portlet:param name="action" value="addCategoryEntry" />
								</portlet:actionURL>
								<form:form modelAttribute="data" id="addCategoryEntryForm"
									data-ajax="false" method="post" action="${addCategoryEntryUrl}">
									<fieldset <%= demoDisabled %>>
									<bform:bffield path="type" type="hidden"
										value="<%= ctype.name() %>" />

									<table class="table table-striped">
										<tr>
											<th><spring:message code="admin.table.catEntries.name" /></th>
											<th><spring:message code="admin.table.catEntries.descr" /></th>
											<th><spring:message code="admin.table.catEntries.parent" /></th>
											<th><spring:message code="admin.table.catEntries.action" /></th>
										</tr>

										<%
				        Map<Long, String> selectValues = AHCatEntriesLocalServiceUtil.getEntryMapForCatId(category.getCatId());
				        List<AHCatEntries> dependencies = null;
				        int childOfferSize = 0;
				        for (AHCatEntries child: childs) {
				        	childOfferSize = 0;
				        	disabledStr = "";
				        	String parentStr = "-";
				        	if (child.getParentId() >= 0) {
				        		  AHCatEntries parent = AHCatEntriesLocalServiceUtil.getCategoryEntryById(child.getParentId());
				        		  if (parent != null)
				        			  parentStr = parent.getName();
				        	}
				        	dependencies = AHCatEntriesLocalServiceUtil.getChildEntriesById(child.getItemId());
				        	
				        	childOfferSize = AHOfferLocalServiceUtil.countOfferByCategoryItems(new String[]{Long.toString(child.getItemId())});
				        	
				        	if (dependencies.size() > 0)
				        	 disabledStr = "disabled";
				        	//log.info("Adding child to select values: "+child.getItemId()+","+child.getName());
                  //selectValues.put(Long.toString(child.getItemId()), child.getName());// = AHCatEntriesLocalServiceUtil.getEntryMapForCatId(child.getCatId());
				        	

                  
				        	%>
										<tr>
											<td><%= child.getName() %></td>
											<td><%= child.getDescr() %></td>
											<td><%= parentStr %></td>
											<td><a href="#"
												onclick="createModal('#modal','<spring:message code="admin.form.addCatEntry.deleteHeader"/>','<spring:message code="admin.form.addCatEntry.deleteBody"/><%= Integer.toString(childOfferSize)%>','<spring:message code="admin.form.addCatEntry.deleteAbort"/>','<spring:message code="admin.form.addCatEntry.deleteOk"/>','<portlet:actionURL>
                                <portlet:param name="action" value="removeCategoryEntry" />
                                <portlet:param name="catId" value="<%= catId %>" />
                                <portlet:param name="itemId" value="<%= Long.toString(child.getItemId()) %>" />
                                </portlet:actionURL>')"
												class="btn btn-default" <%= disabledStr %>><span
													class="glyphicon glyphicon-minus" aria-hidden="true"></span>&nbsp;
													<spring:message code="admin.form.addCatEntry.delete" /> </a></td>
										</tr>
										<%
				        }
				        //selectValues.put("-1", "-");
				      
				        %>

										<tr>
											<td><bform:bffield path="name" type="text"
													required="true" /></td>
											<td><bform:bffield path="descr" type="textarea"
													cssClass="input-lg" required="true" /></td>
											<td><form:select cssClass="form-control" path="parent">
													<form:option value="-1" label="-"></form:option>
													<%
			              
			              for (Long key: selectValues.keySet()) {
			            	  String val = selectValues.get(key);
			            	  %>
													<form:option value="<%= Long.toString(key) %>"
														label="<%= val %>"></form:option>
													<%
			              }
			              
			              %>
												</form:select></td>
											<td><bform:bffield path="cat" type="hidden"
													required="true"
													value="<%= Long.toString(category.getCatId()) %>" />
												<button type="submit" class="btn btn-default">
													<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;
													<spring:message code="admin.form.addCatEntry.submit" />
												</button></td>
										</tr>

									</table>
									</fieldset>
								</form:form>
							</div>
						</div>
						<% 
			     } // END: check of category depth/level
			    %>
					</div>

					<%  
				  
			  }
			 %>
				</div>
				<hr />
				<div class="jumbotron">
					<h2>
						<spring:message code="admin.form.addMainCat.title" />
					</h2>
					<p>
						<portlet:actionURL var="addCategoryUrl">
							<portlet:param name="action" value="addMainCategory" />
						</portlet:actionURL>
						<form:form modelAttribute="data" id="addMainCategoryForm"
							data-ajax="false" method="post" action="${addCategoryUrl}" acceptCharset="UTF-8" enctype="application/x-www-form-urlencoded; charset=utf-8">
						  <fieldset <%= demoDisabled %>>
								<bform:bffield path="type" type="hidden"
									value="<%= ctype.name() %>" />
								<bform:bffield path="name"
									label="admin.form.addMainCat.field.name" type="text"
									required="true" />
								<bform:bffield path="descr"
									label="admin.form.addMainCat.field.descr" cssClass="input-lg"
									type="textarea" required="true" />
								<button type="submit" class="btn btn-lg btn-default">
									<span class="glyphicon glyphicon-ok"></span>&nbsp;
									<spring:message code="admin.form.addMainCat.submit" />
								</button>
							</fieldset>
						</form:form>
					</p>
				</div>



			</div>
			<% } 
			%>
			
			<div role="tabpanel" class="tab-pane <%= (requestedTab.equals("dbtools") ? "active" : " ") %>"
        id="dbtools">

        <h2><spring:message code="admin.tab.db.export" /></h2>
        <% if (exportFilename != null) { %>
         <div class="alert alert-success">
	         <spring:message code="admin.tab.db.export.success" /><br/>
	         <%= exportFilename %>
         </div>
       <% } 
          if (exportLogs != null) {
        	  %>
        	  <div class="alert alert-info">
        	  <spring:message code="admin.tab.db.export.log.intro" /><br/><br/>
        	  <%
        	  for (String name : exportLogs.keySet()) {
        		  String value = exportLogs.get(name);
        		  if (value.length() > 0) {
        			  String msg = LanguageUtil.get(portletConfig,locale,"admin.tab.db.export.log."+name.toLowerCase().trim());
	        		  %>
	        	      <strong><%= msg %></strong>:<br/>
	        	      <%= value %><br/><br/>
	        		  <%
        		  }
        	  }
        	  %>
        	  </div>
        	  <%
          }
       %>
       <a href="<portlet:actionURL><portlet:param name="action" value="exportDatabase" /></portlet:actionURL>" class="btn btn-default">
	       <span class="glyphicon glyphicon-save"></span>&nbsp;
	       <spring:message code="admin.tab.db.exportSubmit" />
       </a>
       
       <h2 style="margin-top: 50px;"><spring:message code="admin.tab.db.import" /></h2>
       <%
        if (importLogs != null) {
           %>
           <div class="alert alert-info">
           <spring:message code="admin.tab.db.import.log.intro" /><br/><br/>
           <%
           for (String name : importLogs.keySet()) {
             String value = importLogs.get(name);
             if (value.length() > 0) {
               String msg = LanguageUtil.get(portletConfig,locale,"admin.tab.db.import.log."+name.toLowerCase().trim());
               %>
                 <strong><%= msg %></strong>:<br/>
                 <%= value %><br/><br/>
               <%
             }
           }
           %>
           </div>
           <%
         }
       %>
       <form method="post" action="<portlet:actionURL><portlet:param name="action" value="importDatabase" /></portlet:actionURL>" enctype="multipart/form-data">
          <input id="databaseImport" type="file" name="file" class="file" data-show-preview="false"
       data-browsetext="<spring:message code="admin.tab.db.importBrowse" />" data-uploadtext="<spring:message code="admin.tab.db.importUpload" />" data-deletetext="<spring:message code="admin.tab.db.importDelete" />">    
       </form>
       
      </div>
		</div>

	</div>
</div>


<div class="yui3-skin-sam">
	<div id="modal"></div>
</div>