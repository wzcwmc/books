<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'bookDetails.jsp' starting page</title>

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
<style type="text/css">
.loadfile {
	float: left;
}

.loadfile {
	margin-top: 20px;
	padding:0px;
	display: block;
	width: 220px;
	height: 300px;
	line-height: 312px;
	font-size: 60px;
	text-align: center;
	border: 1px solid #ccc;
	font-size: 60px;
	background-repeat: no-repeat;
	background-size: 220px 312px;
}

.bg_size {
padding:0px;
	background-repeat: no-repeat;
	background-size: 220px 312px;
}

</style>
<script type="text/javascript">
			$(function(){
				$("#uploadfile").change(function(){
					var fr=new FileReader();
					fr.readAsDataURL(document.getElementById("uploadfile").files[0]);
					fr.onload=function(e){
						$("#imglab").addClass("bg_size");
						$("#imglab").css("background-image","url(" + e.target.result + ")");
						$("#imglab").html('');
					};
				});
				
				 $("#saveBtn").click(function(){  
			      	// 将表单复制到父画面，在父页面的回调函数里提交表单  
			        var popupForm= $(parent.document.body).children("div[id='popupFormDiv']").append($("#popupForm"));  
			        var index = parent.layer.getFrameIndex(window.name); //获取窗口索引  
			                parent.layer.close(index);  
			        });  

		});
</script>
</head>

<body>
	<form id="popupForm" action="DoUpdateServlet?bookImg=${book.bookImg }" method="post" enctype="multipart/form-data">
		<div id="content" style=" margin:10px auto 10px;">
			<div class="bloc" style=" margin:0px;padding: 0px;">
				<div class="content">
					<div class="" style="float:left; margin: 0px 50px auto auto">
						<label id="imglab" title="上传封面图像" class="loadfile" for="uploadfile"
						 style="background-image: url('${book.bookImg }');"></label>
						<div style="display:none;">
							<input type="file" id="uploadfile" name="bookImg" 
							value="${book.bookImg }"/>
						</div>

					</div>
					<div class="input" style="margin-left:280px ">
						<label for="input1">书 名</label> 
						<input type="text" id="input1" name="bookName" value="${book.bookName }"/>
					</div>

					<div class="input" style="margin-left:280px ">
						<label for="input2">作 者</label> 
						<input type="text" id="input2" name="author" value="${book.author }"/>
					</div>

					<div class="input" style="margin-left:280px ">
						<label for="input3">版本号</label> 
						<input type="text" id="input3" name="isbn" value="${book.isbn }"/>
					</div>
					<div class="input" style="margin-left:280px ">
						<label for="input4">出版社</label> 
						<input type="text" id="input4" name="publisher" value="${book.publisher }"/>
					</div>

					<div class="input" style="margin-left:280px ">
						<label for="input5">出版日期</label> 
						<input type="text" style="width:156px" 
							onFocus="WdatePicker({isShowClear:false,readOnly:true})"
							id="input5" name="pubDate" value="${book.pubDate }"/>
					</div>

					<div class="input" style="margin-left:280px ">
						<label for="select">图书类型</label> 
						<select name="bookType" id="select" style="width:158px">
							<option value="童话" <c:if test="${book.bookType eq '童话' }">selected="selected"</c:if> >童话</option>
							<option value="哲学" <c:if test="${book.bookType eq '哲学' }">selected="selected"</c:if> >哲学</option>
							<option value="军事" <c:if test="${book.bookType eq '军事' }">selected="selected"</c:if> >军事</option>
						</select>
					</div>

					<div class="input textarea">
						<label for="textarea2">图书介绍</label>
						<textarea name="introduction" id="textarea2" rows="7" class="wysiwyg" cols="4">
                			${book.introduction }
            			</textarea>
					</div>
					<div class="input">
						<label>图书价格 : $<span></span></label> 
						<input type="text" class="range min-10 max-150" name="price" value="${book.price }" />
					</div>

					<div class="input">
						<label for="input6">书的数量</label> 
						<input type="text" id="input6" name="bookNum" value="${book.bookNum }" />
					</div>
					<div class="input">
						<label for="input5">入库日期</label> 
						<input type="text"  style="width:185px" 
							onFocus="WdatePicker({isShowClear:false,readOnly:true})"
							id="input5" name="innerDate" value="${book.innerDate }"/>
					</div>
					<input type="hidden" id="input6" name="bookId" value="${book.bookId }" />
					<input type="hidden" id="input6" name="lendNum" value="${book.lendNum }" />
					<input type="hidden" id="input6" name="nowNum" value="${book.nowNum }" />
					<div class="submit">
						<input type="button" id="saveBtn"  value="  更新   " />
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
