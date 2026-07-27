class Solution {
    public int maxProduct(int[] nums) 
    {
        Arrays.sort(nums);
        int n=nums.length;
        int product1=(nums[n-1]-1)*(nums[n-2]-1);
        int product2=(nums[1]-1)*(nums[0]-1);

        return Math.max(product1,product2);
    }
}