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
                            <td class="right_content">
                                                        
                                <table style="vertical-align:middle;font-size: 24px">
                                    <tr>
                                        <td>
                                            <img src="/WEB-INF/jsp/error/error_small.png"/>
                                        </td>
                                    </tr>
                                </table>
                                
                                <div style="margin: 0; font: medium sans-serif;">
                                    ${errormessage}
                                </div>
                                <%-- End of main part  --%>     
                            </td>
                        </tr>
                    </tbody>
                </table>
</div>
</body>
</html>
