import java.util.*;

class adjacencyList{

    int V;
    LinkedList<Integer> adjList[];
    adjacencyList(int V)
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
        adjacencyList obj = new adjacencyList(V);
        for(int i=0;i<E;i++)
        {
            int s= sc.nextInt(),d = sc.nextInt();
            obj.addEdge(s, d);
        }
        obj.printEdges();
    }

    private void printEdges() {
        for(int i=0;i<V;i++)
        {
            System.out.println(adjList[i]);
        }
    }

}