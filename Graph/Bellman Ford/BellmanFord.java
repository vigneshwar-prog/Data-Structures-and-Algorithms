import java.util.*;

class Edge implements Comparable{
    int src,dst,weight;
    Edge(int s,int d,int w)
    {
        src = s;
        dst = d;
        weight = w;
    }
    public int getWeight(){
        return weight;
    }
    @Override
    public int compareTo(Object o) {
        return  (this.getWeight() < ((Edge) o).getWeight() ? -1 : (this.getWeight() == ((Edge) o).getWeight() ? 0 : 1));
    }
}
class BellmanFord{
    static ArrayList<Edge> adjList;
    static int V;
    
    BellmanFord(int v){
        V = v;
        adjList = new ArrayList<Edge>(V);
    }
    static void insert(Edge e)
    {
        adjList.add(e);
    }
    
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(),E = sc.nextInt();
        BellmanFord obj = new BellmanFord(V);
        int path[] = new int[V];
        Arrays.fill(path,Integer.MAX_VALUE);
        for(int i=0;i<E;i++)
        {
            int s = sc.nextInt(),d = sc.nextInt(),w = sc.nextInt();
            insert(new Edge(s,d,w));
            insert(new Edge(d,s,w));

        }
        int startNode = sc.nextInt();
        path[startNode] =  0;
        for(int i=0;i<V-1;i++){
            for(Edge item : obj.adjList)
            {
                if(path[item.src] != Integer.MAX_VALUE && (path[item.src] + item.getWeight() < path[item.dst]))
                {
                    path[item.dst]  = path[item.src]+item.getWeight();
                }
            }
        }
        for(int i=0;i<V;i++){
            System.out.println(i+"-->"+path[i])
        }       
    }
}