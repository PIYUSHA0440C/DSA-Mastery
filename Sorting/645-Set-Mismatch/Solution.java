class Solution {
    public int[] findErrorNums(int[] nums) {
        int len = nums.length;
        int i = 0;
        while(i < len){
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]){
                swap(nums, i, correct);
            } else {
                i++;
            }
        }

        for(i = 0; i < len; i++){
            int num = nums[i];
            int index = i + 1;
            if(num != index){
                return new int[]{num, index};
            }
        }

        return new int[]{-1,-1};

    }
    void swap(int[] nums, int current, int correct){
        int temp = nums[current];
        nums[current] = nums[correct];
        nums[correct] = temp;
    }
}
