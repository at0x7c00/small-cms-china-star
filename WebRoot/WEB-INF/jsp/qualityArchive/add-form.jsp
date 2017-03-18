<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
				<section class="col col-12">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchive.title"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="title"
											id="qualityArchive.title"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<section class="col col-12">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchive.content"/>:
							<font style='color:red' class="required-mark">*</font>
										<label class="textarea">
										<form:textarea path="content"
											id="qualityArchive.content" cols="60"
											rows="5"
											cssClass="required ckeditor-able"
											 />
										</label>
					</label>
				</section>
				<section class="col col-4">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchive.category"/>:
							<font style='color:red' class="required-mark">*</font>
							<label class="select">
							<form:select id="category" path="category" cssClass="required comboxed">
							<option value="">-${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.QualityArchive.category')}-</option>
								<form:options  items="${categoryList}" itemValue="manageKey"  itemLabel="name"/>
							</form:select>
							<i></i>
							</label>
				</section>
				
				
				
				<section class="col col-4">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchive.orderNum"/>:
							<font style='color:red' class="required-mark">*</font>
								<form:input path="orderNum"
									id="qualityArchive.orderNum" type="text"
									cssClass="textInput required digits" />
				</label>
				</section>
				<section class="col col-4">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchive.status"/>:
							<font style='color:red' class="required-mark">*</font>
								<label class="select">
								<form:select id="status" path="status" cssClass="required comboxed">
								<option value=""><spring:message code="base.common.selectone"/></option>
									<form:options  items="${useStatusMap}"/>
								</form:select><i></i>
								</label>
				</label>
				</section>