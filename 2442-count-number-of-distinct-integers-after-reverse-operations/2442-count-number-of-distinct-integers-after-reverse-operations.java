class Solution {
    public int countDistinctIntegers(int[] nums) 
    {
        HashSet<Integer> map = new HashSet<>();
        int n=nums.length;
        int nums1[]=new int [n*2];
      
        for(int i=0;i<n;i++)
        {
            nums1[i]=nums[i];
            map.add(nums[i]);
            int num=nums[i];
            int rev=0;
            while(num>0)
            {
                int digit =num%10;
                rev=rev*10+digit;
                num=num/10;
            }
            nums1[n+i]=rev;
        }

        int count = map.size();

        for (int j = 0; j < nums1.length; j++)
         {

            if (map.contains(nums1[j])) 
            {
                continue;
            } 
            else 
            {
                map.add(nums1[j]); 
                count++;
            }
        }
        return count;
    }
}