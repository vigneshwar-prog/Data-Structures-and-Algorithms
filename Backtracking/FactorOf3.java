import java.util.*;


class FactorOf3{

    static boolean Found = false;

    static void backTracking(int array[],int Result[],int RIndex,int index,boolean[] visited)
    {
        if(Found == true)
        {
            return ;
        }
        if(RIndex == array.length){
            Found = true;
            return ;
        }
        for(int i = 0;i<array.length;i++)
        {
            if(index != i && (Result[RIndex-1]+ array[i])%3 != 0 && visited[i] == false){
                Result[RIndex] = array[i];
                visited[i] = true;
                backTracking(array, Result, RIndex+1,i,visited);
                visited[i] = false;
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        int ResultInd = 0;
        boolean visited[] = new boolean[N];
        Arrays.fill(visited,false);
        int result[] = new int[N];
        for(int i=0;i<N;i++)
        {
            arr[i] = sc.nextInt();
        }
        for(int i=0;i<N;i++)
        {
            result[ResultInd] = arr[i];
            visited[i] = true;
            backTracking(arr,result,ResultInd+1,i,visited);
            visited[i] = false;
        }

        if (Found){
            System.out.print("YES");
        }
        else{
            System.out.print("NO");
        }
    }
}