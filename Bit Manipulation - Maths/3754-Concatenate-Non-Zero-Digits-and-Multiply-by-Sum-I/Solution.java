class Solution {
    public long sumAndMultiply(int n) {
        int ans = 0;
        int sum = 0;
        int i = 1;

        while(n > 0){
            int digit = n % 10;
            n /= 10;

            if(digit == 0) continue;

            sum += digit;

            ans += digit * i;
            i *= 10;
        }

        return (long) ans * sum;
    }
}
