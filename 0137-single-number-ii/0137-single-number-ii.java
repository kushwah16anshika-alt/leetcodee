class Solution 
{
    public int singleNumber(int[] nums) 
    {
       int result=0;
       for(int i=0;i<32;i++)
       {
        int temp=(1<<i);

        int countone =0;
        for (int num:nums)
        {
            if((num & temp)!=0)
            {
                countone++;
            }
        }
        if(countone %3==1)
        {
            result |=temp;
        }
       }
        return result;
    }
}