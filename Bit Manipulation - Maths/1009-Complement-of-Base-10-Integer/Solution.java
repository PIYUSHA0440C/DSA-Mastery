class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1;

        int mask = 1;
        while(mask < n){
            mask = (mask << 1) | 1;
        }

        return n ^ mask;
    }
}


// class Solution {
//     public int bitwiseComplement(int n) {
//         if(n == 0) return 1;

//         int num = 0;
//         int count = 0;
//         while(n != 0){
//             int bit = n & 1;
//             num = (num << 1) | bit;
//             n >>= 1;
//             count++;
//         }
//         int complement = 0;
//         for(int i = 0; i < count; i++){
//             int bit = num & 1;
//             complement = (complement << 1) | ( bit == 1  ? 0 : 1);
//             num >>= 1;
//         }
//         return complement;
//     }
// }
