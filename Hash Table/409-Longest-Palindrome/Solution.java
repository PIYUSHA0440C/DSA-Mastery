class Solution {
    public int longestPalindrome(String s) {
        int[] map = new int[128];
        int result = 0;
        boolean hasOdd = false;

        for(char ch : s.toCharArray()){
            map[ch]++;
        }

        for(int val : map){
            if(val % 2 == 0){ 
                result += val;
            } else {
                result += val - 1;
                hasOdd = true;
            }
        }

        return hasOdd ? result + 1 : result;
    }
}
