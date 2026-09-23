import java.util.*;

class Solution 
{
    public int[] advantageCount(int[] nums1, int[] nums2) 
    {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int x : nums1)
            map.put(x, map.getOrDefault(x, 0) + 1);

        int[] ans = new int[nums2.length];

        for(int i = 0; i < nums2.length; i++)
        {
            Integer x = map.higherKey(nums2[i]);

            if(x == null)
                x = map.firstKey();

            ans[i] = x;

            if(map.get(x) == 1)
                map.remove(x);
            else
                map.put(x, map.get(x) - 1);
        }

        return ans;
    }
}