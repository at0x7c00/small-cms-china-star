<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
					<section class="col col-2">
						<label class="input"> 
										<label class="select">
										<form:select id="headerPic" path="headerPic" cssClass=" comboxed">
										<option value="">-<spring:message code="props.me.huqiao.smallcms.chinastar.entity.SiteSetting.headerPic"/>-</option>
											<form:options  items="${commonFileList}" itemValue="manageKey" itemLabel="manageKey"/>
										</form:select>
										<i></i>
										</label>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<label class="select">
										<form:select id="infoHeaderPic" path="infoHeaderPic" cssClass=" comboxed">
										<option value="">-<spring:message code="props.me.huqiao.smallcms.chinastar.entity.SiteSetting.infoHeaderPic"/>-</option>
											<form:options  items="${commonFileList}" itemValue="manageKey" itemLabel="manageKey"/>
										</form:select>
										<i></i>
										</label>
				</label>
				</section>