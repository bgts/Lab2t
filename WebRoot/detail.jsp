<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Detail of the Book</title>


</head>

<body>
	<jsp:useBean id="bookbean" scope="page" class="model.DetailAction" />
	书籍详情：<br>
	书名：
	<jsp:setProperty name="bookbean" property="name" param="name" />
	<jsp:getProperty name="bookbean" property="name" /><br>
	ISBN：
	<jsp:setProperty name="bookbean" property="isbn" param="isbn" />
	<jsp:getProperty name="bookbean" property="isbn" /><br>
	Publisher：
	<jsp:setProperty name="bookbean" property="publisher" param="publisher" />
	<jsp:getProperty name="bookbean" property="publisher" /><br>
	PublishDate:
	<jsp:setProperty name="bookbean" property="publishdate" param="publishdate" />
	<jsp:getProperty name="bookbean" property="publishdate" /><br>
	Price:
	<jsp:setProperty name="bookbean" property="price" param="price" />
	<jsp:getProperty name="bookbean" property="price" /><br>
	<br>
	作者详情：<br>
	Name:
	<jsp:setProperty name="bookbean" property="authorname" param="authorname" />
	<jsp:getProperty name="bookbean" property="authorname" /><br>
	Age：
	<jsp:setProperty name="bookbean" property="age" param="age" />
	<jsp:getProperty name="bookbean" property="age" /><br>
	Country:
	<jsp:setProperty name="bookbean" property="country" param="country" />
	<jsp:getProperty name="bookbean" property="country" /><br>
	
	<br>
	<a href="#" onclick ="javascript:history.go(-1);">返回</a>
</body>
</html>


