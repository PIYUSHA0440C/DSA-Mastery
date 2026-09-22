class Solution {
    public int countNegatives(int[][] grid) {
        int len = grid.length;
        int row_len = grid[0].length;
        int count = 0;

        for(int i = 0; i < len; i++){
            int left = 0, right = row_len - 1, idx = row_len;

            while(left <= right) {
                int mid = left + (right - left) / 2;

                if(grid[i][mid] < 0) {
                    idx = mid;
                    right = mid - 1;

                } else {
                    left = mid + 1;
                }
            }

            count += (row_len - idx);
        }

        return count;
    }
}
