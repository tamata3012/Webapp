<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="admin-header.html" %>
<%@include file="admin-menu.jsp" %>

	<h2>貸出品登録</h2>
	<c:if test="${!requestScope.message}">
		<c:out value="${requestScope.message}" /><br>
		<div style="text-align: :center;color:red;font-weight:bold;">
		<c:forEach var="message" items="${requestScope.errorMessageList}">
			<c:out value="${message}" /><br>
		</c:forEach>
		</div>
	</c:if>
	<form action="../admin/ProductRegister.action" method="post">
		<table>
			<tr>
				<td>貸出品名</td>
				<td><input type="text" name="productName"></td>
			</tr>
			<tr>
				<td>個数</td>
				<td><input type="number" min="0" name="rentalNumber"></td>
			</tr>
		</table>
		<input type="submit" value="追加">
		<input type="hidden" name="productid" value="${product.id}">
	</form>

<%@include file="admin-footer.html" %>