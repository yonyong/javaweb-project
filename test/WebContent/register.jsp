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
<title>Insert title here</title>

<link href="<%=basePath %>js/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet"></head>
<body>	
<br/><br/><br/><br/><br/><br/><br/>
<div class="row">
  <div class="col-md-2"></div>
  <div class="col-md-4"><img src="<%=basePath %>/js/register.png" width="420"
  			height="330">
  </div>
  <div class="col-md-3">
  
	  <form id="myform">
	  <div class="form-group">
	    <label for="exampleInputEmail1"><font 
	 	   	   size="6" >注册</font></label>
	    <input type="text" class="form-control" id="tel" name="tel" placeholder="手机号码">
	    
	  </div>
	  

	  
	  
	  <!-- 手机验证码模块 -->

	  
	   <div id="telDiv" class="form-group">
	   	<div class="col-md-9">
	    <input type="text" class="form-control" id="volidate" name="volidate" placeholder="短信验证码">
	    </div>
	    <div class="col-md-3">
	    <input type="button" id="yanzhengma" class="btn btn-default" value="获取验证码"> <br/><br/>
	    <img alt="验证码" id="telcode" src="validateTel" style="display:none" />
	    </div>
	    
	    
	    
	   </div>
	  
	  
	  
	  <!-- 图形验证码模块 -->
	  <div id="imageDiv" style="display:none" >
	   <div class="form-group">
	   <div class="col-md-7">
	   <div class="form-group">
	  <input type="text" id="validateCode" class="form-control" name="validateCode">
	  </div>
	  </div>
	   <div class="col-md-3">
	   
	  <img alt="验证码" id="imagecode" src="validateImage"/>
	  </div>
	  <div class="col-md-2">
    <a href="javascript:reloadCode()">变</a><br>
    </div>
    </div>
    
    <div class="form-group">
	   <input type="button" id="yanzheng" class="btn btn-primary btn-lg btn-block" value="验证">
	 </div>
	 </div> 
		  <!-- 密码及登陆 -->
		  <div class="form-group">
		    <input type="password" class="form-control" id="password" name="password" placeholder="密码">
		  </div>
		  <div class="checkbox">
		    <label>
		      <input type="checkbox"> 我已阅读并同意<a href="success.jsp">《用户注册协议》</a>
		    </label>
		  </div>
		  <div class="form-group">
		  <input type="button" id="submit" class="btn btn-primary btn-lg btn-block" value="注册">
		  </div>
	</form>
		<div class="form-group">
	  	<label for="exampleInputEmail1"><font color="red" >完成注册即可获取500积分</font></label>
	  	<a href="login.jsp">点我登陆</a>
	  	</div>
	</div>
  </div>
  <div class="col-md-3"></div>


  <script src="<%=basePath %>js/jquery/jquery-3.3.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="<%=basePath %>js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>register.js"></script>	
<script>
//手机验证码




</script>
</body>
</html>