import java.util.*;

public class Quick{
  /*return the value that is the kth smallest value of the array.
  */
  public static int quickselect(int []data, int k){
    if (data.length==1)return data[0];
    int start = 0;
    int end = data.length-1;
    int pivoted = start;
    while (start!=end){
      pivoted = Partition.partition(data,start,end);
      if (pivoted==k)return data[pivoted];
      if (pivoted > k)end=pivoted-1;
      else if (pivoted < k)start = pivoted +1;
    }
    return data[k];
  }



  public static void quicksort(int []data){
     qh (data, 0, data.length-1);
 }
     // helper? with start and end
 public static void qh(int []data, int lo, int hi){
     if (lo < hi){
     int pivot = Partition.partition(data, lo, hi);
     // when a = k, you are done.

     qh(data, lo, pivot);
     qh(data, pivot + 1, hi);
    }

}


public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Quick.quicksort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
}
}
