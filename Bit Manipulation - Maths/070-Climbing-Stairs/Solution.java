class Solution {
    public int climbStairs(int n) {
        if(n < 3) return n;

        int n1 = 1, n2 = 2;
        while( n - 2 > 0){
            n2 = n2 + n1;
            n1 = n2 - n1;
            n--;
        }

        return n2;
    }
}
