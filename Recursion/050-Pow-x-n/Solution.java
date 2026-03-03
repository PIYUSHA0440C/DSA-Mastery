class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(x == 0 || x == 1) return x;
        long N = n;
        if(n < 0){
            N = -n;
            x = 1 / x;
        }

        return pow(x, N);
    }
    double pow(double x, long n){
        if(n == 0) return 1;
        if(n == 1) return x;

        double half = pow(x, n / 2);

        if(n % 2 == 0) return half * half;
        
        return half * half * x;
    }
}
