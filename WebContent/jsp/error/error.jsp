<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>Error page</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<link type="text/css" rel="stylesheet" href="css/gadgets.css" />
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
							</div> <!-- end of auth -->
							<div class="menu_frame">
								<%@include file="/jsp/menu.jsp"%>
							</div> <!-- end of menu -->
						</td>
						<td class="right_content">
							<table style="vertical-align: middle; font-size: 24px">
								<tr>
									<td><img src="images/error_small.png" /></td>
								</tr>
							</table>
							<div style="margin: 0; font: medium sans-serif;">
								<p>
									<b>${errormessage}</b>
								</p>
							</div> 
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
