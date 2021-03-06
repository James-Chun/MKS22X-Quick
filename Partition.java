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
    if (start==end)return start;

    //int pivot = Math.abs(rand.nextInt() % (end - start) ) ; //making random pivot
    //pivot += start;

    int pivot = (end - start)/2;
    int temp1 = 0;

    //--------------------------------------------------------------------------------------------------------------------------------------------------
    //choosing the median value for pivot instead of random
    if ( data[start] >= data[pivot] && data[start] >= data[end] ){
        if (data [pivot] >= data [start]) { temp1 = pivot; }
        else{ temp1 = start; }
    }
    else if( data[end] >= data[pivot] && data[end] >= data[start] ){
        if (data [pivot] >= data [start]){ temp1 = pivot; }
        else{ temp1 = start; }
    }
    else if ( data[pivot] >= data[start] && data[pivot] >= data[end] ){
        if (data [end] >= data [start]){ temp1 = end; }
        else{ temp1 = start; }
    }

    int temp = 0;
    if (start!=end){    //placing pivot at the front of the list
      temp = data[start];
      data[start]=data[temp1];
      data[temp1]=temp;
      start++;
      pivot = start-1;
    }
    //--------------------------------------------------------------------------------------------------------------------------------------------------
    while (start<end){    //going through the list "sorting" the values
      if (data[start]>data[pivot]){   //if start value is > pivot then switch that value with the value at the end and move end back
        temp = data[end];
        data[end]=data[start];
        data[start]=temp;
        end--;
      }
      else if (data[start]<data[pivot]){    //if value at start is < pivot then simply move start ahead since list is being looked at from left to right
        start++;
      }

      else if (data [start] == data [pivot]){   //if value being looked at is the same as pivot, use rand to get 50-50 chance of putting it on either side of pivot
            int r =  (rand.nextInt() % 2 );
            if (r == 0){
                temp = data [start];
                data [start] = data [end];
                data [end] = temp;
                end --;
            }
            else{
                start ++;
            }
        }

    }
    //--------------------------------------------------------------------------------------------------------------------------------------------------
      if (data[pivot]>data[start]){    // if pivot is greater than value at where start and end meet, switch start and pivot since all values of pivot belong on that side
        temp = data[start];
        data[start]=data[pivot];
        data[pivot]=temp;
        return start;
      }
      else if (data[pivot]<data[start]){   //if pivot is less than value at start/end, place pivot at spot right before start/end (all values before that are < pivot since the entire while loop was checking for that ya know)
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
