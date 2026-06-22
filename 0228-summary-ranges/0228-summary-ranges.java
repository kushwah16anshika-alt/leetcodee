class Solution 
{
    public List<String> summaryRanges(int[] nums) 
    {
        List<String>ans=new ArrayList<>();
        
        if(nums.length==0)
        {
            return ans;
        }

        int start=nums[0];

        for(int i=1;i<nums.length;i++)
        {
            if((long)nums[i]!=(long)nums[i-1]+1)
            {
                int end =nums[i-1];

                if(start==end)
                {
                    ans.add(String.valueOf(start));
                }
                else
                {
                    ans.add(start+"->"+end);
                }
                start=nums[i];
            }
        }
        int end = nums[nums.length - 1];

        if (start == end)
            ans.add(String.valueOf(start));
        else
            ans.add(start + "->" + end);

        return ans;  
    }
}