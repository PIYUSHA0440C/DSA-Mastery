# 45. Jump Game II (Medium)

## 📝 Problem Statement
Given an array `nums` where each element represents your maximum jump length from that position, return the minimum number of jumps to reach the last index. You are guaranteed to be able to reach the end.

## 💡 Intuition & Approach
The most efficient way to find the minimum jumps is to use a greedy strategy that maximizes the reach of each jump. We think of this as moving in "jump ranges."

### 🛠️ The Strategy:
1. **Three Variables:** - `jumps`: Total jumps taken so far.
   - `currEnd`: The farthest index we can reach with our *current* number of jumps.
   - `maxReach`: The farthest index we can reach with *one more* jump.
2. **The Loop:** Iterate through the array (excluding the last element):
   - Continuously update `maxReach` by checking `i + nums[i]`.
   - When we reach the `currEnd` (the limit of our current jump):
     - Increment `jumps`.
     - Update `currEnd` to `maxReach` (the new horizon).
3. **Termination:** If `currEnd` reaches or exceeds the last index, we can stop early.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We traverse the array exactly once.
* **Space Complexity:** 𝙊(𝟭) - We only store three integer variables.

## 💻 Implementation (Java)
```java
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        int jumps = 0;
        int currEnd = 0;   // End of the current jump's range
        int maxReach = 0;  // Farthest we can go with the next jump

        for (int i = 0; i < n - 1; i++) {
            // Greedily update the farthest point reachable
            maxReach = Math.max(maxReach, i + nums[i]);

            // When we reach the end of our current jump range
            if (i == currEnd) {
                jumps++;
                currEnd = maxReach; // "Move" to the next jump range

                // If we can already reach the end, no need to check further
                if (currEnd >= n - 1) break;
            }
        }

        return jumps;
    }
}
