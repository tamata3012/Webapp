<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="admin-header.html" %>
<%@include file="admin-menu.jsp" %>

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
					<td>申請者名</td>
					<td>返却予定日</td>
				</tr>
				<c:forEach var="lental" items="${lentalList}" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${lental.productName}</td>
						<td>${lental.lentalNumber}</td>
						<td>${lental.returnDate}</td>
						<td>
							<form action="../reserve/AdminLentalDetail.action?id=${lental.id}" method="post">
				              <input type="submit" value="詳細表示">
				            </form>
			            </td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>申請中のものはありません。</c:otherwise>
	</c:choose>

<%@include file="admin-footer.html" %>