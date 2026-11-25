class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<double[]> queue = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int i = 0; i < arr.length - 1; i++) {
            queue.offer(new double[] {
                -1.0 * arr[i] / arr[arr.length - 1], 
                i,
                arr.length - 1
            });
        }

        while (--k > 0) {
            double[] curr = queue.poll();
            int numeratorIndex = (int) curr[1];
            int denominatorIndex = (int) curr[2] - 1;
            if (denominatorIndex > numeratorIndex) {
                queue.offer(new  double[] {
                    -1.0 * arr[numeratorIndex] / arr[denominatorIndex],
                    numeratorIndex,
                    denominatorIndex
                });
            }
        }

        double[] result = queue.poll();
        return new int[] {arr[(int) result[1]], arr[(int) result[2]]};
    }
}
