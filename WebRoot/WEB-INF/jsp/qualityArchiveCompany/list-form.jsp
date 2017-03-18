<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
				<section class="col col-2">
					<label class="input"> 
										<form:input path="name"
											id="qualityArchiveCompany.name"
											cssClass="textInput"
											size="12"
											maxlength="255" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.QualityArchiveCompany.name')}"/>
					</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="lawPerson"
											id="qualityArchiveCompany.lawPerson"
											cssClass="textInput"
											maxlength="255"  size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.QualityArchiveCompany.lawPerson')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
								<form:input path="registerMoney"
									id="qualityArchiveCompany.registerMoney" type="text"
									cssClass="textInputdigits" size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.QualityArchiveCompany.registerMoney')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="address"
											id="qualityArchiveCompany.address" size="12"
											maxlength="255" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.QualityArchiveCompany.address')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="tradeScope"
											id="qualityArchiveCompany.tradeScope" size="12"
											 placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.QualityArchiveCompany.tradeScope')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="serviceCenter"
											id="qualityArchiveCompany.serviceCenter"
											cssClass="textInput"
											maxlength="255"  size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.QualityArchiveCompany.serviceCenter')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="auditStatus"
											id="qualityArchiveCompany.auditStatus"
											cssClass="textInput"
											maxlength="255"  size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.QualityArchiveCompany.auditStatus')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
								<label class="select">
								<form:select id="status" path="status" cssClass="comboxed">
								<option value="">-${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.QualityArchiveCompany.status')}-</option>
									<form:options  items="${useStatusMap}"/>
								</form:select>
								<i></i>
								</label>
				</label>
				</section>