<%@ taglib uri="/WEB-INF/tld/struts-menu.tld" prefix="menu" %>
<%@ taglib uri="/WEB-INF/tld/hi.tld" prefix="hi" %>
<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>J-Hi Java快速开发平台</title>
<%@ include file="/includes/styles.jsp"%>
<script type="text/javascript">
$(function(){
	DWZ.init("styles/dwz/dwz.frag.xml", {
//		loginUrl:"loginsub.jsp", loginTitle:"登录",	// 弹出登录对话框
		loginUrl:"login.jsp",	// 跳到登录页面
		pageInfo:{pageNum:"pageInfo.currentPage", numPerPage:"pageInfo.pageSize", orderField:"pageInfo.sorterName", orderDirection:"pageInfo.sorterDirection"}, //【可选】
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"styles/dwz/themes"});
		}
	});
});
</script>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="javascript:void(0)">标志</a>
				<ul class="nav">
					<li><a href="personalSettingView.action" target="dialog"><ws:property value="@org.hi.framework.security.context.UserContextHelper@getUserName()"/></a></li>
					<li><a href="j_acegi_logout">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="ext"><div>EXT</div></li>
				</ul>
			</div>
		</div>
		
		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>
			
				<menu:useMenuDisplayer name="Velocity" config="menu/sysmenu.html"  bundle="">
 					<hi:displayMenu name="com.hi.tree.menu" menuName="himenu" type="sys"/>
				</menu:useMenuDisplayer>
			</div>
			
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:void(0)"><span><span class="home_icon">我的主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:void(0)">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent">
					<div>
						<div class="accountInfo">
							<div class="alertInfo">
								<h2><a href="http://j-hi.googlecode.com/files/j-hi_user_guide.pdf" target="_blank">J-Hi平台开发指南(PDF)</a></h2>
								<a href="http://j-hi.googlecode.com/files/dwz-user-guide.pdf" target="_blank">DWZ框架使用手册(PDF)</a>
							</div>
							<div class="right">
								<h2><p><a href="http://www.j-hi.net/courses!ke_cheng.action?project.id=1" target="_blank" style="line-height:19px">初学者必读</a></p></h2>
								<p><a href="http://j-hi.googlecode.com/files/application.swf" target="_blank" style="line-height:19px">应用开发视频(flash)</a></p>
							</div>
							<p><span>J-Hi Java快速开发平台</span></p>
							<p><a href="demo_page2.html" target="dialog"></a></p>
						</div>
						<div class="pageFormContent" layoutH="80">
							<h3><p>J-Hi官方网站<a href="http://www.j-hi.net" target="_blank"> http://www.j-hi.net</a></p></h3>
							<p>在线演示地址<a href="http://demo.j-hi.net" target="_blank"> http://demo.j-hi.net</a> 帐号/密码 sa/sa </p>
							<p>Google Code下载 <a href="http://code.google.com/p/j-hi/" target="_blank">http://code.google.com/p/j-hi/</a></p>
							<p>J-Hi HowTo手册 <a href="http://j-hi.googlecode.com/files/j-hi_howto.doc" target="_blank">http://j-hi.googlecode.com/files/j-hi_howto.doc</a></p>
							<p>WooW工作流文档(PDF) <a href="http://j-hi.googlecode.com/files/WooW-user-guide.pdf" target="_blank">http://j-hi.googlecode.com/files/WooW-user-guide.pdf</a></p>
							<p>WooW工作流演示 <a href="http://woow.j-hi.net" target="_blank">http://woow.j-hi.net</a>	帐号/密码  	sa/sa	</p>
							
<div class="divider"></div>
<h2>J-Hi历程:</h2>
<pre style="margin:5px;line-height:1.4em">
唉！J-Hi平台终于发布了，这里面凝聚了太多人的艰辛与汗水。回想五年前它还只是大家为了探索如何使程序开发更好、更快速、易于管理而又不影响开发人员的编程习惯的一个构想，
当初它还只是个底层框架或开发工具，核心团队成员就是用这个小小的底层框架做了很多项目，从未想过会将它开源出来（因为我们觉得做得还不够好，担心开源后会被同行笑话）。
后来随着所接项目的逐渐增多，J-Hi所涉足的行业领域也不断广阔，因此我们也不得不适应需求的变化不断的为它加入新的功能，慢慢的它变得越来越强壮。
突然有一天有人提议我们将它开源吧,大家这才为平台的开源做准备。

如今这一版是J-Hi的第二个版本,除对底层做完善工作外，主要是集成了DWZ前端框架,以后我们还会秉承这一思想使J-Hi融入更多更优秀的技术。

使用Java开发就像，嗨！~~，打个招呼这般简单实用是J-Hi的源动力
</pre>
</pre>
<div class="divider"></div>
<h2>我们仍在努力:</h2>
<pre style="margin:5px;line-height:1.4em">
1、完善平台,使其更稳定,更健壮
2、网站建设,使它成为平台之上的平台,为大家提供技术交流的环境,我们希望在这个网站上交流的不只是J-Hi的技术
	更是大家分享经验与成果,展示自己能力的平台
3、为平台增加新技术组件,例如对SpringMVC SpringJDBC(已完成)及其它优秀开源框架的支持
4、基于平台之上,增加业务组件库,例如BBS CRM CMS等

我们要做的事情还有很多,真心的希望大家能参与其中,为中国的开源做出自己的贡献!!
</pre>

<div class="divider"></div>
<h2>联系我们:</h2>
<p style="color:red">邮箱：services.jhi@gmail.com</p>

<p style="color:red">QQ群：133176937(满) 133177634(满) 133178083(满) 134232577(满) 134241201 134241933</p>

<p style="color:red">微博：<a href="http://weibo.com/javahi" target="_blank">http://weibo.com/javahi</a></p>
						</div>

					</div>
				</div>
			</div>
		</div>

		<div id="taskbar" style="left:0px; display:none;">
			<div class="taskbarContent">
				<ul></ul>
			</div>
			<div class="taskbarLeft taskbarLeftDisabled" style="display:none;">taskbarLeft</div>
			<div class="taskbarRight" style="display:none;">taskbarRight</div>
		</div>
		<div id="splitBar"></div>
		<div id="splitBarProxy"></div>
	</div>
	
	<div id="footer">Copyright &copy; 2011 <a href="#" target="dialog">J-Hi研发团队</a></div>

<!--拖动效果-->
	<div class="resizable"></div>
<!--阴影-->
	<div class="shadow" style="width:508px; top:148px; left:296px;">
		<div class="shadow_h">
			<div class="shadow_h_l"></div>
			<div class="shadow_h_r"></div>
			<div class="shadow_h_c"></div>
		</div>
		<div class="shadow_c">
			<div class="shadow_c_l" style="height:296px;"></div>
			<div class="shadow_c_r" style="height:296px;"></div>
			<div class="shadow_c_c" style="height:296px;"></div>
		</div>
		<div class="shadow_f">
			<div class="shadow_f_l"></div>
			<div class="shadow_f_r"></div>
			<div class="shadow_f_c"></div>
		</div>
	</div>
	<!--遮盖屏幕-->
	<div id="alertBackground" class="alertBackground"></div>
	<div id="dialogBackground" class="dialogBackground"></div>

	<div id='background' class='background'></div>
	<div id='progressBar' class='progressBar'>数据加载中，请稍等...</div>

<script type="text/javascript">
  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-16716654-1']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? ' https://ssl' : ' http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();
</script>

</body>
</html>