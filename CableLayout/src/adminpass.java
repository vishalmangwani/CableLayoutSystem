

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
 * Servlet implementation class adminpass
 */
public class adminpass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminpass() {
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
		String key=request.getParameter("cpwd");
		String npsword=request.getParameter("npwd");
		String driver="com.ibm.db2.jcc.DB2Driver";
		String url="jdbc:db2://localhost:50000/opdb1";
		String username="AbhishekAbi";
		String password="microsoft";
		try
		{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, username, password);
			if(key.equals("adminpass"))
			{
				PreparedStatement ps=con.prepareStatement("update bhargav.admin set admin_pass=?");
				ps.setString(1, npsword);
				int rs=ps.executeUpdate();
				if(rs!=0)
				{
					getServletContext().getRequestDispatcher("/adminpass.jsp").include(request, response);
					response.getWriter().write("<html><body><center><font color='#151B54' face='cursive,sans-serif'><strong>");
					response.getWriter().write("Password updated successfully...");
					response.getWriter().write("</strong></font></center></body></html>");
				}
				else
				{
					getServletContext().getRequestDispatcher("/adminpass.jsp").include(request, response);
					response.getWriter().write("<html><body><center><font color=red><strong>");
					response.getWriter().write("Password updation is not done...");
					response.getWriter().write("</strong></font></center></body></html>");
				}
			}
			else
			{						
				getServletContext().getRequestDispatcher("/adminpass.jsp").include(request, response);
				response.getWriter().write("<html><body><center><font color=red><strong>");
				response.getWriter().write("Secret key doesn't match...");
				response.getWriter().write("</strong></font></center></body></html>");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
