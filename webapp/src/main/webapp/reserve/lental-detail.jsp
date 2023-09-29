<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="reserve-header.html" %>
<%@include file="menu.jsp" %>

	<h2>申請詳細</h2>
		<table>
			<tr>
				<td>貸出品名</td>
				<td>${lental.productName}</td>
			</tr>
			<tr>
				<td>申請数</td>
				<td>${lental.lentalNumber}</td>
			</tr>
			<tr>
				<td>申請日</td>
				<td>${lental.lentalDate}</td>
			</tr>
			<tr>
				<td>返却予定日</td>
				<td>${lental.returnDate}</td>
			</tr>
		</table>
		<form action="../reserve/RequestDelete.action?id=${lental.id}" method="post">
			<input type="submit" value="申請取消">
		</form>

<%@include file="reserve-footer.html" %>