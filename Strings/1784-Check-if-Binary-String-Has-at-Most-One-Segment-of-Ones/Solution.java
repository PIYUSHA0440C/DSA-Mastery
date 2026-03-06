class Solution {
    public boolean checkOnesSegment(String s) {
        int i = s.length() - 1;
        while(i >= 0 && s.charAt(i) == '0'){
            i--;
        }

        while(i >= 0){
            if(s.charAt(i) == '0') return false;
            i--;
        }

        return true;
    }
}
