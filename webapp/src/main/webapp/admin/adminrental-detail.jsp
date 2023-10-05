<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="admin-header.html" %>
<%@include file="admin-menu.jsp" %>

	<h2>申請詳細</h2>
		<table>
			<tr>
				<td>貸出品名</td>
				<td>${rental.productName}</td>
			</tr>
			<tr>
				<td>申請数</td>
				<td>${rental.rentalNumber}</td>
			</tr>
			<tr>
				<td>申請日</td>
				<td>${rental.rentalDate}</td>
			</tr>
			<tr>
				<td>返却予定日</td>
				<td>${rental.returnDate}</td>
			</tr>
			<tr>
				<td>
					<form action="../admin/RequestApproval.action?id=${rental.id}" method="post">
						<input type="submit" value="承認">
						<input type="hidden" name="productid" value="${product.id}">
					</form>
				</td>
				<td>
					<form action="../admin/RequestRemand.action?id=${rental.id}" method="post">
						<input type="submit" value="差し戻し">
						<input type="hidden" name="productid" value="${product.id}">
					</form>
				</td>
			</tr>
		</table>

<%@include file="admin-footer.html" %>