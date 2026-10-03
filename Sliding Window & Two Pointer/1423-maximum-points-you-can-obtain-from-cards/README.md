# 1423. Maximum Points You Can Obtain from Cards (Medium)

## 📝 Problem Statement

You have an array `cardPoints` where each card has a number of points. In one step, you can take a card from either the beginning or the end of the row.

You must take exactly `k` cards. Return the maximum score you can obtain.

## 💡 Intuition & Approach

Since every selected card must come from either end, we can start by taking all `k` cards from the left.

Then, one by one, remove a card from the left selection and replace it with a card from the right end. This checks every possible combination of taking some cards from the left and the remaining cards from the right.

We keep track of the maximum score found during these replacements.

If `k` equals the array length, all cards must be taken, so we simply return the total sum.

### 🛠️ The Strategy:

1. Calculate the score of the first `k` cards.
2. Store this as the initial maximum score.
3. Move from the last selected left card toward the first one.
4. Remove that left card from the current score.
5. Add the next available card from the right.
6. Update the maximum score.
7. Return the maximum score found.

## 📊 Complexity Analysis

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

## 💻 Implementation (Java)

```java
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
```
