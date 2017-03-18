<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Worker.workNum"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="workNum"
											id="worker.workNum"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Worker.name"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="name"
											id="worker.name"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Worker.area"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="area"
											id="worker.area"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Worker.job"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="job"
											id="worker.job"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Worker.status"/>:
							<font style='color:red' class="required-mark">*</font>
								<label class="select">
								<form:select id="status" path="status" cssClass="required comboxed">
								<option value=""><spring:message code="base.common.selectone"/></option>
									<form:options  items="${useStatusMap}" itemLabel="description"/>
								</form:select><i></i>
								</label>
				</label>
				</section>