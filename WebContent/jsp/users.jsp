<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Users</title>
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
								<%@include file="/jsp/login.jsp"%>
							</div>
							<div class="menu_frame">
								<%@include file="/jsp/menu.jsp"%>
							</div> <!-- end of menu -->
						</td>
						<td class="right_content">
							<div class="Index">
							<h1>Список пользователей:</h1>
									<table class="Table">
										<tr>
											<td><b>First Name</b></td>
											<td><b>Last Name</b></td>
											<td><b>Category</b></td>
											<td><b>Email</b></td>
											<td><b>Password</b></td>
										</tr>
										<c:forEach var="user" items="${requestScope.list}">
											<tr>
												<td>${user.firstName}</td>
												<td>${user.lastName}</td>
												<td>${user.userType}</td>
												<td>${user.email}</td>
												<td>${user.password}</td>
												<td>
													<form action="act" method="post">
                                                    <input type="hidden" name="command" value="delUser" />  
                                                    <input type="hidden" name="user_id" value="${user.id}"/>
                                                    <input type="submit" value="Удалить пользователя" class="Button"/>
                                                	</form> 
												</td>
												<td>
													<form action="act" method="post">
                                                    <input type="hidden" name="command" value="prepareEditUser" />  
                                                    <input type="hidden" name="user_id" value="${user.id}"/>
                                                    <input type="submit" value="Изменить пользователя" class="Button"/>
                                                	</form> 
												</td>
											</tr>
										</c:forEach>
									</table>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>