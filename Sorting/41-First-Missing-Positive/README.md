# 41. First Missing Positive (Hard)

## 📝 Problem Statement
Given an unsorted integer array `nums`, return the smallest positive integer that is not present in `nums`.

**Constraints:**
- Time Complexity: **O(n)**
- Auxiliary Space: **O(1)**



## 💡 Intuition & Approach
The smallest missing positive must fall within the range `[1, n + 1]`. To solve this in $O(1)$ space, we use the array itself to store information.

### 🛠️ The Strategy: Cyclic Sort
1. **Rearrange in-place:** We iterate through the array and try to place every number `x` at index `x - 1` (e.g., `1` goes to index `0`, `2` goes to index `1`).
2. **Conditions for Swapping:** We only swap if:
   - The number is positive (`nums[i] >= 1`).
   - The number is within the array bounds (`nums[i] <= n`).
   - The number is not already at its correct position (`nums[nums[i] - 1] != nums[i]`).
3. **Scan for the Gap:** After sorting, we look for the first index `i` where `nums[i] != i + 1`. The value `i + 1` is our missing positive.
4. **Edge Case:** If all positions match, the missing number is `n + 1`.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - Even though there is a nested `while` loop, each element is moved to its correct position at most once.
* **Space Complexity:** 𝙊(𝟭) - We rearrange the input array without using extra data structures.

## 💻 Implementation (Java)
```java
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Place each number in its correct index (Cyclic Sort)
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int correct = nums[i] - 1;
                // Swap
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }
        }

        // Find the first index that doesn't hold the correct value
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
