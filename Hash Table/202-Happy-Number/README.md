# 202. Happy Number (Easy)

## 📝 Problem Statement
A **happy number** is defined by a process where you replace a number with the sum of the squares of its digits. Repeat this until:
1. The number becomes 1 (Happy!).
2. The process loops endlessly in a cycle that does not include 1 (Not Happy).

## 💡 Intuition & Approach
This is fundamentally a **Cycle Detection** problem. As we transform the number, we need to know if we have encountered the current value before.

### 🛠️ The Strategy:
1. **Digit Square Sum Helper:** Create a function to peel off digits using `% 10` and `/ 10`, squaring them and summing them up.
2. **Detecting the Loop:** - Use a `HashSet<Integer>` to store every new number generated.
   - In each iteration, check if the current number is `1`. If yes, return `true`.
   - If the number is already in the `HashSet`, a cycle has been detected. Since it didn't reach 1 before looping, it never will. Return `false`.
3. **Alternative (Space Optimized):** This can also be solved using **Floyd's Cycle-Finding Algorithm** (Slow and Fast pointers) to achieve $O(1)$ space.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗹𝗼𝗴 𝗻) - While difficult to measure exactly, the number of digits decreases quickly, and the values eventually stay within a small range (under 243 for most 3-digit numbers).
* **Space Complexity:** 𝙊(𝗹𝗼𝗴 𝗻) - To store the history of numbers in the HashSet.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        // Continue until n becomes 1 or we hit a number we've seen before
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }

        return n == 1;
    }

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            totalSum += d * d;
            n /= 10;
        }
        return totalSum;
    }
}
