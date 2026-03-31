class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        String res = "";

        for(int i = 0; i < len; i++){
            int start = i, end = i;
            while(start >= 0 && end < len && s.charAt(start) == s.charAt(end)){
                start--;
                end++;
            }

            String temp = s.substring(start + 1, end);
            if(temp.length() > res.length()) res = temp;

            start = i;
            end = i + 1;
            while(start >= 0 && end < len && s.charAt(start) == s.charAt(end)){
                start--;
                end++;
            }

            temp = s.substring(start + 1, end);
            if(temp.length() > res.length()) res = temp;
        }

        return res;
    }
}
