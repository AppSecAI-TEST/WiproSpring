<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${title}</title>

<style>
section
{
	background: rgb(230, 240, 250);
	border:1px solid black;
	position:absolute;
 	width:560px;
	top:60px;
	left:210px;
	margin:0px;
	padding:10px;
}
table{
	font-family:century;
	border: 2px solid LightBlue;
	background: LightBlue;
 	width:100%;
}

td,th{
	background: LightCyan;
}
</style>
</head>
<body>
<header><h1>${headerMessage}</h1></header>
<section>
<form:errors path="user.*"/>

	<form action="/MyApp/registrationComplete" method="post">
		<table cellspacing="3" cellpadding="10">
		<tr>
			<td colspan="4"><h1>Sign Up</h1></td>
		</tr>
		<tr>
			<td rowspan="2">Name:</td>
			<td colspan="3"><input type="text" placeholder="First name" name="fName" size="40" maxlength="20"/></td>
		</tr>
		
		<tr>			
			<td colspan="3"><input type="text" placeholder="Enter Last name" name="lName" size="40" maxlength="20"/></td>
		</tr>

		<tr>
			<td rowspan="2">Email:</td>
			<td colspan="3"><input type="text" placeholder="Email" size="40" name="email" maxlength="30"/></td>
		</tr>
		<tr>
			<td colspan="3"><input type="text" placeholder="Re-enter Email" name="confirm_email" size="40" maxlength="30"/></td>
		</tr>
		
		<tr>
			<td rowspan="2">Password:</td>
			<td colspan="3"><input type="password" placeholder="Password" name="password" size="40" maxlength="8"/></td>
		</tr>
		<tr>
			<td colspan="3"><input type="password" placeholder="Re-enter password" name="confirm_pwd" size="40" maxlength="8"/></td>
		</tr>

		<tr>
			<td>Birthday</td>
			<td colspan="3"><input type="text" placeholder="DOB YYYY/MM/DD" name="dob"/>
			</td>
		</tr>
		
		<tr>
			<td>Gender:</td>
			<td><input type="radio" name="gender" value="male" checked="checked"/>Male</td>
			<td colspan="2"><input type="radio" name="gender" value="female"/>Female</td>
		</tr>

		<tr>
			<td rowspan="2">Address</td>
			<td colspan="3"><input type="text" name="address.city" placeholder="Enter city"/></td>
		</tr>
		<tr>
			<td colspan="3"><input type="text" name="address.pin" placeholder="Enter pin"/></td>
		</tr>
			
		<tr>
			<td>Select your photo:</td>
			<td colspan="3"><input type="file" name="photo"/></td>
		</tr>

		<tr>
			<td><input type="submit" value="Submit" name="submit"/></td>
			<td colspan="3"><input type="reset" value="Reset" name="clear"/></td>
		</tr>
		</table>
	</form>
	</section>
</body>
</html>