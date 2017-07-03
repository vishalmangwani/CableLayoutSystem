

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
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
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
			PreparedStatement ps=con.prepareStatement("delete from bhargav.sector_conn where sector=?");
			ps.setString(1, sector1);
			int s=ps.executeUpdate();
			PreparedStatement ps1=con.prepareStatement("delete from bhargav.sector_no_db where sector=?");
			ps1.setString(1, sector1);
			int s1=ps1.executeUpdate();
			PreparedStatement ps2=con.prepareStatement("delete from bhargav.sector_db where sector=?");
			ps2.setString(1, sector1);
			int s2=ps2.executeUpdate();
			PreparedStatement ps3=con.prepareStatement("delete from bhargav.connections where sector=?");
			ps3.setString(1, sector1);
			int s3=ps3.executeUpdate();
			if(s!=0&&s1!=0)
			{
				getServletContext().getRequestDispatcher("/delete1.jsp").include(request, response);
				response.getWriter().write("<html><body><center><font color=#151B54><strong>");
				response.getWriter().write("Sector Deleted successfully....");
				response.getWriter().write("</strong></font></center></body></html>");
			}
			else
			{
				getServletContext().getRequestDispatcher("/delete1.jsp").include(request, response);
				response.getWriter().write("<html><body><center><h1><font color=#151B54><strong>");
				response.getWriter().write("Check the details Sector deletion cannot be processed....");
				response.getWriter().write("</strong></font></h1></center></body></html>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
