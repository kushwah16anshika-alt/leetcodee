class Solution {
    public int[] pivotArray(int[] nums, int pivot) 
    {
        List<Integer> smaller = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        for (int num : nums) {
            if (num < pivot)
                smaller.add(num);
            else if (num == pivot)
                equal.add(num);
            else
                greater.add(num);
        }

        int[] ans = new int[nums.length];
        int k = 0;

        for (int x : smaller) ans[k++] = x;
        for (int x : equal) ans[k++] = x;
        for (int x : greater) ans[k++] = x;

        return ans;
    }
}