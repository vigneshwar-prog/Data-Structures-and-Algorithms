import java.sql.Time;
import java.util.*;

class SJFS{

    static class Time implements Comparable<Time>{
        int sTime,eTime;
        Time(){
            sTime = 0;
            eTime = 0;
        }
        Time(int sTime,int eTime)
        {
            this.sTime = sTime;
            this.eTime = eTime;
        }
        public int compareTo(Time time){  
            if(eTime>=time.eTime)  
            return -1;  
            else  
            return 1;  
        }  
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Time min = new Time();
        min.sTime = 99999;
        min.eTime = 99999;
        Time time[] = new Time[N];
        for(int i=0;i<N;i++)
        {
            
            int stime = sc.nextInt(),eTime = sc.nextInt();
            time[i] = new Time(stime,eTime);
            if(min.sTime > time[i].sTime)
            {
                min.sTime = time[i].sTime;
                min.eTime = time[i].eTime;
            }
            else if(min.sTime  == time[i].sTime && min.eTime > time[i].eTime)
            {
                min.sTime = time[i].sTime;
                min.eTime = time[i].eTime;
            }
        }
        PriorityQueue<Time> heap = new  PriorityQueue<Time>();
        int total = min.eTime;
        int count = 1;
        while(count < N)
        {
            for(int i=0;i<N;i++)
            {
                if(time[i].sTime <= total)
                {
                    heap.add(time[i]);
                }
            }
        }
        while(heap.size() > 0)
        {
            System.out.print(heap.poll()+" ");
        }
    }
}