# 1460. Make Two Arrays Equal by Reversing Subarrays (Easy)

## 📝 Problem Statement

Given two integer arrays, `target` and `arr`, of equal length, determine whether `arr` can be transformed into `target` by reversing any number of subarrays.

## 💡 Intuition & Approach

Reversing subarrays allows elements to be rearranged into any order. Therefore, the arrays can be made equal if and only if they contain the same elements with the same frequencies.

A `HashMap` can track the frequency of each element in `arr`. Then, each element in `target` reduces its corresponding frequency. If an element is missing, the arrays cannot be equal.

### 🛠️ The Strategy:

1. Count the occurrences of every element in `arr` using a `HashMap`.
2. Traverse `target` and check whether each element exists in the frequency map.
3. If an element is missing, return `false`.
4. Decrease its frequency and remove the entry when its count reaches zero.
5. Return `true` if the map is empty after processing all elements.

## 📊 Complexity Analysis

- **Time Complexity:** O(n) on average, where `n` is the length of the arrays.
- **Space Complexity:** O(n) in the worst case for the frequency map.

## 💻 Implementation (Java)

```java
class Solution {

    public boolean canBeEqual(int[] target, int[] arr) {
        
        Map<Integer, Integer> arrFreq = new HashMap<>();
        for (int num : arr) {
            arrFreq.put(num, arrFreq.getOrDefault(num, 0) + 1);
        }

        for (int num : target) {
            if (!arrFreq.containsKey(num)) return false;

            arrFreq.put(num, arrFreq.get(num) - 1);
            if (arrFreq.get(num) == 0) {
                arrFreq.remove(num);
            }
        }

        return arrFreq.size() == 0;
    }
}
```
