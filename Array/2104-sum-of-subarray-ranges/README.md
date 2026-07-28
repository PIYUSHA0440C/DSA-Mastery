# 2104. Sum of Subarray Ranges (Medium)

## 📝 Problem Statement

Given an integer array `nums`, the **range** of a subarray is defined as:

```
maximum element - minimum element
```

Return the sum of ranges of all possible non-empty contiguous subarrays.

---

## 💡 Intuition & Approach

A brute-force approach is to consider every possible subarray and calculate its maximum and minimum values.

For each starting index:

- Expand the subarray one element at a time.
- Maintain the current minimum and maximum values while extending the range.
- Add the current range (`max - min`) to the total sum.

By updating the minimum and maximum values during traversal, we avoid recalculating them for every subarray.

### 🛠️ The Strategy

1. **Fix the Starting Index**
   - Iterate through every possible starting position of a subarray.

2. **Expand the Subarray**
   - Extend the ending index one step at a time.
   - Update the current minimum and maximum values.

3. **Calculate Range Contribution**
   - For every generated subarray, add:
   ```
   maximum - minimum
   ```

4. **Return the Final Sum**
   - The accumulated value represents the sum of all subarray ranges.

---

## 📊 Complexity Analysis

- **Time Complexity:** **O(n²)** - Every possible subarray is considered once.

- **Space Complexity:** **O(1)** - Only variables for tracking minimum, maximum, and sum are used.

---

## 💻 Implementation (Java)

```java
class Solution {
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        int len = nums.length;

        for(int i = 0; i < len; i++) {
            int min = nums[i];
            int max = nums[i];

            for(int j = i + 1; j < len; j++) {
                if(nums[j] < min)
                    min = nums[j];
                else if(nums[j] > max)
                    max = nums[j];

                sum += max - min;
            }
        }

        return sum;
    }
}
```
