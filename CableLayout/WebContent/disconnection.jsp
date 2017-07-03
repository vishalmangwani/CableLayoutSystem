<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Disconnecting</title>
<script>
	function cnfrm() 
	{
    	if(confirm("Disconnect???"))
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
		if(rs.next())
		{
		PreparedStatement ps1=con.prepareStatement("select * from bhargav.connections where sector=?");
		ps1.setString(1,rs.getString(6));
		ResultSet rs1=ps1.executeQuery();
		
%>
	<div style="float:left;">
	<form name="f1" action="disconnection" method="POST">
		<table border="2">
		<tr>
<% 
		if(rs1.next())
		{
%>
		<th colspan="2"><h3><strong>Sector</strong></h3></th>
		<th colspan="2"><h3><strong>Location1</strong></h3></th>
		<th colspan="2"><h3><strong>Location2</strong></h3></th>
		<th colspan="2"><h3><strong>Cost</strong></h3></th>
		</tr>
		<tr>
					<td colspan="2"><%=rs1.getString(1) %></td>
					<td colspan="2"><%=rs1.getString(2) %></td>
					<td colspan="2"><%=rs1.getString(3) %></td>
					<td colspan="2"><%=rs1.getString(4) %></td>
		</tr>
<%	
		int i=0;
		while(rs1.next())
		{
%>
		
				<tr>
					<td colspan="2"><%=rs1.getString(1) %></td>
					<td colspan="2"><%=rs1.getString(2) %></td>
					<td colspan="2"><%=rs1.getString(3) %></td>
					<td colspan="2"><%=rs1.getString(4) %></td>
				</tr>
<%
		}
		}
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
%>
			</table>
		<table>
			<tr>
				<th><font color=#151B54 face="cursive, sans-serif" size=2><strong>Enter the sector number, details of which you required:</strong></font><input type="text" name=sec></th>
			</tr>
			<tr>
				<td><input type="submit" value="details" ></td>
			</tr>
		</table>
	</form>
	</div>
	<div style="float:left;">
	<form action=disconnection1 method=post name=f2 onSubmit="return cnfrm()">
		<table>
			<tr>
				<th><font color=#151B54 face="cursive, sans-serif" size=2><strong><br><br>Enter the sector and connection details of which you wanted to disconnect:</strong></font></th>
			</tr>
			<tr>
				<td>Sector:<input type="text" name=se>Location1:<input type="text" name=loc1>Location2:<input type="text" name=loc2></td>
			</tr>
			<tr>
				<td><input type="submit" value="disconnect" ></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>