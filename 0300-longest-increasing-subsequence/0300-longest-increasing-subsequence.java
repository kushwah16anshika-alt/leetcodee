class Solution 
{
    private int n;
    private int [][]t;

    public int lis(int []nums, int prev,int curr)
    {
        if(curr==n)
        return 0;

        if(prev != -1 && t[prev][curr]!=-1)
        {
            return t[prev][curr];
        }
        int taken = 0;

        if(prev==-1 || nums[curr]>nums[prev])
        {
            taken =1 + lis(nums,curr,curr+1);
        }
        
        int nottaken=lis(nums,prev,curr+1);

        if(prev != -1)
        {
            t[prev][curr] = Math.max(taken,nottaken);
        }
        return Math.max(taken,nottaken);
    }
    public int lengthOfLIS(int[] nums) 
    {
        n=nums.length;

        t= new int [n][n];

        for(int []row:t)
        {
            Arrays.fill(row,-1);
        }

        return lis(nums,-1,0);
    }
}