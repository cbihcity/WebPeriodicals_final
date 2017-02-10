<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:choose>
<c:when test="${not empty sessionScope.user}">
 <table class="menu">
			<tr>
				<td>
					<form action="action" method="post">
						<input type="hidden" name="command" value="showAllMag" /> 
						 <input	type="submit" value="Show All Magazines"/>
					</form>
				</td>
			</tr>
 </table>
 </c:when>
  </c:choose>
 <c:if test="${sessionScope.user.userType == 'ADMIN'}">
 			<tr>
				<td>
					<form action="addMag" method="post">
                            <input type="submit" name="submit" value="Add Magazine"/>
                        </form>
				</td>
			</tr>
 </c:if>
