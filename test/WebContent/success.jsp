<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%  
	String path = request.getContextPath();  
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>用户注册协议</title>
<link href="<%=basePath %>js/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
   	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div class="container">
<div class="row" >
	
  			<h3 align="center">您已阅读,是否同意用户注册手册</h3>
  			<div class="col-md-3"></div>
		<hr/>
</div>
<div class=".align-items-center">
  <div class="col-md-5"></div>
  <div class="col-md-5">
	  <a href="register.jsp" >  
  		<button type="button" id="wotongyi" class="btn btn-warning">我同意</button>
	  </a>
  </div>
  <div class="col-md-2"></div>
</div>
</div>
<script src="<%=basePath %>js/jquery/jquery-3.3.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="<%=basePath %>js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>	

</body>
</html>