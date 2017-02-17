<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Users Subscriptions</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="wrapper">
		<div id="content">
			<table class="main_table" >
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
							<h1>Список подписок:</h1>
									<table class="Table">
										<tr>
											<td><b>First Name</b></td>
											<td><b>Magazine Name</b></td>
											<td><b>Category</b></td>
											<td><b>Type Subscription</b></td>
											<td><b>Start Date</b></td>
											<td><b>End Date</b></td>
											<td><b>Price</b></td>
										</tr>
										<c:forEach var="sub" items="${requestScope.list}">
										<tr>
											<td>${sub.user.firstName}</td>
											<td>${sub.magazine.name}</td>
											<td>${sub.magazine.type}</td>
											<td>${sub.type.name}</td>
											<td>${sub.startDate}</td>
											<td>${sub.endDate}</td>
											<td>${sub.price}</td>
											<c:if test="${sessionScope.user.userType == 'ADMIN'}">
												<td>
													<form action="act" method="post">
														<input type="hidden" name="command" value="delSub" /> 
														<input type="hidden" name="sub_id" value="${sub.id}" /> 
														<input type="submit" value="Удалить подписку" class="Button" />
													</form>
												</td>
											</c:if>
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