class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
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
        List<Integer> ans = new ArrayList<>();
        for(i = 0; i < len; i++){
            if(nums[i] != i + 1){
                ans.add(i+1);
            }
        }
        return ans;
    }
    void swap(int[] nums, int current, int correct){
        int temp = nums[correct];
        nums[correct] = nums[current];
        nums[current] = temp;
    }
}
