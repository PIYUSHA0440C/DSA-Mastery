class Solution {
    public int[] singleNumber(int[] nums) {
        int xorAll = 0;

        for(int num : nums) xorAll ^= num;

        int diffBit = xorAll & (-xorAll);

        int x = 0;
        for(int num : nums){
            if((diffBit & num) != 0) x ^= num;
        }

        return new int[]{x, xorAll ^ x};

    }
}
