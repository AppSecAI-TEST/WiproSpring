<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<span>${error}</span>
	<form action="./login" method="post">
		<table cellspacing="3" cellpadding="10">
		<tr>
			<td colspan="4"><h1>Sign Up</h1></td>
		</tr>
		<tr>
			<td rowspan="2">Name:</td>
			<td colspan="3"><input type="text" placeholder="First name" name="fName" size="40" maxlength="20"/></td>
		</tr>
		<tr>
			<td colspan="3"><input type="text" placeholder="Last name" name="lName" size="40" maxlength="20"/></td>
		</tr>
		
		<tr>
			<td>Password:</td>
			<td colspan="3"><input type="password" placeholder="Password" name="password" size="40" maxlength="8"/></td>
		</tr>

		<tr>
			<td colspan="4"><input type="submit" value="Submit" name="submit"/><input type="reset" value="Reset" name="clear"/></td>
		</tr>
		</table>
	</form>
	</section>
</body>
</html>