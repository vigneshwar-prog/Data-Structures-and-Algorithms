import java.util.*;

class maxFlow{

    int V;
    int adjMat[][];
    maxFlow(int v)
    {
        this.V = v;
        adjMat = new int[V][V];
    }
    public static void main(String[] args) {
        int v;
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        maxFlow obj = new maxFlow(v);
        for(int i=0;i<v;i++)
        {
            for(int j=0;j<v;j++)
            {
                obj.adjMat[i][j] = sc.nextInt();
            }
        }
        int s = sc.nextInt(),T = sc.nextInt();
        int  k = obj.FulkersonAlgo(s,T);
        System.out.print(k);

    }

    int FulkersonAlgo(int s,int t) {
        int u,v;

        int duplicate[][] = new int[V][V];

        for (u = 0; u < V; u++) 
            for (v = 0; v < V; v++) 
                duplicate[u][v] = adjMat[u][v];

        int parent[] = new int[V]; 

        int maxflow = 0;

        while(bfs(duplicate,s,t,parent))
        {
            int path_flow = Integer.MAX_VALUE; 
            for (v=t; v!=s; v=parent[v]) 
            { 
                u = parent[v]; 
                path_flow = Math.min(path_flow, duplicate[u][v]); 
            } 
  
            for (v=t; v != s; v=parent[v]) 
            { 
                u = parent[v]; 
                duplicate[u][v] -= path_flow; 
                duplicate[v][u] += path_flow; 
            } 
  
            maxflow += path_flow; 
        }
        return maxflow;

    }

    private boolean bfs(int[][] duplicate, int s, int t, int[] parent) {
        boolean visited[] = new boolean[V]; 
        for(int i=0; i<V; ++i) 
            visited[i]=false; 
  
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
        queue.add(s); 
        visited[s] = true; 
        parent[s]=-1; 
        while (queue.size()!=0) 
        { 
            int u = queue.poll(); 
  
            for (int v=0; v<V; v++) 
            { 
                if (visited[v]==false && duplicate[u][v] > 0) 
                { 
                    queue.add(v); 
                    parent[v] = u; 
                    visited[v] = true; 
                } 
            } 
        } 
        return (visited[t] == true); 
    }
}
