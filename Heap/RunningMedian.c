#include <stdio.h>
#include <Math.h>

int minIndex = 0,maxIndex = 0;
int minHeap[100],maxHeap[100];
void swap(int *p1,int* p2)
{
    int temp = *p1;
    *p1= *p2;
    *p2 = temp;
}

void insertAtmaxHeap(int data){
    maxHeap[++maxIndex] = data;
    int k = maxIndex;
    while(k/2 > 0){
        if(maxHeap[k] > maxHeap[k/2]){
            swap(&maxHeap[k],&maxHeap[k/2]);
            k = k/2;
        }
        else{
            break;
        }
    }
}

void insertAtminHeap(int data){
    minHeap[++minIndex] = data;
    int k = minIndex;
    while(k/2 > 0){
        if(minHeap[k] < minHeap[k/2]){
            swap(&minHeap[k],&minHeap[k/2]);
            k = k/2;
        }
        else{
            break;
        }
    }
}
void minHeapify()
{
    int k = 1,min;
    while(2*k <= minIndex)
    {
        if(2*k+1 <= minIndex){
            min = minHeap[2*k] < minHeap[2*k+1] ? 2*k : 2*k+1;
        }
        else{
            min = 2*k;
        }
        if(minHeap[min] < minHeap[k]){
            swap(&minHeap[min],&minHeap[k]);
            k = min;
        }
        else{
            break;
        }
    }
}
void maxHeapify()
{
    int k = 1,max;
    while(2*k <= maxIndex)
    {
        if(2*k+1 <= maxIndex){
            max = maxHeap[2*k] > maxHeap[2*k+1] ? 2*k : 2*k+1;
        }
        else{
            max = 2*k;
        }
        if(maxHeap[max] > maxHeap[k]){
            swap(&maxHeap[max],&maxHeap[k]);
            k = max;
        }
        else{
            break;
        }
    }
}
int main(){
    int N;
    scanf("%d",&N);
    float currentMedian = 0;
    for(int i=0;i<N;i++)
    {
        int k;
        scanf("%d",&k);
        if(currentMedian > k)
        {
            insertAtmaxHeap(k);
        }
        else{
            insertAtminHeap(k);
        }
        if(abs(maxIndex - minIndex) > 1){
            if(maxIndex > minIndex){
                swap(&maxHeap[maxIndex--],&maxHeap[1]);
                maxHeapify();
                insertAtminHeap(maxHeap[maxIndex+1]);
            }
            else{
                swap(&minHeap[minIndex--],&minHeap[1]);
                minHeapify();
                insertAtmaxHeap(minHeap[minIndex+1]);
            }
        }
        if(maxIndex == minIndex)
        {
            currentMedian = (maxHeap[1] + minHeap[1])/2.0;
        }
        else if(maxIndex > minIndex){
            currentMedian = maxHeap[1];
        }
        else{
            currentMedian = minHeap[1];
        }
        printf("-%.2f-",currentMedian);
    }
}