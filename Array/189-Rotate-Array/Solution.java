class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length ;
        k %= len;

        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }
    void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}














// class Solution {
//     public void rotate(int[] nums, int k) {
//         int len = nums.length - 1;
//         int ptr = 0;
//         int temp = nums[ptr];
//         for(int i = 0; i <= len; i++){
//             if(len - ptr < k){
//                 ptr = k - (len - ptr) - 1;
//                 int current = nums[ptr];

//                 nums[ptr] = temp;
//                 temp = current;
//             } else {
//                 ptr += k;
//                 int current = nums[ptr];
//                 nums[ptr] = temp;
//                 temp = current;
//             }
//         }
//     }
// }
