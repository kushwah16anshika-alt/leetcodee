class Solution {
    public boolean uniformArray(int[] nums1) 
    {
        
        boolean even = false;
        boolean odd = false;

        for (int num : nums1) 
        {
            if (num % 2 == 0)
                even = true;
            else
                odd = true;
        }

        if (even && odd)
            return true;

        return true;
    }
}