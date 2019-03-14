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


  public static void main(String[] args){


    //{1,3,4,5,6,7,9}
    for (int i =0;i<1000;i++){
      int[] data = {1};
      if (quickselect(data,0)!=1) {
        System.out.println("false");
      }
    }
  }
}
