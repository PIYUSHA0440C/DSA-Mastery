# 367. Valid Perfect Square (Easy)

## 📝 Problem Statement
Given a positive integer `num`, return `true` if `num` is a perfect square or `false` otherwise. A perfect square is an integer that is the square of an integer (e.g., 16 is 4 * 4).

**Constraint:** You must not use built-in library functions like `sqrt`.



## 💡 Intuition & Approach
Instead of checking every number from 1 to `num` (which would be $O(n)$), we can use **Binary Search** because the square of numbers is monotonically increasing.

1. **Search Space:** The potential square root of `num` lies between `0` and `num`.
2. **Binary Search Logic:**
   - Calculate `mid`.
   - If $mid \times mid == num$, we found the square root! Return `true`.
   - If $mid \times mid > num$, the root must be smaller. Move `end = mid - 1`.
   - If $mid \times mid < num$, the root must be larger. Move `start = mid + 1`.
3. **Handling Overflow:** Since $num$ can be as large as $2^{31} - 1$, $mid \times mid$ can exceed the capacity of an `int`. Using `long` for `start`, `end`, and `mid` prevents this overflow.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝙡𝙤𝙜 𝙣) - We effectively search the range in logarithmic time.
* **Space Complexity:** 𝙊(𝟭) - Only constant extra space is used.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean isPerfectSquare(int num) {
        long start = 0;
        long end = num;

        while(start <= end){
            long mid = start + (end - start) / 2;
            
            // Check the square
            if(mid * mid == num){
                return true;
            } else if(mid * mid > num){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
