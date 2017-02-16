<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>subscriptionTypes</title>
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
						<c:if test="${sessionScope.user.userType == 'ADMIN'}">
							<div class="Index">
							<h1>Список типов возможных подписок:</h1>
									<table class="Table">
										<tr>
											<td><b>Name</b></td>
											<td><b>Month Value</b></td>
										</tr>
										<c:forEach var="type" items="${requestScope.list}">
											<tr>
												<td>${type.name}</td>
												<td>${type.monthValue}</td>
												<td>
													<form action="act" method="post">
                                                    <input type="hidden" name="command" value="delSubscriptionTypes" />  
                                                    <input type="hidden" name="type_id" value="${type.id}"/>
                                                    <input type="submit" value="Удалить тип подписки" class="Button"/>
                                                	</form> 
												</td>
												<td>
													<form action="editSubscriptionType" method="post">
                                                    <input type="hidden" name="command" value="prepareEditSubscriptionTypes" />  
                                                    <input type="hidden" name="type_id" value="${type.id}"/>
                                                    <input type="submit" value="Изменить тип подписки" class="Button"/>
                                                	</form> 
												</td>
											</tr>
										</c:forEach>
									</table>
									<table class="TableButtonLeft">
									<tr>
									<td>
									<form action="act" method="post">
                                                    <input type="hidden" name="command" value="referAddSubscriptionType" />  
                                                    <input type="submit" value="Добавить тип подписки" class="Button"/>
                                    </form> 
                                    </td>
                                    </tr>
                                    </table>
							</div>
							</c:if>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>