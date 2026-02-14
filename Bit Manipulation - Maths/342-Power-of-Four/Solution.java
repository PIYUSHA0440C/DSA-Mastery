class Solution {
    public boolean isPowerOfFour(int n) {
        if(n <= 0) return false;
        while(n % 4 == 0){
            n /= 4;
        }

        return n == 1;
    }
}
// class Solution {
//     public boolean isPowerOfFour(int n) {
//         for(int i = 0; Math.pow(4,i) <= n; i++){
//             if(Math.pow(4,i) == n) return true;
//         }
//         return false;
//     }
// }
