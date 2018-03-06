class KthSmallest
{
  public static void main(String[] args) {
    int[] arr = {5,4,3,1,2,8,6,7};
    int len = arr.length;
    int k =3;
    System.out.print(kthSmallest(arr,0,len-1,k));

  }
  //partition the array such that elements smaller than pivot are ahead of it and elements larger than pivot are after it
  public static int partition(int[] arr,int l,int r) //l: starting of array,r: end of array
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

    return i+1;
  }
  public static int kthSmallest(int arr[], int l, int r, int k)
{
    // If k is smaller than number of
    // elements in array
    // 1st:(3 > 0 && 3 <= 7 - 0 + 1) 2nd: (3 > 0 && 3 <= 5 - 0 + 1)
    if (k > 0 && k <= r - l + 1) {

        // Partition the array around last element
        // and get position of pivot element in sorted array
        int index = partition(arr, l, r);

        // If position is same as k
        // 1st:(6     - 0 == 3 - 1) 2nd: (2     - 0 == 3 - 1)
        if (index - l == k - 1)
            return arr[index];

        // If position is more, recur
        // for left subarray
        // 1st:(6     - 0 > 3 - 1)
        if (index - l > k - 1)
            return kthSmallest(arr, l, index - 1, k);
                            //1st:(arr, 0, 6     - 1, 3);
        // Else recur for right subarray
        return kthSmallest(arr, index + 1, r,
                            k - index + l - 1);
    }

    // If k is more than number of
    // elements in array
    return 10000;
}
}
