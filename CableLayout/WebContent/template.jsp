<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cable Layout Assistance</title>
<link rel="Stylesheet" type="text/css" href="css/style.css ">
</head>
<body class="pageback">
	<center>
	<table class="temppage" height=20% width=100%>
		<tr>
			<th align=center class=linkw><h1><a href="template.jsp"><font color='white' face="arial">Cable Layout Assistance</font></a></h1><a href="template.jsp"><input type="submit" value="Home" name="home" class="s1"></a><a href="login.jsp"><input type="button" value="Login" class="s1"></a><a href="Registration.jsp"><input type="button" value="Register" class="s1"></a></th>
		</tr>
	</table>
	</center>
	<table>
			<tr>
				<th></th><th></th><th></th>
			</tr>
			<tr>
				<td colspan=2>
					<dl>
						<ul>
							<li>
								<dt>
									<strong>
										<font color='white' face="arial">Introduction:</font>
									</strong>
								</dt>
								<dd><font color='white' face="arial">The purpose of this document is to define scope and requirements of a Cable
Layout System - LAYOUT for a leading Telephone Company that is expanding its
operations rapidly. To meet the growth demand, laying telephone cables becomes a
major challenge as it involves deciding optimal paths where cables can be laid from
a large number of choices of paths available. These paths are nothing but all
possible interconnections between “distribution boxes” installed at various locations
in an area. The decision is often made on the basis of cost of laying cable on a
path. The cost varies due to distance or depth at which a cable is placed.
The proposed system will provide a simple and effective way to select the optimum
cable laying paths for every new area.</font>
								</dd>
							</li>
						</ul>
					<ul type="bullet">
					<li>
						<dt><strong><font color='white' face="arial">Basic System Operations:</font></strong></dt>
						<dd><font color='white' face="arial">The following set of operations outline as to how the telephone company’s team will
determine the optimum path.<br>
1. User will be able to create a new area and upload the details of all possible
paths in that area along with cost details in CSV format.<br>
2. On successful upload, the list of uploaded path for the given area will be
displayed. At this stage, user can click on “Find Optimal Paths” to determine
the optimum path. This will be displayed in the form of list of pairs of distribution boxes that are directly connected with each other.<br>
3. User will also be able to edit and save the cost data to perform a what-if
analysis to determine corresponding change in paths.<br>
4. The data for each area analyzed will be saved and will remain available for
the future reference.<br><br><br>
The LAYOUT software will receive the input in a CSV whose format will be as
follows:<br><br>
<table align="center" border=1>
	<tr class="pageback">
		<th>Location1</th>
		<th>Location2</th>
		<th>Cost</th>
	</tr>
	<tr>
		<td>Sector 51 Block A</td>
		<td>Sector 51 Block B</td>
		<td align=center>10</td>
	</tr>
	<tr>
		<td>Sector 51 Block B</td>
		<td>Sector 51 Block C</td>
		<td align=center>37</td>
	</tr>
	<tr>
		<td>Sector 51 Block C</td>
		<td>Sector 51 Block D</td>
		<td align=center>96</td>
	</tr>
	<tr>
		<td>Sector 51 Block D</td>
		<td>Sector 51 Block A</td>
		<td align=center>15</td>
	</tr>
	<tr>
		<td>Sector 51 Block A</td>
		<td>Sector 51 Block C</td>
		<td align=center>75</td>
	</tr>
	<tr>
		<td>Sector 51 Block B</td>
		<td>Sector 51 Block D</td>
		<td align=center>51</td>
	</tr>	
</table>
		</font>
		</dd>
		</li>
		</ul>
		</dl>
		</td>
		</tr>
		</table>
</body>
</html>