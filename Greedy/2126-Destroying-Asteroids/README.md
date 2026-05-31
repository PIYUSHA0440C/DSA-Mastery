# 2126. Destroying Asteroids (Medium)

## 📝 Problem Statement
You are given an integer `mass`, which represents the initial mass of a planet, and an integer array `asteroids`, where `asteroids[i]` is the mass of the $i$-th asteroid. You can collide with the asteroids in any order. If the planet's mass is greater than or equal to the asteroid's mass, the asteroid is destroyed and the planet absorbs its mass. Otherwise, the planet is destroyed. Return `true` if all asteroids can be destroyed, and `false` otherwise.

## 💡 Intuition & Approach
This problem can be solved optimally using a **Greedy Strategy**. To absorb as much mass as possible without getting destroyed, the planet should always target the smallest available asteroid first. 

If the planet cannot destroy the smallest remaining asteroid, it certainly cannot destroy any larger ones, meaning a valid sequencing is impossible.

### 🛠️ The Strategy:
1. **Sort the Asteroids:** Sort the `asteroids` array in ascending order.
2. **Prevent Overflow:** Cast the initial `mass` to a `long` datatype (`currentMass`). Since the array can contain up to $10^5$ elements with values up to $10^5$, the accumulated mass can easily exceed the maximum limit of a standard 32-bit signed integer (`Integer.MAX_VALUE`).
3. **Simulate Collisions:** Loop through the sorted array:
   - If `currentMass < asteroid`, the planet is destroyed. Return `false` immediately.
   - Otherwise, the planet absorbs the asteroid: `currentMass += asteroid`.
4. **Success:** If the loop finishes completely, all asteroids have been safely absorbed. Return `true`.

## 📊 Complexity Analysis
* **Time Complexity:** O(N log N) - The runtime is dominated by sorting the `asteroids` array, where $N$ is the length of the array. The subsequent linear scanning loop takes $O(N)$ time.
* **Space Complexity:** O(1) or O(log N) - Depending on the implementation of primitive sorting (`Arrays.sort` in Java utilizes a variant of Dual-Pivot Quicksort, which requires $O(\log N)$ auxiliary stack space).

## 💻 Implementation (Java)
```java
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        // Step 1: Sort asteroids to apply the greedy approach
        Arrays.sort(asteroids);
        
        // Step 2: Use long to prevent integer overflow during mass accumulation
        long currentMass = mass;

        // Step 3: Verify collisions from smallest to largest
        for (int asteroid : asteroids) {
            if (currentMass < asteroid) {
                return false; // Planet is too small to destroy this asteroid
            }
            currentMass += asteroid; // Absorb the asteroid's mass
        }
        
        return true;
    }
}
