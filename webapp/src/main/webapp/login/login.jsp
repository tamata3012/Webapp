<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="login-header.html" %>

	<h2>ログイン画面</h2>
	
	<c:if test="${!requestScope.message}">
		<c:out value="${requestScope.message}" /><br>
		<div style="text-align: :center;color:red;font-weight:bold;">
		<c:forEach var="message" items="${requestScope.errorMessageList}">
			<c:out value="${message}" /><br>
		</c:forEach>
		</div>
	</c:if>
	
	<a href="login-register.jsp">ユーザ新規登録</a>
	
	<form action="../login/Login.action" method="post">
		<div>
			ユーザ名:<input type="text" name="username"><br>
			パスワード:<input type="password" name="password"><br>
			<input type="submit"  value="ログイン">
		</div>
	</form>
	
<%@include file="login-footer.html" %>