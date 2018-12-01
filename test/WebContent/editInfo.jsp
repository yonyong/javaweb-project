<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="cn.lianwei.yonyong.utils.*,java.util.*,cn.lianwei.yonyong.pojo.*" %>
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
	<%
		String temp_id=request.getParameter("id");
		int id=Integer.parseInt(temp_id);
		InfoBean infoBean=dbOperateUtils.queryInfoById(id);
		request.setAttribute("infoBean", infoBean);
		session.setAttribute("id", id);
	%>
<div class="row">
  <div class="col-md-2"></div>
  <div class="col-md-4"><br/><br/><br/><br/><br/><img src="<%=basePath %>/js/editInfo.png" width="400"
  			height="330">
  </div>
  <div class="col-md-3">
  	<form action="" name="form1" method="post">
  	<br/><br/><br/><br/><br/>
		<div class="form-group">
	    <label for="exampleInputEmail1"><font 
	 	   	   size="6" >编辑</font></label>
		<input type="text" class="form-control" value="<%=infoBean.getTitle() %>" name="title" width=200/>
		</div>
		
		<div class="form-group">
		<input type="text" class="form-control" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" value="<%=infoBean.getDate() %>" name="date" width=200/>
		</div>
		
		<div class="form-group">
		<textarea class="form-control" id="deblock_udid" 
							name="content" rows="8" style="min-width: 90%" placeholder="内容"><%=infoBean.getContent() %> </textarea>

		</div>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" class="btn btn-default" value="保存" onclick="form1.action='editInfo';form1.submit()">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" class="btn btn-default" align="left" value="删除" onclick="form1.action='deleteInfo?id=<%=id %>';form1.submit()">
	
	</form>
	</div>
  <div class="col-md-3"></div>
</div>
  <script src="<%=basePath %>js/jquery/jquery-3.3.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="<%=basePath %>js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>