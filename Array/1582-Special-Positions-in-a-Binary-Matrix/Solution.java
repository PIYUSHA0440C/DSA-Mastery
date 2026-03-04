class Solution {
    public int numSpecial(int[][] mat) {
        int rLen = mat.length, cLen = mat[0].length;

        int[] row = new int[rLen];
        int[] col = new int[cLen];

        for(int i = 0; i < rLen; i++){
            for(int j = 0; j < cLen; j++){
                if(mat[i][j] == 1){
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < rLen; i++){
            for(int j = 0; j < cLen; j++){
                if(mat[i][j] == 1 && row[i] == 1 && col[j] == 1){
                    ans++;
                }
            }
        }

        return ans;
    }
}
