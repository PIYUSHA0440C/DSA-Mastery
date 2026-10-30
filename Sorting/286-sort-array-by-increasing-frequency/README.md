# 1636. Sort Array by Increasing Frequency (Easy)

## 📝 Problem Statement

Given an integer array, sort its elements by increasing frequency. If two elements have the same frequency, arrange them in decreasing order of value.

## 💡 Intuition & Approach

To sort the array according to frequency, first count how many times each element appears. Then use a custom comparator to determine the correct order based on frequency and value.

## 🛠️ The Strategy:

1. Use a HashMap to store the frequency of each element.
2. Copy the array elements into an `Integer[]` array because Java's object array sorting supports a custom comparator.
3. Sort the elements:
   - If frequencies differ, place the element with lower frequency first.
   - If frequencies are equal, place the larger value first.
4. Copy the sorted elements back into the original array.

## 📊 Complexity Analysis

- **Time Complexity:** O(n log n), where n is the array length. Frequency counting takes O(n), and sorting takes O(n log n).
- **Space Complexity:** O(n), for the frequency map and the auxiliary Integer array.

## 💻 Implementation (Java)

```java
class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Integer[] newNums = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            newNums[i] = nums[i];
        }

        Arrays.sort(newNums, (n1, n2) -> {
            if (freq.get(n1) != freq.get(n2)){
                return freq.get(n1) - freq.get(n2);
            } else return n2 - n1;
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = newNums[i];
        }

        return nums;
    }
}
```
