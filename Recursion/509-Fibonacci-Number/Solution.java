class Solution {
    public int fib(int n) {
        return fiboNum(n);
    }
    int fiboNum(int n){
        if(n == 0 ||n == 1) return n;
        return fiboNum(n-1) + fiboNum(n-2);
    }
}
