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
				<c:choose>
					<c:when test="${rental.rentalCode!=3}">
						<td>返却予定日</td>
						<td>${rental.returnDate}</td>
					</c:when>
					<c:otherwise>
						<td>返却日</td>
						<td>${rental.returnDate}</td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<td>ユーザー名</td>
				<td>${rental.userName}</td>
			</tr>
			<tr>
				<td>電話番号</td>
				<td>${rental.userPhone}</td>
			</tr>
			<tr>
			<c:choose>
				<c:when test="${rental.rentalCode==1}">
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
				</c:when>
				<c:when test="${rental.rentalCode==2}">
					<td>
					<form action="../admin/ReturnRequest.action?id=${rental.id}" method="post">
						<input type="submit" value="返却">
						<input type="hidden" name="productId" value="${rental.productId}">
						<input type="hidden" name="rentalNumber" value="${rental.rentalNumber}">
					</form>
				</td>
				</c:when>
			</c:choose>
			<td>
				<form action="../admin/AllRentalRequest.action" method="post">
						<input type="submit" value="戻る">
				</form>
			</td>
			</tr>
		</table>

<%@include file="admin-footer.html" %>