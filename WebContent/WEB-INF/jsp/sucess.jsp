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
                                <div class="menu_frame">
                                    <%@include file="/WEB-INF/jsp/menu.jsp" %>
                                </div><!-- end of menu -->
                            </td>
                            <td class="right_content">
                                
                                <div style="margin: 0; font: medium sans-serif;">
                                    ${sucessmessage}
                                </div>
                                <%-- End of main part  --%>     
                            </td>
                        </tr>
                    </tbody>
                </table>
</div>
</body></html>