# 930. Binary Subarrays With Sum (Medium)

## 📝 Problem Statement

Given a binary array `nums` and an integer `goal`, return the number of non-empty subarrays whose sum is exactly `goal`.

## 💡 Intuition & Approach

We can use **prefix sums** with a `HashMap` to store the frequency of previously seen prefix sums.

For the current prefix sum, if `currentSum - goal` has appeared before, each occurrence represents a subarray ending at the current position whose sum is `goal`.

### 🛠️ The Strategy:

1. Maintain the current prefix sum while traversing the array.
2. If the current sum itself equals `goal`, count the subarray starting from index `0`.
3. Check whether `currentSum - goal` exists in the frequency map.
4. Add its frequency to the total count.
5. Store the current prefix sum and increase its frequency.
6. Return the total number of valid subarrays.

## 📊 Complexity Analysis

- **Time Complexity:** `O(n)` average.
- **Space Complexity:** `O(n)` in the worst case.

## 💻 Implementation (Java)

```java
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int totalCount = 0;
        int currentSum = 0;
        
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        for(int num: nums){
            currentSum += num;
            if(currentSum == goal) totalCount++;

            if(freq.containsKey(currentSum - goal)){
                totalCount += freq.get(currentSum - goal);
            }

            freq.put(currentSum, freq.getOrDefault(currentSum, 0) + 1);
        }

        return totalCount;
    }
}
```
