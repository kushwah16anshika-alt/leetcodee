class Solution {
    public int minSubArrayLen(int target, int[] nums) 
    {
        int left=0;
        int sum=0;
        int ans=Integer.MAX_VALUE;
        for(int rigth=0;rigth<nums.length;rigth++)
        {
            sum+=nums[rigth];

            while(sum>=target)
            {
                ans=Math.min(ans,rigth-left+1);
                sum-=nums[left];
                left++;
            }
        }
        return (ans==Integer.MAX_VALUE)?0:ans;
    }
}