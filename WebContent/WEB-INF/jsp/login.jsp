<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:choose>
<c:when test="${empty sessionScope.user}">
		<form action="action" method="POST" autocomplete="off">
			<input type="hidden" name="command" value="login" /> Email:<br /> <input
				type="text" name="email" value="" /> <br />Password:<br /> <input
				type="password" name="password" value="" /> <br />
			<input type="submit" value="Log in" />
		</form>
	</c:when>
<c:otherwise>
<div class="authorized">
                        <b>Hello ${sessionScope.user.firstName}!</b>
                        <br/><b>Your session - ${sessionScope.user.userType}!</b>
                        <br/><b>Your mail - ${sessionScope.user.email}!</b>
                        <br/>
                        <br/>
                        <a href="action?command=logout">Log Out</a>
                </div>
</c:otherwise>
</c:choose>
