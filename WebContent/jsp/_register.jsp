<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript" src="js/validation.js"></script>
<div class="add_user">
	<form action="index" method="post" autocomplete="off">
		<input type="hidden" name="command" value="register" />
		<h1>Регистрация нового пользователя</h1>
		<b style="color: gray; font-size: 11px;"><i style="color: red">*</i>All
			fields must be set!</b>
		<table class="add_user_table">
                <tr>
                    <td style="vertical-align: top"><i style="color: red">*First Name:</i></td>
                    <td><input type="text" name="first_name" id="first_nameForm" onKeyUp="check('first_name')" maxlength="15"/>
                        <br/><b id="first_name" style="color: red; font-size: 10px;">
                            Only latin or only russian letters up to 15 symbols
                        </b>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top"><i style="color: red">*Last Name:</i></td>
                    <td><input type="text" name="last_name" id="last_nameForm" onKeyUp="check('last_name')"/>
                        <br/><b id="last_name" style="color: red; font-size: 10px;">
                            Only latin or only russian letters up to 15 symbols
                        </b>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top"><i style="color: red">*Email:</i></td>
                    <td><input type="text" name="email" id="emailForm" onKeyUp="check('email')"/>
                        <br/><b id="email" style="color: red; font-size: 10px;">
                            Examples: vasia.pupkin@gmail.com.
                        </b>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top"><i style="color: red">*Password:</i></td>
                    <td><input type="password" name="pass" id="passwordForm" onKeyUp="check('password')"/>
                        <br/><b id="password" style="color: red; font-size: 10px;">
                            Latin letters, digits, *, ! or ^ at least 6 symbols up to 15
                        </b>
                    </td>
                </tr>
            </table>
		<input style="margin: 0px 15%" class="RegButton" type="submit"
			name="submit" value="Register" />
	</form>
</div>