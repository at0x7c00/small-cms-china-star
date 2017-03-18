<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="tab-pane fade" id="attachments">
	<a href="${basePath}filee/viewPic.do?manageKey=${tempBean.cover.manageKey }" target="_blank">
	<img src="${basePath}filee/viewPic.do?manageKey=${tempBean.cover.manageKey }" class="table-pic-lg hover-able"/>
	</a>
</div> 

<div class="tab-pane fade" id="videoOrPicture">
	<a href="${basePath}filee/viewPic.do?manageKey=${tempBean.detailCover.manageKey }" target="_blank">
	<img src="${basePath}filee/viewPic.do?manageKey=${tempBean.detailCover.manageKey }" class="table-pic-lg hover-able"/>
	</a>
</div> 

				<c:if test="${not historyView}">
				<!-- 产品展示  productDisplay:many to many prop tab start -->
				<div class="tab-pane fade" id="productDisplay">
					<div class="dataTables_wrapper select-list" id="productDisplaySelectList" style="border-bottom:1px solid #ddd;" 
						 data-dataurl="filee/selectList.do?showCheckBox=false"
						 data-groupname="productDisplayKeys"
						 data-entityidname="manageKey"
						 data-method="POST"
						 data-initvalues="${nfn:serialKyes(tempBean.productDisplay,'manageKey')}"
						 >
					</div>
				</div>
				<!-- 产品展示 productDisplay:!-- many to many prop tab end -->
				</c:if>
				<c:if test="${not historyView}">
				<!-- 荣誉展示  gloryDisplay:many to many prop tab start -->
				<div class="tab-pane fade" id="gloryDisplay">
					<div class="dataTables_wrapper select-list" id="gloryDisplaySelectList" style="border-bottom:1px solid #ddd;" 
						 data-dataurl="filee/selectList.do?showCheckBox=false"
						 data-groupname="gloryDisplayKeys"
						 data-entityidname="manageKey"
						 data-method="POST"
						 data-initvalues="${nfn:serialKyes(tempBean.gloryDisplay,'manageKey')}"
						 >
					</div>
				</div>
				<!-- 荣誉展示 gloryDisplay:!-- many to many prop tab end -->
				</c:if>