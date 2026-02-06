class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];
        int prefix = 1;
        for(int i = 0; i < len; i++){
            answer[i] = prefix;
            prefix *= nums[i];
        }
        int postfix = 1;
        for(int i = len - 1; i >= 0; i--){
            answer[i] = postfix * answer[i];
            postfix *= nums[i];
        }
        return answer;
    }
}
// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int len = nums.length;
//         int[] answer = new int[len];
//         for(int i = 0; i < len; i++){
//             int product = 1;
//             for(int j = 0; j < len; j++){
//                 if(j != i){
//                     product *= nums[j];
//                 }
//             }
//             answer[i] = product;
//         }
//         return answer;
//     }
// }
