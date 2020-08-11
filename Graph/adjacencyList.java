import java.util.*;

class adjacencyList {
    static void insert(ArrayList<ArrayList<Integer>> vertice,int s,int d){
        vertice.get(s).add(d);
        vertice.get(d).add(s);
    }
    static void print(ArrayList<ArrayList<Integer>> list){
        for(int i =0;i< list.size();i++)
        {
            System.out.print("Head = " + i);
            int len = list.get(i).size();
            for(int j=0;j<len;j++)
            {
                System.out.print( " -> " + list.get(i).get(j));
            }
            System.out.println(" ");
        }
    }
    public static void main(String[] args) {
        int T;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while(T-- > 0)
        {
            int V = sc.nextInt(),E = sc.nextInt();
            ArrayList<ArrayList<Integer>> vertices = new ArrayList<ArrayList<Integer>>(V);
            for(int i=0;i<V;i++)
            {
                vertices.add(new ArrayList<Integer>());
            }
            for (int i=0;i<E;i++)
            {
                int S = sc.nextInt(),D = sc.nextInt();
                insert(vertices,S,D);
            }
            print(vertices);
        }
    }
}
