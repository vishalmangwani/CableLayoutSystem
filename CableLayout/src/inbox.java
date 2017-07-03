

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
 * Servlet implementation class inbox
 */
public class inbox extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inbox() {
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
		String chck=request.getParameter("c1");
		String driver="com.ibm.db2.jcc.DB2Driver";
		String url="jdbc:db2://localhost:50000/opdb1";
		String username="AbhishekAbi";
		String password="microsoft";
		try
		{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps5=con.prepareStatement("select  bhargav.admin_inbox(eid,password,fname,mname,lname,gender,sector,phoneno,question,answer,dob,address,state) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ResultSet rs=ps5.executeQuery();		
			String empid=rs.getString(1);
			String password1=rs.getString(2);
			String fstname=rs.getString(3);
			String midname=rs.getString(4);
			String lstname=rs.getString(5);
			String dob=rs.getString(11);
			String gender=rs.getString(6);
			String phno=rs.getString(8);
			String address=rs.getString(12);
			String ustate=rs.getString(13);
			String sectr=rs.getString(7);
			String ques=rs.getString(9);
			String answer=rs.getString(10);
			while(empid==chck)
			{
				PreparedStatement ps2=con.prepareStatement("insert into bhargav.empdetails(eid,fname,mname,lname,gender,sector,phoneno,question,answer,dob,address,state) values(?,?,?,?,?,?,?,?,?,?,?,?)");
				ps2.setString(1, empid);
				ps2.setString(2, fstname);
				ps2.setString(3, midname);
				ps2.setString(4, lstname);
				ps2.setString(5, gender);
				ps2.setString(6, sectr);
				ps2.setString(7, phno);
				ps2.setString(8, ques);
				ps2.setString(9, answer);
				ps2.setString(10, dob);
				ps2.setString(11, address);
				ps2.setString(12, ustate);
				PreparedStatement ps3=con.prepareStatement("insert into bhargav.user_id_pass(eid,password) values(?,?)");
				ps3.setString(1, empid);
				ps3.setString(2, password1);
				PreparedStatement ps4=con.prepareStatement("insert into bhargav.user_sector(eid,sector) values(?,?)");
				ps4.setString(1, empid);
				ps4.setString(2, sectr);
				int rs4=ps4.executeUpdate();
				if(rs4!=0)
				{
					response.getWriter().write("<html><body><center><h1><font color=white><strong>");
					response.getWriter().write("selected rows are added into database.....");
					response.getWriter().write("</strong></font></h1></center></body></html>");
					getServletContext().getRequestDispatcher("/inbox.jsp").include(request, response);
				}
			}
			if(chck==null)
			{
				response.getWriter().write("<html><body><center><h1><font color=white><strong>");
				response.getWriter().write("no rows are added into database.....");
				response.getWriter().write("</strong></font></h1></center></body></html>");
				getServletContext().getRequestDispatcher("/inbox.jsp").include(request, response);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}