
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="formValidation.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Signup here...</title>
	<link rel="Stylesheet" type="text/css" href="css/style.css ">
	<link rel="Stylesheet" type="text/css" href="css/style1.css ">
</head>
<body class="pageback">
	<center>
	<table class="temppage" height=20% width=100%>
		<tr>
			<th align=center class=linkw><h1><a href="template.jsp" name="main"><font color='white' face="arial">Cable Layout Assistance</font></a></h1><a href="template.jsp"><input type="submit" value="Home" name="home" class="s1"></a><a href="login.jsp"><input type="button" value="Login" class="s1"></a><a href="Registration.jsp"><input type="button" value="Register" class="s1"></a></th>
		</tr>
	</table>
	</center>
	<form action="RegistrationDetails" method="POST" onSubmit="return  formValidation()" name="registration">
	<center>
		<br><br><br><a><font color=white size="4"><b>Sign Up here...!!</b></font></a><br><br><br>
		<table>
		<tr><td align="left"><font color=white>*First Name:</font></td><td align="left"><input type=text name="fname"></td></tr>
		<tr></tr>
		<tr><td align="left"><font color=white>Middle Name:</font></td><td align="left"><input type=text name="mname"></td></tr>
		<tr></tr>
		<tr><td align="left"><font color=white>*Last Name:</font></td><td align="left"><input type=text name="lname" ></td></tr>
		<tr></tr>
		<tr><td align="left"><font color=white>*Gender:</font></td><td align="left"><input type=radio name=mle value="male" checked><font color=white>Male </font>&nbsp;&nbsp;<input type=radio name=mle value="female"><font color=white>Female</font></td></tr>
		<tr><td align="left"><font color=white>*Date Of Birth: </font></td><td align="left"><input type=date name="dob" ></td></tr>
		<tr><td align="left"><font color=white>*PhoneNo:</font> </td><td align="left"><input type=text name="phoneno" ></td></tr>
		<tr><td align="left"><font color=white>*Address For Communication:</font></td><td align="left"><textarea rows="6" cols="16" name="addr" style="background-color:#E5E4E2;border-radius:5px;padding:4px;"></textarea></td></tr>
		<tr></tr>
		<tr><td align="left"><font color=white>*State:</font></td><td align="left"><select name="state"><option value="Default">Select a State</option><optgroup label="INDIA"><option value="Andhra Pradesh">Andhra Pradesh</option><option value="Arunachal Pradesh">Arunachal Pradesh</option><option value="Assam">Assam</option><option value="Bihar">Bihar</option><option value="Chhattisgarh">Chhattisgarh</option><option value="Goa">Goa</option><option value="Gujarat">Gujarat</option><option value="Haryana">Haryana</option><option value="Himachal Pradesh">Himachal Pradesh</option><option value="Jammu and Kashmir">Jammu and Kashmir</option><option value="Jharkhand">Jharkhand</option><option value="Karnataka">Karnataka</option><option value="Kerala">Kerala</option><option value="Madhya Pradesh">Madhya Pradesh</option><option value="Maharashtra">Maharashtra</option><option value="Manipur">Manipur</option><option value="Meghalaya">Meghalaya</option><option value="Mizoram">Mizoram</option><option value="Nagaland">Nagaland</option><option value="Odisha (Orissa)">Orissa</option><option value="Punjab">Punjab</option><option value="Rajasthan">Rajasthan</option><option value="Sikkim">Sikkim</option><option value="Tamil Nadu">Tamil Nadu</option><option value="Telangana">Telangana</option><option value="Tripura">Tripura</option><option value="Uttar Pradesh">Uttar Pradesh</option><option value="Uttarakhand">Uttarakhand</option><option value="West Bengal">West Bengal</option></optgroup></select></td></tr>
		<tr><td align="left"><font color=white>*Sector:</font></td><td align="left"><input type=text name="sector" ></td></tr>
		<tr><td align="left"><font color=white>*Employee id: </font></td><td align="left"><input type=text name="eid" ></td></tr>
		<tr><td align="left"><font color=white>*Password:</font></td><td align="left"><input type=password name="pwd" ></td></tr>
		<tr><td align="left"><font color=white>*ReEnter Password:</font></td><td align="left"><input type=password name="cpwd"></td></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr><td colspan=2><center><input type=submit value="Submit"></center>
		<tr><td colspan=2><center><input type=reset value="Clear"></center>
	</table>
	</center>
	</form>
</body>
	