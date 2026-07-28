class Solution {
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        int len = nums.length;
        for(int i = 0; i < len; i++){
            int min = nums[i];
            int max = nums[i];
            for(int j = i + 1; j < len; j++){
                if(nums[j] < min) min = nums[j];
                else if(nums[j] > max) max = nums[j];

                sum += max - min;
            }
        }
        return sum;
    }
}
