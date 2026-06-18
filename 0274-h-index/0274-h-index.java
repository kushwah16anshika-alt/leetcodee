class Solution 
{
    public int hIndex(int[] arr) 
    {
        Arrays.sort(arr);

      for(int i = 0, j = arr.length - 1; i < j; i++, j--) 
      {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      }

      int k=0,l=arr.length;
      int hindex=1;
      int count=0;
      while(k<l)
      {
        if(hindex<=arr[k])
        {
            count++;
            hindex++;
        }
        else 
        {
            break;
        }
        k++;
        
      }
      return count;
    }
}