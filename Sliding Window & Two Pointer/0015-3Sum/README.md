# 15. 3Sum (Medium)

## 📝 Problem Statement
Given an integer array `nums`, return all unique triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`. The solution set must not contain duplicate triplets.

## 💡 Intuition & Approach
A brute-force approach checks every combination of three numbers, costing $O(N^3)$ time. We can optimize this down to $O(N^2)$ by sorting the array and reducing the problem to a series of **Two-Pointer** target searches.

Once the array is sorted, we fix one element `nums[i]` as the anchor and search for the other two elements between `i + 1` and `n - 1`.

### 🛠️ The Strategy:
1. **Sort the Array:** Sorting clusters identical numbers together and lets us use directional pointers based on whether our sum is too small or too large.
2. **Anchor Loop:** Iterate through the array with pointer `i`. 
   - **Early Exit:** If `nums[i] > 0`, break early because a sum of zero is impossible with sorted positive numbers.
   - **Deduplication:** If `nums[i] == nums[i - 1]`, skip the iteration to prevent duplicate triplets.
3. **Two-Pointer Search:** Initialize `left = i + 1` and `right = n - 1`.
   - If `sum < 0`, we need a larger value, so we advance `left++`.
   - If `sum > 0`, we need a smaller value, so we retreat `right--`.
   - If `sum == 0`, record the valid triplet. Then, advance `left` and retreat `right` past all identical neighboring values to ensure uniqueness.

## 📊 Complexity Analysis
* **Time Complexity:** O(N^2) - Sorting takes $O(N \log N)$. The outer loop runs $N$ times, and for each anchor, the two-pointer inner scan processes the remaining elements in $O(N)$ time. This yields an overall $O(N^2)$ runtime.
* **Space Complexity:** O(1) or O(log N) - The space complexity is bounded by the memory required to sort the array in-place.

## 💻 Implementation (Java)
```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to manage duplicates and enable two pointers
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // Optimization: If the smallest number is positive, sum to 0 is impossible
            if (nums[i] > 0) break;
            
            // Skip duplicate anchors
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) {
                    left++; // Sum too small, move to a larger number
                } else if (sum > 0) {
                    right--; // Sum too large, move to a smaller number
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicate elements for left and right pointers
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                }
            }
        }

        return result;
    }
}
