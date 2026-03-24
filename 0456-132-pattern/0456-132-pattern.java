import java.util.*;

class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int second = Integer.MIN_VALUE; // this is nums[k]

        for (int i = n - 1; i >= 0; i--) {

            // If we find nums[i] < second → 132 pattern exists
            if (nums[i] < second) {
                return true;
            }

            // Update second (nums[k])
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                second = stack.pop();
            }

            // Push current as potential nums[j]
            stack.push(nums[i]);
        }

        return false;
    }
}