class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}







// class Solution {
//     public void moveZeroes(int[] nums) {
//         int i = 0, j = 0;
//         int len = nums.length;
//         while(i < len){
//             if(nums[i] != 0){
//                 int temp = nums[i];
//                 nums[i] = 0;
//                 nums[j] = temp;
//                 j++;
//             }
//             i++;
//         }
//     }
// }
