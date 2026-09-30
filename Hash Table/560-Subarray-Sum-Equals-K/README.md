# 560. Subarray Sum Equals K (Medium)

## 📝 Problem Statement

Given an integer array `nums` and an integer `k`, return the total number of non-empty subarrays whose sum equals `k`.

## 💡 Intuition & Approach

We can use **prefix sums** along with a `HashMap` to count how many times each prefix sum has appeared.

If the current prefix sum is `sum`, then a previous prefix sum equal to `sum - k` means that the elements between that previous position and the current position have a sum of exactly `k`.

### 🛠️ The Strategy:

1. Initialize the current prefix sum and answer count to `0`.
2. Store `(0, 1)` in the map to handle subarrays that start from index `0`.
3. Traverse the array and update the prefix sum.
4. Check whether `sum - k` already exists in the map.
5. If it exists, add its frequency to the answer.
6. Store the current prefix sum and increment its frequency.
7. Return the total count.

## 📊 Complexity Analysis

- **Time Complexity:** `O(n)` average.
- **Space Complexity:** `O(n)` in the worst case.

## 💻 Implementation (Java)

```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];

            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
```
