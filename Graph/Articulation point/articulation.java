import java.util.*;

class articulation{

    int V;
    int time = 0;
    LinkedList<Integer> adjList[];
    articulation(int V)
    {
        this.V = V;
        adjList = new LinkedList[V];
        for(int i=0;i<V;i++)
        {
            adjList[i] = new LinkedList();
        }
    }
    void addEdge(int s,int d)
    {
        adjList[s].add(d);
        adjList[d].add(s);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(),E = sc.nextInt();
        articulation obj = new articulation(V);
        for(int i=0;i<E;i++)
        {
            int s= sc.nextInt(),d = sc.nextInt();
            obj.addEdge(s, d);
        
        }
        obj.articulatePts();
    }

    void articulatePts() {
        articulation obj = new articulation(V);
        boolean[] visited = new boolean[V];
        int disc[] = new int[V];
        int low[] = new int[V];
        int parent[] = new int[V];
        boolean[] artpts = new boolean[V];

        Arrays.fill(artpts,false);
        Arrays.fill(parent,-1);
        Arrays.fill(visited,false);

        for(int i=0;i<V;i++)
        {
            if(visited[i] == false){
                dfsTraverse(i,visited,disc,low,parent,artpts);
            }
        }
        obj.PrintArtPts(artpts);

    }

    void dfsTraverse(int u, boolean[] visited, int[] disc,
                     int[] low, int[] parent, boolean[] artpts) {
        disc[u] = low[u] = ++time;
        int children = 0;
        visited[u] = true;
        Iterator<Integer> itr = adjList[u].iterator();
        while(itr.hasNext())
        {
            int  k =itr.next();
            children++;
            if(visited[k] ==false){

                parent[k] = u;
                dfsTraverse(k, visited, disc, low, parent, artpts);

                low[u] = Math.min(low[u],low[k]);
                if(parent[u] == -1 && children > 1)
                artpts[u] =true;
                
                if(parent[u] != -1 && low[k] >= disc[u]){
                    artpts[u] = true;
                }
            }
            else if(k != parent[u]){
                low[u] = Math.min(low[u],disc[k]); 
            }
        }

    }

    void PrintArtPts(boolean[] result) {
        System.out.println("----Articulate Points-----");
        for(int i=0;i<V;i++)
        {
            if(result[i]==true)
            System.out.println(i+" ");
        }
    }

}