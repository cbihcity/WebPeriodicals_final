<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Error page</title>
</head>
<body>
<div id="content">
	<table class="main_table"> 
                    <tbody>
                        <tr>
                            <td class="left_content">
                                <div class="auth_frame">
                                    <%@include file="/WEB-INF/jsp/login.jsp" %>
                                </div><!-- end of auth --> 
                            </td>
                        </tr>
                        
                        <tr>
                            <td class="left_content">
                                <div style="margin: 0; font: medium sans-serif;">
                                    <p><fmt:message key="${errormessage}"/></p>
                                    dsfdsfdsfdsfdsf
                                </div> 
                            </td>
                        </tr>
                    </tbody>
                </table>
</div>
</body>
</html>
