<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="login-header.html" %>

	<h2>ログイン画面</h2>
	
	<c:out value="${requestScope.message}" /><br>
	<div style="text-align: :center;color:red;font-weight:bold;">
	<c:forEach var="message" items="${requestScope.errorMessageList}">
		<c:out value="${message}" /><br>
	</c:forEach>
	</div>
	
	<a href="login-register.jsp">ユーザー新規登録</a>
	
	<form action="Login.action" method="post">
		<div>
			ユーザー名:<input type="text" name="username"><br>
			パスワード:<input type="password" name="password"><br>
			<button type="submit" >ログイン</button>
		</div>
	</form>
	
<%@include file="login-footer.html" %>