<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="reserve-header.html" %>
<%@include file="menu.jsp" %>

	<p>ようこそ${user.name}さん。
	
	<h2>貸出品一覧</h2>
	<form action="../reserve/Product.action" method="post">
		<input type="text" name="keyword">
		<input type="submit" value="検索">
	</form>
	<table style="border-collapse:separate;border-spacing:10px;">
	<c:forEach var="product" items="${productList}">
		<tr>
			<td>${product.name}</td>
			<td>${product.lentalNumber}</td>
			<td>
				<form action="../reserve/Lental.action?id=${product.id}" method="post">
	              <input type="submit" value="貸出申請">
	            </form>
            </td>
		</tr>
	</c:forEach>
	</table>

<%@include file="reserve-footer.html" %>