<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<title>Add Magazine</title>
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
                                    	<h1>Форма добавления нового магазина</h1>
                                        <form action="act" method="post" autocomplete="off">
                                            <input type="hidden" name="command" value="addMag" />
                                            <b style="color: red; font-size: 11px;">Все поля должны быть заполнены</b><br/>
                                            <table class="add_mag_table">
                                                <tr>
                                                    <td>Название</td>
                                                    <td><input type="text" name="name"/></td>
                                                </tr>
                                                <tr>
                                                    <td>Категория</td>
                                                    <td><input type="text" name="type" /></td>
                                                </tr>
                                                <tr>
                                                    <td>Цена</td>
                                                    <td><input type="text" name="price" /></td>
                                                </tr>
                                            </table>
                                            <input class="RegButton" type="submit" name="submit" value="Добавить" />
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