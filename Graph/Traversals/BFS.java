import java.util.*;
import java.io.*;
class BFS{
    private LinkedList<Integer> adj[];
    private int V;
    BFS(int V){
        this.V = V;
        adj = new LinkedList[V];
        for(int i=0;i<V;i++)
        {
            adj[i] = new LinkedList();
        }
    }
    void addValue(int S,int D){
        adj[S].add(D);
    }
    void bfsTraverse(int startNode)
    {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[startNode] = true;
        queue.add(startNode);
        while(queue.size() != 0){
            startNode = queue.poll();
            System.out.print(startNode+" ");
            Iterator<Integer> i = adj[startNode].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            } 
        }
    }
    public static void main(String[] args)
    {
        int T;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while(T-- > 0)
        {
            int V = sc.nextInt(), E = sc.nextInt();
            BFS list = new BFS(V);
            for(int i=0;i<E;i++)
            {
                int s = sc.nextInt(),d = sc.nextInt();
                list.addValue(s,d);
            }
            list.bfsTraverse(0);
            System.out.println("");
        }
        
    }
}