<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<title>Список пользователей</title>
	<link href="<c:url value='/pages/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/pages/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	<div class="generic-container">
		<%@include file="authheader.jsp" %>	
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">Список пользователей</span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>Логин</th>
				        <th>Имя</th>
				        <th>Роль</th>				        
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.login}</td>
						<td>${user.name}</td>
						<td>${user.role}</td>
					
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
		</div>
		<sec:authorize access="hasRole('ADMIN')">
		 	<div class="well">
		 		<a href="<c:url value='/newuser' />">Add New User</a>
		 	</div>
	 	</sec:authorize>
   	</div>
</body>
</html>