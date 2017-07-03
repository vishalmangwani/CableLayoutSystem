

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class optimal
 */
public class optimal extends HttpServlet {
	public static int infinity=999;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public optimal() {
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
		String msg1=request.getParameter("txt");
		String driver="com.ibm.db2.jcc.DB2Driver";
		String url="jdbc:db2://localhost:50000/opdb1";
		String username="AbhishekAbi";
		String password="microsoft";
		try
		{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, username, password);
			String a[]=new String[20];
			int n,v,i=1,j;
			int cost[][]=new int[100][100];
			int dist[]=new int[100];
			PreparedStatement ps1=con.prepareStatement("select * from bhargav.sector_no_db where sector=?");
			ps1.setString(1, msg1);
			ResultSet rs1=ps1.executeQuery();
			if(rs1.next())
			{
				n=rs1.getInt(2);
				if(rs1.getInt(2)!=0)
				{		
					PreparedStatement ps2=con.prepareStatement("select * from bhargav.sector_db where sector=?");
					ps2.setString(1, msg1);
					ResultSet rs2=ps2.executeQuery();
					i=1;
					while(rs2.next())
					{
						a[i]=rs2.getString(2);
						i++;
					}
					for(i=1;i<=n;i++)
					{
						for(j=1;j<=n;j++)
						{
							if(a[i]==a[j])
							{
								cost[i][j]=infinity;
							}
							else
							{
								PreparedStatement ps3=con.prepareStatement("select cost from bhargav.connections where sector=? and location1=? and location2=?");
								ps3.setString(1, msg1);
								ps3.setString(2, a[i]);
								ps3.setString(3, a[j]);
								ResultSet rs3=ps3.executeQuery();
								if(rs3.next())
								{
									cost[i][j]=rs3.getInt(1);
								}
								else
								{
									cost[i][j]=infinity;
								}
							}
						}
					}
					getServletContext().getRequestDispatcher("/userfrontend.jsp").include(request, response);
					response.getWriter().write("<html><body><center><table border=1><tr><td>Location1</td><td>Location2</td><td>Optimal Cost</td></tr>");
					for(j=1;j<=n;j++)
					{
						v=j;
						dij(n,v,cost,dist);
						
						for(i=1;i<=n;i++)
						{
							if(i!=v)
							{
								if(dist[i]<999)
								{
								response.getWriter().write("<tr><td>"+a[v]+"</td><td>"+a[i]+"</td><td>"+dist[i]+"</td></tr>");
								}
								else
								{
									response.getWriter().write("<tr><td>"+a[v]+"</td><td>"+a[i]+"</td><td>infinite"+"</td></tr>");
								}
							}
						}
					}
					response.getWriter().write("</table></center></body></html>");
					response.getWriter().write("<font color=red>*Here infinite indicates <br>no connections can be <br>established between these distribution boxes..</font>");
				}
				else
				{
					getServletContext().getRequestDispatcher("/userfrontend.jsp").include(request, response);
					response.getWriter().write("<html><body><center><font color=red><strong>");
					response.getWriter().write("No connections available....");
					response.getWriter().write("</strong></font></center></body></html>");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void dij(int n,int v,int cost[][],int dist[])
	{
		int i,u=0,count,w=0,min;
		int flag[]=new int[10];
		for(i=1;i<=n;i++)
		{
			flag[i]=0;
			dist[i]=cost[v][i];
		}
		count=2;
		while(count<=n)
		{
			min=99;
			for(w=1;w<=n;w++)
			{
				if(min>dist[w]&&flag[w]!=1)
				{
					u=w;
				}
			}
			flag[u]=1;
			count++;
			for(w=1;w<=n;w++)
			{
					if(dist[w]>dist[u]+cost[u][w])
					{
						dist[w]=dist[u]+cost[u][w];
					}
			}	
		}
	}
}
