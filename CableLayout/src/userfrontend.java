

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.StringTokenizer;




/**
 * Servlet implementation class userfrontend
 */
public class userfrontend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userfrontend() {
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
		String sec=request.getParameter("sec");
		String msg=request.getParameter("t1");
		String driver="com.ibm.db2.jcc.DB2Driver";
		String url="jdbc:db2://localhost:50000/opdb1";
		String username="AbhishekAbi";
		String password="microsoft";
		HttpSession session= request.getSession();
		session.setAttribute("sect1", sec);
		try
		{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps1=con.prepareStatement("select * from bhargav.sector_conn where sector=?");
			ps1.setString(1, sec);
			ResultSet rs1=ps1.executeQuery();
			StringTokenizer st = new StringTokenizer(msg,","); 
			int i=0;
			int co=0;
				if(rs1.next())
				{
					while(st.hasMoreTokens())
					{ 
						String l1=st.nextToken();
						String l2=st.nextToken();
						String c=st.nextToken();
						PreparedStatement ps9=con.prepareStatement("select * from bhargav.sector_no_db where sector=?");
						ps9.setString(1, sec);
						ResultSet rs8=ps9.executeQuery();
						rs8.next();
						if(rs8.getInt(2)<9)
						{
						PreparedStatement ps=con.prepareStatement("insert into bhargav.connections values(?,?,?,?)");
						ps.setString(1, sec);
						ps.setString(2, l1);
						ps.setString(3, l2);
						ps.setString(4, c);
						int s=ps.executeUpdate();
						i=i+1;
						if(s!=0)
						{
							PreparedStatement ps3=con.prepareStatement("select * from bhargav.sector_db where sector=? and db=?");
							ps3.setString(1, sec);
							ps3.setString(2, l1);
							ResultSet rs3=ps3.executeQuery();
							PreparedStatement ps4=con.prepareStatement("select * from bhargav.sector_db where  sector=? and db=?");
							ps4.setString(1, sec);
							ps4.setString(2, l2);
							ResultSet rs4=ps4.executeQuery();
							if(rs3.next())
							{
				
							}
							else
							{
									PreparedStatement ps5=con.prepareStatement("insert into bhargav.sector_db(sector,db) values(?,?)" );
									ps5.setString(1, sec);
									ps5.setString(2, l1);
									int rs5=ps5.executeUpdate();
									int j=0;
									if(rs5!=0)
									{
										j=j+1;
										PreparedStatement ps7=con.prepareStatement("update bhargav.sector_no_db set no_db=no_db+"+j+" where sector=?" );
										ps7.setString(1,sec);
										int se1=ps7.executeUpdate();
									}
							}
							if(rs4.next())
							{
								
							}
							else
							{
									PreparedStatement ps7=con.prepareStatement("insert into bhargav.sector_db(sector,db) values(?,?)" );
									ps7.setString(1, sec);
									ps7.setString(2, l2);
									int rs7=ps7.executeUpdate();
									int j=0;
									if(rs7!=0)
									{
										j=j+1;
										PreparedStatement ps8=con.prepareStatement("update bhargav.sector_no_db set no_db=no_db+"+j+" where sector=?" );
										ps8.setString(1,sec);
										int se2=ps8.executeUpdate();
										
									}					
							}
						}
						else
						{
							getServletContext().getRequestDispatcher("/userfrontend.jsp").include(request, response);
							response.getWriter().write("<html><body><center><h1><font color=#151B54><strong>");
							response.getWriter().write("Duplicate Details Are Found...!!! Connection Cannot Be Established....");
							response.getWriter().write("</strong></font></h1></center></body></html>");
						}
						}
						else
						{
							getServletContext().getRequestDispatcher("/userfrontend1.jsp").include(request, response);
							response.getWriter().write("<html><body><center><br><br><br><br><font color=red><strong>");
							response.getWriter().write("Not more than 9 Distribution Boxes can be connected in a single sector...!!! Limit exceeded..!!! Connection Cannot Be Established....");
							response.getWriter().write("</strong></font></center></body></html>");
							co=1;
						}
						
					}
					if(i>0)
					{
					PreparedStatement ps2=con.prepareStatement("update bhargav.sector_conn set no_conn=no_conn+"+i+" where sector=?" );
					ps2.setString(1,sec);
					int se=ps2.executeUpdate();
					if(co==0)
					{
					if(se!=0)
					{
						getServletContext().getRequestDispatcher("/userfrontend1.jsp").include(request, response);
					}
					else
					{
						getServletContext().getRequestDispatcher("/userfrontend.jsp").include(request, response);
						response.getWriter().write("<html><body><center><h1><font color=#151B54><strong>");
						response.getWriter().write("Connection Cannot Be Established....");
						response.getWriter().write("</strong></font></h1></center></body></html>");
					}
					}
					}
				}
				else
				{
					getServletContext().getRequestDispatcher("/userfrontend.jsp").include(request, response);
					response.getWriter().write("<html><body><center><h1><font color=#151B54><strong>");
					response.getWriter().write("Can't process..!!! Check the sector details....");
					response.getWriter().write("</strong></font></h1></center></body></html>");
				}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
