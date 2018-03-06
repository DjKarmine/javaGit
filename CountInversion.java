/*
Count number of inversions in an array that may be needed to make it a sorted Array
*/
import java.util.*;
class CountInversion
{
  public static void main(String[] args) {
    int arr[] ={1,3,5,2,4,6};

    System.out.println(invert(arr,3,arr.length));

  }
static int invert(int[] arr,int k,int n)
{
  int count =0;
  for(int start = 0;start<n-k+1;start++)
  {
    int[] subArray = new int[k];
    for(int i=start;i<start+k;i++)
    {
      subArray[i - start] = arr[i];
    }
    count +=sortedCount(subArray);
  }
  return count;
}
  public static int sortedCount(int arr[]){
    if (arr.length<2)  return 0;

    int x=0,y=0,z=0;
    int m = (arr.length+1)/2;
    int b[] = Arrays.copyOfRange(arr,0,m);

    int c[] = Arrays.copyOfRange(arr,m,arr.length);

        x = sortedCount(b);
        //System.out.println(x);
        y = sortedCount(c);
        //System.out.println(y);
        z = mergeSortedCount(arr,b,c);

    return x+y+z;
  }

public static int mergeSortedCount(int arr[],int b[],int c[])
  {
     //Arrays.sort(b);
     //Arrays.sort(c);

        int i=0,j=0,count=0;
        int k=0;
        while(i<b.length && j<c.length)
        {
            if (i == b.length)
            {
              arr[k] = c[j];
              j++;
            }
            else if(j==c.length)
            {
              arr[k] = b[i];
              i++;
            }
            else if (b[i] <= c[j])
            {
              arr[k] = b[i];
              i++;
            }
            else
            {
              arr[k] = c[j];
              count += b.length - i;
              j++;
            }
            k++;
        }

    return count;
  }
}
