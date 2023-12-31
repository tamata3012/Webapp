<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="login-header.html" %>

	<h2>新規登録</h2>
	
	<div style="text-align: :center;color:red;font-weight:bold;">
	<c:forEach var="message" items="${requestScope.errorMessageList}">
		<c:out value="${message}" /><br>
	</c:forEach>
	</div>
	
	下記項目すべてを入力してください。
	<form action="UserRegister.action" method="post">
		<div>
			ユーザ名<input type="text" name="username"><br>
			パスワード<input type="password" name="password"><br>
			電話番号  <input type="text" name="phone"><br>
			<button type="submit" >登録</button>
		</div>
	</form>
	
<%@include file="login-footer.html" %>