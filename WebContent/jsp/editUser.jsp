<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<title>Edit Magazine</title>
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
                                    	<h1>Форма изменение пользователя</h1>
                                        <form action="act" method="post" autocomplete="off">
                                            <input type="hidden" name="command" value="editUser" />
                                            <input type="hidden" name="user_id" value="${user.id}" />
                                            <input type="hidden" name="email" value="${user.email}" />
                                            <input type="hidden" name="password" value="${user.password}" />
                                            <b style="color: red; font-size: 11px;">Все поля должны быть заполнены</b><br/>
                                            <table class="add_mag_table">
                                                <tr>
                                                    <td>First Name</td>
                                                    <td><input type="text" name="firstName" value="${user.firstName}"/></td>
                                                </tr>
                                                <tr>
                                                    <td>Last Name</td>
                                                    <td><input type="text" name="lastName" value="${user.lastName}"/></td>
                                                </tr>
                                                <tr>
                                                    <td>Category</td>
                                                    <td>
                                                    <select name="category">
                                              		<c:forEach begin="0" end="${fn:length(requestScope.list)-1}" var="type">
                                                    <option value="${list[type]}">${list[type]}</option>
                                                    </c:forEach> 
                                                    </select>
                                                    </td>
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