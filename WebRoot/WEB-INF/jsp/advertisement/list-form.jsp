<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
				<section class="col col-2">
					<label class="input"> 
										<form:input path="title"
											id="advertisement.title"
											cssClass="textInput"
											size="12"
											maxlength="255" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.cms.entity.Advertisement.title')}"/>
					</label>
				</section>
				<section class="col col-2">
					<label class="input"> 
										<form:input path="url"
											id="advertisement.url"
											cssClass="textInput"
											size="12"
											maxlength="255" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.cms.entity.Advertisement.url')}"/>
					</label>
				</section>
				<section class="col col-2">
					<label class="input"> 
										<label class="select">
										<form:select id="picture" path="picture" cssClass=" comboxed">
										<option value="">-<spring:message code="props.me.huqiao.smallcms.cms.entity.Advertisement.picture"/>-</option>
											<form:options  items="${commonFileList}" itemValue="manageKey" itemLabel="manageKey"/>
										</form:select>
										<i></i>
										</label>
					</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
								<form:input path="orderNum"
									id="advertisement.orderNum" type="text"
									cssClass="textInputdigits" size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.cms.entity.Advertisement.orderNum')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
								<label class="select">
								<form:select id="status" path="status" cssClass="comboxed">
								<option value="">-${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.cms.entity.Advertisement.status')}-</option>
									<form:options  items="${useStatusMap}"/>
								</form:select>
								<i></i>
								</label>
				</label>
				</section>