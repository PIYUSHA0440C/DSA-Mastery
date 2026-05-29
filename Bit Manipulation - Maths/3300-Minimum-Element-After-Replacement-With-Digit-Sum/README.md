# 3300. Minimum Element After Replacement With Digit Sum (Easy)

## 📝 Problem Statement
You are given an integer array `nums`. Replace each element in `nums` with the sum of its digits. Return the minimum element found in `nums` after all replacements are made.

## 💡 Intuition & Approach
The problem requires converting each integer into its digit sum and then finding the lowest value among those sums. 

Instead of converting integers to strings to parse characters, we can extract individual digits mathematically using base-10 arithmetic. This minimizes overhead and runs in O(1) space.

### 🛠️ The Strategy:
1. **Initialize Global Minimum:** Set a tracking variable `res` to `Integer.MAX_VALUE`.
2. **Iterate & Extract:** Loop through every number in `nums`:
   - Use a nested `while` loop to repeatedly isolate the last digit using modulo (`num % 10`) and add it to a running accumulator `ans`.
   - Shrink the number by dropping the processed digit using integer division (`num /= 10`).
3. **Update Minimum:** After computing a number's total digit sum, update `res` if the new sum is smaller than our current record.
4. **Return** the final value stored in `res`.

## 📊 Complexity Analysis
* **Time Complexity:** O(N * L) - Where N is the number of elements in the array and L is the maximum number of digits per integer. Given the constraints state `nums[i] <= 10^4`, an integer has at most 5 digits. Thus, L <= 5, making the time complexity strictly linear, O(N).
* **Space Complexity:** O(1) - The transformation is handled purely through scalar primitives, using zero auxiliary arrays or object allocations.

## 💻 Implementation (Java)
```java
class Solution {
    public int minElement(int[] nums) {
        int res = Integer.MAX_VALUE;

        for (int num : nums) {
            int ans = 0;
            // Mathematical digit sum extraction
            while (num > 0) {
                ans += num % 10;
                num /= 10;
            }
            // Retain the lowest digit sum encountered
            res = Math.min(res, ans);
        }

        return res;
    }
}
