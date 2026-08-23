class Solution {
    public int maxProduct(int[] nums) {
        int maxpro = nums[0];
        int minpro = nums[0];
        int ans = nums[0];

   for(int i = 1; i < nums.length; i++)
   {
    int current = nums[i];

    int oldMax = maxpro;
    int oldMin = minpro;

    maxpro = Math.max(current,
            Math.max(oldMax * current, oldMin * current));

    minpro = Math.min(current,
            Math.min(oldMax * current, oldMin * current));

    ans = Math.max(ans, maxpro);
   }
   return ans;
    }
}