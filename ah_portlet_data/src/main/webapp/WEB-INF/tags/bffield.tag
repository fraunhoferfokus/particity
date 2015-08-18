
<%@tag
	description="Extended input tag to allow for sophisticated errors"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>

<%@attribute name="path" required="true" type="java.lang.String"%>
<%@attribute name="cssClass" required="false" type="java.lang.String"%>
<%@attribute name="label" required="false" type="java.lang.String"%>
<%@attribute name="required" required="false" type="java.lang.Boolean"%>
<%@attribute name="prepend" required="false" type="java.lang.Boolean"%>
<%@attribute name="append" required="false" type="java.lang.Boolean"%>
<%@attribute name="icon" required="false" type="java.lang.String"%>
<%@attribute name="rows" required="false" type="java.lang.String"%>
<%@attribute name="type" required="false" type="java.lang.String"%>
<%@attribute name="items" required="false" type="java.util.Map"%>
<%@attribute name="value" required="false" type="java.lang.String"%>
<%@attribute name="directLabel" required="false"
	type="java.lang.Boolean"%>
<%@attribute name="insetLabel" required="false" type="java.lang.Boolean"%>
<%@attribute name="min" required="false" type="java.lang.String"%>
<%@attribute name="max" required="false" type="java.lang.String"%>
<%@attribute name="disabled" required="false" type="java.lang.String"%>
<%@attribute name="readonly" required="false" type="java.lang.String"%>
<%@attribute name="helpLabel" required="false" type="java.lang.String"%>


<c:if test="${fn:length(icon) gt 1 }">
	<c:set var="icon" value='<i class="${icon}"></i>' />
</c:if>
<c:if test="${empty type}">
	<c:set var="type" value="text" />
</c:if>
<c:if test="${!empty helpLabel}">
	<c:set var="helpLabel">
		<s:message code="${helpLabel}" />
	</c:set>
</c:if>
<c:if test="${!directLabel}">
	<c:if test="${fn:length(label) gt 1 }">
		<c:set var="innerLabel">
			<s:message code="${label}" />
		</c:set>
	</c:if>
</c:if>
<c:if test="${directLabel}">
	<c:set var="innerLabel">
    ${label} 
  </c:set>
</c:if>

<c:choose>
	<c:when test="${type == 'submit'}">
		<button type="submit" name="submit"
			class="${empty cssClass ? 'btn' : cssClass}">
			<s:message code="${label}" />
		</button>
	</c:when>
	<c:otherwise>

		<s:bind path="${path}">
			<div class="form-group ${status.error ? 'has-error' : '' }">

				<c:if test="${!insetLabel}">
					<c:choose>
						<c:when test="${type != 'checkbox'}">
							<c:if test="${fn:length(label) gt 1 }">
								<label class="control-label" for="${path}">
									${innerLabel} <c:if test="${required}">
										<span class="required text-error"> *</span>
									</c:if> <c:if test="${!disabled && !readonly && !empty helpLabel}">
										<span
											class="pull-right text-info glyphicon glyphicon-question-sign"
											data-toggle="tooltip" data-placement="top"
											title="${helpLabel}"></span>
									</c:if>
								</label>
							</c:if>
						</c:when>
					</c:choose>
				</c:if>

				<c:choose>
					<c:when test="${type == 'textarea'}">
						<form:textarea path="${path}" rows="${empty rows ? '3' : rows}"
							cssClass="form-control ${empty cssClass ? 'input-lg' : cssClass}"
							disabled="${disabled}" readonly="${readonly ? 'true' : 'false'}" />
					</c:when>
					<c:when test="${type == 'select'}">
						<c:if test="${readonly}">
							<form:select
								cssClass="form-control ${empty cssClass ? 'input-lg' : cssClass}"
								path="${path}" items="${items}" disabled="${disabled}"
								readonly="${readonly ? 'true' : 'false'}" />
						</c:if>
						<c:if test="${!readonly}">
							<form:select
								cssClass="form-control ${empty cssClass ? 'input-lg' : cssClass}"
								path="${path}" items="${items}" disabled="${disabled}" />
						</c:if>
					</c:when>
					<c:when test="${type == 'number'}">
						<form:input
							cssClass="form-control ${empty cssClass ? 'input-lg' : cssClass}"
							path="${path}" min="${min}" max="${max}" disabled="${disabled}"
							readonly="${readonly ? 'true' : 'false'}" />
					</c:when>
					<c:when test="${type == 'hidden'}">
						<form:input path="${path}" type="${type}" value="${value}" />
					</c:when>
					<c:when test="${type == 'file'}">
						<form:input path="${path}" type="${type}" />
					</c:when>
					<c:when test="${type == 'checkbox'}">
						<div class="checkbox">
							<label> <c:if test="${readonly}">
									<form:checkbox path="${path}"
										cssClass="form-control ${empty cssClass ? 'input-lg' : cssClass}"
										disabled="${disabled}" value="${value}" readonly="true" />
								</c:if> <c:if test="${!readonly}">
									<form:checkbox path="${path}"
										cssClass="form-control ${empty cssClass ? 'input-lg' : cssClass}"
										disabled="${disabled}" value="${value}" />
								</c:if> <c:choose>
									<c:when test="${directLabel}">
			               ${label}
			             </c:when>
									<c:otherwise>
										<s:message code="${label}" />
									</c:otherwise>
								</c:choose>
							</label>
						</div>
					</c:when>
					<c:when test="${type == 'date'}">
						<form:input path="${path}" type="text"
							cssClass="form-control datepicker ${empty cssClass ? 'input-lg' : cssClass}"
							disabled="${disabled}" value="${value}"
							readonly="${readonly ? 'true' : 'false'}" />
					</c:when>
					<c:when test="${type == 'time'}">
						<form:input path="${path}" type="text"
							cssClass="form-control timepicker ${empty cssClass ? 'input-lg' : cssClass}"
							disabled="${disabled}" value="${value}"
							readonly="${readonly ? 'true' : 'false'}" />
					</c:when>
					<c:otherwise>
						<form:input path="${path}" type="${type}"
							cssClass="form-control ${empty cssClass ? 'input-lg' : cssClass}"
							disabled="${disabled}" value="${value}"
							placeholder="${insetLabel ? innerLabel : ''}"
							readonly="${readonly ? 'true' : 'false'}" />
					</c:otherwise>
				</c:choose>
				<c:if test="${status.error}">
					<span class="text-error"> <small><spring:message
								code="${status.errorMessage}" /></small>
					</span>
				</c:if>

			</div>
		</s:bind>

	</c:otherwise>
</c:choose>