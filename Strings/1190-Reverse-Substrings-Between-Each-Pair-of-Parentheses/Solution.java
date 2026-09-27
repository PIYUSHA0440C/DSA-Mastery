class Solution {
    public String reverseParentheses(String s) {
        int len = s.length();
        int[] pair = new int[len];

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < len; i++){
            if (s.charAt(i) == '(') stack.push(i);
            else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuilder res = new StringBuilder();
        int idx = 0, direction = 1;

        while (idx >= 0 && idx < len){
            if (s.charAt(idx) == '(' || s.charAt(idx) == ')') {
                idx = pair[idx];
                direction = - direction;
            } else {
                res.append(s.charAt(idx));
            }

            idx += direction;
        }

        return res.toString();
    }
}
