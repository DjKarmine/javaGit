
//Permute all possible combinations of a given String
//The soltion is by using BackTracking technique
//Time complexity of the algorithm is O(N * N!)
//Algorithm Source: GeeksForGeeks

class Permutation {
	public static void main (String[] args) {
    String str = "ABCD";
    int len = str.length();
    Permutation obj = new Permutation();
    obj.permute(str,0,len-1);

  }

  public void permute(String myStr,int l,int r)
  {
    if(l==r)
      System.out.println(myStr);
    for(int i= l; i<=r ;i++){
      {
        myStr = swap(myStr,l,i);
        permute(myStr,l+1,r);
        myStr = swap(myStr,l,i);
      }
    }
  }

  public String swap(String a,int i,int j)
  {
    char arr[] = a.toCharArray();
    char temp;
    temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
    return String.valueOf(arr);
  }
}
