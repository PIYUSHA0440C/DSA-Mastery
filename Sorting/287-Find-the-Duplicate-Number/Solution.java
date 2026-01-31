class Solution {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int i = 0;
        while(i < len){
            if(nums[i] != i+1){
                int correct = nums[i] - 1;
                if(nums[i] != nums[correct]){
                    swap(nums,i,correct);
                } else{
                    return nums[i];
                }
            } else {
                i++;
            }
        }
        return -1;
    }
    void swap(int[] nums, int current, int correct){
        int temp = nums[current];
        nums[current] = nums[correct];
        nums[correct] = temp;
    }
}
