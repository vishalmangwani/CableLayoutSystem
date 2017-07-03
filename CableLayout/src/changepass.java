

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
 * Servlet implementation class changepass
 */
public class changepass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changepass() {
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
		String password1=request.getParameter("cpwd");
		String npsword=request.getParameter("npwd");
		String driver="com.ibm.db2.jcc.DB2Driver";
		String url="jdbc:db2://localhost:50000/opdb1";
		String username="AbhishekAbi";
		String password="microsoft";
		try
		{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps1=con.prepareStatement("select * from bhargav.user_id_pass where eid=? and password=?");
			ps1.setString(1, eid);
			ps1.setString(2, password1);
			ResultSet rs1=ps1.executeQuery();		
			if(rs1.next())
			{
				PreparedStatement ps=con.prepareStatement("update bhargav.user_id_pass set password=? where eid=?");
				ps.setString(1, npsword);
				ps.setString(2, eid);
				int rs=ps.executeUpdate();
				if(rs!=0)
				{
					getServletContext().getRequestDispatcher("/profile.jsp").include(request, response);
					response.getWriter().write("<html><body><center><font color=red><strong>");
					response.getWriter().write("Password updated successfully...");
					response.getWriter().write("</strong></font></center></body></html>");
				}
				else
				{
					getServletContext().getRequestDispatcher("/profile.jsp").include(request, response);
					response.getWriter().write("<html><body><center><font color=red><strong>");
					response.getWriter().write("Password updation is not done...");
					response.getWriter().write("</strong></font></center></body></html>");
				}
			}
			else
			{						
				getServletContext().getRequestDispatcher("/update.jsp").include(request, response);
				response.getWriter().write("<html><body><center><font color=red><strong>");
				response.getWriter().write("Wrong password...");
				response.getWriter().write("</strong></font></center></body></html>");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
