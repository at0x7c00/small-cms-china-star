<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
				<section class="col col-12">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.chinastar.entity.CorporateStyle.title"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="title"
											id="corporateStyle.title"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<section class="col col-12">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.chinastar.entity.CorporateStyle.corporateName"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="corporateName"
											id="corporateStyle.corporateName"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<%--
				<section class="col col-12">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.chinastar.entity.CorporateStyle.content"/>:
										<label class="textarea">
										<form:textarea path="content"
											id="corporateStyle.content" cols="60"
											rows="5"
											cssClass="ckeditor-able"
											 />
										</label>
					</label>
				</section>
				 --%>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.chinastar.entity.CorporateStyle.orderNum"/>:
							<font style='color:red' class="required-mark">*</font>
								<form:input path="orderNum"
									id="corporateStyle.orderNum" type="text"
									cssClass="textInput required digits" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.chinastar.entity.CorporateStyle.status"/>:
							<font style='color:red' class="required-mark">*</font>
								<label class="select">
								<form:select id="status" path="status" cssClass="required comboxed">
								<option value=""><spring:message code="base.common.selectone"/></option>
									<form:options  items="${useStatusMap}"/>
								</form:select><i></i>
								</label>
				</label>
				</section>