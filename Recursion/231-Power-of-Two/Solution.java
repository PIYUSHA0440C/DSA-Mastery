class Solution {
    public boolean isPowerOfTwo(int n) {
        return helper(n);
    }

    boolean helper(int n){
        if(n == 2 || n == 1) return true;

        if(n > 0 && n % 2 == 0) return helper(n/2);
        
        return false;
    }
}

// class Solution {
//     public boolean isPowerOfTwo(int n) {
//         return n > 0 && (n & (n - 1)) == 0;
//     }
// }

// class Solution {
//     public boolean isPowerOfTwo(int n) {
//         if (n <= 0) return false;

//         for (int i = 0; i < 31; i++) {
//             if (Math.pow(2, i) == n) {
//                 return true;
//             }
//         }
//         return false;
//     }
// }
