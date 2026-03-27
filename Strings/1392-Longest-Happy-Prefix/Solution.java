class Solution {
    public String longestPrefix(String s) {
        int[] lps = new int[s.length()];
        int len = 0;

        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(len)){
                len++;
                lps[i] = len;
            } else if (len != 0) {
                len = lps[len - 1];
                i--;
            }
        }   

        return s.substring(0, lps[s.length() - 1]);
    }
}
