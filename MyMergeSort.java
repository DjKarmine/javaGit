class MyMergeSort
{
  public static void main(String[] args) {
    int  values[] = {4,3,2,1,4,7,7,8};
    int lengthOfValues = values.length;

    System.out.println("Initial Array: ");
    printArray(values);

    MyMergeSort obj = new MyMergeSort();
    obj.sort(values,0,lengthOfValues-1);

    System.out.println("Sorted Array: ");
    printArray(values);
  }

  public static void printArray(int arr[])
  {
    for(int a : arr)
     System.out.print(a + " ");

    System.out.println();
  }
  public void sort(int arr[], int beginning, int end)
   {
       if (beginning < end)
       {
           // Find the middle point
           int middle = (beginning+end)/2;

           // Sort first and second halves
           sort(arr, beginning, middle);
           sort(arr , middle+1, end);

           // Merge the sorted halves
          merge(arr, beginning, middle, end);
       }
   }

  public  void merge(int mergedArr[],int beginning,int middle,int end)
  {

    int n1 = middle-beginning+1;
    int n2 = end - middle;
    int[]  subArray1 = new int[n1];
    int[]  subArray2 = new int[n2];

    for(int i=0;i<n1;i++)
      subArray1[i] = mergedArr[beginning + i];
    for(int j=0;j<n2;j++)
      subArray2[j] = mergedArr[middle+1+j];

    int i=0,j=0;
    int k=beginning;
    while(i<n1 && j<n2)
    {
        if (subArray1[i] <= subArray2[j])
        {
          mergedArr[k] = subArray1[i];
          i++;
        }
        else
        {
          mergedArr[k] = subArray2[j];
          j++;
        }
        k++;
    }
    while (i < n1)
  {
      mergedArr[k] = subArray1[i];
      i++;
      k++;
  }

  while (j < n2)
  {
      mergedArr[k] = subArray2[j];
      j++;
      k++;
  }

  }
}
