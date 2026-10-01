# 594. Longest Harmonious Subsequence (Easy)

## 📝 Problem Statement

Given an integer array `nums`, find the length of the longest harmonious subsequence.

A harmonious array is one where the difference between its maximum and minimum values is exactly `1`.

## 💡 Intuition & Approach

For a harmonious subsequence, the only possible values are two numbers that differ by exactly `1`.

We can use a **HashMap** to store the frequency of every number. Then, for each distinct number, check whether `key + 1` exists. If it does, the combined frequency of both values forms a valid harmonious subsequence.

### 🛠️ The Strategy:

1. Count the frequency of every number using a `HashMap`.
2. Iterate through each distinct number in the map.
3. Check whether `key + 1` exists.
4. If it exists, add the frequencies of `key` and `key + 1`.
5. Keep track of the maximum length found.
6. Return the maximum length.

## 📊 Complexity Analysis

- **Time Complexity:** `O(n)` average.
- **Space Complexity:** `O(n)` in the worst case.

## 💻 Implementation (Java)

```java
class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int key: map.keySet()){
            if(map.containsKey(key + 1)) maxLen = Math.max(maxLen, map.get(key) + map.get(key + 1));
        }

        return maxLen;
    }
}
```
