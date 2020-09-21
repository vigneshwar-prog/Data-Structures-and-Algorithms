import java.util.*;

class mergeSort
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for(int i=0;i<N;i++)
        {
            arr[i] = sc.nextInt();
        }
        
        MergeSort(arr,0,N-1);
        for(int i=0;i<arr.length;i++) System.out.print(arr[i]+" ");
        sc.close();
    }

    private static void MergeSort(int[] arr, int start, int end) {
        if(start < end)
        {
            int mid = (start + end) / 2;
            MergeSort(arr, start, mid);
            MergeSort(arr, mid+1, end);
            Merger(arr,start,mid,end);
        }
    }

    private static void Merger(int[] arr, int start, int mid, int end) {
        int len = arr.length;
        int result[] = new int[len];
        int i = start, j = mid+1, k = 0;
        while(i<= mid && j<=end){
            if(arr[i] < arr[j])
            {
                result[k++] = arr[i++];
            }
            else{
                result[k++] = arr[j++];
            }
        }
        while(i <= mid) result[k++] = arr[i++];
        while(j <= end) result[k++] = arr[j++];
        int ind = 0;
        for(i = start;i<=end;i++)
        {
            arr[i] = result[ind++];
        }
    }