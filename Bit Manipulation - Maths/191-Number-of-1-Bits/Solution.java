class Solution {
    public int hammingWeight(int n) {
        int result = 0;
        while(n != 0){
            int bit = n & 1;
            if(bit == 1) result++;
            n >>= 1;
        }

        return result;
    }
}
