# 3635. Earliest Finish Time for Land and Water Rides II (Medium)

## 📝 Problem Statement
You are given the start times and durations of two categories of theme park attractions: land rides and water rides. A tourist must experience exactly one ride from each category in any order. If a ride is started at time `t`, it finishes at `t + duration`. Immediately after finishing the first ride, the tourist can either start the next ride (if it's already open) or wait until it opens. Return the earliest possible time at which the tourist can finish both rides.

## 💡 Intuition & Approach
The mathematical framework remains identical to Part I, but the constraints are significantly larger ($1 \le n, m \le 5 \times 10^4$). A cross-product pair matching algorithm ($O(N \times M)$) would trigger a Time Limit Exceeded (TLE) error here. 

Fortunately, the optimal strategy does not require pairing every single ride. For any fixed sequence (Category 1 $\rightarrow$ Category 2), the absolute best choice for the first leg is always the ride that finishes earliest (`mini`). Minimizing our exit time from the first stage guarantees the maximum flexibility and earliest start capability for any subsequent attraction.

### 🛠️ The Strategy:
1. **Symmetric Decomposition:** Check both execution paths: `helper(Land, Water)` and `helper(Water, Land)`.
2. **Linear Minimum Extraction:** Scan Category 1 independently to find the absolute smallest finish timestamp.
3. **Timeline Evaluation:** Scan Category 2 independently. The start time for the second ride is bounded by `Math.max(mini, startTime[i])`. 
4. **Result Protection:** Combine both phases linearly to achieve a strict $O(N + M)$ execution profile that easily handles large inputs.

## 📊 Complexity Analysis
* **Time Complexity:** O(N + M) - Where N is the number of land rides and M is the number of water rides. The helper routine performs separate linear passes. By scanning the elements sequentially rather than pairing them in nested loops, the code scales beautifully for inputs up to $5 \times 10^4$.
* **Space Complexity:** O(1) - The evaluation runs completely in-place using simple primitive state variables.

## 💻 Implementation (Java)
```java
class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        // Evaluate both order permutations and return the minimum overall finish time
        return Math.min(
            helper(landStartTime, landDuration, waterStartTime, waterDuration),
            helper(waterStartTime, waterDuration, landStartTime, landDuration)
        );
    }

    private int helper(int[] firstStart, int[] firstDuration, int[] secondStart, int[] secondDuration) {
        int earliestFirstFinish = Integer.MAX_VALUE;

        // Step 1: Track down the earliest finish mark for the first stage
        for (int i = 0; i < firstStart.length; i++) {
            earliestFirstFinish = Math.min(earliestFirstFinish, firstStart[i] + firstDuration[i]);
        }

        int absoluteMinFinish = Integer.MAX_VALUE;

        // Step 2: Use the best first-stage mark to evaluate the second stage options
        for (int i = 0; i < secondStart.length; i++) {
            // Start time is bounded by either our arrival time or the attraction's opening gate
            int actualStart = Math.max(earliestFirstFinish, secondStart[i]);
            int totalTime = actualStart + secondDuration[i];
            
            absoluteMinFinish = Math.min(absoluteMinFinish, totalTime);
        }

        return absoluteMinFinish;
    }
}
