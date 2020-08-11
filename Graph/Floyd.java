import java.util.*;

public class Floyd {
    int V;
    Floyd(int v)
    {
        this.V = v;
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int adjMat[][] = new int[N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                int k = sc.nextInt();
                if(k == 0 && i!=j)
                {
                    adjMat[i][j] = Integer.MAX_VALUE;
                }
                else{
                    adjMat[i][j] = k;
                }
            }
        }
        Floyd obj = new Floyd(N);
        obj.floydAlgo(adjMat);
    }

    private void floydAlgo(int[][] adjMat) {
        int dist[][] = new int[V][V];
        int i,j,k;

        for(i = 0;i<V;i++)
        {
            for(j=0;j<V;j++)
            {
                dist[i][j] = adjMat[i][j];
            }
        }

        for(k = 0;k<V;k++)
        {
            for(i = 0;i<V;i++)
            {
                for(j = 0;j<V;j++)
                {
                    if(dist[i][k] + dist[k][j] < dist[i][j])
                    {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        for ( i=0; i<V; ++i) 
        { 
            for ( j=0; j<V; ++j) 
            { 
                if (dist[i][j]==Integer.MAX_VALUE) 
                    System.out.print("INF "); 
                else
                    System.out.print(dist[i][j]+"   "); 
            } 
            System.out.println(); 
        } 
    }

}