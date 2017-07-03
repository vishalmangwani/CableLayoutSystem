import java.util.Scanner;


public class DijkstrasAlgorithm 
{
	public static int infinity=999;
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
	
	public static void main(String[] args) 
	{
		int n,v,i=1,j;
		int cost[][]=new int[10][10];
		int a[]=new int[10];
		int dist[]=new int[10];
		Scanner sc=new Scanner(System.in);
		System.out.println("\n Enter the number of nodes:");
		n=sc.nextInt();
		System.out.println("\n Enter the cost matrix:\n");
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			{
				cost[i][j]=sc.nextInt();
				if(cost[i][j]==0)
				{
					cost[i][j]=infinity;
				}
			}
		}
			
		for(j=1;j<=n;j++)
		{
			v=j;
			dij(n,v,cost,dist);
			System.out.println("\n Shortest path:\n");	
			
			for(i=1;i<=n;i++)
			{
				if(i!=v)
				{
					System.out.println(v+"->"+i+",cost="+dist[i]+"\n");
				}
			}
		}
		
	}
}
