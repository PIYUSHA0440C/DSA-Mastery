class Solution {
    public boolean isPowerOfThree(int n) {
        return helper(n);
    }

    boolean helper(int n){
        if(n == 3 || n == 1) return true;

        if(n > 0 && n % 3 == 0) return helper(n / 3);
        else return false;
    }
}
