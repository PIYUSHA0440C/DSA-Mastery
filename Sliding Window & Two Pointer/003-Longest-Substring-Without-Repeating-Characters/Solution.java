class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int maxLen = 0;

        for(int i = 0; i < len; i++){
            int[] hash = new int[256];
            Arrays.fill(hash, 0);

            for(int j = i; j < len; j++){
                if(hash[s.charAt(j)] == 1) break;
                hash[s.charAt(j)] = 1;

                int tempLen = j - i + 1;
                maxLen = Math.max(maxLen, tempLen); 
            }
        }

        return maxLen;
    }
}
