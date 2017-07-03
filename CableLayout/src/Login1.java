

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
 * Servlet implementation class Login1
 */
public class Login1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login1() {
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
		String employee_id=request.getParameter("eid");
		String password1=request.getParameter("pwd");
		String driver="com.ibm.db2.jcc.DB2Driver";
		String url="jdbc:db2://localhost:50000/opdb1";
		String username="AbhishekAbi";
		String password="microsoft";
		try
		{
			if(employee_id.equals("")||password1.equals(""))
			{
				getServletContext().getRequestDispatcher("/login.jsp").include(request,response);
				response.getWriter().write("<html><body><center><font color=red><strong>");
				response.getWriter().write("EmailId or Password cannot be empty");
				response.getWriter().write("</strong></font></center></body></html>");
			}
			else
			{	
				try
				{
					Class.forName(driver);
					Connection con=DriverManager.getConnection(url, username, password);
					PreparedStatement ps=con.prepareStatement("select * from bhargav.admin where admin_id=? and admin_pass=?");
					ps.setString(1, employee_id);
					ps.setString(2, password1);
					ResultSet rs=ps.executeQuery();		
					PreparedStatement ps1=con.prepareStatement("select * from bhargav.user_id_pass where eid=? and password=?");
					ps1.setString(1, employee_id);
					ps1.setString(2, password1);
					ResultSet rs1=ps1.executeQuery();		
					if(rs.next())
					{
						getServletContext().getRequestDispatcher("/frontend.jsp").forward(request, response);
					}
					else if(rs1.next())
					{
						HttpSession session= request.getSession();
						session.setAttribute("userid", employee_id);
						getServletContext().getRequestDispatcher("/userfrontend.jsp").forward(request, response);
					}
					else
					{						
						getServletContext().getRequestDispatcher("/login.jsp").include(request, response);
						response.getWriter().write("<html><body><center><font color=red><strong>");
						response.getWriter().write("Can't access your account,Please check the details...");
						response.getWriter().write("</strong></font></center></body></html>");
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
