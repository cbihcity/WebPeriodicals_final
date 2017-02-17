<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:if test="${sessionScope.locale == 'locale_RU' or empty sessionScope.locale}" >
    <fmt:setBundle basename="locale_ru_RU" />
</c:if>
<c:if test="${sessionScope.locale == 'locale_EN'}">
    <fmt:setBundle basename="locale_en_EN" />
</c:if>
<html>
<head>
<title>Add Magazine</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/gadgets.css" />
</head>
<body>
  <%@include file="/jsp/header.jsp" %>
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
                                    	<h1>Форма добавления нового издания</h1>
                                        <form action="act" method="post" autocomplete="off">
                                            <input type="hidden" name="command" value="addMag" />
                                            <b style="color: red; font-size: 11px;">Все поля должны быть заполнены</b><br/>
                                            <table class="Table">
                                                <tr>
                                                    <td><b>Название</b></td>
                                                    <td><input type="text" name="name"/></td>
                                                </tr>
                                                
                                                <tr>
                                                    <td><b>Категория</b></td>
                                                    <td>
                                                    <select name="type">
                                              		<c:forEach begin="0" end="${fn:length(requestScope.list)-1}" var="type">
                                                    <option value="${list[type]}">${list[type]}</option>
                                                    </c:forEach> 
                                                    </select>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td><b>Цена</b></td>
                                                    <td><input type="text" name="price" /></td>
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