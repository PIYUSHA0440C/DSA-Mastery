# 2784. Check if Array is Good (Easy)

## 📝 Problem Statement
An array is considered **good** if it is a permutation of `base[n] = [1, 2, ..., n-1, n, n]`. 
Given an array `nums`, return `true` if it's a good array, otherwise `false`.

## 💡 Intuition & Approach
The length of a `base[n]` array is always $n + 1$. Therefore, for any given `nums`, we can deduce that $n$ must be `nums.length - 1`.

### 🛠️ The Strategy:
1. **Identify n:** Set `n = nums.length - 1`.
2. **Frequency Count:** Use a frequency array (or bucket) to count occurrences of each number in `nums`.
3. **Validation Rules:**
   - Any number greater than `n` makes the array "bad."
   - Every number from $1$ to $n-1$ must appear exactly **once**.
   - The number $n$ must appear exactly **twice**.
4. **Boundary Case:** If `nums.length` is too small to even form `base[1]`, it should be handled (though constraints usually prevent this).

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗡) - We iterate through the input array once and the frequency array once.
* **Space Complexity:** 𝙊(𝗡) - We use a frequency array of size $n$.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length - 1;
        if (n <= 0) return false; // base[n] starts from n=1 ([1,1])

        int[] freq = new int[n + 1];
        for (int num : nums) {
            // If any number is out of the expected range [1, n]
            if (num > n || num < 1) return false;
            freq[num]++;
        }

        // Check frequencies: 1 to n-1 must appear once, n must appear twice
        for (int i = 1; i < n; i++) {
            if (freq[i] != 1) return false;
        }
        
        return freq[n] == 2;
    }
}
