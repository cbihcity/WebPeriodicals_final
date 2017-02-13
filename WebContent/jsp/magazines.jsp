<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Magazines</title>
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
						<td class="right_content"><%@include
								file="/jsp/_wrappertop.jsp"%> <%-- This is main part --%>
							<div class="Index">
								<div class="IndexTitle"></div>
								<div class="IndexMessage">
									<table class="MagOrdersTable">
										<tr>
											<td><b>id</b></td>
											<td><b>Name</b></td>
											<td><b>Category</b></td>
											<td><b>Price</b></td>
											<td style="border-style: none;"></td>
											<td style="border-style: none;"></td>
										</tr>
										<c:forEach var="mag" items="${requestScope.list}">
											<tr>
												<td>${mag.id}</td>
												<td>${mag.name}</td>
												<td>${mag.type}</td>
												<td>${mag.price}</td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</div> <%@include file="/jsp/_wrapperbottom.jsp"%>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>