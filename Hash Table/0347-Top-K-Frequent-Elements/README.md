# 347. Top K Frequent Elements (Medium)

## 📝 Problem Statement
Given an integer array `nums` and an integer `k`, return the `k` most frequent elements. You may return the answer in any order.

## 💡 Intuition & Approach
The traditional way to fetch top frequent items involves sorting the frequencies ($O(N \log N)$) or maintaining a Priority Queue ($O(N \log K)$). However, we can optimize this to linear time using a **Bucket Sort** strategy.

Since the maximum possible frequency of any element is bounded by the array length $N$, we can create an array of lists (`bucket`) where the index represents the frequency itself.

### 🛠️ The Strategy:
1. **Frequency Mapping:** Walk through `nums` and build a frequency distribution using a `HashMap`.
2. **Bucket Assignment:** Create an array of lists (`bucket`) of size `n + 1`. For each element in our map, place the element value into `bucket[frequency]`.
3. **Reverse Collection:** Scan the buckets backwards starting from index `n` (the highest possible frequency) down to `0`. Collect elements into the result array until exactly `k` items have been extracted.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗡) - Building the hash map takes $O(N)$. Populating the buckets takes $O(U)$ where $U$ is the number of unique numbers ($U \le N$). Collecting the final array reads exactly $K$ values. The overall runtime is strictly linear.
* **Space Complexity:** 𝙊(𝗡) - To store element frequencies in the hash map and manage the bucket lists array.

## 💻 Implementation (Java)
```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Count element frequencies
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Group elements by frequency using buckets
        List<Integer>[] bucket = new ArrayList[n + 1];
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        // Step 3: Gather the top k frequent elements starting from highest bucket
        int[] ans = new int[k];
        int index = 0;

        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    ans[index++] = num;
                    if (index == k) break;
                }
            }
        }

        return ans;
    }
}
