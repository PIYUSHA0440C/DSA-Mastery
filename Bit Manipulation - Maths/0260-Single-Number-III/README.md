# 260. Single Number III (Medium)

## 📝 Problem Statement
Given an integer array `nums`, where exactly two elements appear only once and all other elements appear exactly twice, find the two elements that appear only once. The algorithm must run in $O(N)$ time and use only $O(1)$ constant extra space.

## 💡 Intuition & Approach
If we XOR all numbers in the array, all duplicate pairs cancel out to `0`. We are left with `xorAll = x ^ y`, where `x` and `y` are our two unique numbers. Because `x` and `y` are distinct, `xorAll` must have at least one bit set to `1`. This bit represents a position where `x` and `y` differ from each other.

### 🛠️ The Strategy:
1. **XOR Pass:** XOR every element together to find `xorAll = x ^ y`.
2. **Isolate the Differentiating Bit:** Use the bitwise trick `diffBit = xorAll & (-xorAll)`. This isolates the lowest set bit of `xorAll` (the rightmost `1`).
3. **Partition & Conquer:** Iterate through the array a second time. Use `diffBit` to split the numbers into two groups:
   - Group 1: Numbers that have this specific bit set (`(num & diffBit) != 0`).
   - Group 2: Numbers that do not have this bit set.
4. **Result Extraction:** By XORing all elements in Group 1, all duplicates in that group cancel out, leaving exactly one of our unique numbers (`x`). The other number can be found instantly by XORing `x` out of our original total: `y = xorAll ^ x`.

## 📊 Complexity Analysis
* **Time Complexity:** O(N) - We make exactly two linear passes through the array.
* **Space Complexity:** O(1) - We only allocate a few primitive integer tracking variables, achieving constant extra space.

## 💻 Implementation (Java)
```java
class Solution {
    public int[] singleNumber(int[] nums) {
        int xorAll = 0;

        // Step 1: XOR all numbers together
        for (int num : nums) {
            xorAll ^= num;
        }

        // Step 2: Isolate the rightmost set bit where the two numbers differ
        int diffBit = xorAll & (-xorAll);

        // Step 3: Filter array elements by this differentiating bit
        int x = 0;
        for (int num : nums) {
            if ((num & diffBit) != 0) {
                x ^= num; // Accumulate XOR for the active bit group
            }
        }

        // Step 4: The second unique number is found by stripping x from xorAll
        return new int[]{x, xorAll ^ x};
    }
}
