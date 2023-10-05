<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="reserve-header.html" %>
<%@include file="menu.jsp" %>

	<p>ようこそ${user.name}さん。
	
	<h2>貸出一覧</h2>
	<h3>申請中</h3>
	<c:choose>
		<c:when test="${!requestScope.lentalList}">
			<table style="border-collapse:separate;border-spacing:10px;">
				<tr>
					<td></td>
					<td>貸出品名</td>
					<td>申請数</td>
					<td>返却予定日</td>
				</tr>
				<c:forEach var="rental" items="${rentalList}" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${rental.productName}</td>
						<td>${rental.rentalNumber}</td>
						<td>${rental.returnDate}</td>
						<td>
							<form action="../reserve/RentalDetail.action?id=${rental.id}" method="post">
				              <input type="submit" value="詳細表示">
				            </form>
			            </td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>申請中のものはありません。</c:otherwise>
	</c:choose>

<%@include file="reserve-footer.html" %>