import java.util.*;
import java.util.LinkedList;



public class bridge {
    int V;
    LinkedList<Integer> adjList[];
    int time = 0;
    bridge(int V)
    {
        this.V = V;
        adjList = new LinkedList[V];
        for(int i=0;i<V;i++)
        {
            adjList[i] = new LinkedList();
        }
    }
    void addEdge(int s,int d){
        adjList[s].add(d);
        adjList[d].add(s);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(),E = sc.nextInt();
        bridge obj = new bridge(V);
        for(int i=0;i<E;i++)
        {
            int s = sc.nextInt(), t =sc.nextInt();
            obj.addEdge(s,t);
        }
        System.out.println("--------------------------------------");
        for(int i=0;i<V;i++){
            Iterator<Integer> item = obj.adjList[i].iterator();
            while(item.hasNext()){
                int v = item.next();
                System.out.print(v+" ");
            }
            System.out.println(" ");
        }
        System.out.println("--------------------------------------");
        obj.bridgeDetection();

    }

    void bridgeDetection() {
        boolean visited[] = new boolean[V];
        int disc[] = new int[V];
        int low[] = new int[V];
        int parent[] = new int[V];

        Arrays.fill(visited,false);
        Arrays.fill(parent,-1);

        //DFS Search
        for(int i=0;i<V;i++)
        {
            if(visited[i] == false){
                dfsTraverse(i,visited,disc,low,parent);
            }
        }
    }

    private void dfsTraverse(int u, boolean[] visited, int[] disc,
     int[] low, int[] parent) {
        visited[u] = true;
        disc[u] = low[u] = ++time;

        Iterator<Integer> i = adjList[u].iterator();
        while(i.hasNext()){
            int v = i.next();

            if(visited[v] == false){
                parent[v] = u;
                dfsTraverse(v, visited, disc, low, parent);

                low[u] = Math.min(low[u],low[v]);


                if(low[v] > disc[u])
                {
                    System.out.println(u+ " "+ v);
                }
            }
            else if(v != parent[u]){
                low[u] = Math.min(low[u],disc[v]);
            }

        }
    }
}