<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%Date d=new Date();%>
<h1><%=d%></h1>
<%Random r=new Random();%>
<h3><%=r.nextLong(100)%></h3>
</html>