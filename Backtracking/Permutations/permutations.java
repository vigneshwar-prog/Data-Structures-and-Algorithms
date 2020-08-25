import java.util.*;

public class permutations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<N;i++)
        {
            list.add(sc.nextInt());
        }
        ArrayList<Integer> output = new ArrayList<Integer>();
        for(int i=0;i<N;i++)
        {
            output.add(list.get(i));
            permutate(N,i,list,output);
            output.remove(output.size()-1);
        }

    }

    private static void permutate(int n, int index, ArrayList<Integer> list, ArrayList<Integer> output) {
        if(output.size() == n)
        {
            System.out.println(output);
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(i != index && !output.contains(list.get(i))){
                output.add(list.get(i));
                permutate(n,i,list,output);
                output.remove(output.size()-1);
            }
        }
    }
    
}