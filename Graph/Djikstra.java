import java.util.*;


class Djikstra{
    int V;
    Djikstra(int V){
        this.V = V;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int adjMat[][] = new int[N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                adjMat[i][j] = sc.nextInt();
            }
        }
        int startNode = sc.nextInt();
        Djikstra obj = new Djikstra(N);
        obj.djikstrAlgo(adjMat,startNode);
    }

    void djikstrAlgo(int[][] adjMat, int src) {
        int dist[] = new int[V];
        Boolean sptset[] = new Boolean[V];
        for(int i=0;i<V;i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptset[i] = false;
        }
        dist[src] = 0;
        for(int count = 0;count < V-1;count++){
            int u = minDistance(dist,sptset);
            sptset[u] = true;
            for(int v=0;v < V;v++)
            {
                if(!sptset[v] && adjMat[u][v] != 0 && dist[u] != Integer.MAX_VALUE &&
                 dist[u]+adjMat[u][v] < dist[v]){
                     dist[v] = dist[u]+adjMat[u][v];
                } 
            }
        }
        System.out.println("Vertex \t\t Distance from Source"); 
        for (int i = 0; i < V; i++) 
            System.out.println(i + " \t\t " + dist[i]);
    }

    int minDistance(int[] dist, Boolean[] sptset) {
        int min = Integer.MAX_VALUE,minIndex = -1;
        for(int v =0;v<V;v++)
        {
            if(sptset[v] == false && dist[v] <= min){
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
}