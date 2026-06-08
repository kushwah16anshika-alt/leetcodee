class Solution 
{
    public int minPairSum(int[] nums) 
    {
        int maxnum=0;
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n/2;i++)
         {
           int pairsum=nums[i]+nums[n-1-i];
           if(pairsum>maxnum)
           {
            maxnum=pairsum;
           }

         }
        
        return maxnum; 
    }
}