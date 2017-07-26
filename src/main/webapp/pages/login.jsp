<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
 
    <title>Spring Security</title>
 
    <!-- Bootstrap core CSS -->
   <link rel='stylesheet' href='/resources/css/bootstrap.min.css'>
 
    <!-- Custom styles for this template -->
    <link rel='stylesheet' href='/resources/css/app.css'>
 
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
 
<body>
 
<div class="container" style="width: 300px;">
    <c:url value="/spring_security_check" var="loginUrl" />
    <form action="${loginUrl}" prependId = "false"  method="post">
        <h2 class="form-signin-heading">Введите пароль</h2>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="text" class="form-control" name="username" placeholder="login" >
        <input type="password" class="form-control" name="password" placeholder="Password">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
    </form>
</div>
 
</body>
</html>