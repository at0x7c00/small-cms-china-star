<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
				<section class="col col-12">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Apply.name"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="name"
											id="apply.name"
											cssClass="textInput required"
											maxlength="255" />
					</label>
				</section>
				<section class="col col-12">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Apply.address"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="address"
											id="apply.address"
											cssClass="textInput required"
											maxlength="255" />
					</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Apply.contact"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="contact"
											id="apply.contact"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Apply.tel"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="tel"
											id="apply.tel"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Apply.registMoney"/>:
							<font style='color:red' class="required-mark">*</font>
								<form:input path="registMoney"
									id="apply.registMoney" type="text"
									cssClass="textInput required digits" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Apply.industry"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="industry"
											id="apply.industry"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Apply.bandNum"/>:
										<form:input path="bandNum"
											id="apply.bandNum"
											cssClass="textInput "
											maxlength="255" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Apply.status"/>:
								<label class="select">
								<form:select id="status" path="status" cssClass=" comboxed">
								<option value=""><spring:message code="base.common.selectone"/></option>
									<form:options  items="${useStatusMap}" itemLabel="description"/>
								</form:select><i></i>
								</label>
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Apply.remark"/>:
										<form:input path="remark"
											id="apply.remark"
											cssClass="textInput "
											maxlength="255" />
				</label>
				</section>