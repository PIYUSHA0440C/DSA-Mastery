class Solution {
    public int maxDistance(int[] colors) {
        int ans = 0;
        int len = colors.length;
        int first = colors[0];
        int last = colors[len - 1];

        for(int i = len - 1; i > 0; i--){
            if(first != colors[i]){
                ans = i;
                break;
            }
        }

        for(int i = 0; i < len; i++){
            if(last != colors[i]){
                ans = Math.max(ans, (len - 1) - i);
                break;
            }
        }
        
        return ans;
    }
}

