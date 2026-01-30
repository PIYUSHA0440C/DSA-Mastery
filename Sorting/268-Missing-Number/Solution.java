class Solution {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int totalSum = 0, arraySum = 0;
        for(int num : nums){
            arraySum+=num;
        }
        totalSum=(length)*(length+1)/2;
        return totalSum - arraySum;

    }
}
// class Solution {
//     public int missingNumber(int[] nums) {
//         int length = nums.length;
//         int i = 0;
//         while(i < length){
//             int correct = nums[i];
//             if(nums[i] < length && nums[i] != nums[correct]){
//                 swap(nums, i, correct);
//             } else {
//                 i++;
//             }

//         }
//         for(i = 0; i < length; i++){
//             if(nums[i] != i) return i;
//         }
//         return length;
//     }
//     void swap(int[] nums, int current, int correct){
//         int temp = nums[correct];
//         nums[correct] = nums[current];
//         nums[current] = temp;
//     }
// }
