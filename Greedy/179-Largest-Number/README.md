# 179. Largest Number (Medium)

## 📝 Problem Statement

Given a list of non-negative integers, arrange them such that they form the largest possible number and return the result as a string.

## 💡 Intuition & Approach

The key is to determine which of two numbers should come first by comparing their concatenations. For two strings `a` and `b`, if `b + a` is larger than `a + b`, then `b` should come before `a`.

### 🛠️ The Strategy:

1. Convert all integers into strings.
2. Sort the strings using a custom comparator.
3. For every pair `a` and `b`, compare `b + a` with `a + b`.
4. Place the string producing the larger concatenation first.
5. Handle the special case where the largest element is `"0"`, meaning all numbers are zero.
6. Append the sorted strings to form the largest number.
7. Return the resulting string.

## 📊 Complexity Analysis

* **Time Complexity:** O(n log n × k), where `n` is the number of elements and `k` is the maximum number of digits.
* **Space Complexity:** O(n × k), for storing the string representations of the numbers.

## 💻 Implementation (Java)

```java
class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];

        for(int i = 0; i < nums.length; i++){
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (a,b) -> (b + a).compareTo(a+b));

        if(arr[0].equals("0")) return "0";

        StringBuilder largest = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            largest.append(arr[i]);
        }

        return largest.toString();
    }
}
```
