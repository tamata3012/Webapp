<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="reserve-header.html" %>
<%@include file="menu.jsp" %>

	<p>ようこそ${user.name}さん。
	
	<h2>貸出一覧</h2>
	<h3>申請中</h3>
	<table style="border-collapse:separate;border-spacing:10px;">
	<c:forEach var="lental" items="${lentalList}" varStatus="status">
		<tr>
			<td>${status.count}</td>
			<td>${lental.productName}</td>
			<td>${lental.returnDate}</td>
			<td>
				<form action="../reserve/Lental.action?id=${lental.id}" method="post">
	              <input type="submit" value="詳細表示">
	            </form>
            </td>
		</tr>
	</c:forEach>
	</table>

<%@include file="reserve-footer.html" %>