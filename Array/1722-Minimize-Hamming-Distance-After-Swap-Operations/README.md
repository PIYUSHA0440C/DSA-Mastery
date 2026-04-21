# 1722. Minimize Hamming Distance After Swap Operations (Medium)

## 📝 Problem Statement
Given `source` and `target` arrays and a list of `allowedSwaps`, return the minimum Hamming distance. A swap at $(a, b)$ means you can swap elements at those indices any number of times.

## 💡 Intuition & Approach
Swaps are transitive. If index $0$ can swap with $1$, and $1$ with $2$, then $\{0, 1, 2\}$ form a group where any element can move to any position within these indices.

### 🛠️ The Strategy:
1. **Union-Find (DSU):** Treat indices as nodes and `allowedSwaps` as edges. Use DSU to group indices into connected components.
2. **Frequency Mapping:** For each component (identified by its `root`), create a frequency map of the values present in `source` at those indices.
3. **Greedy Matching:** - Iterate through each index $i$ of the `target` array.
   - Find the component `root` that index $i$ belongs to.
   - Check if the frequency map for that component has the value `target[i]`.
   - If it does, "use" that value (decrement frequency).
   - If not, it's impossible to match this position, so increment the Hamming distance.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊((𝗡 + 𝗦)α(𝗡)) - Where $N$ is array length and $S$ is number of swaps. $\alpha$ is the inverse Ackermann function (nearly constant).
* **Space Complexity:** 𝙊(𝗡) - To store the parent array for DSU and the frequency maps for values.

## 💻 Implementation (Java)
```java
class Solution {
    private int[] parent;

    private int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private void unite(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) parent[rootA] = rootB;
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        // Group indices that can be swapped
        for (int[] swap : allowedSwaps) unite(swap[0], swap[1]);

        // Map: Component Root -> {Value -> Frequency}
        Map<Integer, Map<Integer, Integer>> groupFreq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i);
            groupFreq.computeIfAbsent(root, k -> new HashMap<>())
                     .merge(source[i], 1, Integer::sum);
        }

        int hammingDistance = 0;
        for (int i = 0; i < n; i++) {
            int root = find(i);
            Map<Integer, Integer> freq = groupFreq.get(root);
            
            // Check if target[i] is available in its connected component
            if (freq.getOrDefault(target[i], 0) > 0) {
                freq.put(target[i], freq.get(target[i]) - 1);
            } else {
                hammingDistance++;
            }
        }

        return hammingDistance;
    }
}
