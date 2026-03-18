class Solution {
    public int[] twoSum(int[] ar, int target)
     {
        int n=ar.length;
        for(int i=0;i<n-1;i++)
         {
            for(int j=i+1;j<n;j++)
             {
                if(ar[i]+ar[j]==target)
                {
                    return new int[]{i,j}; 
                }
             }
         }
         return new int[]{}; 
    }
}