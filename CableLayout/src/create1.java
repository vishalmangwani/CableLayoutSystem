

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
 * Servlet implementation class create1
 */
public class create1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public create1() {
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
		String sector1=request.getParameter("se");
		String driver="com.ibm.db2.jcc.DB2Driver";
		String url="jdbc:db2://localhost:50000/opdb1";
		String username="AbhishekAbi";
		String password="microsoft";
		try
		{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=con.prepareStatement("insert into bhargav.sector_conn values(?,?)");
			ps.setString(1, sector1);
			ps.setString(2, "0");
			int s=ps.executeUpdate();
			PreparedStatement ps1=con.prepareStatement("insert into bhargav.sector_no_db values(?,?)");
			ps1.setString(1, sector1);
			ps1.setString(2, "0");
			int s1=ps1.executeUpdate();
			if(s!=0&&s1!=0)
			{
				getServletContext().getRequestDispatcher("/create1.jsp").include(request, response);
				response.getWriter().write("<html><body><center><font color=#151B54><strong>");
				response.getWriter().write("<br><br><br><br><br>Sector created successfully....");
				response.getWriter().write("</strong></font></center></body></html>");
			}
			else
			{
				getServletContext().getRequestDispatcher("/create1.jsp").include(request, response);
				response.getWriter().write("<html><body><center><h1><font color=#151B54><strong>");
				response.getWriter().write("Check the details Sector creation cannot be processed....");
				response.getWriter().write("</strong></font></h1></center></body></html>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
