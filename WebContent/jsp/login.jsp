<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript" src="js/validation.js"></script>
<div class="Gadget">
	<div class="GadgetSmoothTop"></div>
	<div class="GadgetContent">
		<c:choose>
			<c:when test="${empty sessionScope.user}">
				<form action="index" method="POST" autocomplete="off">
					<input type="hidden" name="command" value="login" />
					<div class="Input">
						<input id="loginAuthForm" name="email" type="text" value="Email"
							class="Input2" onfocus="clearField('Email','loginAuthForm')"
							onblur="restoreField('Email','loginAuthForm')" />
					</div>
					<div class="Input">
						<input id="passAuthForm" name="password" type="password"
							value="password" class="Input2"
							onfocus="clearField('password','passAuthForm')"
							onblur="restoreField('password','passAuthForm')" />
					</div>
					<input type="submit" value="Log in" class="LoginButton" />
					
				</form>
			</c:when>
			<c:otherwise>
				<div class="authorized">
					<b>Hello ${sessionScope.user.firstName}!</b> 
					<br/><b>Your session - ${sessionScope.user.userType}!</b> 
					<br/><b>Your mail - ${sessionScope.user.email}!</b>
					<br/> 
					<a href="index?command=logout">Log Out</a>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	<div class="GadgetSmoothBottom"></div>
</div>