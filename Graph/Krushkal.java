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
class Krushkal{
    static ArrayList<Edge> adjList;
    static int V;
    
    Krushkal(int v){
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
        Krushkal obj = new Krushkal(N);
        for(int i=0;i<V;i++)
        {
            int s = sc.nextInt(),d = sc.nextInt(),w = sc.nextInt();
            insert(new Edge(s,d,w));

        }
        for(Edge i : obj.adjList)
        {
            System.out.println(i.src +" "+ i.dst+" "+ i.weight);
        }
        System.out.println("dan dana dan");
        Collections.sort(obj.adjList);
        KrushkalAlgo();
        
    }
    static int find(subset subsets[],int i)
    {
        if(subsets[i].parent != i)
        subsets[i].parent = find(subsets,subsets[i].parent);
        return subsets[i].parent;
    }

    static void Union(subset subsets[],int x,int y)
    {
        int xroot = find(subsets, x); 
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank) 
            subsets[xroot].parent = yroot; 
        else if (subsets[xroot].rank > subsets[yroot].rank) 
            subsets[yroot].parent = xroot; 
        else
        { 
            subsets[yroot].parent = xroot; 
            subsets[xroot].rank++; 
        } 
    }
    static void  KrushkalAlgo(){
        ArrayList<Edge> result = new ArrayList<Edge>(V);
        int e = 0;
        int i = 0;
        subset subsets[] = new subset[V];
        for(i=0;i<V;i++)
        {
            subsets[i] = new subset();
        }
        for(int v = 0;v<V;v++)
        {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        i= 0;
        while(e < V-1)
        {
            Edge nextEdge;
            nextEdge = adjList.get(i++);
            int x = find(subsets,nextEdge.src);
            int y = find(subsets,nextEdge.dst);
            if(x!=y)
            {
                result.add(nextEdge);
                e++;
                Union(subsets,x,y);
            }
        }
        System.out.println(" Result ");
        for(Edge itr:result)
        {
            System.out.println(itr.src+" "+itr.dst+" "+itr.weight);
        }
    }
}