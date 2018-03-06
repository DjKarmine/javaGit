class MyQuickSort
{
  public static void main(String[] args) {
      int[] arr = {5,4,3,1,2,8,6,7};
      int len = arr.length;

      MyQuickSort obj = new MyQuickSort();
      obj.QuickSort(arr,0,len-1);
      System.out.print("Sorted Array: \n");
      obj.printArray(arr);

      }
  static void printArray(int arr[])
  {
    for(int a : arr)
    System.out.print(a + " ");
  }
  //partition the array such that elements smaller than pivot are ahead of it and elements larger than pivot are after it
  public int partition(int[] arr,int l,int r) //l: starting of array,r: end of array
  {
    int pivot = arr[r]; //taking the last element of the array as the pivot
    int i=l-1; //i marks array that has been covered
    for(int j=l;j<r;j++)
    {
      if(arr[j] <= pivot)
      {
        i++;
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
      }
      //if(arr[j] > pivot) then we do not need to do anything
    }
    //swap pivot to its exact position
    int temp = arr[i+1];
    arr[i+1] = arr[r];
    arr[r] = temp;

  //  for(int a : arr)
  //  System.out.print(a + " ");

//    for(int a : arr)
//    System.out.println();

    return i+1;
  }
  public void QuickSort(int[] arr,int l,int r)
  {
    if(l<r)
    {
      int pivot = partition(arr,l,r);   //System.out.println("Pivot :" + pivot);
      QuickSort(arr,l,pivot-1);
      QuickSort(arr,pivot+1,r);
    }
  }
}
