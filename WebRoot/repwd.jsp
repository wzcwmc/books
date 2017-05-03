<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'repwd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/loginStyle.css">
<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>

<style type="text/css">
.login-box {
	width:410px;
	margin:20px auto 0 auto;
	text-align:center;
	padding:30px;
	border-radius:10px;
}

</style>

<script type="text/javascript">
	$(function() {
		$(".screenbg ul li").each(function() {
			$(this).css("opacity", "0");
		});
		$(".screenbg ul li:first").css("opacity", "1");
		var index = 0;

		var li = $(".screenbg ul li");
		var number = li.size();
		function change(index) {
			li.css("visibility", "visible");
			li.eq(index).siblings().animate({
				opacity : 0
			}, 3000);
			li.eq(index).animate({
				opacity : 1
			}, 3000);
		}
		function show() {
			index = index + 1;
			if (index <= number - 1) {
				change(index);
			} else {
				index = 0;
				change(index);
			}
		}
		var t = setInterval(show, 8000);
		//根据窗口宽度生成图片宽度
		var width = $(window).width();
		$(".screenbg ul img").css("width", width + "px");
	});
</script>
<script type="text/javascript">
		function $(element){
		return document.getElementById(element);
		}
		function checkloginId(){			
			var uloginId=$("loginId");			
			if(uloginId.value.trim().length==0){
				layer.tips('请输入登录名,登录名不能为空！', '#loginId');				
				$('#loginBtn').attr('disabled', "true");//添加disabled属性
				return false;
				}else{
					$('#loginBtn').removeAttr("disabled"); //移除disabled属性	
				}	
		}
		
		function checkreaName(){
			 var ureaName=$("reaName");
			 if(ureaName.value.trim().length==0){
				layer.tips('请输入姓名,姓名不能为空！', '#reaName');				
				$('#loginBtn').attr('disabled', "true");//添加disabled属性
				return false;
				}else{
					$('#loginBtn').removeAttr("disabled"); //移除disabled属性	
				}				
		}
		
		function checkloginPwd(){
			 var upwd=$("loginPwd");
			 reg=/^[\@A-Za-z0-9\!\#\$\%\^\&\*\.\~]{6,22}$/;
			 if(reg.test(upwd.value)==false){
				layer.tips('密码必须为6-22位数字或字符', '#loginPwd');				
				$('#loginBtn').attr('disabled', "true");//添加disabled属性
				}else{
					$('#loginBtn').removeAttr("disabled"); //移除disabled属性	
				}			
		}
		
		function checkreloginPwd(){
		     var upwd=$("loginPwd");
			 var repwd=$("reloginPwd");
			 if(upwd.value.trim()!=repwd.value.trim()){
				layer.tips('两次密码输入不一致！', '#reloginPwd');				
				$('#loginBtn').attr('disabled', "true");//添加disabled属性
				return false;
				}else{
					$('#loginBtn').removeAttr("disabled"); //移除disabled属性	
				}			
		}
		
			
</script>
  </head>
  
  <body style="text-align: center;">
  <div class="login-box" style="margin-top: 50px">
  	<h1>找回密码</h1>
  	<form action="RepwdServlet" method="post">
  	
  		<div class="name">
  			<label>登录名：</label>
  			<input type="text" name="loginId" class="Login" onblur="checkloginId()"
					id="loginId" tabindex="1" autocomplete="off" />
  		</div>
  		
  		<div class="name">
  			<label>姓名：</label>
  			<input type="text" name="reaName" class="reaName" onblur="checkreaName()"
					id="reaName" tabindex="1" autocomplete="off"/>
  		</div>
  		
  		
		
		<div class="name">
			<label>生日：</label>
			<input type="text" readonly="readonly" onblur="WdatePicker({isshowClear:false,readonly:true})"
 name="birthday" class="birthday "  id="birthday"  tabindex="2" />
		</div>
		
		<div class="name">
			<label>重置密码：</label>
			<input type="password" name="loginPwd" onblur="checkloginPwd()"
					class="loginPwd" id="loginPwd" maxlength="16" tabindex="2" />
		</div>
		
		<div class="name">
			<label>确认密码：</label> <input type="password" name="reloginPwd" onblur="checkreloginPwd()"
					class="reloginPwd" id="reloginPwd" maxlength="16" tabindex="2" />
		</div>
		<div style="height:30px"></div>
		<div class="myname" style="float:left;">
  			<label >性别：</label>
		</div>
		<div class="name" style="float:left;width:90px;">		 
			<input type="radio" value="男" name="gender" class="gender" id="gender" maxlength="16" tabindex="2" /> 男
		</div>
		<div class="name" style="float:left;width:90px;">			
			<input type="radio" value="女" name="gender" class="gender" id="gender" maxlength="16" tabindex="2" /> 女
		</div>
		<div style="height:30px"></div>
		<div class="login" id="myname">
				<button type="submit" class="" id="loginBtn" tabindex="5">提交</button>
		</div>
		
			
  	
  	</form>
  <div class="screenbg">
		<ul>
			<li><a href="#"><img src="images/3.jpg" style="height:100%"></a></li>
			<li><a href="#"><img src="images/4.jpg" style="height:100%"></a></li>
			<li><a href="#"><img src="images/5.jpg" style="height:100%"></a></li>
		</ul>
	</div>
  
  
  
  </div>
    
  </body>
</html>
