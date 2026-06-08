class Solution 
{
    public int minPairSum(int[] nums) 
    {
        int maxnum=0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;

        while(left < right)
        {
            maxnum = Math.max(maxnum,nums[left] + nums[right]);

            left++;
            right--;
        }
        
        return maxnum; 
    }
}