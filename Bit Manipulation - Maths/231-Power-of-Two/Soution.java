class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}

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
