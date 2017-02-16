<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
						<td class="right_content">
							<div class="Index">
                                    <div class="add_mag">
                                    	<h1>Оформление подписки</h1>
                                        <form action="act" method="post" autocomplete="off">
                                            <input type="hidden" name="command" value="addSub" />
                                            <input type="hidden" name="mag_id" value="${mag}"/>
                                            <input type="hidden" name="type_id" value="${type.id}"/>
                                            <input type="hidden" name="user_id" value="${sessionScope.user.id}"/>
                                            <b style="color: red; font-size: 11px;">Все поля должны быть заполнены</b><br/>
                                            <table class="Table">
                                                <tr>
                                                    <td><b>Название</b></td>
                                                    <td><input type="text" name="name" value="${mag.name}" readonly="readonly"/></td>
                                                </tr>
                                                <tr>
                                                    <td><b>Категория</b></td>
                                                    <td><input type="text" name="category" value="${mag.type}" readonly="readonly"/></td>
                                                </tr>
                                                <tr>
                                                    <td><b>Cтоимость журнала</b></td>
                                                    <td><input type="text" name="price" value="${mag.price}" readonly="readonly"/></td>
                                                    
                                                </tr>
                                            	<tr>
                                                    <td><b>Тип подписки</b></td>
                                                    <td><input type="text" name="type" value="${type.name}" readonly="readonly"/></td>
                                                </tr>
                                                <tr>
                                                    <td><b>Общая сумма подписки</b></td>
                                                    <td><input type="text" name="totalprice" value="${total}" readonly="readonly"/></td>
                                                </tr>
                                            </table>
                                            <input type="submit" name="submit" value="Оформить подписку" class="Button"/>
                                        </form>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
</div>
</div>
</body>
</html>