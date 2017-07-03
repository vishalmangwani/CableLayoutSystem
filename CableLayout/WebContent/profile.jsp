<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="profileValidation.js"></script>
<title>User Profile</title>
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
		PreparedStatement ps1=con.prepareStatement("select * from bhargav.user_id_pass where eid=?");
		ps1.setString(1,abc);
		ResultSet rs1=ps1.executeQuery();
		
%>
	<form name="updation" >
	<table>
<%
		if(rs.next())
		{
%>
		<tr><td align="left"><font color="#151B54" face="cursive, sans-serif" size=2><strong>First Name:</strong></font></td><td align="left"><font color="#151B54" face="cursive, sans-serif" size=2><strong><%=rs.getString(2) %></strong></font></td></tr>
		<tr></tr>
		<tr><td align="left"><font color="#151B54" face="cursive, sans-serif" size=2><strong>Middle Name:</strong></font></td><td align="left"><font color="#151B54" face="cursive, sans-serif" size=2><strong><%=rs.getString(3) %></strong></font></td></tr>
		<tr></tr>
		<tr><td align="left"><font color="#151B54" face="cursive, sans-serif" size=2><strong>Last Name:</strong></font></td><td align="left"><font color="#151B54" face="cursive, sans-serif" size=2><strong><%=rs.getString(4) %></strong></font></td></tr>
		<tr></tr>
		<tr><td align="left"><font color="#151B54" face="cursive, sans-serif" size=2><strong>Gender:</strong></font></td><td align="left"><font color="#151B54" face="cursive, sans-serif" size=2><strong><%=rs.getString(5) %></strong></font></td></tr>
		<tr><td align="left"><font color="#151B54" face="cursive, sans-serif" size=2><strong>Date Of Birth: </strong></font></td><td align="left"><font color="#151B54" face="cursive, sans-serif" size=2><strong><%=rs.getString(8) %></strong></font></td></tr>
		<tr><td align="left"><font color="#151B54" face="cursive, sans-serif" size=2><strong>PhoneNo:</strong></font> </td><td align="left"><font color="#151B54" face="cursive, sans-serif" size=2><strong><%=rs.getString(7) %></strong></font></td></tr>
		<tr><td align="left"><font color="#151B54" face="cursive, sans-serif" size=2><strong>Address For Communication:</strong></font></td><td align="left"><font color="#151B54" face="cursive, sans-serif" size=2><strong><%=rs.getString(9) %></strong></font></td></tr>
		<tr></tr>
		<tr><td align="left"><font color="#151B54" face="cursive, sans-serif" size=2><strong>State:</strong></font></td><td align="left"><font color="#151B54" face="cursive, sans-serif" size=2><strong><%=rs.getString(10) %></strong></font></td></tr>
		<tr><td align="left"><font color="#151B54" face="cursive, sans-serif" size=2><strong>Employee id: </strong></font></td><td align="left"><font color="#151B54" face="cursive, sans-serif" size=2><strong><%=rs.getString(1) %></strong></font></td></tr>
<%
			if(rs1.next())
		 	{
%>
		<tr><td align="left"><font color="#151B54" face="cursive, sans-serif" size=2><strong>Sector:</strong></font></td><td align="left"><font color="#151B54" face="cursive, sans-serif" size=2><strong><%=rs.getString(6) %></strong></font></td></tr>
<%
			}
%>
<%
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
%>
		<tr>
			<td class=linkw><a href="update.jsp">Update Profile??</a></td>
		</tr>
	</table>
	</form>	
</body>
</html>