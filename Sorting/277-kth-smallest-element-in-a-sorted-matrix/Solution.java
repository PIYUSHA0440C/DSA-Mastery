class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int[] arr = new int[matrix.length * matrix.length];
        int idx = 0;

        for (int[] temp : matrix){
            for (int num: temp){
                arr[idx++] = num;
            }
        }

        Arrays.sort(arr);

        return arr[k - 1];
    }
}
