<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="reserve-header.html" %>
<%@include file="menu.jsp" %>

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
				<c:if test="${rental.rentalCode==1}">
				<td>
					<form action="../reserve/RequestDelete.action?id=${rental.id}" method="post">
					<input type="submit" value="申請取消">
					</form>
				</td>
				</c:if>
				<td>
					<form action="../reserve/RentalRequest.action" method="post">
							<input type="submit" value="戻る">
					</form>
				</td>
			</tr>
		</table>

<%@include file="reserve-footer.html" %>