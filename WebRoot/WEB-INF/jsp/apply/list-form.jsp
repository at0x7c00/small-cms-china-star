<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
				<section class="col col-2">
					<label class="input"> 
										<form:input path="name"
											id="apply.name"
											cssClass="textInput"
											size="12"
											maxlength="255" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.Apply.name')}"/>
					</label>
				</section>
				<section class="col col-2">
					<label class="input"> 
										<form:input path="address"
											id="apply.address"
											cssClass="textInput"
											size="12"
											maxlength="255" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.Apply.address')}"/>
					</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="contact"
											id="apply.contact"
											cssClass="textInput"
											maxlength="255"  size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.Apply.contact')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="tel"
											id="apply.tel"
											cssClass="textInput"
											maxlength="255"  size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.Apply.tel')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
								<form:input path="registMoney"
									id="apply.registMoney" type="text"
									cssClass="textInputdigits" size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.Apply.registMoney')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="industry"
											id="apply.industry"
											cssClass="textInput"
											maxlength="255"  size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.Apply.industry')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="bandNum"
											id="apply.bandNum"
											cssClass="textInput"
											maxlength="255"  size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.Apply.bandNum')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="remark"
											id="apply.remark"
											cssClass="textInput"
											maxlength="255"  size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.Apply.remark')}"/>
				</label>
				</section>
				<section class="col col-2">
						<label class="input"> 
								<label class="select">
								<form:select id="status" path="status" cssClass="comboxed">
								<option value="">-${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.Apply.status')}-</option>
									<form:options  items="${useStatusMap}"/>
								</form:select>
								<i></i>
								</label>
				</label>
				</section>