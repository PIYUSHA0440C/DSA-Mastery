class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        int tempMax = 0;
        for(char ch : s.toCharArray()){
            if(ch == '(') tempMax++;
            if(ch == ')') tempMax--;
            ans = Math.max(ans, tempMax);
        }
        return ans;
    }
}
