class Solution {
    public int totalFruit(int[] fruits) {

        int type1 = -1;
        int type2 = -1;

        int lastCount = 0;
        int cur = 0;
        int ans = 0;

        for (int fruit : fruits) {

            if (fruit == type1 || fruit == type2) {
                cur++;
            } 
            else {
                cur = lastCount + 1;
            }

            if (fruit == type2) {
                lastCount++;
            } 
            else {
                lastCount = 1;
                type1 = type2;
                type2 = fruit;
            }

            ans = Math.max(ans, cur);
        }

        return ans;
    }
}