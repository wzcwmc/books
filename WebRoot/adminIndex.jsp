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
    
    <title>My JSP 'adminIndex.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- jQuery AND jQueryUI -->
<script type="text/javascript" src="js/libs/jquery/1.6/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/libs/jqueryui/1.8.13/jquery-ui.min.js"></script>

<link rel="stylesheet" href="css/min.css" />
<script type="text/javascript" src="js/min.js"></script>
<script type="text/javascript" src="content/settings/main.js"></script>
<link rel="stylesheet" href="content/settings/style.css" />
<link href="css/style_jPaginate.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.paginate.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
<style type="text/css">
	.content p #lot{
		color:green;
		font-size:14px;
		text-decoration:none;
		padding-right: 20px;	
	}
	.content p #lot:hover{
		color:#666;
		text-decoration:underline;
		padding-right: 20px;	
	}
	
</style>

  </head>
  
  <body>
<!--              
                HEAD
                        -->
<div id="head">
     <input type="hidden" id="admin" value="${sessionScope.admin.mangName }"/>
	<div class="left"> <a href="#" class="button profile"><img src="img/icons/top/huser.png" alt="" /></a> Hi, <a href="#" >${sessionScope.user.mangName }</a> | <a href="ExitServlet?type=manger">退出</a> </div>
</div>

<!--            
                SIDEBAR
                         -->
<div id="sidebar">
	<ul>
		<li class="current"> <a href="IndexServlet?user=mang"> <img src="img/icons/menu/home.png" alt="" /> Mini 书屋 </a> </li>
		<li><a href="#"><img src="img/icons/menu/books.png" alt="" /> 管理 </a>
			<ul>
				
				<li><a href="adminShow.html"> 信息明细 </a></li>
				<li><a href="addBook.html"> 添加图书 </a></li>
			</ul>
		</li>
		<li><a><img src="img/icons/menu/brush.png" alt="" /> 未来功能 3Q </a>
			
		</li>
		<li><a><img src="img/icons/menu/brush.png" alt="" /> 未来功能 3Q</a>
		</li>
	</ul>
</div>

<!--            
              CONTENT 
                        -->
<div id="content" class="white">
	<h1><img src="img/icons/home.png" alt="" /> Mini 书屋首页 </h1>
	<div class="bloc left">
		<div class="title"> 馆长推荐 </div>
		<div class="content dashboard">
			<div class="center">
				<c:forEach items="${requestScope.listOne }" var="book">
				<img  class="shortcut last"  src="${book.bookImg }" alt="图片暂无" title="${book.bookName }" />
				</c:forEach>
				<div class="cb"></div>
			</div>
			<p style="text-align: right;"><a id="lot" href="adminShow.html" style="font-family:'华文行楷';">更多...</a></p>
		</div>
	</div>
	<div class="bloc right">
		<div class="title"> 新书上架 </div>
		<div class="content">
			<div class="left">
				<table class="noalt">
					<thead>
						<tr>
							<th><em>书名</em></th>
							<th><em>类型</em></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listTwo }" var="book">
							<tr>
								<td style="font: italic 18px '楷体';">${book.bookName }</td>
								<td style="font: 16px '仿宋';">${book.bookType }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="right">
				<table class="noalt">
					<thead>
						<tr>
							<th><em>作 者</em></th>
							<th><em>进屋日期</em></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listTwo }" var="book">
							<tr>
								<td style="font: 14px '叶根友毛笔行书2.0版';">${book.author }</td>
								<td style="font: 14px 'Times New Roman';">${book.innerDate }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="cb"></div>
		</div>
	</div>
	<div class="cb"></div>
	<div class="bloc">
		<div class="title"> 借书记录 </div>
		<div class="content">
			<table>
				<thead>
					<tr>
						<th>序 号</th>
						<th>读 者</th>
						<th>图书名</th>
						<th>借书日期</th>
						<th>归还日期</th>
						<th>联系方式</th>
						<th>状 态</th>
						<th>操 作</th>
					</tr>
				</thead>
				<tbody class="mytbody">
				
				</tbody>
			</table>
			<div id="demo2"></div>
		</div>
	</div>
	<div class="bloc">
		<div class="title"> Mini 书屋  管训 </div>
		<div class="content" style="text-align: center;"> 
		   <img style="width: 90%;height: 70%;" alt="" src="images/guanshu.jpg" >
			<div class="cb"></div>
		</div>
	</div>

</div>
<script type="text/javascript">
//页容量
    var pageSize=5;
   //总页数
    var pageCount;
   $(function(){
   	//获取总页数
   getPageCounts();
   });
   function getPageCounts(){
   	var jsonStr={pSize:pageSize};
   	$.post("GetPageCountServlet?type=mark",
   			jsonStr,
   			function(data) {
   			
   				var str=$.parseJSON(data);
   				
   				pageCount=str.pcount;
   				
   				/*调用进行分页的方法*/
    			setPages();
   			});
   }
   /*分页的函数*/
   function setPages(){
   	$("#demo2").paginate({
    			count : pageCount, //${6}此处要写清本次分页的总页数,不支持动态改变,不可写非int型数.个人建议在进入页面的时候就把页数传过来
    			start : 1, //开始页码,从1开始,一般设置成1
    			display : 6, //在分页条上显示的个数,分页数等于或超过本设置会显示设置的个数,不够的话会显示真实个数,不过就不会出现滚动效果了.
    			border : false, //是否显示外框
    			text_color : '#888', //文字颜色
    			background_color : '#EEE', //背景颜色
    			text_hover_color : 'black', //鼠标放上去时文字的颜色
    			background_hover_color : '#CFCFCF',//鼠标放上去时背景的颜色
    			rotate : true, //是否滚动
    			images : false, //
    			mouse : 'press', //可选值为'press'和'slide',具体差别请自己体验.
    			onChange : function(page) {//本插件唯一可触发的事件,在点击页数的时候触发,只传过来当前被选中的页数,我想这其实足够了.
    				getPageData(page, pageSize);
    			}
    		});
    		//调用ajax异步实现每页的数据
    		getPageData(1, pageSize);
   }
   
   function getPageData(pageIndex,pageSize){
   
    		var jsonStr={
    				start : pageIndex,
    				pageSize : pageSize,
    				
    			};
    		$.ajax({
    			url : "PageServlet?type=mark",
    			type : "post",
    			data : jsonStr,
    			dataType : "json",
    			timeout : 100000,
    			error : function() {
    				alert('请求超时，请稍候再试');
    			},
    			success : function(result) {
    				var s = new StringBuffer();
    				$.each(result, function(index, value) {
    					s.append("<tr>").append("<td>").append((index + 1)).append(
    							"</td>");
    					s.append("<td>").append(value.loginId).append("</td>")
    							.append("<td>");
    					s.append(value.bookName).append("</td>").append("<td>");
    					var lendday=toDates(value.lendDate.time);
    					s.append(lendday.getFullYear()+"-").append(lendday.getMonth()+1+"-").append(lendday.getDate());
    					s.append("</td>").append("<td>");
    					var backday = toDates(value.backDate.time);
    					s.append(backday.getFullYear()+"-").append(backday.getMonth()+1+"-").append(backday.getDate());
    					s.append("</td>").append("<td>");
    					s.append(value.phone).append("</td>").append("<td id='delmark"+index+"'>");
    					s.append(value.isback).append("</td>").append("<td>");
    					s.append("<a title='删除记录' onclick=delMark("+value.reaId+","+value.bookId+","+value.back+",'#delmark"+index+"')><img src='img/icons/actions/delete.png' /></a>");
    					s.append("</td>").append("</tr>");
    				});
    				$(".mytbody").html(s.toString());
    			}
    		});
    	}
    	
    function toDates(dateStr){
	 //js 日期格式
	 var newTime = new Date(dateStr); 
	 return newTime;//返回js日期格式
  	}
    	function StringBuffer() {
    		this.__string__ = new Array();
    	}
    	StringBuffer.prototype.append = function(str) {
    		this.__string__.push(str);
    		return this;
    	};
    	StringBuffer.prototype.toString = function() {
    		return this.__string__.join("");
    	};
    
	function delMark(reaId,bookId,back,index){
	
		if(back==0){
			layer.tips('未归还记录，不可删除！！', index);
		}else if(back==1){
		
			layer.msg('确定删除这条记录吗！', {
			  time: 0 //不自动关闭
			  ,btn: ['删除', '取消']
			  ,yes: function(index){
			  		layer.close(index);
		
					$.ajax({
		    			url : "DoDeleteServlet?type=mark&reaId="+reaId+"&bookId="+bookId,
		    			type : "get",
		    			data : "",
		    			dataType : "text",
		    			timeout : 10000,
		    			error : function() {
		    				alert('请求超时，请稍候再试');
		    			},
		    			success : function(result) {
		    				var isOk=result;
		    				if(isOk=="ok"){
		    					getPageCounts();
		    					layer.msg('一条记录已删除！');
		    				}
		    			}
					});
				}
			});
		}
	}


</script>
</body>
</html>
