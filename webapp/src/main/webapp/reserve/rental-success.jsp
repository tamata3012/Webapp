<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="reserve-header.html" %>
<%@include file="menu.jsp" %>
	
	<h2>貸出申請が完了しました</h2>
	
	<a href="../reserve/Product.action">申請を続ける</a>
	<a href="../reserve/RentalRequest.action">申請内容を確認する</a>

<%@include file="reserve-footer.html" %>