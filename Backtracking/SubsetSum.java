import java.util.*;


public class SubsetSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(),T = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<N;i++)
        {
            
            list.add(sc.nextInt());
        }
        ArrayList<Integer> output = new ArrayList<Integer>();
        FindSubset(N,T,list,output,0,0);
    }

    private static void FindSubset(int n, int t, ArrayList<Integer> list, ArrayList<Integer> output, int sum,int index) {
        if (sum == t)
        {
            System.out.println(output);
            return ;
        }
        if(sum > t){
            return ;
        }
        if(index == n) return ;
        
        output.add(list.get(index));
        FindSubset(n, t, list, output, sum + list.get(index), index+1);
        output.remove(output.size()-1);
        FindSubset(n, t, list, output, sum, index+1);
    }

    
}