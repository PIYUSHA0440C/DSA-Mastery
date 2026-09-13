class Solution {
    public int arrangeCoins(int n) {
        long start = 1, end = n;

        while(start <= end) {
            long mid = start + (end - start) / 2;

            long coins_needed = mid * (mid + 1) / 2;

            if (coins_needed == n) return (int) mid;
            else if (coins_needed < n) start = mid + 1;
            else end = mid - 1;
        }

        return (int) end;
    }
}
