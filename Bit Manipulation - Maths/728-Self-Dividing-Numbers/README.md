# 728. Self Dividing Numbers (Easy)

## 📝 Problem Statement
A self-dividing number is a number that is divisible by every digit it contains. For example, 128 is self-dividing because $128 \% 1 == 0$, $128 \% 2 == 0$, and $128 \% 8 == 0$. It cannot contain the digit zero.

## 💡 Intuition & Approach
To solve this, we iterate through every number in the given range and verify if it meets the self-dividing criteria.

### 🛠️ The Strategy:
1. **Range Traversal:** Use a `for` loop to check every number from `left` to `right`.
2. **Helper Logic:** Create a boolean function to check divisibility:
   - Extract digits one by one using `% 10`.
   - **Condition 1:** If a digit is `0`, the number is not self-dividing.
   - **Condition 2:** If the original number is not divisible by the current digit (`num % digit != 0`), it fails.
3. **Storage:** Add numbers that pass all checks into a `List`.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗡 × 𝗗) - where $N$ is the number of elements in the range and $D$ is the average number of digits. Since the range is at most 10,000, $D$ is at most 4.
* **Space Complexity:** 𝙊(𝗠) - where $M$ is the number of self-dividing numbers found, used to store the result.

## 💻 Implementation (Java)
```java
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (isDivisible(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isDivisible(int num) {
        int temp = num;

        while (temp > 0) {
            int digit = temp % 10;
            // Rule 1: Cannot contain zero. Rule 2: Must be divisible by digit.
            if (digit == 0 || num % digit != 0) {
                return false;
            }
            temp /= 10;
        }
        return true;
    }
}
