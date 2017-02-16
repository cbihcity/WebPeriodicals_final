<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<title>Edit SubscriptionType</title>
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
                                    <div class="add_mag">
                                    	<h1>Форма изменения типа подписки</h1>
                                        <form action="act" method="post" autocomplete="off">
                                            <input type="hidden" name="command" value="editSubscriptionType" />
                                            <input type="hidden" name="type_id" value="${type.id}" />
                                            <b style="color: red; font-size: 11px;">Все поля должны быть заполнены</b><br/>
                                            <table class="add_mag_table">
                                                <tr>
                                                    <td>Name</td>
                                                    <td><input type="text" name="name" value="${type.name}"/></td>
                                                </tr>
                                                <tr>
                                                    <td>Month Value</td>
                                                    <td><input type="text" name="monthValue" value="${type.monthValue}"/></td>
                                                </tr>
                                            </table>
                                            <input type="submit" name="submit" value="Изменить" class="Button"/>
                                        </form>
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