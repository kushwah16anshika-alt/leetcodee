class Solution 
{
    public int maxSubarraySumCircular(int[] nums) 
    {
        int totalsum = 0;
        
        int maxsum = nums[0];
        int curmax = 0;
        
        int minsum = nums[0];
        int curmin = 0;

        for(int num: nums)
        {
            curmax=Math.max(num,curmax+num);
            maxsum=Math.max(maxsum,curmax);
            
            curmin = Math.min(num, curmin + num);
            minsum=Math.min(minsum,curmin);

            totalsum+=num;
        }
        if(maxsum<0)
        {
            return maxsum;
        }
       return Math.max(maxsum,totalsum-minsum);
    }
}