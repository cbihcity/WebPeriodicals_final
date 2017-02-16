<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<title>Add SubscriptionType</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/gadgets.css" />
</head>
<body>
<div class="wrapper">
		<div id="content">
	<table class="main_table"> 
                    <tbody>
                        <tr>
                            <td class="left_content">
                                <div class="auth_frame">
                                    <%@include file="/jsp/login.jsp" %>
                                </div>
                                <div class="menu_frame">
                                    <%@include file="/jsp/menu.jsp" %>
                                </div><!-- end of menu -->
                            </td>
                        <c:if test="${sessionScope.user.userType == 'ADMIN'}">
						<td class="right_content">
							<div class="Index">
                                    <div class="add_mag">
                                    	<h1>Форма добавления нового типа подписки:</h1>
                                        <form action="act" method="post" autocomplete="off">
                                            <input type="hidden" name="command" value="addSubscriptionType" />
                                            <b style="color: red; font-size: 11px;">Все поля должны быть заполнены</b><br/>
                                            <table class="Table">
                                                <tr>
                                                    <td><b>Name</b></td>
                                                    <td><input type="text" name="name"/></td>
                                                </tr>
                                                <tr>
                                                    <td><b>Month Value</b></td>
                                                    <td><input type="text" name="monthValue" /></td>
                                                </tr>
                                            </table>
                                            <input type="submit" name="submit" value="Добавить" class="Button"/>
                                        </form>
                                    </div>
                                </div>
                            </td>
                            </c:if>
                        </tr>
                    </tbody>
                </table>
</div>
</div>
</body>
</html>