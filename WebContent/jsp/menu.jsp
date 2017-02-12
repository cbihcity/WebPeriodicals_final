<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="Gadget">
	<div class="GadgetSmoothTop"></div>
	<div class="GadgetContent">
	<table class="menu">
		<c:choose>
			<c:when test="${not empty sessionScope.user}">
					<tr>
						<td>
							<form action="index" method="post">
								<input type="hidden" name="command" value="magazines" /> <input
									type="submit" value="Show All Magazines" />
							</form>
						</td>
					</tr>
			</c:when>
		</c:choose>
		<c:if test="${sessionScope.user.userType == 'ADMIN'}">
			<tr>
				<td>
					<form action="addMag" method="post">
						<input type="submit" name="submit" value="Add Magazine" />
					</form>
				</td>
			</tr>
		</c:if>
		</table>
	</div>
	<div class="GadgetSmoothBottom"></div>
</div>