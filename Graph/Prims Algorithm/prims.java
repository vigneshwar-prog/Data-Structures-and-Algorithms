import java.util.*;

class Edges{
    int src,dest,weight;
}

class prims{
    int V,E;
    PriorityQueue<Edges> edge;
    prims(int v,int e)
    {
        this.V = v;
        this.E = e;
        edge = new PriorityQueue<Edges>();
        for (int i=0;i<E;i++)
        {
            edge.add(new Edges());
        }
    }
    void insert(int s,int d,int w)
    {
        Edges obj = new Edges();
        obj.src = s;
        obj.dest = d;
        obj.weight = w;
        edge.add(obj);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V =sc.nextInt(),E = sc.nextInt();
        prims p = new prims(V,E);
        for(int i=0;i<E;i++)
        {
            int s = sc.nextInt(),t = sc.nextInt(),w = sc.nextInt();
            p.insert(s, t, w);
        }

        int startNode = sc.nextInt();
        p.primsAlgo(startNode);


    }

    private void primsAlgo(int startNode) {

        boolean visited[] = new boolean[V];
        

    }
}