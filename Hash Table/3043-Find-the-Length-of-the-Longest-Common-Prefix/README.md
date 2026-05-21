# 3043. Find the Length of the Longest Common Prefix (Medium)

## 📝 Problem Statement
You are given two arrays with positive integers `arr1` and `arr2`. A prefix of an integer is formed by one or more of its digits, starting from its leftmost digit. Find the length of the longest common prefix between all pairs of integers `(x, y)` such that `x` belongs to `arr1` and `y` belongs to `arr2`.

## 💡 Intuition & Approach
A naive pair-wise comparison ($O(N \times M)$) would easily time out given constraints up to $5 \times 10^4$. 

Instead of treating numbers as strings or building a complex string Trie, we can break down integers mathematically. Dividing a positive integer by $10$ strips away its last digit, effectively generating its prefixes from right to left (e.g., `123` $\rightarrow$ `12` $\rightarrow$ `1`).

### 🛠️ The Strategy:
1. **Build the Prefix Registry:** Loop through every integer in `arr1`. Repeatedly divide each number by $10$, inserting all of its generated numerical prefixes into a `HashSet`.
2. **Scan and Match:** Loop through every integer in `arr2`. Repeatedly divide each number by $10$ to look up its prefixes inside the `HashSet`.
3. **Track Max Length:** If a prefix is found in the set, determine its length (number of digits) and update our maximum length `ans`.
4. **Early Exit Opportunity:** Since we strip digits from right to left, the first match we hit for a number from `arr2` will always be its longest possible match. We can optimize further by updating the max length and breaking early for that specific integer.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗡 • 𝗟 + 𝗠 • 𝗟) - Where $N$ is the length of `arr1`, $M$ is the length of `arr2`, and $L$ is the maximum number of digits in an integer (since numbers $\le 10^8$, $L \le 9$). Because $L$ is a small constant, this runs effectively in linear $O(N + M)$ time.
* **Space Complexity:** 𝙊(𝗡 • 𝗟) - To store the generated numerical prefixes of `arr1` inside the `HashSet`.

## 💻 Implementation (Java)
```java
class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;

        // Step 1: Register all mathematical prefixes of arr1
        for (int num : arr1) {
            while (num > 0) {
                set.add(num);
                num /= 10;
            }
        }

        // Step 2: Match prefixes of arr2 against the registry
        for (int num : arr2) {
            while (num > 0) {
                if (set.contains(num)) {
                    ans = Math.max(ans, length(num));
                    // Optimization: Once a match is found for this number, 
                    // smaller prefixes won't exceed this length, so we can break.
                    break; 
                }
                num /= 10;
            }
        }

        return ans;
    }

    // Helper method to compute digit count
    private int length(int num) {
        int ans = 0;
        while (num > 0) {
            ans++;
            num /= 10;
        }
        return ans;
    }
}
