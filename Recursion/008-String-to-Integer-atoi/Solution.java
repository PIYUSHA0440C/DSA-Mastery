class Solution {
    final static int intMax = Integer.MAX_VALUE;
    final static int intMin = Integer.MIN_VALUE;
    static int sign = 1;

    public int myAtoi(String s) {
        int len = s.length();
        
        // White Space skip
        int i = 0;
        while(i < len && s.charAt(i) == ' ') i++;

        // Handle Sign
        int sign = 1;
        if(i < len && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Recursive helper
        return helper(s, i, 0, sign, len);
    }

    int helper(String s, int i, long num, int sign, int len){
        //Base case for non-digit and end
        if(i >= len || !Character.isDigit(s.charAt(i))){
            return (int) (sign * num);
        }

        // Update num
        num = num * 10 + (s.charAt(i) - '0');

        // Round Overflow
        if(num * sign >= intMax) return intMax;
        if(num * sign <= intMin) return intMin;

        // Recurse
        return helper(s, i + 1, num, sign, len);
    }
}
