# 137. Single Number II (Medium)

## 📝 Problem Statement
Given an integer array `nums` where every element appears exactly three times except for one, which appears exactly once. Find the single element using linear time and constant extra space.

## 💡 Intuition & Approach
Since every number appears three times, we need a way to count the occurrences of bits in modulo 3. 

### 🛠️ The Strategy:
We maintain two variables, `ones` and `twos`, to track the state of each bit position:
1. **Initial State:** `ones = 0, twos = 0` (Bit has appeared 0 times).
2. **First Appearance:** Bit is added to `ones`.
3. **Second Appearance:** Bit is removed from `ones` and added to `twos`.
4. **Third Appearance:** Bit is removed from `twos` and (because of the `~twos` logic) not added to `ones`.

**Logic Breakdown:**
- `ones = (ones ^ num) & ~twos`: Add `num` to `ones` only if it is not already in `twos`.
- `twos = (twos ^ num) & ~ones`: Add `num` to `twos` only if it is not in the updated `ones`.

By the end of the loop, the bits that appeared $1 \pmod 3$ times (the single number) will be stored in `ones`.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We iterate through the array exactly once.
* **Space Complexity:** 𝙊(𝟭) - We only use two integer variables regardless of input size.

## 💻 Implementation (Java)
```java
class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        
        for (int num : nums) {
            // bits that appear 1st time or 4th time...
            ones = (ones ^ num) & ~twos;
            // bits that appear 2nd time or 5th time...
            twos = (twos ^ num) & ~ones;
        }

        return ones;
    }
}
