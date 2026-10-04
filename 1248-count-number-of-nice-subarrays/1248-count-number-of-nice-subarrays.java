class Solution {
    public int numberOfSubarrays(int[] nums, int k) 
    {
        int left = 0;
        int odd = 0;
        int count = 0;
        int ans = 0;

        for(int right = 0; right < nums.length; right++)
        {
            if(nums[right] % 2 != 0)
            {
                odd++;
                count = 0;
            }

            while(odd > k)
            {
                if(nums[left] % 2 != 0)
                {
                    odd--;
                }
                left++;
            }

            if(odd == k)
            {
                while(left <= right && nums[left] % 2 == 0)
                {
                    count++;
                    left++;
                }

                ans += count + 1;
            }
        }

        return ans;
    }
}