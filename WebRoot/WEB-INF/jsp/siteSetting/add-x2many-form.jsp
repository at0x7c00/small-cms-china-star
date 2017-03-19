<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
			<div class="tab-pane fade" id="headerPics">
					<div style="padding:5px">
						<a class="btn btn-primary attachement-dialog-add-btn"
						   href="javascript:void(0)" style="padding:5px 15px;" 
						   data-selectlist="headerPicSelectList" 
						   data-targetpanel="${targetPanel}"
						   data-maxfilesize="100"
						   data-acceptedfiles="${file_format_picture},.mp4,.ogg,.webm"
						   >
							<i class="fa fa-plus"></i> <spring:message code="base.function.add"/>
						</a>
						<a class="btn btn-danger select-list-delete-btn"
						   href="javascript:void(0)" style="padding:5px 15px;" data-selectlist="headerPicSelectList">
							<i class="fa fa-trash-o"></i> <spring:message code="base.function.delete"/>
						</a>
					</div>
				<div class="dataTables_wrapper select-list" id="headerPicSelectList" style="border-bottom:1px solid #ddd;" 
						 data-dataurl="filee/selectList.do"
					 	 data-groupname="headerPicKeys"
						 data-entityidname="manageKey"
						 data-method="POST"
					 	 data-initvalues="${tempBean.headerPic.manageKey }"
						 >
					</div>
				</div>
			<div class="tab-pane fade" id="infoHeaderPics">
					<div style="padding:5px">
						<a class="btn btn-primary attachement-dialog-add-btn"
						   href="javascript:void(0)" style="padding:5px 15px;" 
						   data-selectlist="infoHeaderPicSelectList" 
						   data-targetpanel="${targetPanel}"
						   data-maxfilesize="100"
						   data-acceptedfiles="${file_format_picture},.mp4,.ogg,.webm"
						   >
							<i class="fa fa-plus"></i> <spring:message code="base.function.add"/>
						</a>
						<a class="btn btn-danger select-list-delete-btn"
						   href="javascript:void(0)" style="padding:5px 15px;" data-selectlist="infoHeaderPicSelectList">
							<i class="fa fa-trash-o"></i> <spring:message code="base.function.delete"/>
						</a>
					</div>
				<div class="dataTables_wrapper select-list" id="infoHeaderPicSelectList" style="border-bottom:1px solid #ddd;" 
						 data-dataurl="filee/selectList.do"
					 	 data-groupname="infoHeaderPicKeys"
						 data-entityidname="manageKey"
						 data-method="POST"
					 	 data-initvalues="${tempBean.infoHeaderPic.manageKey }"
						 >
					</div>
				</div>