class Solution {
    public int equalPairs(int[][] grid) {
        int pairs = 0;

        int len = grid.length;
        Map<List<Integer>, Integer> rowCounts = new HashMap<>();

        for (int r = 0; r < len; r++) {
            List<Integer> row = new ArrayList<>();

            for (int c = 0; c < len; c++) row.add(grid[r][c]);

            rowCounts.put(row, rowCounts.getOrDefault(row, 0) + 1);
        }

        for (int c = 0; c < len; c++) {
            List<Integer> col = new ArrayList<>();

            for (int r = 0; r < len; r++) col.add(grid[r][c]);

            pairs += rowCounts.getOrDefault(col, 0);
        }

        return pairs;
    }
}
