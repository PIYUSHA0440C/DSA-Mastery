# 3633. Earliest Finish Time for Land and Water Rides I (Easy)

## 📝 Problem Statement
You are given the start times and durations of two categories of theme park attractions: land rides and water rides. A tourist must experience exactly one ride from each category in any order. If a ride is started at time `t`, it finishes at `t + duration`. Immediately after finishing the first ride, the tourist can either start the next ride (if it's already open) or wait until it opens. Return the earliest possible time at which the tourist can finish both rides.

## 💡 Intuition & Approach
Since the tourist can do the rides in either order, the problem can be broken down into two symmetric cases:
1. **Land Ride $\rightarrow$ Water Ride**
2. **Water Ride $\rightarrow$ Land Ride**

For a fixed ordering (e.g., Category 1 then Category 2), to minimize the final finish time, we should always pick the ride in Category 1 that finishes at the absolute earliest time possible (`mini`). 

Once we have that minimum first-stage finish time, we check every option in Category 2. The start time for the second ride will be the maximum of when our first ride finished and when the second ride actually opens: `Math.max(mini, category2StartTime[i])`. Adding the duration gives the total finish time.

### 🛠️ The Strategy:
1. **Symmetric Execution:** Call a helper function `calFinishTime` twice—once for `(Land, Water)` and once for `(Water, Land)`.
2. **First-Pass Optimization:** In the helper function, find the earliest possible finish time for the first category.
3. **Second-Pass Tracking:** Iterate through the second category, applying waiting time logic via `Math.max()`, and track the minimum overall end time.
4. **Result:** Return the minimum value produced by the two independent paths.

## 📊 Complexity Analysis
* **Time Complexity:** O(N + M) - Where N is the number of land rides and M is the number of water rides. The helper method runs in O(N + M) time, and calling it twice keeps the overall runtime strictly linear.
* **Space Complexity:** O(1) - Only standard scalar tracking variables are used, resulting in constant extra space.

## 💻 Implementation (Java)
```java
class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        // Evaluate both sequential combinations and return the absolute minimum
        return Math.min(
            calFinishTime(landStartTime, landDuration, waterStartTime, waterDuration),
            calFinishTime(waterStartTime, waterDuration, landStartTime, landDuration)
        );
    }

    private int calFinishTime(int[] firstStart, int[] firstDuration, int[] secondStart, int[] secondDuration) {
        int earliestFirstFinish = Integer.MAX_VALUE;

        // Step 1: Find the earliest finish time for the first category of rides
        for (int i = 0; i < firstStart.length; i++) {
            earliestFirstFinish = Math.min(earliestFirstFinish, firstStart[i] + firstDuration[i]);
        }

        int absoluteMinFinish = Integer.MAX_VALUE;

        // Step 2: Calculate the best total finish time using the second category
        for (int i = 0; i < secondStart.length; i++) {
            // The second ride starts either when the first ride ends or when it opens, whichever is later
            int actualStart = Math.max(earliestFirstFinish, secondStart[i]);
            int totalTime = actualStart + secondDuration[i];
            
            absoluteMinFinish = Math.min(absoluteMinFinish, totalTime);
        }

        return absoluteMinFinish;
    }
}
