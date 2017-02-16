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
							<form action="Index" method="post">
								<input type="hidden" name="command" value="index" /> 
								<input type="submit" value="Main Page" class="Button" />
							</form>
						</td>
					</tr>
					<tr>
						<td>
							<form action="showMagazines" method="post">
								<input type="hidden" name="command" value="magazines" /> 
								<input type="submit" value="Show All Magazines" class="Button" />
							</form>
						</td>
					</tr>
				</c:when>
			</c:choose>
			<c:if test="${sessionScope.user.userType == 'ADMIN'}">
				<tr>
					<td style="font-size: 10px; text-align: center">-Панель Администратора-
					</td>
				</tr>
				<tr>
					<td>
						<form action="act" method="post">
							<input type="hidden" name="command" value="getListsCategory" />
							<input type="submit" name="submit" value="Add Magazine" class="Button"/>
						</form>
					</td>
				</tr>
				<tr>
					<td>
						<form action="usersList" method="post">
							<input type="hidden" name="command" value="users" />
							<input type="submit" name="submit" value="Users" class="Button"/>
						</form>
					</td>
				</tr>
				<tr>
					<td>
						<form action="subscription_types" method="post">
							<input type="hidden" name="command" value="subscriptionTypes" />
							<input type="submit" name="submit" value="Subscription types" class="Button"/>
						</form>
					</td>
				</tr>
			</c:if>
		</table>
	</div>
	<div class="GadgetSmoothBottom"></div>
</div>