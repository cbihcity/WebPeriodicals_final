<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html><head><title>Login</title></head>
<body>
<form name="loginForm" method="POST" action="servlet">
<input type="hidden" name="command" value="login" />
Email:<br/>
<input type="text" name="email" value=""/>
<br/>Password:<br/>
<input type="password" name="password" value=""/>

<input type="submit" value="Log in"/>
</form><hr/>

Links for guest...<br/>
Debug info - session = ${session} 
</body></html>