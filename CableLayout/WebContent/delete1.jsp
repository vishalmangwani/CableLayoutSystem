<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
	function cnfrm() 
	{
    	if(confirm("Proceed to delete??"))
    	{
    		return true;
    	}
    	else
    	{
			return false;    
    	}
	}
</script>
<title>Home Page</title>
<link rel="Stylesheet" type="text/css" href="css/style.css ">
</head>
<body bgcolor="#D1D0CE">
		<table class="temppage" width=100% height=20%>
			<tr>
				<th align="left"><h1><font color='white' face="cooper black">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Welcome To Cable Layout Administration</font></h1></th>
				<th align="right">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a href="frontend.jsp"><input type="button" value="SectorDetails" name="home" class="s1"></a><a href="adminpass.jsp"><input type="button" value="ChangePassword" name="cp" class="s1"></a><a href="delete.jsp"><input type="button" value="Delete a sector" name="crt" class="s1"></a><a href="deleteu.jsp"><input type="submit" value="Delete a user" class="s1"></a><a href="signout.jsp"><input type="button" value="Sign out" class="s1"></a></th>
			</tr>
		</table>
	<div style="float:left;">
	<form name="f1">
			<table>
			<tr>
				<th><h1><font color=#151B54 face="cursive, sans-serif" size=5><strong>Sectors and Number of connections available are:</strong></font></h1></th>
			</tr>
		</table>
<%
	try
	{
		String sec2= (String)session.getAttribute("sect");
    	String driver="com.ibm.db2.jcc.DB2Driver";
		String url="jdbc:db2://localhost:50000/opdb1";
		String username="AbhishekAbi";
		String password="microsoft";
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url, username, password);
		PreparedStatement ps1=con.prepareStatement("select * from bhargav.sector_conn");
		ResultSet rs1=ps1.executeQuery();
		PreparedStatement ps2=con.prepareStatement("select * from bhargav.connections where sector=?");
		ps2.setString(1, sec2);
		ResultSet rs2=ps2.executeQuery();
%>
<% 
		if(rs1.next())
		{
%>
		<table border="2">
		<tr>
		<th colspan="2"><h3><strong>Sector</strong></h3></th>
		<th colspan="2"><h3><strong>No of connections</strong></h3></th>
		</tr>
		<tr>
					<td colspan="2"><%=rs1.getString(1) %></td>
					<td colspan="2"><%=rs1.getString(2) %></td>
		</tr>
<%	
		while(rs1.next())
		{
%>
		
				<tr>
					<td colspan="2"><%=rs1.getString(1) %></td>
					<td colspan="2"><%=rs1.getString(2) %></td>
				</tr>
<%
		}
		}
%>
			</table>	
		</form>
		</div>
	<div style="float:left;">
		<% 
		if(rs2.next())
		{
%>
		<table border="2">
		<tr>
		<th colspan="2"><h3><strong>Sector</strong></h3></th>
		<th colspan="2"><h3><strong>Location1</strong></h3></th>
		<th colspan="2"><h3><strong>Location2</strong></h3></th>
		<th colspan="2"><h3><strong>Cost</strong></h3></th>
		</tr>
		<tr>
					<td colspan="2"><%=rs2.getString(1) %></td>
					<td colspan="2"><%=rs2.getString(2) %></td>
					<td colspan="2"><%=rs2.getString(3) %></td>
					<td colspan="2"><%=rs2.getString(4) %></td>
		</tr>
<%	
		while(rs2.next())
		{
%>
		
				<tr>
					<td colspan="2"><%=rs2.getString(1) %></td>
					<td colspan="2"><%=rs2.getString(2) %></td>
					<td colspan="2"><%=rs2.getString(3) %></td>
					<td colspan="2"><%=rs2.getString(4) %></td>
				</tr>
<%
		}
		}
		else
		{
%>
		<tr><td><font color=#151B54 face="cursive, sans-serif"><strong>No connections are found...</strong></font></td></tr>
<%
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
%>
			</table>	
		<form name="c1" action="delete1" method="POST">
		<table>
			<tr>
				<th><font color=#151B54 face="cursive, sans-serif" size=2><strong>Enter the sector number, details of which you required:</strong></font><input type="text" name=sec></th>
			</tr>
			<tr>
				<td><input type="submit" value="details" ></td>
			</tr>
		</table>
		</form>
		<form action="delete" method=post name=f2 onSubmit="return cnfrm()">
		<table>
			<tr>
				<th><font color=#151B54 face="cursive, sans-serif" size=2><strong>Enter the sector number of which you wanted to disconnect:</strong></font></th>
			</tr>
			<tr>
				<td>Sector:<input type="text" name=se></td>
			</tr>
			<tr>
				<td><input type="submit" value="delete the sector" ></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>