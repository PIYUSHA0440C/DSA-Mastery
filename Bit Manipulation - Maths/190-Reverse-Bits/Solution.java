class Solution {
    public int reverseBits(int n) {
        int result = 0;

        for(int i = 0; i < 32; i++){
            int bit = n & 1;                // Last bit of the current n
            result = (result << 1) | bit;   // Store the calculation of result and the bit in result
            n >>>= 1;                      // Unsigned right-shift so work for both positive and negative
        }
        
        return result;
    }
}
