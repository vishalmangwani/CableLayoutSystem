

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class RegistrationDetails
 */
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String eid= request.getParameter("uid");
    	String fstname=request.getParameter("fname");
		String midname=request.getParameter("mname");
		String lstname=request.getParameter("lname");
		String dob=request.getParameter("dob");
		String phno=request.getParameter("phoneno");
		String address=request.getParameter("addr");
		String ustate=request.getParameter("state");
		String sectr=request.getParameter("sector");
		String driver="com.ibm.db2.jcc.DB2Driver";
		String url="jdbc:db2://localhost:50000/opdb1";
		String username="AbhishekAbi";
		String password="microsoft";
		try
		{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, username, password);
				
				try 
				{
					if(fstname.equals(""))
					{
						
					}
					else
					{
						PreparedStatement ps=con.prepareStatement("update bhargav.empdetails set fname=? where eid=?");
						ps.setString(1, fstname);
						ps.setString(2, eid);
						int i=ps.executeUpdate();
					}
					if(midname.equals(""))
					{
						
					}
					else
					{
						PreparedStatement ps1=con.prepareStatement("update bhargav.empdetails set mname=? where eid=?");
						ps1.setString(1, midname);
						ps1.setString(2, eid);
						int i1=ps1.executeUpdate();	
					}
					if(lstname.equals(""))
					{
						
					}
					else
					{
						PreparedStatement ps8=con.prepareStatement("update bhargav.empdetails set lname=? where eid=?");
						ps8.setString(1, lstname);
						ps8.setString(2, eid);
						int i8=ps8.executeUpdate();	
					}
					if(dob.equals(""))
					{
						
					}
					else
					{
						PreparedStatement ps3=con.prepareStatement("update bhargav.empdetails set dob=? where eid=?");
						ps3.setString(1, dob);
						ps3.setString(2, eid);
						int i3=ps3.executeUpdate();	
					}
					if(phno.equals(""))
					{
						
					}
					else
					{
						PreparedStatement ps4=con.prepareStatement("update bhargav.empdetails set phoneno=? where eid=?");
						ps4.setString(1, phno);
						ps4.setString(2, eid);
						int i4=ps4.executeUpdate();	
					}
					if(address.equals(""))
					{
						
					}
					else
					{
						PreparedStatement ps5=con.prepareStatement("update bhargav.empdetails set address=?where eid=?");
						ps5.setString(1, address);
						ps5.setString(2, eid);
						int i5=ps5.executeUpdate();	
					}
					if(ustate.equals("Default"))
					{
						
					}
					else
					{
						PreparedStatement ps6=con.prepareStatement("update bhargav.empdetails set state=?where eid=?");
						ps6.setString(1, ustate);
						ps6.setString(2, eid);
						int i6=ps6.executeUpdate();	
					}
					if(sectr.equals(""))
					{
						
					}
					else
					{
						PreparedStatement ps7=con.prepareStatement("update bhargav.empdetails set sector=? where eid=?");
						ps7.setString(1, sectr);
						ps7.setString(2, eid);
						int i7=ps7.executeUpdate();	
					}
						getServletContext().getRequestDispatcher("/profile.jsp").include(request, response);
						response.getWriter().write("<html><body><center><font color=#151B54><strong>");
						response.getWriter().write("Updation successful.....");
						response.getWriter().write("</strong></font></center></body></html>");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
