<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="reserve-header.html" %>
<%@include file="menu.jsp" %>

	<h2>貸出予約</h2>
	<table style="border-collapse:separate;border-spacing:10px;">
		<tr>
			<td>${product.name}</td>
			<td>${product.lentalNumber}</td>
			<td></td>
		</tr>
	</table>

<%@include file="reserve-footer.html" %>