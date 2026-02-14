class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int[] row: image){
            for(int i = 0; i < (row.length + 1) / 2; i++){
                int index = row.length - 1 - i;
                int temp = row[i] ^ 1;
                row[i] = row[index] ^ 1;
                row[index] = temp;
            }
        }
        return image;
    }
}
