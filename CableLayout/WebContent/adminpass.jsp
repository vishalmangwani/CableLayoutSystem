<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AdminPassword</title>
<script>
		function passwrd()
		{
			if(c1.npwd.value==c1.cnpwd.value)
			{
				return true;
			}
			else
			{
				window.alert("Passwords doesn't match...")
				return false;
			}
		}
	</script>
	<link rel="Stylesheet" type="text/css" href="css/style.css ">
</head>
<body bgcolor="#D1D0CE">
		<table class="temppage" width=100% height=20%>
			<tr>
				<th align="left"><h1><font color='white' face="cooper black">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Welcome To Cable Layout Administration</font></h1></th>
				<th align="right">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a href="frontend.jsp"><input type="button" value="SectorDetails" name="home" class="s1"></a><a href="adminpass.jsp"><input type="button" value="ChangePassword" name="cp" class="s1"></a><a href="delete.jsp"><input type="button" value="Delete a sector" name="crt" class="s1"></a><a href="deleteu.jsp"><input type="submit" value="Delete a user" class="s1"></a><a href="signout.jsp"><input type="button" value="Sign out" class="s1"></a></th>
			</tr>
		</table>
		<form name="c1" action="adminpass" method="POST" onSubmit="return passwrd()" onSubmit="return cnfrm()">
		<table>
		<tr><td align="left" colspan=2>&emsp;&emsp;&emsp;&emsp;&emsp;
		<font color="#151B54" face="cursive, sans-serif" size=3><strong>Change password?</strong></font></td></tr>
				<tr><td><strong>Secret key:</strong></td><td><input type=password name="cpwd"></td></tr>
				<tr><td><strong>New:</strong></td><td><input type=password name="npwd"></td></tr>
				<tr><td><strong>Re-enter new:</strong></td><td><input type=password name="cnpwd"></td></tr>
		<tr><td><input type="submit" value="Change password"></td></tr>
		</table>
	</form>
</body>
</html>