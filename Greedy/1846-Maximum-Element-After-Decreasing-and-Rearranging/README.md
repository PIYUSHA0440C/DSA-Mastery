# 1846. Maximum Element After Decreasing and Rearranging (Medium)

## 📝 Problem Statement
You are given an array of positive integers `arr`. Perform some operations (possibly none) on `arr` so that it satisfies these conditions:
1. The value of the first element in `arr` must be `1`.
2. The absolute difference between any 2 adjacent elements must be less than or equal to `1`. In other words, `abs(arr[i] - arr[i - 1]) <= 1` for each `i` where `1 <= i < arr.length`.

There are 2 types of operations that you can perform any number of times:
* **Decrease** the value of any element of `arr` to a smaller positive integer.
* **Rearrange** the elements of `arr` to be in any order.

Return the maximum possible value of an element in `arr` after performing the operations to satisfy the conditions.

## 💡 Intuition & Approach
The problem allows us to rearrange the elements in any order and decrease them as much as needed to fulfill the adjacent step size rule. To maximize the final element, a **Greedy Strategy** is best: we want the array to grow as steadily as possible from left to right. Sorting the array first helps us build this gradual climb optimally.

The rule states that the array must start at `1`, and each subsequent step can increase by at most `1`. By tracking our current achievable peak in a variable `max`, we can loop through our sorted array and check if the current element `arr[i]` can help us step up. If `arr[i]` is strictly greater than our current maximum, it means we have enough budget to safely increment our peak by `1` (`max++`). If `arr[i]` is smaller or equal, it caps our growth at that point, and we must wait for a larger element to climb higher.

### 🛠️ The Strategy:
1. **Sort the Input:** Sort `arr` to lay down a greedy foundation for steady upward growth.
2. **Anchor the Start:** Set our baseline maximum value `max = 1`, satisfying the rule for the first element.
3. **Linear Climb Validation:** Loop through the array starting from index `1`. For each element, if `arr[i] > max`, cap the jump to a single unit increment (`max++`). If it's not larger, our peak remains constrained by our existing value.
4. **Result Delivery:** Return the final accumulated value of `max`.

## 📊 Complexity Analysis
* **Time Complexity:** O(N log N) - The runtime is dominated by sorting the input array of size $N$. The subsequent tracking step is a fast, linear $O(N)$ pass.
* **Space Complexity:** O(1) or O(N) - Depending on the sorting implementation details in the background (Java's Dual-Pivot Quicksort uses $O(\log N)$ auxiliary space for primitives). No additional custom structures are allocated.

## 💻 Implementation (Java)
```java
class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        // Step 1: Sort the array to process elements from smallest to largest
        Arrays.sort(arr);
        
        // Step 2: The first element must always be forced/reduced to 1
        int max = 1;

        // Step 3: Build the optimal staircase greedily
        for (int i = 1; i < arr.length; i++) {
            // If the element is larger than our current max, we can step up by 1
            if (arr[i] > max) {
                max++;
            }
        }

        return max;
    }
}
