#include <stdio.h>

void swap(int* p1, int* p2)
{
    int temp = *p1;
    *p1 = *p2;
    *p2 = temp;
}
void main(){
    int N;
    scanf("%d",&N);
    int heap[N+1];
    int i= 1,k;
    scanf("%d",&heap[i++]);
    while(i <= N){
        scanf("%d",&heap[i]);
        k = i;
        while(k/2 > 0)
        {
            if(heap[k/2] < heap[k]){
                swap(&heap[k/2],&heap[k]);
                k = k/2;
            }
            else{
                break;
            }
        }
        i++;
    }
    for(int i=1;i<=N;i++)
    {
        printf("%d ",heap[i]);
    }
    printf("\n");
    int size = N,max ;
    while(size>0)
    {
        swap(&heap[1],&heap[size]);
        size--;
        i = 1;
        while(2*i<=size)
        {
            if(2*i+1 < size)
            {
                max = heap[2*i] > heap[2*i+1]?2*i:2*i+1;
            }
            else{
                max = 2*i;
            }
            if(heap[i] < heap[max]){
                swap(&heap[i],&heap[max]);
                i = max;
            }
            else{
                break;
            }
        }
    }
    for(int i=1;i<=N;i++)
    {
        printf("%d ",heap[i]);
    }

}