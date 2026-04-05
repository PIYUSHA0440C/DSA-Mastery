# 274. H-Index (Medium)

## 📝 Problem Statement
The h-index is a metric that measures both the productivity and citation impact of a researcher. It is defined as the maximum value $h$ such that the researcher has published at least $h$ papers that have each been cited at least $h$ times.

## 💡 Intuition & Approach
The simplest way to find this threshold is to look at the papers with the most citations first.

### 🛠️ The Strategy:
1. **Sort:** Sort the `citations` array. This allows us to easily see the papers with the highest impact.
2. **Reverse Iteration:** Start from the end of the sorted array (the paper with the most citations).
3. **Threshold Check:** - Keep a counter `h` representing the number of papers found so far that meet the criteria.
   - For each paper, if the number of citations is greater than our current `h`, it means we can include this paper and increment `h`.
   - The moment we find a paper where `citations[i] <= h`, we stop, because any subsequent papers will have even fewer citations.
4. **Result:** The value of `h` at the end of the loop is the researcher's h-index.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻 𝗹𝗼𝗴 𝗻) - Due to the `Arrays.sort()` call. The subsequent linear scan is $O(n)$.
* **Space Complexity:** 𝙊(𝟭) or 𝙊(𝗻) - Depending on the implementation of the sorting algorithm (Java's Dual-Pivot Quicksort typically uses $O(\log n)$ stack space).

## 💻 Implementation (Java)
```java
public class Solution {
    public int hIndex(int[] citations) {
        // Sort to bring the highest citations to the end
        Arrays.sort(citations);
        
        int h = 0;
        // Check papers from most cited to least cited
        for (int i = citations.length - 1; i >= 0; i--) {
            // If the citation count is higher than the number of papers counted so far
            if (citations[i] > h) {
                h++;
            } else {
                // Once citations are not enough to increase h, we've found the max h
                break;
            }
        }

        return h;
    }
}
