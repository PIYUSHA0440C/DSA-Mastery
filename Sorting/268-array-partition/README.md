# 561. Array Partition (Easy)

## 📝 Problem Statement

Given an integer array `nums` containing `2n` integers, divide the elements into `n` pairs such that the sum of the minimum value in each pair is maximized. Return the maximum possible sum.

## 💡 Intuition & Approach

To maximize the sum of pairwise minimums, sort the array in ascending order and pair adjacent elements. The smaller element in each pair contributes to the sum.

After sorting, the elements at even indices contribute to the maximum sum. The solution traverses backward from the second-largest element, adding every second element.

### 🛠️ The Strategy:

1. Sort the array in ascending order.
2. If the array contains two elements, return the first element.
3. Traverse backward from the second-last index, moving two positions at a time.
4. Add each selected element to the sum and return the result.

## 📊 Complexity Analysis

- **Time Complexity:** O(n log n), due to sorting, where n is the number of elements in the array.
- **Space Complexity:** O(log n) auxiliary space for Java primitive-array sorting.

## 💻 Implementation (Java)

```java
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        if(nums.length == 2) return nums[0];

        int sum = 0;
        for(int i = nums.length - 2; i >= 0; i -= 2){
            sum += nums[i];
        }

        return sum;
    }
}
```
