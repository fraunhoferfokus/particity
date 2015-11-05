
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomLockServiceHandler"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHOrgLocalServiceUtil"%>
<%@page
	import="org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHOrg"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHOffer"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.forms.OfferForm"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferWorkType"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferType"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHCatEntries"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHCatEntriesLocalServiceUtil"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHCategories"%>
<%@page import="java.util.List"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHCategoriesLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ include file="init.jsp"%>

<portlet:actionURL var="addUrl">
	<portlet:param name="action" value="addOffer" />
</portlet:actionURL>

<portlet:actionURL var="saveUrl">
	<portlet:param name="action" value="saveOffer" />
</portlet:actionURL>

<portlet:actionURL var="approveUrl">
	<portlet:param name="action" value="approveOffer" />
</portlet:actionURL>




<% 
  Log log = LogFactoryUtil.getLog(this.getClass().getName());
 
  String ctxPth = request.getContextPath();

  OfferForm data = (OfferForm) request.getAttribute("data");
  
  %>


<portlet:actionURL var="intBackUrl">
	<portlet:param name="action" value="unlock" />
	<portlet:param name="offerId"
		value="<%= Long.toString(data.getOfferId()) %>" />
</portlet:actionURL>

<portlet:renderURL var="searchBackUrl">
</portlet:renderURL>

<%
  
  //Object countries = request.getAttribute("countries");
  //Object workhours = request.getAttribute("workhours");
  
  AHOrg orga = null;
  
  String actionType = request.getParameter("actionType");
  
  boolean isReadOnly = false;
  boolean isChangeAllowed = true;
  boolean showHeader = false;
  boolean showTitle = false;
  String formUrl = addUrl;
  String backUrl = intBackUrl;
  if (actionType != null) {
	  isChangeAllowed = data.getOfferId() >= 0 && !CustomLockServiceHandler.isLocked(AHOffer.class.getName(), data.getOfferId(), themeDisplay);
	  
	  if (actionType.equals("edit")) {
		  formUrl = saveUrl;
	  }
	  else if (actionType.equals("approve")) {
	      formUrl = approveUrl;
	      isReadOnly = true;
	      long orgId = data.getOrgId();
	      if (orgId >= 0) {
	    	  try {
	    		  orga = AHOrgLocalServiceUtil.getAHOrg(orgId);
	    	  } catch (Throwable t) {
	    		  log.error(t);
	    	  }
	      }
	  } else if (actionType.equals("view")) {
		  isReadOnly = true;
	  } else if (actionType.equals("search")) {
		  isReadOnly = true;
	    backUrl = searchBackUrl;
	  }
	  
  } else {
	  showHeader = true;
	  showTitle = true;
  }
  
  
  %>



<script>
       $(function() {
         setMarkerBase("<%=ctxPth%>");
       });
   </script>

<div id="offer" class="container-fluid">

	<%
  if (showHeader) {
	  %>
	<div class="page-header">
		<h1>
			<spring:message code="org.intern.jsp.title" />
			&nbsp;&nbsp;<small><spring:message
					code="org.intern.jsp.descr" /></small>
		</h1>
	</div>
	<%
  }
 %>

	<a class="btn btn-default" href="<%= backUrl %>"><spring:message
			code="org.offer.back" /></a>

	<%
 if (showTitle) {
	 %>
	<h2>
		<spring:message code="org.offer.form.title" />
	</h2>
	<%
 }
 %>



	<%
  if (!isChangeAllowed) {
      
      %>
	<div class="row">
		<div class="col-xs-12">
			<div class="alert alert-error" role="alert">
				<spring:message code="org.offer.form.locked" />
			</div>
		</div>
	</div>

	<%
    }
  %>

	<form:form modelAttribute="data" id="approveOfferForm"
		data-ajax="false" method="post" action="<%= formUrl %>">

		<bform:bffield path="offerId" type="hidden"
			value="<%= Long.toString(data.getOfferId()) %>" />
		<bform:bffield path="orgId" type="hidden"
			value="<%= Long.toString(data.getOrgId()) %>" />
		<bform:bffield path="addrLat" type="hidden"
			value="<%= Float.toString(data.getAddrLat()) %>" />
		<bform:bffield path="addrLon" type="hidden"
			value="<%= Float.toString(data.getAddrLon()) %>" />

		<div class="row">
			<div class="col-md-12">

				<div class="row">
					<h3>
						<spring:message code="org.offer.form.title.common" />
					</h3>
					<div class="col-xs-12 jumbotron">
						<div class="row">
							<div class="col-md-4">
								<bform:bffield path="title" label="org.form.offer.field.title"
									helpLabel="org.form.offer.field.title.help" type="text"
									required="true"
									readonly="<%= isReadOnly ? \"true\" : \"false\" %>" />
								<div class="row">
									<div class="col-xs-7">
										<bform:bffield path="publishDate"
											label="org.form.offer.field.publishDate"
											helpLabel="org.form.offer.field.publishDate.help" type="date"
											required="true"
											readonly="<%= isReadOnly ? \"true\" : \"false\" %>" />
									</div>
									<div class="col-xs-5">
										<bform:bffield path="publishTime"
											label="org.form.offer.field.publishTime"
											helpLabel="org.form.offer.field.publishTime.help" type="time"
											required="true"
											readonly="<%= isReadOnly ? \"true\" : \"false\" %>" />
									</div>
								</div>
								<div class="row">
									<div class="col-xs-7">
										<bform:bffield path="expireDate"
											label="org.form.offer.field.expireDate"
											helpLabel="org.form.offer.field.expireDate.help" type="date"
											required="true"
											readonly="<%= isReadOnly ? \"true\" : \"false\" %>" />

									</div>
									<div class="col-xs-5">
										<bform:bffield path="expireTime"
											label="org.form.offer.field.expireTime"
											helpLabel="org.form.offer.field.expireTime.help" type="time"
											required="true"
											readonly="<%= isReadOnly ? \"true\" : \"false\" %>" />
									</div>
								</div>


							</div>
							<div class="col-md-8">
								<bform:bffield path="descr" label="org.form.offer.field.descr"
									helpLabel="org.form.offer.field.descr.help" type="textarea"
									required="true" rows="8"
									readonly="<%= isReadOnly ? \"true\" : \"false\" %>" />
							</div>
						</div>
						<div class="row">
							<div class="col-md-4">
								<div class="form-group">
									<label class="control-label" for="type"> <spring:message
											code="org.form.offer.field.type" /> <span
										class="required text-error"> *</span> <%
		            if (!isReadOnly) {
		            	%> <span
										class="pull-right text-info glyphicon glyphicon-question-sign"
										data-toggle="tooltip" data-placement="top"
										title="<spring:message code="org.form.offer.field.type.help"/>"></span>
										<%
		            }
		           %>

									</label>
									<form:select cssClass="form-control input-lg" path="type"
										disabled="<%= isReadOnly ? \"true\" : \"false\" %>">
										<%
	             
	             for (E_OfferType type: E_OfferType.values()) {
	               %>
										<form:option value="<%= type.toString() %>">
											<spring:message code="<%= type.getMsgProperty() %>" />
										</form:option>
										<%
	             }
	             
	             %>
									</form:select>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="control-label" for="workType"> <spring:message
											code="org.form.offer.field.workType" /> <%
                if (!isReadOnly) {
             %> <span
										class="pull-right text-info glyphicon glyphicon-question-sign"
										data-toggle="tooltip" data-placement="top"
										title="<spring:message code="org.form.offer.field.workType.help"/>"></span>
										<%
                }
             %>
									</label>
									<form:select cssClass="form-control input-lg" path="workType"
										disabled="<%= isReadOnly ? \"true\" : \"false\" %>">
										<%
             
             for (E_OfferWorkType type: E_OfferWorkType.values()) {
               %>
										<form:option value="<%= type.toString() %>">
											<spring:message code="<%= type.getMsgProperty() %>" />
										</form:option>
										<%
             }
             
             %>
									</form:select>
								</div>
							</div>
							<div class="col-md-4">
								<%
                if (isReadOnly) {
		             %>
								<bform:bffield path="workHours"
									label="org.form.offer.field.workHours"
									helpLabel="org.form.offer.field.workHours.help" type="text"
									required="true"
									readonly="<%= isReadOnly ? \"true\" : \"false\" %>" />
								<%
                } else {
                	%>
								<bform:bffield items="${workhours}" path="workHours"
									label="org.form.offer.field.workHours"
									helpLabel="org.form.offer.field.workHours.help" type="select"
									required="true"
									readonly="<%= isReadOnly ? \"true\" : \"false\" %>" />
								<%
                }
             %>

							</div>
						</div>
					</div>

				</div>

				<div class="row">
					<h3>
						<spring:message code="org.offer.form.title.address" />
					</h3>
					<div class="col-xs-12 jumbotron">
						<div class="row">
							<div class="col-md-8">
								<div class="row">
									<div class="col-xs-9">
										<bform:bffield path="addrStreet"
											label="org.form.offer.field.addrStreet"
											helpLabel="org.form.offer.field.addrStreet.help" type="text"
											required="true"
											readonly="<%= isReadOnly ? \"true\" : \"false\" %>" />
									</div>
									<div class="col-xs-3">
										<bform:bffield path="addrNum"
											label="org.form.offer.field.addrNum"
											helpLabel="org.form.offer.field.addrNum.help" type="text"
											required="true"
											readonly="<%= isReadOnly ? \"true\" : \"false\" %>" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-4">
										<bform:bffield path="regionZip"
											label="org.form.offer.field.regionZip"
											helpLabel="org.form.offer.field.regionZip.help" type="text"
											required="true"
											readonly="<%= isReadOnly ? \"true\" : \"false\" %>" />
									</div>
									<div class="col-md-8">
										<bform:bffield path="regionCity"
											label="org.form.offer.field.regionCity"
											helpLabel="org.form.offer.field.regionCity.help" type="text"
											required="true"
											readonly="<%= isReadOnly ? \"true\" : \"false\" %>" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<%
	        if (isReadOnly) {
	        	%>
										<bform:bffield path="regionCountry"
											label="org.form.offer.field.regionCountry"
											helpLabel="org.form.offer.field.regionCountry.help"
											type="text" required="true"
											readonly="<%= isReadOnly ? \"true\" : \"false\" %>" />
										<%
	        } else {
	        	%>
										<bform:bffield items="${countries}" path="regionCountry"
											label="org.form.offer.field.regionCountry"
											helpLabel="org.form.offer.field.regionCountry.help"
											type="select" required="true"
											readonly="<%= isReadOnly ? \"true\" : \"false\" %>" />
										<%
	        }
	       %>

									</div>
								</div>
							</div>
							<div id="offerMap" class="map col-md-4"></div>
							<%
       if (data.getOfferId() >= 0 && data.getAddrLat() != null && data.getAddrLon() != null) {
    	   %>
							<script>
	    	   $(function() {
	    		   addMarkerToArray("<%=data.getAddrLat()%>","<%=data.getAddrLon()%>");
	    	   });
    	   </script>
							<%
       }
       %>
						</div>
					</div>

				</div>

				<div class="row">
					<div class="col-xs-8">
						<h3>
							<spring:message code="org.offer.form.title.contact" />
						</h3>
					</div>
					<div class="col-xs-4 pull-right">
						<bform:bffield path="requireAgencyContact"
							label="org.form.offer.field.requireAgencyContact"
							helpLabel="org.form.offer.field.requireAgencyContact.help"
							type="checkbox"
							readonly="<%= isReadOnly ? \"true\" : \"false\" %>" />
					</div>
				</div>

				<%
	  String disableContactFst = "false";
	  if (actionType != null && (actionType.equals("view") || (actionType.equals("approve") && !data.isRequireAgencyContact()))) {
		  disableContactFst = "true";
	  }  
	%>

				<div id="contactFst" class="row">
					<div class="col-xs-12 jumbotron">
						<div class="row">
							<div class="col-xs-6">
								<bform:bffield path="contactForename"
									label="org.form.offer.field.contactFN"
									helpLabel="org.form.offer.field.contactFN.help" type="text"
									required="true" readonly="<%= disableContactFst %>" />
							</div>
							<div class="col-xs-6">
								<bform:bffield path="contactSurname"
									label="org.form.offer.field.contactSN"
									helpLabel="org.form.offer.field.contactSN.help" type="text"
									required="true" readonly="<%= disableContactFst %>" />
							</div>
						</div>
						<div class="row">
							<div class="col-xs-6">
								<bform:bffield path="contactMail"
									label="org.form.offer.field.contactMail"
									helpLabel="org.form.offer.field.contactMail.help" type="text"
									required="true" readonly="<%= disableContactFst %>" />
							</div>
							<div class="col-xs-6">
								<bform:bffield path="contactTel"
									label="org.form.offer.field.contactPhone"
									helpLabel="org.form.offer.field.contactPhone.help" type="text"
									required="true" readonly="<%= disableContactFst %>" />
							</div>
						</div>
					</div>

				</div>

				<div class="row">
					<h3>
						<spring:message code="org.offer.form.title.contactSnd" />
					</h3>
					<div class="col-xs-12 jumbotron">
						<div class="row">
							<div class="col-xs-6">
								<bform:bffield path="contactSndForename"
									label="org.form.offer.field.contactFN"
									helpLabel="org.form.offer.field.contactFN.help" type="text"
									required="true"
									readonly="<%= isReadOnly ? \"true\" : \"false\" %>" />
							</div>
							<div class="col-xs-6">
								<bform:bffield path="contactSndSurname"
									label="org.form.offer.field.contactSN"
									helpLabel="org.form.offer.field.contactSN.help" type="text"
									required="true"
									readonly="<%= isReadOnly ? \"true\" : \"false\" %>" />
							</div>
						</div>
						<div class="row">
							<div class="col-xs-6">
								<bform:bffield path="contactSndMail"
									label="org.form.offer.field.contactMail"
									helpLabel="org.form.offer.field.contactMail.help" type="text"
									required="true"
									readonly="<%= isReadOnly ? \"true\" : \"false\" %>" />
							</div>
							<div class="col-xs-6">
								<bform:bffield path="contactSndTel"
									label="org.form.offer.field.contactPhone"
									helpLabel="org.form.offer.field.contactPhone.help" type="text"
									required="true"
									readonly="<%= isReadOnly ? \"true\" : \"false\" %>" />
							</div>
						</div>
					</div>

				</div>

				<div class="row">
					<h3>
						<spring:message code="org.offer.form.title.services" />
					</h3>
					<div class="col-xs-12 jumbotron">
						<%
      
      List<AHCategories> rootcats = AHCategoriesLocalServiceUtil.getCategories(E_CategoryType.OFFERCATS);
      
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
							<bform:bffield path="services" directLabel="true"
								label="<%= child.getName() %>"
								value="<%= Long.toString(child.getItemId()) %>" type="checkbox"
								required="false"
								readonly="<%= isReadOnly ? \"true\" : \"false\" %>" />
							<!--/div-->


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

									<bform:bffield path="services" directLabel="true"
										label="<%= innerChild.getName() %>"
										value="<%= Long.toString(innerChild.getItemId()) %>"
										type="checkbox" required="false"
										readonly="<%= isReadOnly ? \"true\" : \"false\" %>" />

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

				<div class="row">
					<h3>
						<spring:message code="org.offer.form.title.categories" />
					</h3>
					<div class="col-xs-12 jumbotron">
						<%
      
      rootcats = AHCategoriesLocalServiceUtil.getCategories(E_CategoryType.SEARCH);
      
      
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
								required="false"
								readonly="<%= isReadOnly ? \"true\" : \"false\" %>" />
							<!--/div-->


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
										type="checkbox" required="false"
										readonly="<%= isReadOnly ? \"true\" : \"false\" %>" />

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


				<%
  
    String btnDisabled = "";
    if (!isChangeAllowed) {
    	btnDisabled = "disabled=\"disabled\"";
    	
    	%>
				<div class="row">
					<div class="col-xs-12">
						<div class="alert alert-error" role="alert">
							<spring:message code="org.offer.form.locked" />
						</div>
					</div>
				</div>

				<%
    }
  
  %>

				<%
  if (actionType == null) {
  %>
				<div class="row">
					<div class="col-xs-12">
						<button type="submit" class="btn btn-lg btn-success"
							<%= btnDisabled %>>
							<span class="glyphicon glyphicon-ok"></span>&nbsp;
							<spring:message code="org.offer.form.submit" />
						</button>
					</div>
				</div>
				<%
  } else if (actionType.equals("edit")) {
	  %>
				<div class="row">
					<div class="col-xs-12">
						<button type="submit" class="btn btn-lg btn-success"
							<%= btnDisabled %>>
							<span class="glyphicon glyphicon-ok"></span>&nbsp;
							<spring:message code="org.offer.form.editSubmit" />
						</button>
					</div>
				</div>
				<%  
  } else if (actionType.equals("approve")) {
	    %>
				<div class="row">
					<div class="col-xs-12">
						<button type="submit" class="btn btn-lg btn-success"
							<%= btnDisabled %>>
							<span class="glyphicon glyphicon-ok"></span>&nbsp;
							<spring:message code="mgmt.offer.form.approveSubmit" />
						</button>
						<% if (orga != null) {
	          %>
						<a class="btn btn-lg btn-primary"
							href="mailto:<%= orga.getOwner() %>,<%= data.getContactMail() %>?subject=<spring:message code="org.offer.form.contact.subject"/>&body=<spring:message code="org.offer.form.contact.opening"/>%0A%0A<spring:message code="org.offer.form.contact.footer"/>%0A<%= CustomPortalServiceHandler.getConfigValue(E_ConfigKey.MGMT_CONTACT_NAME) %>"><span
							class="glyphicon glyphicon-envelope"></span>&nbsp;<spring:message
								code="mgmt.offer.form.contact" /></a>
						<%
	        } else {
	        	log.warn("No organisation found!");
	        }
	        %>

					</div>
				</div>
				<%  
	}
  %>

			</div>
		</div>
	</form:form>


</div>
<%
  if (actionType == null || actionType.equals("edit")) {
	  %>
<script>
	  $(function() {
		  $("input[name=requireAgencyContact]").change(function() {
			  var val = $($("#contactFst input")[0]).prop("readonly");
		    $("#contactFst input").prop("readonly",!val);
		  })
		  if ($("input[name=requireAgencyContact]").is(":checked")) {
			  $("#contactFst input").prop("readonly",true);
		  }
	  });
	  </script>
<%
  }
 
 %>