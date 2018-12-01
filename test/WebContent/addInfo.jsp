<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="cn.lianwei.yonyong.utils.*,java.util.*,cn.lianwei.yonyong.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>消息详情</title>
<link href="<%=basePath %>js/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
 <script type="text/javascript" src="<%=basePath %>My97DatePicker/WdatePicker.js"></script> 
</head>
<body>

<div class="row">
  <div class="col-md-2"></div>
  <div class="col-md-4"><br/><br/><br/><br/><br/><img src="<%=basePath %>/js/addInfo.png" width="400"
  			height="350">
  </div>
  <div class="col-md-3">
  	<form action="" name="form1" method="post">
  	<br/><br/><br/><br/><br/>
		<div class="form-group">
	    <label for="exampleInputEmail1"><font 
	 	   	   size="6" >添加消息</font></label>
		<input type="text" class="form-control" name="title" width=200 placeholder="标题" />
		</div>
		<div class="form-group">
		<input type="text" class="form-control" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" name="date" width=200 placeholder="时间"/>
		</div>
		<div class="form-group">
		<textarea class="form-control" id="deblock_udid" name="content" rows="8" style="min-width: 90%" placeholder="内容"></textarea>

		</div>
		
		<div class="form-group">
		<input type="submit" class="btn btn-primary btn-lg btn-block" value="添加" onclick="form1.action='addInfo';form1.submit()">
		</div>
	
	</form>
	
	</div>
  <div class="col-md-3"></div>
</div>
 <script src="<%=basePath %>js/jquery/jquery-3.3.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="<%=basePath %>js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>