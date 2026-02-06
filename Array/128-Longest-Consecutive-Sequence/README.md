# 128. Longest Consecutive Sequence (Medium)

## 📝 Problem Statement
Given an unsorted array of integers `nums`, return the length of the longest consecutive elements sequence. The algorithm must run in **O(n)** time.

## 💡 Intuition & Approach
To achieve $O(n)$ time, we cannot sort the array (which would be $O(n \log n)$). Instead, we use a `HashSet` for $O(1)$ lookups. The key is to only start counting a sequence when we find its smallest element.

### 🛠️ The Strategy:
1. **Set Construction:** Dump all numbers into a `HashSet`. This removes duplicates and allows instant lookups.
2. **Finding the Start:** Iterate through the set. For each number `num`, check if `num - 1` exists in the set.
   - If `num - 1` exists, this is NOT the start of a sequence. Skip it.
   - If `num - 1` does NOT exist, this is the **start** of a potential sequence.
3. **Counting:** From the start node, keep checking for `num + 1`, `num + 2`, etc., using the set.
4. **Update Max:** Keep track of the longest sequence length found so far.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - Although there is a `while` loop inside a `for` loop, each number is visited at most twice (once to check for the start, once to be counted).
* **Space Complexity:** 𝙊(𝗻) - We store all unique elements in a `HashSet`.

## 💻 Implementation (Java)
```java
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        int longest = 0;

        for(int num : nums){
            numSet.add(num);
        }

        for(int num : numSet){
            // Check if 'num' is the start of a sequence
            if(!numSet.contains(num - 1)){
                int currentNum = num;
                int seqLength = 1;

                // Count the length of the sequence
                while(numSet.add(currentNum + 1) == false || numSet.contains(currentNum + 1)){
                    currentNum++;
                    seqLength++;
                }
                
                longest = Math.max(longest, seqLength);
            }
        }
        return longest;
    }
}
