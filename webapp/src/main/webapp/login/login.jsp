<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="login-header.html" %>

	<h2>ログイン画面</h2>
	
	<form action="LoginServlet" method="post">
		<div>
			ユーザー名:<input type="text" name="username"><br>
			パスワード:<input type="password" name="password"><br>
			<button type="submit" >ログイン</button>
		</div>
	</form>
	
<%@include file="login-footer.html" %>