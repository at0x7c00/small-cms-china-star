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
										<input name="${propName}[${trIndex}].title"
											id="${propName}[${trIndex}].title"
											class="textInput required"
											 value="<c:out value="${tempBean.title}"/>"
											maxlength="255" />
								</label>
				</td>
				<td>
								<label class="input">
										<input name="${propName}[${trIndex}].corporateName"
											id="${propName}[${trIndex}].corporateName"
											class="textInput required"
											 value="<c:out value="${tempBean.corporateName}"/>"
											maxlength="255" />
								</label>
				</td>
				<td>
								<label class="input">
										<input name="${propName}[${trIndex}].content"
											id="${propName}[${trIndex}].content"
											class="textInput "
											 value="<c:out value="${tempBean.content}"/>"
											maxlength="255" />
								</label>
				</td>
				<td>
										<label class="select">
										<select id="${propName}[${trIndex}].video.id" name="${propName}[${trIndex}].video.id" class=" comboxed">
											<option value=""><spring:message code="base.common.selectone"/></option>
											<c:forEach items="${commonFileList}" var="commonFile" >
												<option value="${commonFile.id}" ${tempBean.video.id eq commonFile.id ? 'selected' : ''}><c:out value="${commonFile.manageKey}"/></option>
											</c:forEach>
										</select><i></i>
										</label>
				</td>
				<td>
										<label class="select">
										<select id="${propName}[${trIndex}].creator.id" name="${propName}[${trIndex}].creator.id" class="required comboxed">
											<option value=""><spring:message code="base.common.selectone"/></option>
											<c:forEach items="${userList}" var="user" >
												<option value="${user.id}" ${tempBean.creator.id eq user.id ? 'selected' : ''}><c:out value="${user.manageKey}"/></option>
											</c:forEach>
										</select><i></i>
										</label>
				</td>
				<td>
								<label class="input">
								<i class="icon-append fa fa-calendar"></i>
								<input name="${propName}[${trIndex}].createTime" id="${propName}[${trIndex}].createTime" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}' value='${tempBean.createTime}'/>" class="date_required required textInput valid"/>
								</label>
				</td>
				<td>
								<label class="input">
								<i class="icon-append fa fa-calendar"></i>
								<input name="${propName}[${trIndex}].updateTime" id="${propName}[${trIndex}].updateTime" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}' value='${tempBean.updateTime}'/>" class="date_required required textInput valid"/>
								</label>
				</td>
				<td>
								<label class="input">
								<input name="${propName}[${trIndex}].orderNum"
									id="${propName}[${trIndex}].orderNum" type="text"
									   value="<c:out value="${tempBean.orderNum}"/>"
									class="textInput required digits" />
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