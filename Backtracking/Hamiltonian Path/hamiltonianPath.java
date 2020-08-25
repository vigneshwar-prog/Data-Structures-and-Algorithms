import java.util.*;
import java.lang.*;
import java.io.*;

class hamiltonianPath {
    int V;
    ArrayList<ArrayList<Integer>> adjList;
    boolean visited[];
    hamiltonianPath(int v)
    {
        this.V = v+1;
        adjList = new ArrayList<ArrayList<Integer>>(V);
        visited = new boolean[V];
        for(int i=0;i<V;i++)
        adjList.add(new ArrayList<Integer>());
    }
    void insert(int src,int des)
    {
        adjList.get(src).add(des);
        adjList.get(des).add(src);
    }
	public static void main (String[] args) {
		int T;
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		while(T-- > 0)
		{
		    
		    int N = sc.nextInt(),E = sc.nextInt();
		    hamiltonianPath obj = new hamiltonianPath(N);
		    for(int i=0;i<E;i++)
		    {
		        int s = sc.nextInt(),t = sc.nextInt();
		        obj.insert(s,t);
		    }
		    Arrays.fill(obj.visited,false);
		    for(int i=1;i<=N;i++){
		        obj.visited[i] = true;
		        obj.found = obj.solve(obj.visited,1,i);
		        obj.visited[i] = false;
		    }
		    if(obj.found)
		    {
		        System.out.println(1);
		    }
		    else{
		        System.out.println(0);
		    }
		}
	}
	boolean found = false;
	public boolean solve(boolean[] visited,int count,int index){
	    if (found == true) return found;
	    if(count == V-1)
	    {
	        found = true;
	        return true;
	    }
	    boolean ans = false;
        for(Integer j:adjList.get(index))
        {
            if(visited[j] == false)
            {
                visited[j] = true;
                ans = solve(visited,count+1,j);
                visited[j] = false;
            }
        }
	    return ans;
	}
	
}