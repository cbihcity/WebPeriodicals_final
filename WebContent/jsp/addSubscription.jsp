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
                                    	<h1>Форма добавления новой подписки</h1>
                                        <form action="act" method="post" autocomplete="off">
                                            <input type="hidden" name="command" value="countTotalPrice" />
                                            <input type="hidden" name="mag_id" value="${mag.id}"/>
                                            <input type="hidden" name="user" value="${sessionScope.user}"/>
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
                                                    <td>
                                                    <select name="type_id">
                                                    <c:forEach var="type" items="${requestScope.list}">
                                                   	<option value="${type.id}">${type.name}</option>
                                                   	  	</c:forEach> 
                                                    </select>
                                                    </td>
                                                </tr>
                                            </table>
                                            <input type="submit" name="submit" value="Итоговая стоимость" class="Button"/>
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