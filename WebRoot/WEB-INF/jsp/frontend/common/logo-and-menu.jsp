<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<header>
	<div class="left-full">
		<div class="logo-img"></div>
	</div>
	<div class="right-full">
		<div class="right-note"></div>
	</div>
</header>
<div class="menu-bar" data-request="${_request_url}">
	<ul>
		<li>
			<a href="${basePath}frontend/index.do" >首&nbsp;&nbsp;页</a>
		</li>
		<li>
			<a href="${basePath}frontend/zhengcedongtai.do">政策动态</a>
		</li>
		<li>
			<a href="${basePath}frontend/zhiliangredian.do">质量热点</a>
		</li>
		<li>
			<a href="${basePath}frontend/huiyuanfengcai.do">会员风采</a>
		</li>
		<li>
			<a href="${basePath}frontend/zhiliangdangan.do">质量档案</a>
		</li>
		<li>
			<a href="${basePath}frontend/hangyezixun.do">行业资讯</a>
		</li>
		<li>
			<a href="${basePath}frontend/about.do">关于我们</a>
		</li>
	</ul>
</div>