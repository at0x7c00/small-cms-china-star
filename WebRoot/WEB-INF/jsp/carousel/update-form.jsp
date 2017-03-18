<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
				<section class="col col-12">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Carousel.title"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="title"
											id="carousel.title"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<section class="col col-12">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Carousel.url"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="url"
											id="carousel.url"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<section class="col col-6">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Carousel.orderNum"/>:
							<font style='color:red' class="required-mark">*</font>
								<form:input path="orderNum"
									id="carousel.orderNum" type="text"
									cssClass="textInput required digits" />
				</label>
				</section>
				<section class="col col-6">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Carousel.status"/>:
							<font style='color:red' class="required-mark">*</font>
								<label class="select">
								<form:select id="status" path="status" cssClass="required comboxed">
								<option value=""><spring:message code="base.common.selectone"/></option>
									<form:options  items="${useStatusMap}"/>
								</form:select><i></i>
								</label>
				</label>
				</section>