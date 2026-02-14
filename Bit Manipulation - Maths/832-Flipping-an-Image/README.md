# 832. Flipping an Image (Easy)

## 📝 Problem Statement
Given an $n \times n$ binary matrix `image`, flip the image horizontally (reverse each row), then invert it (replace 0s with 1s and 1s with 0s).

## 💡 Intuition & Approach
Instead of performing the flip and the inversion in two separate passes, we can process each row in a single pass using a **Two-Pointer** logic.

### 🛠️ The Strategy:
1. **Row-by-Row Processing:** Iterate through each row of the 2D array.
2. **Two-Pointer Swap:** For each row, iterate from the start to the middle (`(row.length + 1) / 2`). 
3. **Simultaneous Inversion:** - Use the XOR operator (`^ 1`) to invert the bits.
   - Swap the elements at `i` and `length - 1 - i` while applying the inversion.
4. **Middle Element:** The logic `(row.length + 1) / 2` ensures that in rows with an odd number of elements, the middle element is also inverted.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻²) - We visit every element in the $n \times n$ matrix exactly once.
* **Space Complexity:** 𝙊(𝟭) - The operation is performed in-place (if allowed) or using constant extra space for the swap.

## 💻 Implementation (Java)
```java
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int[] row: image){
            // Process the row from both ends towards the middle
            for(int i = 0; i < (row.length + 1) / 2; i++){
                int index = row.length - 1 - i;
                
                // Swap and Invert using XOR
                int temp = row[i] ^ 1;
                row[i] = row[index] ^ 1;
                row[index] = temp;
            }
        }
        return image;
    }
}
