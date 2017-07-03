function formValidation()
{
	var ufname=document.registration.fname;	
	var ulname=document.registration.lname;
	var uphno=document.registration.phoneno;
	var uaddress=document.registration.addr;
	var ustate=document.registration.state;
	var usector=document.registration.sector;
	var ueid=document.registration.eid;
	var upassword=document.registration.pwd;
	var ucpassword=document.registration.cpwd;
	if(fname_validation(ufname))
	{
		if(lname_validation(ulname))
		{
			if(contact_validation(uphno))
			{
				if(address_validation(uaddress))
				{
					if(state_validation(ustate))
					{
						if(sector_validation(usector))
						{
							if(eid_validation(ueid))
							{
								if(password_validation(upassword,7,12))
								{
									if(cpassword_validation(ucpassword,7,12))
									{
										return true;										
									}
								}
							}
						}
					}
				}
			}
		}
	}
	return false;
}
function fname_validation(ufname)
{
	var letter=/^[A-Za-z]+$/;
	if(ufname.value.match(letter))
	{
		return true;
	}
	else
	{
		alert("First Name Must be Alphabetic character only");
		ufname.focus();
		return false;
	}
}
function lname_validation(ulname)
{
	var letter=/^[A-Za-z]+$/;
	if(ulname.value.match(letter))
	{
		return true;
	}
	else
	{
		alert("Last Name Must be Alphabetic character only");
		ulname.focus();
		return false;
	}
}
function contact_validation(uphno)
{
	var contact_len=uphno.value.length;
	if(contact_len==10)
	{
		var number=/^[0-9]+$/;
		if(uphno.value.match(number))
		{
			return true;
		}
		else
		{
			alert("Contact must be Numeric Only");
			uphno.focus();
			return false;
		}
	
	}
	else
	{
		alert("Contact must be 10 digit only");
		uphno.focus();
		return false;
	}
}
function address_validation(uaddress)
{
	var letter=/^[A-Za-z0-9_\-\.\,]+$/;	
	if(uaddress.value.match(letter))
	{
		return true;
	}
	else
	{
		alert("Please enter the valid address");
		uaddress.focus();
		return false;
	}
}
function state_validation(ustate)
{
	if(ustate.value=="Default")
	{
		alert("Please Select the state from the list");
		ustate.focus();
		return false;
	}
	else
	{
		return true;
	}
}
function sector_validation(usector)
{
	var number=/^[0-9]+$/;
	if(usector.value.match(number))
	{
		return true;
	}
	else
	{
		alert("sector must be Numeric Only");
		usector.focus();
		return false;
	}
}
function eid_validation(ueid)
{
	var letter=/^([A-Za-z0-9])+$/;	
	if(ueid.value.match(letter))
	{
		return true;	
	}
	else
	{
		alert("Please enter the valid employeeid");
		ueid.focus();
		return false;
	}
}
function password_validation(upassword,mx,my)
{
	var password_len=upassword.value.length;
	if(password_len==0||password_len<mx||password_len>my)
	{
		alert("Password length must be between "+mx+" "+"to"+" "+my);
		upassword.focus();
		return false;
	}
	else
	{
		return true;
	}

}
function cpassword_validation(ucpassword,mx,my)
{
	if(upassword!=ucpassword)
	{
		alert("Your Passwords do not match.\n"+"please try again...");
		ucpassword.focus();
		return false;
	}
	else
	{
		return true;
	}
}
	