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
										<input name="${propName}[${trIndex}].address"
											id="${propName}[${trIndex}].address"
											class="textInput required"
											 value="<c:out value="${tempBean.address}"/>"
											maxlength="255" />
								</label>
				</td>
				<td>
								<label class="input">
										<input name="${propName}[${trIndex}].contact"
											id="${propName}[${trIndex}].contact"
											class="textInput required"
											 value="<c:out value="${tempBean.contact}"/>"
											maxlength="255" />
								</label>
				</td>
				<td>
								<label class="input">
										<input name="${propName}[${trIndex}].tel"
											id="${propName}[${trIndex}].tel"
											class="textInput required"
											 value="<c:out value="${tempBean.tel}"/>"
											maxlength="255" />
								</label>
				</td>
				<td>
								<label class="input">
								<input name="${propName}[${trIndex}].registMoney"
									id="${propName}[${trIndex}].registMoney" type="text"
									   value="<c:out value="${tempBean.registMoney}"/>"
									class="textInput required digits" />
									</label>
				</td>
				<td>
								<label class="input">
										<input name="${propName}[${trIndex}].industry"
											id="${propName}[${trIndex}].industry"
											class="textInput required"
											 value="<c:out value="${tempBean.industry}"/>"
											maxlength="255" />
								</label>
				</td>
				<td>
								<label class="input">
										<input name="${propName}[${trIndex}].bandNum"
											id="${propName}[${trIndex}].bandNum"
											class="textInput "
											 value="<c:out value="${tempBean.bandNum}"/>"
											maxlength="255" />
								</label>
				</td>
				<td>
								<label class="input">
										<input name="${propName}[${trIndex}].remark"
											id="${propName}[${trIndex}].remark"
											class="textInput "
											 value="<c:out value="${tempBean.remark}"/>"
											maxlength="255" />
								</label>
				</td>