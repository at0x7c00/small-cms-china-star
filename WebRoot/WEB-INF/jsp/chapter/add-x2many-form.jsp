<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="tab-pane fade" id="attachments">
					<div style="padding:5px">
						<a class="btn btn-primary attachement-dialog-add-btn"
						   href="javascript:void(0)" style="padding:5px 15px;" 
						   data-selectlist="attachmentsSelectList" 
						   data-targetpanel="${targetPanel}"
						   data-maxfilesize="100"
						  data-acceptedfiles="${file_format_picture}"
						   >
							<i class="fa fa-plus"></i> <spring:message code="base.function.add"/>
						</a>
					
						<a class="btn btn-danger select-list-delete-btn"
						   href="javascript:void(0)" style="padding:5px 15px;" data-selectlist="attachmentsSelectList">
							<i class="fa fa-trash-o"></i> <spring:message code="base.function.delete"/>
						</a>
						
					</div>
					<div class="dataTables_wrapper select-list" id="attachmentsSelectList" style="border-bottom:1px solid #ddd;" 
						 data-dataurl="filee/selectList.do"
						 data-groupname="coverKeys"
						 data-entityidname="manageKey"
						 data-method="POST"
						 data-initvalues=""
						 >
					</div>
					<strong>说明</strong>
					<ul>
					<li style="list-style-type: none;">推荐图片尺寸：高：270像素，宽550像素</li>
					<li style="list-style-type: none;">上传一张图片，多余图片将被忽略</li>
					<li style="list-style-type: none;">目前仅“会员风采”栏目的图片做了页面显示 </li>
					</ul>
				</div>