<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" language="javascript">javascript.window.history.forward(1);</script>
<title>User Home Page</title>
<script>
	function csvFormat()
	{
		var sentence=f1.t1.value;
		var words=sentence.split(",");
		if((words.length)%3!=0)
		{
			window.alert("provide the valid inputs");
			return false;
		}
	}
	function emp()
	{
		var number=/^[0-9]+$/;
		if(opt.txt.value=="")
		{
			window.alert("provide the Sector number");
			return false;
		}
		if(opt.txt.value.match(number))
		{
			return true;
		}
		else
		{
			alert("Sector must be Numeric Only");
			opt.txt.focus();
			return false;
		}
	}

</script>
<link rel="Stylesheet" type="text/css" href="css/style.css ">
</head>
<body bgcolor="#D1D0CE" onload=f1.sec.focus()>
		<table class="temppage" width=100% height=20%>
			<tr>
				<th align="left"><h1><font color='white' face="cooper black">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Welcome To Cable Layout Assistance</font></h1></th>
				<th align="right">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a href="profile.jsp"><input type="button" value="Profile" name="prof" class="s1"></a><a href="create.jsp"><input type="button" value="Create a sector" name="crt" class="s1"></a><a href="userfrontend.jsp"><input type="submit" value="Establishing new connection" class="s1"></a><a href="disconnection.jsp"><input type="button" value="Disconnection" class="s1"></a><a href="signout.jsp"><input type="button" value="Signout" class="s1"></a></th>
			</tr>
		</table>
		<div style="float:left;">
		<form name="f1" action="userfrontend" method="POST" onsubmit="return csvFormat()">
		<table>
			<tr>
				<th><h1><font color=#151B54><strong>Converting inputs from text to CSV format:</strong></font></h1></th>
			</tr>
		</table>
		<table>
			<tr>
				<td><font color=#151B54><strong>Enter the sector:</strong></font><input type="text" name=sec></td>
			</tr>
			<tr>
				<td><textarea rows=16 cols=70 style='border:2px solid #dcdcdc; background-color:#F5F5F5;' name="t1" ></textarea><br><font color=red face="cursive, sans-serif" size=2><strong>*At most only 9 distribution boxes can be established in a single sector.</strong></font></td>
				<td><input type="submit" value="create csv format" ></td>
			</tr>
		</table>
		</form>
		</div>
		<div style="float:left;">
			<br><br><br><br>
			<form name="opt" action="optimal" method="POST" onSubmit="return emp()">
			<font color=#151B54 face="cursive, sans-serif" size=2><strong>Sector:<input type=text name=txt><input type=submit value="Find Optimal path"></strong></font><br><br><br>
			</form>
			<form name="det" action="details" method="POST" >
			<font color=#151B54 face="cursive, sans-serif" size=2><strong>Enter the Sector number for details:<input type=text name=se><input type=submit value="Details"></strong></font>
			</form>
			<form name="graph" action="graphics" method="POST" >
				<br><br><font color=#151B54 face="cursive, sans-serif" size=2><strong>Enter the Sector number for graphical representation of the connections:<input type=text name=s><input type=submit value="view"></strong></font>
			</form>
		</div>
</body>
</html>