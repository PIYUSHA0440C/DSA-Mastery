# 697. Degree of an Array (Easy)

## 📝 Problem Statement
The **degree** of an array is the maximum frequency of any one of its elements. Find the smallest possible length of a contiguous subarray that has the same degree as the original array.

## 💡 Intuition & Approach
To keep the same degree, a subarray must contain all occurrences of at least one of the most frequent elements. The shortest such subarray will start at the first occurrence and end at the last occurrence of that element.

### 🛠️ The Strategy:
1. **Frequency Tracking:** Use a `HashMap` (`count`) to track how many times each number appears.
2. **First Occurrence Tracking:** Use another `HashMap` (`first`) to store the index of the first time we see each number.
3. **Single Pass Logic:**
   - As we iterate, update the frequency of the current number.
   - If the current frequency exceeds the global `degree`, update the `degree` and calculate the new `res` (current index - first index + 1).
   - If the current frequency matches the current `degree`, calculate the length for this element and take the minimum: `res = Math.min(res, current_length)`.
4. **Result:** The variable `res` will hold the shortest length found for the maximum degree.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We traverse the array once, performing $O(1)$ map operations at each step.
* **Space Complexity:** 𝙊(𝗸) - Where $k$ is the number of unique elements in the array (at most 50,000).

## 💻 Implementation (Java)
```java
class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        int res = 0, degree = 0;

        for (int i = 0; i < nums.length; i++) {
            // Record the first time we see this number
            first.putIfAbsent(nums[i], i);
            
            // Update the frequency
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            int currentFreq = count.get(nums[i]);

            if (currentFreq > degree) {
                // New highest frequency found
                degree = currentFreq;
                res = i - first.get(nums[i]) + 1;
            } else if (currentFreq == degree) {
                // Same frequency, check if this span is shorter
                res = Math.min(res, i - first.get(nums[i]) + 1);
            }
        }
        return res;
    }
}
