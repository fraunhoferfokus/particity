<%@page import="de.particity.model.I_CategoryEntryModel"%>
<%@page import="de.particity.model.I_CategoryModel"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomCategoryServiceHandler"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@ include file="../shared/init.jsp"%>

<% 
  Log log = LogFactoryUtil.getLog(this.getClass().getName());
 
  boolean isEnabled = CustomPortalServiceHandler.isConfigEnabled(E_ConfigKey.ENABLE_NEWSLETTER);

  %>

<portlet:actionURL var="addUrl">
	<portlet:param name="action" value="addUser" />
</portlet:actionURL>

<div class="container-fluid">

	<div class="page-header">
		<h1>
			<spring:message code="user.register.jsp.title" />
			&nbsp;&nbsp;<small><spring:message
					code="user.register.jsp.descr" /></small>
		</h1>
	</div>

  <%
   if (isEnabled) {
  %>

	<form:form modelAttribute="data" id="approveOfferForm"
		data-ajax="false" method="post" action="<%= addUrl %>">

		<div class="row">
			<h3>
				<spring:message code="user.form.register.title.basic" />
			</h3>
			<div class="col-xs-12 jumbotron">
				<bform:bffield path="mail" label="user.form.register.field.mail"
					helpLabel="user.form.register.field.mail.help" type="text"
					required="true" />
			</div>
		</div>

		<div class="row">
			<h3>
				<spring:message code="user.form.register.title.categories" />
			</h3>
			<div class="col-xs-12 jumbotron">
				<%
      
      List<I_CategoryModel> rootcats = CustomCategoryServiceHandler.getCategoryByType(E_CategoryType.SEARCH);
      
      List<I_CategoryEntryModel> childs;
      for (I_CategoryModel rootcat: rootcats) {
        childs = CustomCategoryServiceHandler.getCategoryEntriesByCategoryIdSorted(rootcat.getId());
        if (childs != null && childs.size() > 0) {
          %>
				<h4><%= rootcat.getName() %>&nbsp;&nbsp;<small><%= rootcat.getDescription() %></small>
				</h4>
				<div class="row">
					<!-- start childs -->
					<%
          List<I_CategoryEntryModel> innerChilds;   
          for (I_CategoryEntryModel child: childs) {
            innerChilds = CustomCategoryServiceHandler.getChildCategoryEntriesByCategoryEntryId(child.getId());
            if (innerChilds == null || innerChilds.size() == 0) {
            %>

					<!-- div class="col-md-3"-->
					<bform:bffield path="categories" directLabel="true"
						label="<%= child.getName() %>"
						value="<%= Long.toString(child.getId()) %>" type="checkbox"
						required="false" />
					<!-- /div-->


					<%
            } else {
              %>
					<div class="col-xs-12">
						<h5><%= child.getName() %></h5>
						<div class="row">
							<%
                 
                 for (I_CategoryEntryModel innerChild: innerChilds) {
                   %>
							<!-- div class="col-md-3"-->

							<bform:bffield path="categories" directLabel="true"
								label="<%= innerChild.getName() %>"
								value="<%= Long.toString(innerChild.getId()) %>"
								type="checkbox" required="false" />

							<!-- /div-->
							<%
                 }
                 
                 %>
						</div>
					</div>
					<%  
            }
            
          }
          
          %>
				</div>
				<!-- end childs -->
				<%
        }
      }
      
      %>
			</div>

		</div>


		<hr />

		<div class="row">
			<div class="col-xs-12">
				<button type="submit" class="btn btn-lg btn-primary">
					<span class="glyphicon glyphicon-ok"></span>&nbsp;
					<spring:message code="user.form.register.submit" />
				</button>
			</div>
		</div>
	</form:form>

  <%
    } 
   // newsletter not enabled
   else {
    	%>
    	
    	<div class="alert alert-info">
    	 <spring:message code="user.newsletter.disabled" />
    	</div>
    	
    	<%
    }
  %>

</div>