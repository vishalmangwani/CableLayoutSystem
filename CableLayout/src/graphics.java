

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JPanel;

/**
 * Servlet implementation class graphics
 */
public class graphics extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public graphics() {
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
		String sec=request.getParameter("s");
		String driver="com.ibm.db2.jcc.DB2Driver";
		String url="jdbc:db2://localhost:50000/opdb1";
		String username="AbhishekAbi";
		String password="microsoft";
		BufferedImage bufferedImage = new BufferedImage(200, 200,BufferedImage.TYPE_INT_RGB);
		try
		{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=con.prepareStatement("select * from bhargav.sector_no_db where sector=?");
			ps.setString(1, sec);
			ResultSet rs=ps.executeQuery();		
			rs.next();
		    if(rs.getInt(2)==4)
			{
				getServletContext().getRequestDispatcher("/userfrontend.jsp").include(request, response);
				response.getWriter().write("<html><head></head><body><applet code='v.class' width=1000 height=1000></applet></body></html>");
			}
			else
			{	
								
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
