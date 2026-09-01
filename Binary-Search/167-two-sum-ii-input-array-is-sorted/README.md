# 167. Two Sum II - Input Array Is Sorted (Medium)


## 📝 Problem Statement


Given a 1-indexed array of integers sorted in non-decreasing order, find two numbers whose sum equals the given target.


Return their 1-based indices.


## 💡 Intuition & Approach


Since the array is sorted, we can use the **Two-Pointer** technique instead of checking every possible pair.


One pointer starts at the beginning and the other at the end. If their sum is smaller than the target, the left pointer moves right to increase the sum. If their sum is greater than the target, the right pointer moves left to decrease the sum.


Because the problem guarantees exactly one solution, the pointers will eventually reach the required pair.


### 🛠️ The Strategy:


1. Initialize `start` at the first element and `end` at the last element.
2. Calculate the sum of the elements at both pointers.
3. If the sum equals the target, return their 1-based indices.
4. If the sum is smaller than the target, move `start` forward.
5. If the sum is greater than the target, move `end` backward.
6. Continue until the two pointers meet.


## 📊 Complexity Analysis


* **Time Complexity:** O(n) - Each pointer moves through the array at most once.


* **Space Complexity:** O(1) - Only constant extra space is used.


## 💻 Implementation (Java)


```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;

        while(start < end){
            int currentSum = numbers[start] + numbers[end];

            if (currentSum == target) return new int[]{start + 1, end + 1};
            else if (currentSum < target) start++;
            else end--;
        }

        return new int[]{-1, -1};
    }
}
