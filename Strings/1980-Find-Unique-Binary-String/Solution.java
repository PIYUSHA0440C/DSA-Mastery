class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set = new HashSet<>();
        int len = nums[0].length();

        for(String str : nums){
            if(!set.contains(str)){
                set.add(str);
            }
        }
        set.add("");
        return helper("",set, len);
    }

    String helper(String up,HashSet<String> set, int len){
        if(up.length() == len && !set.contains(up)) return up;
        if(up.length() == len) return "";

        String ans = helper(up+'0', set, len);
        
        if(ans != ""){
            return ans;
        }
        return helper(up+'1', set, len);

    }

}


// class Solution {
//     public String findDifferentBinaryString(String[] nums) {
//         StringBuilder result = new StringBuilder();
//         for (int i = 0; i < nums.length; i++) {
//             // For the i-th number, we look at the i-th character.
//             // If the i-th character is '0', we append '1' to our result.
//             // If the i-th character is '1', we append '0'.
//             result.append(nums[i].charAt(i) == '0' ? '1' : '0');
//         }
//         return result.toString();
//     }
// }
