<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="reserve-header.html" %>
<%@include file="menu.jsp" %>

	<h2>貸出予約</h2>
	<form action="../reserve/Reserve.action" method="post">
		<table>
			<tr>
				<td>貸出品名</td>
				<td>${product.name}</td>
			</tr>
			<tr>
				<td>貸出可能数</td>
				<td>${product.lentalNumber}</td>
			</tr>
			<tr>
				<td>申請数</td>
				<td><input type="number" name="lentalnumber"></td>
			</tr>
			<tr>
				<td>返却予定日</td>
				<td><input type="date" name="date"></td>
			</tr>
			<tr>
				<td><input type="submit" value="貸出"></td>
			</tr>
		</table>
		<input type="hidden" name="productid" value="${product.id}">
	</form>

<%@include file="reserve-footer.html" %>