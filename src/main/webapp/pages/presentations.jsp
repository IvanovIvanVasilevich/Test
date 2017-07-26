<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>Главная страница</title>
<link rel='stylesheet' href='/resources/css/bootstrap.min.css'>
</head>
<body>
	<div class="generic-container">
			<%@include file="authheader.jsp" %>
			<br>
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">Расписание презентаций</span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
		      			<th>Дата начала</th>
		      			<th>Дата окончания</th>
				        <th>Нименование</th>
				        <th>Описание</th>
				        <th>Номер аудитории</th>		        
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${presentations}" var="presentation">
					<tr>
						<td>${presentation.schedule.start}</td>
						<td>${presentation.schedule.end}</td>
						<td>${presentation.name}</td>
						<td>${presentation.description}</td>
						<td>${presentation.room.description}</td>
								
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
		</div>
		
   	</div>
</body>
</html>