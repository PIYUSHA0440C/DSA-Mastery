class Solution {
    public List<Integer> findDuplicates(int[] nums) {
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

        List<Integer> duplicates = new ArrayList<>();
        for(i = 0; i < len; i++){
            int num = nums[i];
            if(num != i + 1){
                duplicates.add(num);
            }
        }
        return duplicates;
    }
    void swap(int[] nums, int current, int correct){
        int temp = nums[current];
        nums[current] = nums[correct];
        nums[correct] = temp;
    }
}
