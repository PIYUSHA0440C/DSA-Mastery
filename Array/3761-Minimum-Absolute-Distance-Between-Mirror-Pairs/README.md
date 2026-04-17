# 3761. Minimum Absolute Distance Between Mirror Pairs (Medium)

## 📝 Problem Statement
A **mirror pair** is a pair of indices $(i, j)$ such that $i < j$ and $reverse(nums[i]) == nums[j]$. Find the minimum absolute distance $|i - j|$ among all such pairs. If none exist, return -1.

## 💡 Intuition & Approach
The condition $reverse(nums[i]) == nums[j]$ means that when we are at index $j$, we are looking for a value that matches $nums[j]$ but was stored as its reversed version earlier.

### 🛠️ The Strategy:
1. **One-Pass Search:** We iterate through the array once.
2. **The "Reverse-Lookup" Map:** - For every number `nums[i]`, we first check if its current value exists in our `seen` map.
   - If `map.containsKey(nums[i])`, it means some previous number's reverse matches our current number. We calculate the distance $i - seen.get(nums[i])$ and update our minimum.
3. **Updating the Mirror:** - We calculate the reverse of the current `nums[i]`.
   - We store this reversed value in the map with the current index $i$.
   - **Crucial Optimization:** If the reversed value is already in the map, we overwrite it with the current index. This is because a later matching number will be closer to this current index than any previous one.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻 × 𝗗) - Where $n$ is the array length and $D$ is the number of digits in the integers (max 10 for $10^9$). This is effectively linear $O(n)$.
* **Space Complexity:** 𝙊(𝗻) - In the worst case, we store the reverse of every number in the HashMap.

## 💻 Implementation (Java)
```java
class Solution {
    public int minMirrorPairDistance(int[] nums) {
        // Map stores: Key = reverse(nums[i]), Value = index i
        Map<Integer, Integer> seenMirror = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int currentVal = nums[i];

            // 1. Check if the current value is a mirror of something seen before
            if (seenMirror.containsKey(currentVal)) {
                minDistance = Math.min(minDistance, i - seenMirror.get(currentVal));
            }

            // 2. Calculate reverse of currentVal to store for future matches
            int temp = currentVal;
            int reversed = 0;
            while (temp > 0) {
                reversed = (reversed * 10) + (temp % 10);
                temp /= 10;
            }

            // 3. Store/Update the reversed value with current index
            seenMirror.put(reversed, i);
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}
