import java.util.*;

class prims{
    static ArrayList<Edge> adjList;
    static int V;
    static class Edge implements Comparable{
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
    prims(int v){
        V = v;
        adjList = new ArrayList<Edge>(V);
    }
    static void insert(Edge e)
    {
        adjList.add(e);
    }
    static class subset{
        int parent,rank;
    }
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(),V = sc.nextInt();
        prims obj = new prims(N);
        for(int i=0;i<V;i++)
        {
            int s = sc.nextInt(),d = sc.nextInt(),w = sc.nextInt();
            insert(new Edge(s,d,w));
        }
        for(Edge i : obj.adjList)
        {
            System.out.print(i.weight);
        }
        
    }
}