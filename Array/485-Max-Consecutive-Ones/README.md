# 485. Max Consecutive Ones (Easy)

## 📝 Problem Statement
Given a binary array `nums`, return the maximum number of consecutive `1`s in the array.

## 💡 Intuition & Approach
The problem requires finding the longest continuous streak of a specific value. A single linear scan is the most efficient way to track the current streak and compare it against the maximum streak found so far.

### 🛠️ The Strategy:
1. **State Tracking:** Use two variables: `max` to hold the highest count seen and `count` to track the current streak of ones.
2. **Linear Scan:** Iterate through the array once.
   - If the element is `1`, increment `count`.
   - If the element is `0`, update `max` using `Math.max(max, count)` and reset `count` to 0.
3. **Edge Case Handling:** If the array ends with a `1`, the streak hasn't been compared to the `max` yet. A final `Math.max` check at the end ensures the last streak is included.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We traverse the array exactly once.
* **Space Complexity:** 𝙊(𝟭) - No extra data structures used; only two integer variables.

## 💻 Implementation (Java)
```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for(int num: nums){
            if(num == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        // Final check to handle streaks ending at the last index
        return Math.max(max, count);
    }
}
