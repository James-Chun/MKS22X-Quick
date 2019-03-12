import java.util.Random;
import java.util.*;

public class Partition{
  /*Choose a random pivot element between the start and end index inclusive,
 Then modify the array such that:
 *1. Only the indices from start to end inclusive are considered in range
 *2. A random index from start to end inclusive is chosen, the corresponding
 *   element is designated the pivot element.
 *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
 *4. all elements in range that are larger than the pivot element are placed after the pivot element.
 *@return the index of the final position of the pivot element.
 */
private static Random rand = new Random();


public static int partition ( int[] data, int start, int end){
    if (start==end)end++;
    int pivot = Math.abs(rand.nextInt() % (end - start) ) ; //making seed from that randgen

    //System.out.println("PIVOT1:"+pivot);
    pivot += start;
    int temp = 0;
    if (start!=end){
      temp = data[start];
      data[start]=data[pivot];
      data[pivot]=temp;
      start++;
      pivot = start-1;
    }
    //System.out.println("PIVOT:"+pivot);
    //System.out.println("START:"+start);

    while (start<end){

      //System.out.println(start);System.out.println(end);
      //System.out.println(visual(data));
      //System.out.println("END:"+end);
      //System.out.println("START:"+start);

      if (data[start]>data[pivot]){
        temp = data[end];
        data[end]=data[start];
        data[start]=temp;
        end--;
      }
      else if (data[start]<data[pivot]){
        start++;
      }
    }

      if (data[pivot]>data[start]){
        temp = data[start];
        data[start]=data[pivot];
        data[pivot]=temp;
        return start;
      }
      if (data[pivot]<data[start]){
        temp = data[start-1];
        data[start-1]=data[pivot];
        data[pivot]=temp;
      }
      return start-1;
}


private static String visual(int[] data){
  String visual = "[";
    for (int v = 0; v < data.length; v++){
        visual = visual + data[v];
        if (v<data.length-1 ) visual += ", ";
    }
    return visual +"]";
}


public static void main(String[] args){
  /*int[] data = {1, 2, 3, 4, 5,6,7,8,9,10,11};
  int p = partition(data,0,10);
  System.out.println(p);
  System.out.println(visual(data));
  System.out.println("____");
  System.out.println(partition(data,0,p-1));
  System.out.println(visual(data));
  /*for (int i=0;i<500;i++){
    int pivot = Math.abs(rand.nextInt() % (data.length) ) ; //making seed from that randgen
    if (pivot >10){System.out.println(pivot);}
  }*/
}


}
