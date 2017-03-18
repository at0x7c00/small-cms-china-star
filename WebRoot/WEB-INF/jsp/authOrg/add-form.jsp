<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
				<section class="col col-12">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.AuthOrg.name"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="name"
											id="authOrg.name"
											cssClass="textInput required"
											maxlength="255" />
					</label>
				</section>
				<section class="col col-12">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.AuthOrg.address"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="address"
											id="authOrg.address"
											cssClass="textInput required"
											maxlength="255" />
					</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.AuthOrg.tel"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="tel"
											id="authOrg.tel"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.AuthOrg.coroprateFrom"/>:
							<font style='color:red' class="required-mark">*</font>
								<label class="input">
								<i class="icon-append fa fa-calendar"></i>
								<input name="coroprateFrom" id="authOrg.coroprateFrom" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY}' value='${tempBean.coroprateFrom}'/>" class="date_required required textInput valid"/>
								</label>
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.AuthOrg.coroprateTo"/>:
							<font style='color:red' class="required-mark">*</font>
								<label class="input">
								<i class="icon-append fa fa-calendar"></i>
								<input name="coroprateTo" id="authOrg.coroprateTo" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY}' value='${tempBean.coroprateTo}'/>" class="date_required required textInput valid"/>
								</label>
				</label>
				</section>
				
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Chapter.status"/>:
								<label class="select">
								<form:select id="status" path="status" cssClass=" comboxed">
								<option value=""><spring:message code="base.common.selectone"/></option>
									<form:options  items="${useStatusMap}" itemLabel="description"/>
								</form:select><i></i>
								</label>
				</label>
				</section>
