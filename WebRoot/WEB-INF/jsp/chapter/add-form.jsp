<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
				<section class="col col-12">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Chapter.title"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="title"
											id="chapter.title"
											cssClass="textInput required"
											maxlength="255" />
					</label>
				</section>
				<section class="col col-12">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Chapter.content"/>:
							<font style='color:red' class="required-mark">*</font>
										<label class="textarea">
										<form:textarea path="content"
											id="chapter.content" cols="60"
											rows="5"
											cssClass="required ckeditor-able"
											 />
										</label>
					</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Chapter.orderNum"/>:
								<form:input path="orderNum"
									id="chapter.orderNum" type="text"
									cssClass="textInput  digits" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Chapter.status"/>:
								<label class="select">
								<form:select id="status" path="status" cssClass=" comboxed">
								<option value=""><spring:message code="base.common.selectone"/></option>
									<form:options  items="${useStatusMap}"/>
								</form:select><i></i>
								</label>
				</label>
				</section>