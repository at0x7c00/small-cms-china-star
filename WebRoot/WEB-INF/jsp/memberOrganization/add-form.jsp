<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
				<section class="col col-12">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.MemberOrganization.name"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="name"
											id="memberOrganization.name"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.MemberOrganization.corporateFrom"/>:
							<font style='color:red' class="required-mark">*</font>
								<label class="input">
								<i class="icon-append fa fa-calendar"></i>
								<input name="corporateFrom" id="memberOrganization.corporateFrom" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY}' value='${tempBean.corporateFrom}'/>" class="date_required required textInput valid"/>
								</label>
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.MemberOrganization.corporateTo"/>:
							<font style='color:red' class="required-mark">*</font>
								<label class="input">
								<i class="icon-append fa fa-calendar"></i>
								<input name="corporateTo" id="memberOrganization.corporateTo" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY}' value='${tempBean.corporateTo}'/>" class="date_required required textInput valid"/>
								</label>
				</label>
				</section>
				
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.MemberOrganization.status"/>:
								<label class="select">
								<form:select id="status" path="status" cssClass=" comboxed">
								<option value=""><spring:message code="base.common.selectone"/></option>
									<form:options  items="${useStatusMap}" itemLabel="description"/>
								</form:select><i></i>
								</label>
				</label>
				</section>
