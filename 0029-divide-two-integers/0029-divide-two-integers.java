class Solution {
    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean negative = (dividend < 0) ^ (divisor < 0);

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int result = 0;

        while (a >= b) {

            long temp = b;
            int multiple = 1;

            while (a >= temp * 2) {
                temp = temp * 2;
                multiple = multiple * 2;
            }

            a = a - temp;
            result = result + multiple;
        }

        return negative ? -result : result;
    }
}