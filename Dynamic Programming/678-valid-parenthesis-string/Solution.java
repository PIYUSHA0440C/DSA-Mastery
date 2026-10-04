class Solution {
    public boolean checkValidString(String s) {
        int len = s.length();
        int[][] memo = new int[len][len];

        for(int[] row: memo) Arrays.fill(row, -1);

        return isValidString(memo, s, 0, 0);
    }

    private boolean isValidString(int[][] memo, String str, int index, int openCount){
        if(index == str.length()) return openCount == 0;

        if(memo[index][openCount] != -1) return memo[index][openCount] == 1;

        boolean isValid = false;

        if (str.charAt(index) == '*') {
            isValid |= isValidString(memo, str, index + 1, openCount + 1);

            if(openCount > 0){
                isValid |= isValidString(memo, str, index + 1, openCount - 1);
            }

            isValid |= isValidString(memo, str, index + 1, openCount);
        } else {
            if (str.charAt(index) == '('){
                isValid = isValidString(memo, str, index + 1, openCount + 1);
            } else if (openCount > 0) {
                isValid = isValidString(memo, str, index + 1, openCount - 1);
            }
        }

        memo[index][openCount] = isValid ? 1 : 0;
        return isValid;
    }
}
