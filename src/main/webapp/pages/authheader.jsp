<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<div class="authbar">
		 
		
		<sec:authorize access="!isAuthenticated()">
		<span class="floatLeft"><a href="<c:url value="/login" />">Войти</a></span>
		<span class="floatLeft"><a href="<c:url value="/registrations" />">Регистрация докладчика</a></span>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
		<span>Приветствую <strong><sec:authentication property="principal.username" /></strong>, Welcome.</span>
		 <span class="floatRight"><a href="<c:url value="/login/logout" />">Выйти</a></span>
		 </sec:authorize>
	</div>
