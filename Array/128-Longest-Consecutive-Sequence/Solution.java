class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        int longest = 0;
        // int len = nums.length;
        for(int num : nums){
            numSet.add(num);
        }
        for(int num : numSet){
            // check if it is the start of the sequence.
            if(!numSet.contains(num - 1)){
                int seqLength = 0;
                while(numSet.contains(num + seqLength)){
                    seqLength++;
                }
                longest = Math.max(longest, seqLength);
            }
        }
        return longest;
    }
}
