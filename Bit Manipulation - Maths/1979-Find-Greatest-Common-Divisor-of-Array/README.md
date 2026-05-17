# 1979. Find Greatest Common Divisor of Array (Easy)

## 📝 Problem Statement
Given an integer array `nums`, find the smallest and largest numbers in the array, and return their Greatest Common Divisor (GCD).

## 💡 Intuition & Approach
The task breaks down cleanly into two distinct parts: finding the extreme values (min and max) and calculating their GCD.

### 🛠️ The Strategy:
1. **Min-Max Extraction:** Traverse the array in a single pass to track the maximum (`largest`) and minimum (`smallest`) elements.
2. **GCD Calculation:** 
   - Start a loop from the `smallest` value down to `2`.
   - The first number that divides both `smallest` and `largest` without a remainder is the greatest common divisor.
   - If the loop finishes without finding any common divisor, the answer defaults to `1`.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗡) - Finding the minimum and maximum takes a single pass over the array of size $N$. The GCD loop runs at most `smallest` times, which is bounded by a constant (1000), making it $O(1)$.
* **Space Complexity:** 𝙊(𝟭) - Only constant extra space is used for tracking variables.

## 💻 Implementation (Java)
```java
class Solution {
    public int findGCD(int[] nums) {
        int largest = 1;
        int smallest = 1000;

        // Step 1: Single pass to find min and max
        for (int num : nums) {
            if (num > largest) largest = num;
            if (num < smallest) smallest = smallest = num;
        }

        return gcd(smallest, largest);
    }

    // Step 2: Linear scan to find the Greatest Common Divisor
    private int gcd(int smallest, int largest) {
        for (int i = smallest; i > 1; i--) {
            if (smallest % i == 0 && largest % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
