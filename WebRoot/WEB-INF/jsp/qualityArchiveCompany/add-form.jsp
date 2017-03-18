<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
				<section class="col col-12">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchiveCompany.name"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="name"
											id="qualityArchiveCompany.name"
											cssClass="textInput required"
											maxlength="255" />
					</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchiveCompany.lawPerson"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="lawPerson"
											id="qualityArchiveCompany.lawPerson"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchiveCompany.registerMoney"/>:
							<font style='color:red' class="required-mark">*</font>
								<form:input path="registerMoney"
									id="qualityArchiveCompany.registerMoney" type="text"
									cssClass="textInput required digits" />
				</label>
				</section>
				<section class="col col-12">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchiveCompany.address"/>:
							<font style='color:red' class="required-mark">*</font>
										<label class="textarea">
										<form:textarea path="address"
											id="qualityArchiveCompany.address" cols="60"
											rows="5"
											cssClass="required"
											maxlength="255" />
										</label>
					</label>
				</section>
				<section class="col col-12">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchiveCompany.tradeScope"/>:
							<font style='color:red' class="required-mark">*</font>
										<label class="textarea">
										<form:textarea path="tradeScope"
											id="qualityArchiveCompany.tradeScope" cols="60"
											rows="5"
											cssClass="required"
											 />
										</label>
					</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchiveCompany.serviceCenter"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="serviceCenter"
											id="qualityArchiveCompany.serviceCenter"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchiveCompany.auditStatus"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="auditStatus"
											id="qualityArchiveCompany.auditStatus"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchiveCompany.status"/>:
							<font style='color:red' class="required-mark">*</font>
								<label class="select">
								<form:select id="status" path="status" cssClass="required comboxed">
								<option value=""><spring:message code="base.common.selectone"/></option>
									<form:options  items="${useStatusMap}"/>
								</form:select><i></i>
								</label>
				</label>
				</section>