# 1838. Frequency of the Most Frequent Element (Medium)

## 📝 Problem Statement
Given an integer array `nums` and an integer `k`, you can increment any element by 1 at most `k` total times. Return the maximum possible frequency of any element after these operations.

## 💡 Intuition & Approach
To maximize frequency, it makes sense to try and make multiple elements equal to an existing value in the array. Sorting helps because it's cheaper (requires fewer increments) to increase a number to a target value if that number is already close to the target.

### 🛠️ The Strategy:
1. **Sort the Array:** This allows us to use a sliding window where the `right` pointer always represents the target value we are trying to reach.
2. **Sliding Window:** - Expand the `right` pointer and add `nums[right]` to our `currentSum`.
   - **The Condition:** The operations needed to make all elements in the window $[left, right]$ equal to `nums[right]` is calculated as:
     $$(target \times windowLength) - currentSum$$
   - If this value exceeds `k`, we shrink the window by moving the `left` pointer and subtracting `nums[left]` from the sum.
3. **Max Frequency:** The window size `(right - left + 1)` at any valid moment represents a possible frequency. We track the maximum size seen.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻 𝗹𝗼𝗴 𝗻) - Sorting takes $O(n \log n)$, and the sliding window pass takes $O(n)$.
* **Space Complexity:** 𝙊(𝗹𝗼𝗴 𝗻) or 𝙊(𝗻) - Depending on the implementation of the sorting algorithm in the language.

## 💻 Implementation (Java)
```java
class Solution {
    public int maxFrequency(int[] nums, int k) {
        int maxFrequency = 0;
        long currentSum = 0;

        // Sorting is necessary to use the sliding window effectively
        Arrays.sort(nums);

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            
            // If total operations needed > k, shrink the window
            // Needed operations = (nums[right] * windowSize) - currentSum
            while ((long) nums[right] * (right - left + 1) > currentSum + k) {
                currentSum -= nums[left];
                left++;
            }

            maxFrequency = Math.max(maxFrequency, right - left + 1);
        }

        return maxFrequency;
    }
}
