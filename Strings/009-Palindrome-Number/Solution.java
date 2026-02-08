class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int newNum = 0;
        int xCopy =x;
        while(xCopy > 0){
            int digit = xCopy % 10;
            newNum = (newNum * 10) + digit;
            xCopy /= 10;
        }
        return x == newNum;
    }
}
