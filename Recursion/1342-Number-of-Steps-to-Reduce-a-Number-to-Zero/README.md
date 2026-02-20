# 1342. Number of Steps to Reduce a Number to Zero (Easy)

## 📝 Problem Statement
Given an integer `num`, return the number of steps to reduce it to zero. If the current number is even, divide it by 2; otherwise, subtract 1 from it.

## 💡 Intuition & Approach
While this problem is often solved with a simple `while` loop, solving it via **Recursion** helps demonstrate how state (the step count) can be passed through a call stack.

### 🛠️ The Strategy:
1. **Helper Method:** A secondary function `countSteps` is used to carry the `count` as an accumulator.
2. **Base Case:** When `num` hits `0`, the recursion stops and returns the final `count`.
3. **Recursive Branching:**
   - **Even Case:** `num % 2 == 0` $\to$ Recurse with `num / 2`.
   - **Odd Case:** `num % 2 != 0` $\to$ Recurse with `num - 1`.
4. **Tail Recursion:** By passing `++count` into the next call, the result is calculated during the descent, making it highly efficient.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗹𝗼𝗴 𝗻) - Every even step halves the number, leading to logarithmic time.
* **Space Complexity:** 𝙊(𝗹𝗼𝗴 𝗻) - Each recursive call adds a frame to the stack.

## 💻 Implementation (Java)
```java
class Solution {
    public int numberOfSteps(int num) {
        int count = 0;
        return countSteps(num, count);
    }

    // Recursive helper function
    int countSteps(int num, int count){
        if(num == 0) return count;

        if(num % 2 == 0) return countSteps(num / 2, ++count);
        else return countSteps(num - 1, ++count);
    }
}
