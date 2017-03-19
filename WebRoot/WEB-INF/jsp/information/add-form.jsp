<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
				<section class="col col-12">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.chinastar.entity.Information.title"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="title"
											id="information.title"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<section class="col col-12">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.chinastar.entity.Information.content"/>:
							<font style='color:red' class="required-mark">*</font>
										<label class="textarea">
										<form:textarea path="content"
											id="information.content" cols="60"
											rows="5"
											cssClass="required ckeditor-able"
											 />
										</label>
					</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.chinastar.entity.Information.orderNum"/>:
							<font style='color:red' class="required-mark">*</font>
								<form:input path="orderNum"
									id="information.orderNum" type="text"
									cssClass="textInput required digits" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.chinastar.entity.Information.status"/>:
							<font style='color:red' class="required-mark">*</font>
								<label class="select">
								<form:select id="status" path="status" cssClass="required comboxed">
								<option value=""><spring:message code="base.common.selectone"/></option>
									<form:options  items="${useStatusMap}"/>
								</form:select><i></i>
								</label>
				</label>
				</section>