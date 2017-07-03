<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="profileValidation.js"></script>
<title>User Profile</title>
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
		function cnfrm() 
		{
	    	if(confirm("Proceed to Update??"))
	    	{
	    		return true;
	    	}
	    	else
	    	{
				return false;    
	    	}
		}
	</script>
	<link rel="Stylesheet" type="text/css" href="css/style.css ">
</head>
<body bgcolor="#D1D0CE">
		<table class="temppage" width=100% height=20%>
			<tr>
				<th align="left"><h1><font color='white' face="cooper black">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Welcome To Cable Layout Assistance</font></h1></th>
				<th align="right">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a href="profile.jsp"><input type="button" value="Profile" name="prof" class="s1"></a><a href="create.jsp"><input type="button" value="Create a sector" name="crt" class="s1"></a><a href="userfrontend.jsp"><input type="submit" value="Establishing new connection" class="s1"></a><a href="disconnection.jsp"><input type="button" value="Disconnection" class="s1"></a><a href="signout.jsp"><input type="button" value="Signout" class="s1"></a></th>
			</tr>
		</table>
<%
	try
	{
		String abc= (String)session.getAttribute("userid");
    	String driver="com.ibm.db2.jcc.DB2Driver";
		String url="jdbc:db2://localhost:50000/opdb1";
		String username="AbhishekAbi";
		String password="microsoft";
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url, username, password);
		PreparedStatement ps=con.prepareStatement("select * from bhargav.empdetails where eid=?");
		ps.setString(1,abc);
		ResultSet rs=ps.executeQuery();
%>
	<form name="updation" action="update" method="POST" onSubmit="return cnfrm()">
		<table>
<%
		if(rs.next())
		{
%>
		<tr><td align="left"><font color="#151B54" face="cursive, sans-serif" size=2><strong>First Name:</strong></font></td><td align="left"><input type=text name="fname"></td></tr>
		<tr></tr>
		<tr><td align="left"><font color="#151B54" face="cursive, sans-serif" size=2><strong>Middle Name:</strong></font></td><td align="left"><input type=text name="mname"></td></tr>
		<tr></tr>
		<tr><td align="left"><font color="#151B54" face="cursive, sans-serif" size=2><strong>Last Name:</strong></font></td><td align="left"><input type=text name="lname" ></td></tr>
		<tr></tr>
		<tr><td align="left"><font color="#151B54" face="cursive, sans-serif" size=2><strong>Date Of Birth: </strong></font></td><td align="left"><input type=date name="dob"></td></tr>
		<tr><td align="left"><font color="#151B54" face="cursive, sans-serif" size=2><strong>PhoneNo:</strong></font> </td><td align="left"><input type=text name="phoneno"></td></tr>
		<tr><td align="left"><font color="#151B54" face="cursive, sans-serif" size=2><strong>Address For Communication:</strong></font></td><td align="left"><textarea rows="6" cols="16" name="addr" ></textarea></td></tr>
		<tr></tr>
		<tr><td align="left"><font color="#151B54" face="cursive, sans-serif" size=2><strong>State:</strong></font></td><td align="left"><select name="state"><option value="Default">select a state</option><optgroup label="INDIA"><option value="Andhra Pradesh">Andhra Pradesh</option><option value="Arunachal Pradesh">Arunachal Pradesh</option><option value="Assam">Assam</option><option value="Bihar">Bihar</option><option value="Chhattisgarh">Chhattisgarh</option><option value="Goa">Goa</option><option value="Gujarat">Gujarat</option><option value="Haryana">Haryana</option><option value="Himachal Pradesh">Himachal Pradesh</option><option value="Jammu and Kashmir">Jammu and Kashmir</option><option value="Jharkhand">Jharkhand</option><option value="Karnataka">Karnataka</option><option value="Kerala">Kerala</option><option value="Madhya Pradesh">Madhya Pradesh</option><option value="Maharashtra">Maharashtra</option><option value="Manipur">Manipur</option><option value="Meghalaya">Meghalaya</option><option value="Mizoram">Mizoram</option><option value="Nagaland">Nagaland</option><option value="Odisha (Orissa)">Orissa</option><option value="Punjab">Punjab</option><option value="Rajasthan">Rajasthan</option><option value="Sikkim">Sikkim</option><option value="Tamil Nadu">Tamil Nadu</option><option value="Telangana">Telangana</option><option value="Tripura">Tripura</option><option value="Uttar Pradesh">Uttar Pradesh</option><option value="Uttarakhand">Uttarakhand</option><option value="West Bengal">West Bengal</option></optgroup></select></td></tr>
<%
		}
%>
		<tr><td align="left"><font color="#151B54" face="cursive, sans-serif" size=2><strong>Sector:</strong></font></td><td align="left"><input type=text name="sector"></td></tr>
		<tr>
			<td align=right><input type="reset" value="Reset"></td>
			<td><input type="submit" value="Update"></td>
		</tr>
		</table>
		<input type=hidden name="uid" value=<%=abc %> >
	</form>	
		<form name="c1" action="changepass" method="POST" onSubmit="return passwrd()" onSubmit="return cnfrm()">
		<table>
		<tr><td align="left" colspan=2>&emsp;&emsp;&emsp;&emsp;&emsp;
		<font color="#151B54" face="cursive, sans-serif" size=3><strong>Change password?</strong></font></td></tr>
				<tr><td><strong>Current password:</strong></td><td><input type=password name="cpwd"></td></tr>
				<tr><td><strong>New:</strong></td><td><input type=password name="npwd"></td></tr>
				<tr><td><strong>Re-enter new:</strong></td><td><input type=password name="cnpwd"></td></tr>
		<tr><td><input type="submit" value="Change password"></td></tr>
		</table>
			<input type=hidden name="uid" value=<%=abc %> >
	</form>
<%		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
%>		
</body>
</html>