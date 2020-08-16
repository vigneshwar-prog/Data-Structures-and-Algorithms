import java.util.*;

public class maxSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for(int i=0;i<N;i++)
        {
            arr[i] = sc.nextInt();
        }
        int maxValue = -9999;
        int currentMax = 0;
        for(int i=0;i<N;i++)
        {
            currentMax += arr[i];
            if(currentMax > maxValue){
                maxValue = currentMax ;
            }
            if(currentMax < 0){
                currentMax = 0;
            }
        }
        System.out.print(maxValue);
    }
}