import java.util.*;

class QuickSort{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int array[] = new int[N];
        for(int i=0;i<N;i++)
        {
            array[i] = sc.nextInt();
        }
        partition(array,0,N-1);
        for(int i = 0;i<N;i++)
        {
            System.out.print(array[i]+" ");
        }
    }
    public static void partition(int[] array,int start,int end)
    {
        if(start<end)
        {
            int k = quickSort(array,start,end);
            partition(array, start, k-1);
            partition(array,k+1,end);
        }
    }
    public static int quickSort(int[] array,int start,int end)
    {
        int temp  = start,i=start;
        while(i<end)
        {
            if(array[i] < array[end])
            {
                swap(array,temp,i);
                temp++;
            }
            i++;
        }
        swap(array,temp,end);
        return temp;
    }
    public static void  swap(int[] array,int t1,int t2)
    {
        int temp = array[t1];
        array[t1] = array[t2];
        array[t2] = temp; 
    }
}