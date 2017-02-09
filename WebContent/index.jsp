<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>Index</title></head>
<body>
<div id="content">
	<table class="main_table"> 
                    <tbody>
                        <tr>
                            <td class="left_content">
                                <div class="auth_frame">
                                    <%@include file="/WEB-INF/jsp/login.jsp" %>
                                </div>
                                <div class="error_frame">
                                    <%@include file="/WEB-INF/jsp/error/error.jsp" %>
                                </div><!-- end of auth --> 
                            </td>
                        </tr>
                    </tbody>
                </table>
</div>
</body></html>