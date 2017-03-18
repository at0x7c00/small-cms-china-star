<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
					
					<section class="col col-2">
							<label class="input"> 
											<label class="select">
											<form:select id="category" path="category" cssClass="required comboxed">
											<option value="">-${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.QualityArchive.category')}-</option>
												<form:options  items="${categoryList}" itemValue="manageKey"  itemLabel="name"/>
											</form:select>
											<i></i>
											</label>
					</label>
					</section>
					
					<section class="col col-2">
						<label class="input"> 
										<form:input path="title"
											id="qualityArchive.title"
											cssClass="textInput"
											maxlength="255"  size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.QualityArchive.title')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="content"
											id="qualityArchive.content" size="12"
											 placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.QualityArchive.content')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<label class="select">
										<form:select id="detailCover" path="detailCover" cssClass=" comboxed">
										<option value="">-<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchive.detailCover"/>-</option>
											<form:options  items="${commonFileList}" itemValue="manageKey" itemLabel="manageKey"/>
										</form:select>
										<i></i>
										</label>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<label class="select">
										<form:select id="creator" path="creator" cssClass="required comboxed">
										<option value="">-<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchive.creator"/>-</option>
											<form:options  items="${userList}" itemValue="username" itemLabel="chineseName"/>
										</form:select>
										<i></i>
										</label>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
								<i class="icon-append fa fa-calendar"></i>
								<input name="createTimeStart" id="qualityArchive.createTime" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY}' value='${qualityArchive.createTimeStart}'/>" class="date_not_required textInput valid"  size="12"
									   placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.QualityArchive.createTime')}(${nfn:i18nMessage(reqCtx,'base.common.form.start')})"
									   />
			</label>
				</section>
					<section class="col col-2">
					<label class="input"> 
								<i class="icon-append fa fa-calendar"></i>
								<input name="createTimeEnd" id="qualityArchive.createTime" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY}' value='${qualityArchive.createTimeEnd}'/>" class="date_not_required textInput valid"  size="12"
									   placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.QualityArchive.createTime')}(${nfn:i18nMessage(reqCtx,'base.common.form.end')})"
									   />
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
								<form:input path="orderNum"
									id="qualityArchive.orderNum" type="text"
									cssClass="textInputdigits" size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.QualityArchive.orderNum')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
								<i class="icon-append fa fa-calendar"></i>
								<input name="readCountStart" id="qualityArchive.readCount" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY}' value='${qualityArchive.readCountStart}'/>" class="date_not_required textInput valid"  size="12"
									   placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.QualityArchive.readCount')}(${nfn:i18nMessage(reqCtx,'base.common.form.start')})"
									   />
			</label>
				</section>
					<section class="col col-2">
					<label class="input"> 
								<i class="icon-append fa fa-calendar"></i>
								<input name="readCountEnd" id="qualityArchive.readCount" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY}' value='${qualityArchive.readCountEnd}'/>" class="date_not_required textInput valid"  size="12"
									   placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.QualityArchive.readCount')}(${nfn:i18nMessage(reqCtx,'base.common.form.end')})"
									   />
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
								<label class="select">
								<form:select id="status" path="status" cssClass="comboxed">
								<option value="">-${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.QualityArchive.status')}-</option>
									<form:options  items="${useStatusMap}"/>
								</form:select>
								<i></i>
								</label>
				</label>
				</section>