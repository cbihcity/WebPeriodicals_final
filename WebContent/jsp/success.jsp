<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Success</title>
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
							</div>
							<!-- end of menu -->
						</td>
						<td class="right_content">
							<div class="Index">
								<div style="margin: 0; font: medium sans-serif;">
                                    ${sucessmessage}
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
