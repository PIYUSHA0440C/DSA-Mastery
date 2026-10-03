class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        if(k == len) return arraySum(cardPoints);
        
        int currentScore = 0;
        for(int i = 0; i < k; i++) currentScore += cardPoints[i];

        int maxScore = currentScore;
        int rightIndex = len - 1;

        for(int leftIndex = k - 1; leftIndex >= 0; leftIndex--){
            currentScore -= cardPoints[leftIndex];
            currentScore += cardPoints[rightIndex--];

            if(currentScore > maxScore) maxScore = currentScore;
        }

        return maxScore;
    }

    private int arraySum(int[] arr){
        int sum = 0;
        for(int num: arr) sum += num;

        return sum;
    }
}


// class Solution {
//     public int maxScore(int[] cardPoints, int k) {
//         int len = cardPoints.length;

//         if(k == len) return arraySum(cardPoints);

//         int maxScore = Integer.MIN_VALUE;
//         int[] leftSum = arrayLeftSum(cardPoints, k);
//         int[] rightSum = arrayRightSum(cardPoints, k);

//         for(int leftCount = 0; leftCount <= k; leftCount++){
//             int rightCount = k - leftCount;

//             int currentScore = leftSum[leftCount] + rightSum[rightCount];

//             if(currentScore > maxScore) maxScore = currentScore;
//         }

//         return maxScore;
//     }

//     private int[] arrayRightSum(int[] arr, int k){
//         int[] ans = new int[k + 1];
//         ans[0] = 0;

//         int len = arr.length;

//         for(int i = 1; i <= k; i++){
//             ans[i] = ans[i - 1] + arr[len - i];
//         }
        
//         return ans;
//     }

//     private int[] arrayLeftSum(int[] arr, int k){
//         int[] ans = new int[k + 1];
//         ans[0] = 0;

//         for(int i = 1; i <= k; i++){
//             ans[i] = ans[i - 1] + arr[i - 1];
//         }
        
//         return ans;
//     }

//     private int arraySum(int[] arr){
//         int sum = 0;
//         for(int num: arr) sum += num;

//         return sum;
//     }
// }
