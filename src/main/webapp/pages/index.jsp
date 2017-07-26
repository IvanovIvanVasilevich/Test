<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
 
    <title>Список докладов</title>
    
    <script type="text/javascript" src="/resources/js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery.mask.min.js"></script>
<link type="text/css" rel="stylesheet" href="/resources/css/jquery-ui.css">
<script type="text/javascript" src="/resources/js/jquery-ui.min.js"></script>
<script src="/resources/js/autoNumeric-1.9.36.js" type=text/javascript>
	
</script>
<link href="/resources/css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="/resources/js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
<script type="text/javascript" src="/resources/js/bootstrap.file-input.js"></script>
<link type="/resources/css" rel="stylesheet"
	href="/resources/css/bootstrap-select.min.css" />
<link type="text/css" rel="stylesheet" href="/resources/css/reportstyles.css">
<link href='http://fonts.googleapis.com/css?family=PT+Sans+Narrow:700'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=PT+Sans:700'
	rel='stylesheet' type='text/css'>
 
    <!-- Bootstrap core CSS -->
   <link rel='stylesheet' href='/resources/css/bootstrap.min.css'>
 
 
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    
    <script type="text/javascript">	
			
			function mainSubmit() {
		 		scroll(0,0);
		 		$('body').addClass("loading");
		 		$('#form').submit();
		 	}
			
			
// 			function setEditForm(id,start,end,name, event) {
// 				if (typeof event.stopPropagation != "undefined") {
// 					event.stopPropagation();
// 			    } else {
// 			    	event.cancelBubble = true;
// 			    }
// 				scroll(0,0);
// 		 		$('body').addClass("loading");
// 				if (id != "");
// 				window.location = "editPresent?presentId=" + id;
// 			}
			
			function editPresent() {
				$('#edit').hide();		
				mainSubmit();
			}
			
			function createPresent() {
				$('#create').hide();	
				mainSubmit();
			}
			
			function setEdit(id, name,description,start,enddt,scheduleId,schedule,room) {
				
				$("#openAttr .modal-header .modal-title").text("Редактировать");
				$("#id").val(id); 
 				$("#name").val(name); 
 				$("#description").val(description);
 				$("#start").val(start);
 				$("#end").val(enddt);
 				$("#scheduleId").val(scheduleId);
 				$("#schedule").val(schedule);
 				$("#room").val(room);
 				
 	
				 			
			}
			
			function setCreate() {				
				$("#openAttr .modal-header .modal-title").text("Создать");
		
				$("#id").val(); 
 				$("#name").val(); 
 				$("#description").val();
 				$("#start").val();
 				$("#end").val();
 				$("#room").val();
							 			
			}
			</script>
</head>


 
<body>
 
<div class="container">
 <%@include file="authheader.jsp" %>
    <div class="jumbotron" style="margin-top: 20px;">
    
  
     
		
       
        
        <div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">Список докладов текущего пользователя</span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
		      			<th>Дата начала</th>
		      			<th>Дата окончания</th>
				        <th>Нименование</th>
				        <th>Описание</th>
				        <th>Номер аудитории</th>		
				         <th></th>        
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${presentationsUser}" var="presentationUser">
					<tr>
						<td>${presentationUser.schedule.start}</td>
						<td>${presentationUser.schedule.end}</td>
						<td>${presentationUser.name}</td>
						<td>${presentationUser.description}</td>
						<td>${presentationUser.room.description}</td>
					
						
						<td> <div onClick="setEdit(${presentationUser.id}, &quot;${presentationUser.name}&quot;, &quot;${presentationUser.description}&quot;, &quot;${presentationUser.schedule.start}&quot;, &quot;${presentationUser.schedule.end}&quot;, &quot;${presentationUser.schedule.scheduleId}&quot;, &quot;${presentationUser.schedule}&quot;, &quot;${presentationUser.room.number}&quot;, event)" class="btn btn-success custom-width" data-target="#edit" data-toggle="modal">edit</div></td>
						<td><a href="<c:url value='/index/delete-present-${presentationUser.id}' />" class="btn btn-danger custom-width">delete</a></td>
								
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
	    	<div class="modal-footer">
					<button onClick="setCreate()" class="btn-new btn-report btn-create " type="button" data-target="#edit" data-toggle="modal">Добавить</button>
					
					<button class="btn-exit btn-report btn-cancel"
						onClick="window.location='/'"
						type="button">Отмена</button>
				</div>
		</div>
        
    </div>
    
     <form:form commandName="index" method="POST" modelAttribute="presentAction" id="form" role="form" class="form-horizontal" action="/index/edit-present">
    	<div class="modal fade" id="edit" role="dialog">
				<div class="modal-dialog" style="width: 600px;">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title" style="font-weight: bold;">Редактирование
								призентации</h4>
						</div>
						<div class="modal-body">


							
							<div>
								<form:input id="id" path="id" class="inputtext" 
 									required="true" onChange="disableSaveButton(this);" 
 									onkeyup="disableSaveButton(this);" type="hidden" />
 									
 										<form:input id="scheduleId" path="schedule.scheduleId" class="inputtext" 
 									required="true"  type="hidden" />
 									
 									<form:input id="schedule" path="schedule" class="inputtext" 
 									required="true"  type="hidden" />
 									
<%--  										<form:input id="roomId" path="room.roomId" class="inputtext"  --%>
<%--  									required="true"  type="hidden" /> --%>
 									 
							<div style="padding-bottom: 5px;">
								<label>Название призентации:</label>
							</div>
								<form:input id="name" path="name"
									class="inputtext" required="true" /> 
							</div>
							
							<div style="padding-bottom: 5px;">
								<label>Описание призентации:</label>
							</div>
								<form:input id="description" path="description"
									class="inputtext" required="true" /> 
							
							
							<div style="padding-bottom: 5px;">
								<label>Дата начала:</label>
							</div>
							
							
								<form:input id="start" path="schedule.start"
									class="inputtext" required="true" /> 
							
							
							<div style="padding-bottom: 5px;">
								<label>Дата окончания:</label>
							</div>
								<form:input id="end" path="schedule.end"
									class="inputtext" required="true" /> 
							
							<div style="padding-bottom: 5px;">
								<label>Комната:</label>
							</div>
								<form:input id="room" path="room.number"
									class="inputtext" required="true" /> 

						</div>
						<div class="modal-footer">
							<button class="btn-report btn-create" type="button"
								onClick="editPresent()">Сохранить</button>
							<button class="btn-report btn-cancel" data-dismiss="modal"
								type="button">Отмена</button>
						</div>
					</div>
				</div>
			</div>
			</form:form>
			
			
<!-- 				<div class="modal fade" id="create" role="dialog"> -->
<!-- 				<div class="modal-dialog" style="width: 600px;"> -->
<!-- 					<div class="modal-content"> -->
<!-- 						<div class="modal-header"> -->
<!-- 							<button type="button" class="close" data-dismiss="modal">&times;</button> -->
<!-- 							<h4 class="modal-title" style="font-weight: bold;">Создание -->
<!-- 								доклада</h4> -->
<!-- 						</div> -->
<!-- 						<div class="modal-body"> -->
					
<!-- 							<div> -->
<%-- 								<form:input id="createId" path="id" class="inputtext"  --%>
<%--  									required="true" onChange="disableSaveButton(this);"  --%>
<%--  									onkeyup="disableSaveButton(this);" type="hidden" /> --%>
 									 
<!-- 							<div style="padding-bottom: 5px;"> -->
<!-- 								<label>Название призентации:</label> -->
<!-- 							</div> -->
<%-- 								<form:input id="createName" path="name" --%>
<%-- 									class="inputtext" required="true" />  --%>
<!-- 							</div> -->
							
<!-- 							<div style="padding-bottom: 5px;"> -->
<!-- 								<label>Описание призентации:</label> -->
<!-- 							</div> -->
<%-- 								<form:input id="createDescription" path="description" --%>
<%-- 									class="inputtext" required="true" />  --%>
							
							
<!-- 							<div style="padding-bottom: 5px;"> -->
<!-- 								<label>Дата начала:</label> -->
<!-- 							</div> -->
							
							
<%-- 								<form:input id="createStart" path="schedule.start" --%>
<%-- 									class="inputtext" required="true" />  --%>
							
							
<!-- 							<div style="padding-bottom: 5px;"> -->
<!-- 								<label>Дата окончания:</label> -->
<!-- 							</div> -->
<%-- 								<form:input id="createEnd" path="schedule.end" --%>
<%-- 									class="inputtext" required="true" />  --%>
							
<!-- 							<div style="padding-bottom: 5px;"> -->
<!-- 								<label>Комната:</label> -->
<!-- 							</div> -->
<%-- 								<form:input id="createRoom" path="room.number" --%>
<%-- 									class="inputtext" required="true" />  --%>
						
<!-- 						</div> -->
<!-- 						<div class="modal-footer"> -->
<!-- 							<button class="btn-report btn-create" type="button" -->
<!-- 								onClick="createPresent()">Сохранить</button> -->
<!-- 							<button class="btn-report btn-cancel" data-dismiss="modal" -->
<!-- 								type="button">Отмена</button> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
			
			
			
	<div class="footer">
        <p>© Иванов 2017</p>
        
    </div>
				</div>
    
 
   
 
</div>
</body>
</html>