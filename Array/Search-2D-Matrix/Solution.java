class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length - 1; // Index of the last column

        for (int i = 0; i < m; i++) {
            // Property check: Is target within this row's range?
            if (matrix[i][n] >= target) {
                // Linear search within the identified row
                for (int j : matrix[i]) {
                    if (j == target) {
                        return true;
                    }
                }
                // If not in this row, it's not in the matrix (due to sorted property)
                return false; 
            }
        }
        return false;
    }
}
