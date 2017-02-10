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

						<td class="right_content">
                                    <div class="add_mag">
                                        <form action="action" method="post" autocomplete="off">
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
                        </tr>
                    </tbody>
                </table>
</div>
</body></html>