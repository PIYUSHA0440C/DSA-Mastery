class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int length = s.length();
        for(int i = length - 1; i >= 0; i--){
            if(s.charAt(i) == ' ') return length - i - 1;
        }
        return length;
    }
}

