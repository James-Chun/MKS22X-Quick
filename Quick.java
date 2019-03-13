public class Quick{
  /*return the value that is the kth smallest value of the array.
  */
  public static int quickselect(int []data, int k){
    int start = 0;
    int end = data.length-1;
    int pivoted = start;
    while (start!=end){
      pivoted = Partition.partition(data,start,end);
      if (pivoted==k-1)return data[pivoted];
      if (pivoted > k-1)end=pivoted-1;
      else if (pivoted < k-1)start = pivoted +1;
    }
    return data[k-1];
  }


  public static void main(String[] args){


    //{1,3,4,5,6,7,9}
    for (int i =0;i<1000;i++){
      int[] data = {4,1,7,9,3,5,6};
      if (quickselect(data,7)!=9) {
        System.out.println("false");
      }
    }
  }
}
