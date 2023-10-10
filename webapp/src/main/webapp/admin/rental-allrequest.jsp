<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="admin-header.html" %>
<%@include file="admin-menu.jsp" %>
	
	<h2>貸出一覧</h2>
	<b>申請中</b>
	<c:choose>
		<c:when test="${!requestScope.rentalList}">
			<table style="border-collapse:separate;border-spacing:10px;">
				<tr>
					<td></td>
					<td>貸出品名</td>
					<td>申請数</td>
					<td>申請者名</td>
					<td>返却予定日</td>
					<td>貸し出し状況</td>
				</tr>
				<c:forEach var="rental" items="${rentalList}" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${rental.productName}</td>
						<td>${rental.rentalNumber}</td>
						<td>${rental.userName}</td>
						<td>${rental.returnDate}</td>
						<td>${rental.rentalStatus}</td>
						<td>
							<form action="../admin/AdminRentalDetail.action?id=${rental.id}" method="post">
				              <input type="submit" value="詳細表示">
				            </form>
			            </td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise><p>申請中のものはありません。</p></c:otherwise>
	</c:choose>
	<b>返却済み</b>
	<c:choose>
		<c:when test="${!requestScope.returnList}">
			<table style="border-collapse:separate;border-spacing:10px;">
				<tr>
					<td></td>
					<td>貸出品名</td>
					<td>申請数</td>
					<td>申請者名</td>
					<td>返却日</td>
					<td>貸し出し状況</td>
				</tr>
				<c:forEach var="rentalReturn" items="${returnList}" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${rentalReturn.productName}</td>
						<td>${rentalReturn.rentalNumber}</td>
						<td>${rentalReturn.userName}</td>
						<td>${rentalReturn.returnDate}</td>
						<td>${rental.rentalStatus}</td>
						<td>
							<form action="../admin/ReturnDetail.action?id=${rentalReturn.id}" method="post">
				              <input type="submit" value="詳細表示">
				            </form>
			            </td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise><p>申請中のものはありません。</p></c:otherwise>
	</c:choose>

<%@include file="admin-footer.html" %>