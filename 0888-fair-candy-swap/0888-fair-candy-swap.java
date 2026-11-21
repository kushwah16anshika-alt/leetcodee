
class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int sumA = 0, sumB = 0;

        for (int x : aliceSizes)
            sumA += x;

        for (int x : bobSizes)
            sumB += x;

        int diff = (sumB - sumA) / 2;

        HashSet<Integer> set = new HashSet<>();

        for (int x : bobSizes)
            set.add(x);

        for (int x : aliceSizes) 
        {
            int target = x + diff;

            if (set.contains(target))
                return new int[]{x, target};
        }

        return new int[]{};
    }
}
