public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        int leftRem = 0, rightRem = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftRem++;
            } else if (c == ')') {
                if (leftRem > 0) {
                    leftRem--;
                } else {
                    rightRem++;
                }
            }
        }

        dfs(s, 0, result, leftRem, rightRem);
        return result;
    }

    private void dfs(String s, int startIndex, List<String> result, int leftRem, int rightRem) {
        
        if (leftRem == 0 && rightRem == 0) {
            if (isValid(s)) {
                result.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            char c = s.charAt(i);

            if (i > startIndex && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            
            if (leftRem > 0 && c == '(') {
                dfs(s.substring(0, i) + s.substring(i + 1), i, result, leftRem - 1, rightRem);
            }
            
            if (rightRem > 0 && c == ')') {
                dfs(s.substring(0, i) + s.substring(i + 1), i, result, leftRem, rightRem - 1);
            }
        }
    }
    
    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }
}
