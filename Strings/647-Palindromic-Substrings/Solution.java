class Solution {
    public int countSubstrings(String s) {
        int result = 0;
        int len = s.length();
        for(int i = 0; i < len; i++){
            for(int j = i; j < len; j++){
                if(isPalindrome(s.substring(i, j + 1))) result++;
            }
        }

        return result;
    }

    boolean isPalindrome(String s){
        int len = s.length();
        for(int i = 0; i < len / 2; i++){
            if(s.charAt(i) != s.charAt((len - 1) - i)) return false;
        }

        return true;
    }
}
