

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class delete
 */
public class deleteu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteu() {
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
		String user=request.getParameter("uid");
		String driver="com.ibm.db2.jcc.DB2Driver";
		String url="jdbc:db2://localhost:50000/opdb1";
		String username="AbhishekAbi";
		String password="microsoft";
		try
		{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=con.prepareStatement("delete from bhargav.user_sector where eid=?");
			ps.setString(1, user);
			int s=ps.executeUpdate();
			PreparedStatement ps1=con.prepareStatement("delete from bhargav.user_id_pass where eid=?");
			ps1.setString(1, user);
			int s1=ps1.executeUpdate();
			PreparedStatement ps2=con.prepareStatement("delete from bhargav.empdetails where eid=?");
			ps2.setString(1, user);
			int s2=ps2.executeUpdate();
			if(s!=0&&s1!=0&&s2!=0)
			{
				getServletContext().getRequestDispatcher("/deleteu.jsp").include(request, response);
				response.getWriter().write("<html><body><center><font color=#151B54><strong>");
				response.getWriter().write("User Deleted successfully....");
				response.getWriter().write("</strong></font></center></body></html>");
			}
			else
			{
				getServletContext().getRequestDispatcher("/deleteu.jsp").include(request, response);
				response.getWriter().write("<html><body><center><h1><font color=#151B54><strong>");
				response.getWriter().write("Check the details User deletion cannot be processed....");
				response.getWriter().write("</strong></font></h1></center></body></html>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
