
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login Page</title>
	<link rel="Stylesheet" type="text/css" href="css/style.css ">
	<link rel="Stylesheet" type="text/css" href="css/style1.css ">
</head>
<body class="pageback">
	<center>
	<table class="temppage" height=20% width=100%>
		<tr>
			<th align=center class=linkw><h1><a href="template.jsp"><font color='white' face="arial">Cable Layout Assistance</font></a></h1><a href="template.jsp"><input type="submit" value="Home" name="home" class="s1"></a><a href="login.jsp"><input type="button" value="Login" class="s1"></a><a href="Registration.jsp"><input type="button" value="Register" class="s1"></a></th>
		</tr>
	</table>
	</center>
	<form action="Login1" method="POST">
	<center>
		<br><br><br><a><font color=white size="4"><b>User Login:</b></font></a><br><br><br>
		<table>
		<tr><td align=left><font color=white>Employee Id:</font></td><td align=left><input type="text" name="eid"></td></tr>
		<tr><td align=left><font color=white>Password:</font></td><td align=left><input type=password name="pwd" ></td></tr>
		<tr></tr>
		<tr></tr>
		<tr><td colspan=2><center><input type=submit value=Submit></center>
		<tr><td colspan=2 class=linkw><center><a href="Registration.jsp"><font color=white>Create an account???</font></a></center></td></tr>
	</table>
	</center>
	</form>
</body>
	