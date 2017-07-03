

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
 * Servlet implementation class disconnection1
 */
public class disconnection1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public disconnection1() {
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
		String loc1=request.getParameter("loc1");
		String loc2=request.getParameter("loc2");
		String driver="com.ibm.db2.jcc.DB2Driver";
		String url="jdbc:db2://localhost:50000/opdb1";
		String username="AbhishekAbi";
		String password="microsoft";
		HttpSession session= request.getSession();
		session.setAttribute("s", sector1);
		session.setAttribute("l1", loc1);
		session.setAttribute("l2", loc2);
		try
		{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=con.prepareStatement("delete from bhargav.connections where sector=? and location1=? and location2=?");
			ps.setString(1, sector1);
			ps.setString(2, loc1);
			ps.setString(3, loc2);
			int i=ps.executeUpdate();	
			if(i!=0)
			{
				PreparedStatement ps2=con.prepareStatement("update bhargav.sector_conn set no_conn=no_conn-"+1+" where sector=?" );
				ps2.setString(1,sector1);
				int se=ps2.executeUpdate();
				if(se!=0){}
				getServletContext().getRequestDispatcher("/disconnection1.jsp").include(request, response);
				response.getWriter().write("<html><head></head><body><center><h3><font color=#151B54><strong>");
				response.getWriter().write("Disconnected successfully...");
				response.getWriter().write("</strong></font></h3></center></body></html>");
			}
			else
			{
				getServletContext().getRequestDispatcher("/disconnection.jsp").include(request, response);
				response.getWriter().write("<html><body><center><h1><font color=#151B54 face='cursive' face='sans-serif' size=4><strong>");
				response.getWriter().write("can't access the connection!!!<br>Please check the details.....");
				response.getWriter().write("</strong></font></h1></center></body></html>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
