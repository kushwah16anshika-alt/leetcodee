class Solution 
{
    public int minPairSum(int[] nums) 
    {
        int n=nums.length;
        Arrays.sort(nums);
        int result[]=new int [n/2];
        int k=0;
      for(int i=0;i<n/2;i++)
      {
        result[k++]=nums[i]+nums[n-1-i];
      }
       int maxnum=result[0];
       for(int l=1;l<result.length;l++)
       {
          if(result[l]>maxnum)
          {
            maxnum =result[l];
          }
       }
       return maxnum; 
    }
}