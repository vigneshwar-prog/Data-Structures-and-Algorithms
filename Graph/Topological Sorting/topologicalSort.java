import java.util.*;

class topologicalSort{

    int V;
    LinkedList<Integer> adjList[];
    topologicalSort(int V)
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
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(),E = sc.nextInt();
        topologicalSort obj = new topologicalSort(V);
        for(int i=0;i<E;i++)
        {
            int s= sc.nextInt(),d = sc.nextInt();
            obj.addEdge(s, d);
        }
        obj.tSort();
        
    }

    void tSort() {
        boolean visited[] = new boolean[V];
        Arrays.fill(visited,false);
        Stack<Integer> stk = new Stack<Integer>();
        for(int i=0;i<V;i++)
        {
            if(visited[i] == false ){
            dfsTraverse(visited,i,stk);
            stk.push(i);
            }
        }
        while(stk.size()>0){
            System.out.print(stk.pop()+" ");
        }

    }

    private void dfsTraverse(boolean[] visited, int u, Stack<Integer> stk) {
        visited[u] = true;

        Iterator<Integer> itr = adjList[u].iterator();
        while(itr.hasNext()){
            int v = itr.next();
 
            if(visited[v] == false)
            {
                if(stk.size()>0){
                dfsTraverse(visited, v, stk);
                stk.push(v);
                }
            }
        }
    }
}
