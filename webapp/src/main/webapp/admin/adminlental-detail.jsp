<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="admin-header.html" %>
<%@include file="admin-menu.jsp" %>

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

<%@include file="admin-footer.html" %>