import java.util.*;


public class Combinations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<N;i++)
        {
            list.add(sc.nextInt());
        }
        ArrayList<Integer> output = new ArrayList<Integer>();
        Solve(N,K,list,output,0,0);
    }

    private static void Solve(int n, int k, ArrayList<Integer> list, ArrayList<Integer> output, int index, int count) {
        if(count == k){
        System.out.println(output);
        return;
        }
        if(index == n)
        {
            return ;
        }
        output.add(list.get(index));
        Solve(n, k, list, output, index+1, count+1);
        output.remove(output.size()-1);
        Solve(n, k, list, output, index+1, count);
    }
}