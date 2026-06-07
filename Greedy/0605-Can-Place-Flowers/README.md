# 605. Can Place Flowers (Easy)

## 📝 Problem Statement
You have a long flowerbed in which some of the plots are planted (`1`), and some are not (`0`). However, flowers cannot be planted in adjacent plots. Given an integer array `flowerbed` and an integer `n`, return `true` if `n` new flowers can be planted without violating the no-adjacent-flowers rule, and `false` otherwise.

## 💡 Intuition & Approach
This problem is solved efficiently using a **Greedy Approach**. We scan the array sequentially from left to right. The moment we find a valid empty plot that satisfies the placement criteria, we plant a flower there immediately. Planting a flower as early as possible never hurts our chances of placing subsequent flowers down the line.

### 🛠️ The Boundary Logic:
To place a flower at index `i`, three conditions must be met simultaneously:
1. The current spot must be empty: `flowerbed[i] == 0`
2. The left neighbor must be empty or out of bounds (if we are at index 0): `i == 0 || flowerbed[i - 1] == 0`
3. The right neighbor must be empty or out of bounds (if we are at the last index): `i == flowerbed.length - 1 || flowerbed[i + 1] == 0`

If all three match, we mutate the state `flowerbed[i] = 1`, decrement `n`, and verify if our goal has been reached early.

## 📊 Complexity Analysis
* **Time Complexity:** O(N) - We scan through the flowerbed array at most once. If `n` reaches 0 before the end of the array, the function short-circuits and terminates even faster.
* **Space Complexity:** O(1) - The check is done in-place by mutating the input array, resulting in constant auxiliary space.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // Early exit check if no flowers need to be placed
        if (n == 0) return true;

        for (int i = 0; i < flowerbed.length; i++) {
            // Check if current slot is empty and neighbors are free or out of bounds
            if (flowerbed[i] == 0 && 
                (i == 0 || flowerbed[i - 1] == 0) && 
                (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                
                flowerbed[i] = 1; // Greedily plant a flower
                n--;              // Decrement remaining requirement
                
                if (n == 0) return true; // Exit early if goal is met
            }
        }

        return false;
    }
}
