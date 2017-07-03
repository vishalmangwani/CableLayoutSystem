

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class RegistrationDetails
 */
public class RegistrationDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationDetails() {
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
		String empid=request.getParameter("eid");
		String password1=request.getParameter("pwd");
		String cpassword=request.getParameter("cpwd");
		String fstname=request.getParameter("fname");
		String midname=request.getParameter("mname");
		String lstname=request.getParameter("lname");
		String dob=request.getParameter("dob");
		String gender=request.getParameter("mle");
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
			PreparedStatement ps1=con.prepareStatement("select * from bhargav.empdetails where eid=?");
			ps1.setString(1, empid);
			ResultSet rs1=ps1.executeQuery();		
			PreparedStatement ps2=con.prepareStatement("select * from bhargav.sector_no_db where sector=?");
			ps2.setString(1, sectr);
			ResultSet rs2=ps2.executeQuery();		
			if(rs1.next())
			{
				getServletContext().getRequestDispatcher("/Registration.jsp").include(request, response);
				response.getWriter().write("<html><body><center><font color=red><strong>");
				response.getWriter().write("Requested Id already exist, Please Renter the details..");
				response.getWriter().write("</strong></font></center></body></html>");
			}
			if(rs2.next())
			{
			}
			else
			{
				getServletContext().getRequestDispatcher("/Registration.jsp").include(request, response);
				response.getWriter().write("<html><body><center><font color=red><strong>");
				response.getWriter().write("Requested sector is not available..");
				response.getWriter().write("</strong></font></center></body></html>");
			
			}
			if(empid.equals("")||password1.equals("")||cpassword.equals("")||fstname.equals("")||lstname.equals("")||gender.equals("")||dob.equals("")||address.equals("")||ustate.equals("")||sectr.equals("")||phno.equals(""))
			{
				getServletContext().getRequestDispatcher("/Registration.jsp").include(request, response);
				response.getWriter().write("<html><body><center><font color=red><strong>");
				response.getWriter().write("Required fields cannot be empty...");
				response.getWriter().write("</strong></font></center></body></html>");
			}
			else
			{	
				
				try
				{
					PreparedStatement ps=con.prepareStatement("insert into bhargav.empdetails(eid,fname,mname,lname,gender,sector,phoneno,dob,address,state) values(?,?,?,?,?,?,?,?,?,?)");
					ps.setString(1, empid);
					ps.setString(2, fstname);
					ps.setString(3, midname);
					ps.setString(4, lstname);
					ps.setString(5, gender);
					ps.setString(6, sectr);
					ps.setString(7, phno);
					ps.setString(8, dob);
					ps.setString(9, address);
					ps.setString(10, ustate);
					int i=ps.executeUpdate();	
					if(i!=0)
					{
						HttpSession session= request.getSession();
						session.setAttribute("eid", empid);
						session.setAttribute("pass", password1);
						session.setAttribute("sec", sectr);
						getServletContext().getRequestDispatcher("/signout1.jsp").include(request, response);
					}
					else
					{
						getServletContext().getRequestDispatcher("/signout.jsp").include(request, response);
						response.getWriter().write("<html><body><center><h1><font color=white><strong>");
						response.getWriter().write("can't proceed try again.....");
						response.getWriter().write("</strong></font></h1></center></body></html>");
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
