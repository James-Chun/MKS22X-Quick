public class Quick{
  /*return the value that is the kth smallest value of the array.
  */
  public static int quickselect(int []data, int k){
    int start = 0;
    int end = data.length-1;
    int pivoted = start;
    while (start!=k-1){
      pivoted = Partition.partition(data,start,end);
      if (pivoted==k-1)return data[pivoted];
      if (pivoted > k-1)end=pivoted-1;
      else if (pivoted < k-1)start = pivoted +1;
    }
    return data[1];
  }


  public static void main(String[] args){
    int[] data = {4,1,7,9,3};
    //{1,3,4,7,9}
    System.out.println(quickselect(data,2));
  }
}
