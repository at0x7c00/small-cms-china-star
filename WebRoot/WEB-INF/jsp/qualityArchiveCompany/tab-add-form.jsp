<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<%@include file="/WEB-INF/jsp/common/taglib.jsp"%>
	<td>
		<label class="checkbox">
			<input type="checkbox" name="${trTarget}Chk" value="${trIndex}"/>
			<i></i></label>
		<input type="hidden" name="rowGuard${trIndex}" value="1"/>
	</td>
				<td>
								<label class="input">
										<input name="${propName}[${trIndex}].name"
											id="${propName}[${trIndex}].name"
											class="textInput required"
											 value="<c:out value="${tempBean.name}"/>"
											maxlength="255" />
								</label>
				</td>
				<td>
								<label class="input">
										<input name="${propName}[${trIndex}].lawPerson"
											id="${propName}[${trIndex}].lawPerson"
											class="textInput required"
											 value="<c:out value="${tempBean.lawPerson}"/>"
											maxlength="255" />
								</label>
				</td>
				<td>
								<label class="input">
								<input name="${propName}[${trIndex}].registerMoney"
									id="${propName}[${trIndex}].registerMoney" type="text"
									   value="<c:out value="${tempBean.registerMoney}"/>"
									class="textInput required digits" />
									</label>
				</td>
				<td>
								<label class="input">
										<input name="${propName}[${trIndex}].address"
											id="${propName}[${trIndex}].address"
											class="textInput required"
											 value="<c:out value="${tempBean.address}"/>"
											maxlength="255" />
								</label>
				</td>
				<td>
								<label class="input">
										<input name="${propName}[${trIndex}].tradeScope"
											id="${propName}[${trIndex}].tradeScope"
											class="textInput required"
											 value="<c:out value="${tempBean.tradeScope}"/>"
											maxlength="255" />
								</label>
				</td>
				<td>
								<label class="input">
										<input name="${propName}[${trIndex}].serviceCenter"
											id="${propName}[${trIndex}].serviceCenter"
											class="textInput required"
											 value="<c:out value="${tempBean.serviceCenter}"/>"
											maxlength="255" />
								</label>
				</td>
				<td>
								<label class="input">
										<input name="${propName}[${trIndex}].auditStatus"
											id="${propName}[${trIndex}].auditStatus"
											class="textInput required"
											 value="<c:out value="${tempBean.auditStatus}"/>"
											maxlength="255" />
								</label>
				</td>
				<td>
								<label class="select">
								<select id="${propName}[${trIndex}].status" name="${propName}[${trIndex}].status" cssClass="required comboxed">
								<option value=""><spring:message code="base.common.selectone"/></option>
									<c:forEach items="${useStatusMap}" var="entry" >
										<option value="${entry.key}" ${tempBean.status eq entry.key ? 'selected' : ''}><c:out value="${entry.value}"/></option>
									</c:forEach>
								</select><i></i>
								</label>
				</td>