<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Search Result</title>


</head>

<body>
	书名:

	<s:iterator value="#request.allbooks">
		<a href="DetailAction?name=<s:property/>"><s:property />
		</a>
		&nbsp;<a href="DeleteAction?name=<s:property/>">删除
		</a><br>
	</s:iterator>


	<a href="path.action">返回</a>
</body>
</html>
