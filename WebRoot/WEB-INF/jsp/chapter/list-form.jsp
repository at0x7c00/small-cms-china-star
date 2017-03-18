<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<section class="col col-2">
						<label class="input"> 
										<label class="select">
										<form:select id="page" path="page" cssClass="required comboxed change-to-refresh">
											<form:options  items="${webPageList}" itemValue="manageKey" itemLabel="name"/>
										</form:select>
										<i></i>
										</label>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<label class="select">
										<form:select id="creator" path="creator" cssClass="required comboxed">
										<option value="">-<spring:message code="props.me.huqiao.smallcms.cms.entity.Chapter.creator"/>-</option>
											<form:options  items="${userList}" itemValue="username" itemLabel="chineseName"/>
										</form:select>
										<i></i>
										</label>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
								<i class="icon-append fa fa-calendar"></i>
								<input name="createTimeStart" id="chapter.createTime" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY}' value='${chapter.createTimeStart}'/>" class="date_not_required textInput valid"  size="12"
									   placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.cms.entity.Chapter.createTime')}(${nfn:i18nMessage(reqCtx,'base.common.form.start')})"
									   />
			</label>
				</section>
					<section class="col col-2">
					<label class="input"> 
								<i class="icon-append fa fa-calendar"></i>
								<input name="createTimeEnd" id="chapter.createTime" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY}' value='${chapter.createTimeEnd}'/>" class="date_not_required textInput valid"  size="12"
									   placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.cms.entity.Chapter.createTime')}(${nfn:i18nMessage(reqCtx,'base.common.form.end')})"
									   />
				</label>
				</section>
				<section class="col col-2">
					<label class="input"> 
										<form:input path="title"
											id="chapter.title"
											cssClass="textInput"
											size="12"
											maxlength="255" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.cms.entity.Chapter.title')}"/>
					</label>
				</section>
				<section class="col col-2">
					<label class="input"> 
										<form:input path="content"
											id="chapter.content" 
											size="12"
											 placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.cms.entity.Chapter.content')}"/>
					</label>
				</section>
					
					<section class="col col-2">
						<label class="input"> 
								<label class="select">
								<form:select id="status" path="status" cssClass="comboxed">
								<option value="">-${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.cms.entity.Chapter.status')}-</option>
									<form:options  items="${useStatusMap}"/>
								</form:select>
								<i></i>
								</label>
				</label>
				</section>