<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'readerDetails.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/libs/jquery/1.6/jquery.min.js"></script>
<script type="text/javascript" src="js/libs/jqueryui/1.8.13/jquery-ui.min.js"></script>
<link rel="stylesheet" href="css/min.css" />
<script type="text/javascript" src="js/min.js"></script>
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" href="content/settings/style.css" />
<script type="text/javascript" src="content/settings/main.js"></script>
<script type="text/javascript">
$(function(){
$("#saveBtn").click(function(){  
  	// 将表单复制到父画面，在父页面的回调函数里提交表单  
    var popupForm= $(parent.document.body).children("div[id='popupFormDiv1']").append($("#popupForm1"));  
    var index = parent.layer.getFrameIndex(window.name); //获取窗口索引  
            parent.layer.close(index);  
    }); 
    
});
</script>
<style type="text/css">
  body{
  margin: 0px;
  padding: opx;
  }
</style>
  </head>
  
  <body>
    <form action="ReaderUpdateServlet" method="post" id="popupForm1" >
    	<div id="content" style=" margin:10px auto 10px; width: 600px;">
			<div class="bloc" style=" margin:0px;padding: 0px;">
				<div class="content" >
				<div>
				  <input type="hidden" name="reaId" value="${reader.reaId }"/>
				  <input type="hidden" name="loginPwd" value="${reader.loginPwd }"/>
				</div>
					<div class="input" style="margin-left:150px ">
						<label for="input1" >登录名:</label>
						<input type="text" id="input1" name="loginId" value="${reader.loginId }" />
					</div>
					
					<div class="input" style="margin-left:150px ">
						<label for="input2">读者姓名:</label>
						<input type="text" id="input2" name="reaName" value="${reader.reaName }" />
					</div>
					
					<div class="input" style="margin-left:150px ">
						<label for="radio">性别:</label>
						
						<input type="radio" id="radio1" name="gender" value="男" 
						<c:if test="${reader.gender eq '男' }">checked="checked"</c:if>/>男
						<input type="radio" id="radio2"  name="gender" value="女" 
						<c:if test="${reader.gender eq '女' }">checked="checked"</c:if>/> 女
					</div>
					
					<div class="input" style="margin-left:150px ">
						<label for="input3">生日：</label> 
						<input type="text" style="width:156px" 
							onFocus="WdatePicker({isShowClear:false,readOnly:true})"
							id="input3" name="birthday" value="${reader.birthday }"/>
					</div>
					
					<div class="input" style="margin-left:150px" >
						<label for="input4">地址</label>
						<input type="text" id="input4" name="address" value="${reader.address }" />
					</div>
					
					<div class="input" style="margin-left:150px" >
						<label for="input5">电话：</label>
						<input type="text" id="input5" name="phone" value="${reader.phone }" />
					</div>
					
					<div class="submit" style="margin-left:150px">
						<input type="button" value="  更新   " id="saveBtn"/>
					</div>
					
				</div>
			</div>
    	</div>
    </form>
  </body>
</html>
