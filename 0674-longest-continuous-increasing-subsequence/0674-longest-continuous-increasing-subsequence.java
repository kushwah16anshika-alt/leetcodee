class Solution 
{
    public int findLengthOfLCIS(int[] nums) 
    {
         if (nums.length == 0)
            return 0;

        int i = 1;
        int count = 1;
        int max = 1;
        while(i<nums.length)
        {
            if(nums[i]>nums[i-1])
            {
                count++;
            }
            else
            {
                count = 1;
            }
            if (count > max) 
            {
                max = count;
            }

            i++;
        }
       
        return max;
    }
}