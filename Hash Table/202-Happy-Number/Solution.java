class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while(n != 1 && !set.contains(n)){
            set.add(n);
            n = digitSquareSum(n);
        }

        return n == 1;
    }

    int digitSquareSum(int n){
        int ans = 0;
        while(n > 0){
            int digit = n % 10;
            ans += digit * digit;
            n /= 10;
        }

        return ans;
    }
}
