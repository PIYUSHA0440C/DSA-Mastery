class Solution {
    public int minBitFlips(int start, int goal) {
        int num = start ^ goal;
        int result = 0;
        while(num > 0){
            if((num & 1) == 1) result++;
            num >>= 1;
        }

        return result;
    }
}
