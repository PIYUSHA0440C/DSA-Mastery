# 66. Plus One (Easy)

## 📝 Problem Statement
You are given a large integer represented as an integer array `digits`. Increment the large integer by one and return the resulting array of digits. The digits are ordered from most significant to least significant, and there are no leading zeros.

## 💡 Intuition & Approach
The challenge here is handling the "carry" when a digit is `9`. Adding 1 to `9` turns it into `0` and passes the `1` to the next digit on the left.

### 🛠️ The Strategy:
1. **Reverse Traversal:** Start from the last element (the least significant digit).
2. **The "Non-9" Case:** If the current digit is less than `9`, simply increment it by `1` and return the array immediately. We are done!
3. **The "9" Case:** If the digit is `9`, set it to `0`. The loop will then move to the next digit on the left to handle the carry.
4. **The "All-9s" Edge Case:** If the loop finishes, it means every digit was a `9` (e.g., `999`). In this case, we create a new array of size `n + 1`, set the first element to `1`, and return it (e.g., `1000`).



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - In the worst case (all 9s), we traverse the entire array once.
* **Space Complexity:** 𝙊(𝗻) - Usually $O(1)$ as we modify the array in-place, but if all digits are 9, we must allocate a new array of size $n+1$.

## 💻 Implementation (Java)
```java
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        
        // Traverse from right to left
        for(int i = len - 1; i >= 0; i--){
            if(digits[i] != 9){
                digits[i] += 1;
                return digits; // No carry needed further, return early
            }
            // If it was 9, it becomes 0 and loop continues
            digits[i] = 0;
        }
        
        // If we reach here, it means all digits were 9 (e.g., 999 -> 1000)
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}
