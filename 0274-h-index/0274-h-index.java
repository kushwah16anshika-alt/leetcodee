class Solution 
{
    public int hIndex(int[] arr) 
    {
        Arrays.sort(arr);

      for(int i = 0; i < arr.length; i++) 
      {
         if(arr[i]>=arr.length-i)
         {
           return arr.length - i;
         }
      }

      
      return 0;
    }
}