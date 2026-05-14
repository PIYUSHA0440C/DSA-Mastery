class Solution {
    public boolean isGood(int[] nums) {
        int len = nums.length - 1;

        int[] freq = new int[len];
        for(int num : nums){
            if(num > len) return false;
            freq[num - 1]++;
        }

        for(int i = 0; i < len; i++){
            int num = freq[i];
            if(num < 1 || (num > 1 && !(i == len - 1))) return false;
        }
        return true;
    }
}
