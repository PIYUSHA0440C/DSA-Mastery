# 11. Container With Most Water (Medium)

## 📝 Problem Statement
You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the $i$-th line are `(i, 0)` and `(i, height[i])`. Find two lines that together with the x-axis form a container, such that the container contains the most water. Return the maximum amount of water a container can store.

## 💡 Intuition & Approach
The area of a container is always constrained by its shortest wall: 
`Area = Width * Height` where `Width = right - left` and `Height = min(height[left], height[right])`.

Instead of checking every single pair with an $O(N^2)$ nested loop, we can use a **Two-Pointer** approach to solve it in linear time.

### 🛠️ The Strategy:
1. **Maximize Initial Width:** Place one pointer (`left`) at index `0` and another pointer (`right`) at the very end of the array. This gives us the widest possible container to start with.
2. **Calculate and Track:** Compute the area formed between the two pointers and update our maximum area tracker `res`.
3. **Greedy Pointer Movement:** To find a larger area, we *must* find a taller bar, because moving the pointers inward decreases the width. 
   - If `height[left] < height[right]`, moving the `right` pointer inward cannot help us because the area will stay limited by the shorter `left` bar. Thus, our only logical move is to advance `left++`.
   - Conversely, if the right bar is shorter or equal, we decrement `right--`.
4. **Termination:** Stop when the pointers meet (`left == right`).

## 📊 Complexity Analysis
* **Time Complexity:** O(N) - We scan the array exactly once from the outside inward, processing each element in constant time.
* **Space Complexity:** O(1) - Only a few integer variables are used to maintain pointers and areas, requiring no extra memory.

## 💻 Implementation (Java)
```java
class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int currentWidth = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int area = currentWidth * currentHeight;
            
            res = Math.max(res, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}
