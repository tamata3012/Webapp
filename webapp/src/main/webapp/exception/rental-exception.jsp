<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>システムエラー</title>
</head>
<body>

	<h1><c:out value="{$requestScope.errorMessageList}" /></h1>

</body>
</html>