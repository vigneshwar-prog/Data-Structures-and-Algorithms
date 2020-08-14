import java.util.*;
import java.util.Random;
class Edges{
    int src;
    int dest;
}
class subset{
    int parent;
    int rank;
}
class mincut {

    int V,E;
    Edges edge[];
    mincut(int v,int e){
        this.V = v; 
        this.E = e;
        edge = new Edges[E];
        for(int i=0;i<E;i++)
        {
            edge[i] = new Edges();
        }
    }
    void insert(int s,int d,int i)
    {
        edge[i].src = s;
        edge[i].dest = d;
    }
    int find(subset set[],int i)
    {
        if(set[i].parent != i)
        {
            set[i].parent = find(set,set[i].parent);
        }
        return set[i].parent;
    }
    void Union(subset[] set,int s1,int s2){
        int xroot = find(set,s1);
        int yroot = find(set,s2);

        if(set[xroot].rank < set[yroot].rank){
            set[xroot].parent = yroot;
        }
        else if(set[xroot].rank > set[yroot].rank)
        {
            set[yroot].parent = xroot;
        }
        else{
            set[yroot].parent = xroot;
            set[xroot].rank++;
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(), E = sc.nextInt();
        mincut obj = new mincut(V,E);
        for(int i=0;i<E;i++)
        {
            int s = sc.nextInt(),d = sc.nextInt();
            obj.insert(s,d,i);
        }
        int count = obj.kargerMincut();
        System.out.print(count);
    }
    int  kargerMincut(){
        Random random  = new Random();
        subset[] ss = new subset[V];

        for(int i=0;i<V;i++)
        {
            ss[i].parent = i;
            ss[i].rank = 0;
        }
        int vertices = V;

        while(vertices > 2)
        {
            int v = random.nextInt(E);

            int subset1 = find(ss,edge[v].src);
            int subset2 = find(ss,edge[v].dest);

            if(subset1 == subset2) continue;
            else{
                System.out.print(edge[v].src+"-->"+edge[v].dest);
                vertices--;
                Union(ss,subset1,subset2);
            }
        }
        int cutEdges = 0;
        for(int i=0;i<E;i++)
        {
            int subset1 = find(ss, edge[i].src); 
            int subset2 = find(ss, edge[i].dest); 
            if (subset1 != subset2) 
            cutEdges++; 
        } 
  
    return cutEdges; 
    }
}