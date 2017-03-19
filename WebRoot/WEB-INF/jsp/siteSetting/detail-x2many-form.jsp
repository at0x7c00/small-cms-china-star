<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
			<div class="tab-pane fade" id="headerPics">
				<a href="filee/viewPic.do?manageKey=${tempBean.photoFile.manageKey }" target="_blank">
					<img src="filee/viewPic.do?manageKey=${tempBean.headerPic.manageKey }" class="table-pic-lg hover-able"/>
				</a>
			</div> 	
			<div class="tab-pane fade" id="infoHeaderPics">
				<a href="filee/viewPic.do?manageKey=${tempBean.photoFile.manageKey }" target="_blank">
					<img src="filee/viewPic.do?manageKey=${tempBean.infoHeaderPic.manageKey }" class="table-pic-lg hover-able"/>
				</a>
			</div> 	