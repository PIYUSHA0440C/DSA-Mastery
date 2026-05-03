# 187. Repeated DNA Sequences (Medium)

## 📝 Problem Statement
A DNA sequence is composed of 'A', 'C', 'G', and 'T'. Given a string `s`, return all 10-letter-long substrings that occur more than once in the sequence.

## 💡 Intuition & Approach
Since the target length is fixed at 10, we can use a sliding window of size 10 to extract all possible substrings and track their occurrences.

### 🛠️ The Strategy:
1. **Edge Case:** If the string length is less than 10, return an empty list immediately.
2. **Two-Set Logic:**
   - `seen` Set: Stores every 10-letter substring we encounter.
   - `res` Set: Stores substrings that have appeared at least twice. Using a Set for results automatically prevents duplicate entries in the final output.
3. **Iteration:** Loop from `0` to `s.length() - 10`.
   - Extract the substring using `s.substring(i, i + 10)`.
   - Attempt to add it to the `seen` set. If `seen.add()` returns `false`, it means we've seen this exact sequence before, so we add it to the `res` set.
4. **Result:** Convert the `res` set into a List and return.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗡) - We traverse the string once. While `substring` and `hashing` take $O(10)$ time, since 10 is a constant, it simplifies to $O(N)$.
* **Space Complexity:** 𝙊(𝗡) - In the worst case, we store almost all substrings of length 10 in our sets.

## 💻 Implementation (Java)
```java
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        if (len < 10) return new ArrayList<>();

        Set<String> seen = new HashSet<>();
        Set<String> res = new HashSet<>();

        for (int i = 0; i <= len - 10; i++) {
            String sub = s.substring(i, i + 10);
            
            // add() returns false if the element was already present
            if (!seen.add(sub)) {
                res.add(sub);
            }
        }

        return new ArrayList<>(res);
    }
}
