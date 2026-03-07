class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        boolean negative = (dividend < 0) ^ (divisor < 0);

        int a = dividend < 0 ? dividend : -dividend;
        int b = divisor < 0 ? divisor : -divisor;

        int result = 0;
        
        while (a <= b) {
            int temp = b;
            int multiple = 1;
            
            while (temp >= (Integer.MIN_VALUE >> 1) && a <= (temp + temp)) {
                temp += temp;
                multiple += multiple;
            }
            
            a -= temp;
            result += multiple;
        }

        return negative ? -result : result;
    }
}
