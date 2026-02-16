class Solution {
    public int hammingDistance(int x, int y) {
        int z=x^y;
        int c=0;
        while(z>0){
            z=z&(z-1);
            c++;
        }
        return c;
    }
}

// class Solution {
//     public int hammingDistance(int x, int y) {
//         int count = 0;
//         while(x != 0 || y != 0){
//             int xBit = x & 1;
//             int yBit = y & 1;
//             count +=  xBit ^ yBit;
//             x >>= 1;
//             y >>= 1;
//         }
//         return count;
//     }
// }
