<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHCatEntriesLocalServiceUtil"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHCatEntries"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHCategoriesLocalServiceUtil"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHCategories"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ include file="../shared/init.jsp"%>

<% 
  Log log = LogFactoryUtil.getLog(this.getClass().getName());
 
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
      
      List<AHCategories> rootcats = AHCategoriesLocalServiceUtil.getCategories(E_CategoryType.SEARCH.getIntValue());
      
      List<AHCatEntries> childs;
      for (AHCategories rootcat: rootcats) {
        childs = AHCatEntriesLocalServiceUtil.getCategoryEntriesChildsSorted(rootcat.getCatId());
        if (childs != null && childs.size() > 0) {
          %>
				<h4><%= rootcat.getName() %>&nbsp;&nbsp;<small><%= rootcat.getDescr() %></small>
				</h4>
				<div class="row">
					<!-- start childs -->
					<%
          List<AHCatEntries> innerChilds;   
          for (AHCatEntries child: childs) {
            innerChilds = AHCatEntriesLocalServiceUtil.getChildEntriesById(child.getItemId());
            if (innerChilds == null || innerChilds.size() == 0) {
            %>

					<!-- div class="col-md-3"-->
					<bform:bffield path="categories" directLabel="true"
						label="<%= child.getName() %>"
						value="<%= Long.toString(child.getItemId()) %>" type="checkbox"
						required="false" />
					<!-- /div-->


					<%
            } else {
              %>
					<div class="col-xs-12">
						<h5><%= child.getName() %></h5>
						<div class="row">
							<%
                 
                 for (AHCatEntries innerChild: innerChilds) {
                   %>
							<!-- div class="col-md-3"-->

							<bform:bffield path="categories" directLabel="true"
								label="<%= innerChild.getName() %>"
								value="<%= Long.toString(innerChild.getItemId()) %>"
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

</div>