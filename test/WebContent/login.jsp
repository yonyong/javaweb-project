<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    
<title>login</title>

<link href="<%=basePath %>js/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

	<h1 style="text-align:center">login system</h1>
	<hr><br>
	  
<div class="row">
  <div class="col-md-2"></div>
  <div class="col-md-4"><img src="<%=basePath %>/js/login.png" width="330"
  			height="280"></div>
  <div class="col-md-3">
  
	<form>
 	   <div class="form-group">
 	   	<label for="exampleInputEmail1">登陆</label>
	    <input type="text" class="form-control" id="tel" name="tel" placeholder="手机号码">
	  </div>
	  <div class="form-group">
	    <input type="password" class="form-control" id="password" name="password" placeholder="密码">
	  </div>
	  <div class="form-group">
	  	<div class="col-md-4">
	  		<p class="help-block"><a href="register.jsp">快速注册</a></p>
	  	</div>
	  	<div class="col-md-4">
	  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|
	  	</div> 
	  	<div class="col-md-4">
	  		<p class="help-block"><a href="youkeInfo.jsp">游客登录</a></p>
	  	</div> 
	  </div>
	  <input type="button" id="submit" class="btn btn-primary btn-lg btn-block" value="登陆"/>
	
</form>
  </div>
  <div class="col-md-3"></div>
</div>
	 <script src="<%=basePath %>js/jquery/jquery-3.3.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="<%=basePath %>js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>	
<script>


	function func() {
		//验证用户是否已经注册过
		var tel = $("#tel").val();//获取表单元素值
		var password = $("#password").val();
		
		var tel = document.getElementById('tel').value;
		if(tel==""){
			alert("手机号不能为空！");
			//window.location.href="register.jsp";
			return false;
		}
		
		if (!(/^1[34578]\d{9}$/.test(tel))) {
			alert("手机号输入错误");
			return false;
		}
		if(password=="")
			{
			alert("密码不能为空！");
			return false;
			}
		if(password.length<4){
			alert("密码不能少于4位！");
			return false;
		}
		return true;
	}

	$("#submit").on("click", function() {
		if (!func()) {
			console.log("!!!!!!");
			return false;
		}
		var tel = $("#tel").val();//获取表单元素值
		var password = $("#password").val();
		var data = {
			tel : tel,
			password : password
		};
		$.ajax({
			type : "POST",
			url : "/test/login",
			data : data,
			dataType : 'json',
			success : function(msg) {
				if ("00"==msg.errorCode) {
					console.log("success");
					window.location.href = "/test/info.jsp";
				} else if("11"==msg.errorCode) {
					alert("该手机号码不存在！");
					console.log("该手机号码不存在！");
					return false;
				}else if("22"==msg.errorCode){
					alert("密码输入错误，错误输入三次后您的账户将会被锁定！");
					return false;
				}
				else if("33"==msg.errorCode){
					alert("您由于错误登陆次数太多，系统已将您的账户锁定，请在三分钟后重新登录！");
					return false;
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				// 状态码
				console.log(XMLHttpRequest.status);
				// 状态
				console.log(XMLHttpRequest.readyState);
				// 错误信息   
				console.log(textStatus);
			}

		});
	});
</script>

</body>
</html>