# 3723. Maximize Sum of Squares of Digits (Medium)

## 📝 Problem Statement

Given two positive integers `num` and `sum`, construct a `num`-digit positive integer whose digits add up to `sum` and whose sum of squared digits is maximized. If multiple integers achieve the maximum score, return the largest one. If no valid integer exists, return an empty string.

## 💡 Intuition & Approach

To maximize the sum of squared digits, assign as much of the digit sum as possible to digits with the value `9`, since larger digits contribute more to the sum of squares.

Divide `sum` by `9` to determine how many `9`s are needed. If there is a remainder, append that digit next, followed by enough zeros to make the number exactly `num` digits long. Placing the largest digits first also gives the maximum integer among optimal answers.

### 🛠️ The Strategy:

1. If `sum` exceeds `9 * num`, return an empty string because the required digit sum is impossible.
2. Calculate the number of `9`s using `sum / 9`.
3. Calculate the remaining digit using `sum % 9` and append it if it is greater than zero.
4. Append zeros until the string contains exactly `num` digits.
5. Return the constructed string.

## 📊 Complexity Analysis

- **Time Complexity:** O(num), because the algorithm builds a string of `num` digits in the worst case.
- **Space Complexity:** O(num), for the resulting string.

## 💻 Implementation (Java)

```java
class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num) return "";

        int r = sum % 9;
        StringBuilder ans = new StringBuilder();
        int nines = sum / 9;

        for (int i = 0; i < nines; i++){
            ans.append('9');
        }

        if (r > 0){
            ans.append((char) ('0' + r));
        }

        int zeros = num - ans.length();

        for (int i = 0; i < zeros; i++){
            ans.append('0');
        }

        return ans.toString();
    }
}
```
