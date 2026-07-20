# 1922. Count Good Numbers (Medium)

## 📝 Problem Statement

A digit string is considered **good** if:

- Digits at **even indices (0-based)** are **even** (`0, 2, 4, 6, 8`).
- Digits at **odd indices** are **prime** (`2, 3, 5, 7`).

Given an integer `n`, return the total number of good digit strings of length `n`.

Since the answer can be very large, return it modulo **10⁹ + 7**.

---

## 💡 Intuition & Approach

Instead of generating every possible string, observe that each position contributes independently to the total count.

- Every **even index** has **5 possible choices**: `{0, 2, 4, 6, 8}`.
- Every **odd index** has **4 possible choices**: `{2, 3, 5, 7}`.

For a string of length `n`:

- Number of even positions = `(n + 1) / 2`
- Number of odd positions = `n / 2`

Therefore,

**Total Good Strings = 5^(even positions) × 4^(odd positions)**

Since `n` can be as large as **10¹⁵**, directly computing these powers is infeasible. We use **Binary Exponentiation (Fast Modular Exponentiation)** to efficiently calculate large powers under modulo arithmetic.

### 🛠️ The Strategy

1. **Count Position Types**
   - Compute the number of even and odd indexed positions.

2. **Compute Large Powers Efficiently**
   - Calculate `5^(even positions)` using Binary Exponentiation.
   - Calculate `4^(odd positions)` using Binary Exponentiation.

3. **Apply Modular Arithmetic**
   - Multiply both results and take modulo `10⁹ + 7`.

4. **Return the Final Answer**
   - The result represents the total number of valid digit strings.

---

## 📊 Complexity Analysis

- **Time Complexity:** **O(log n)** - Binary Exponentiation reduces exponentiation to logarithmic time.

- **Space Complexity:** **O(1)** - Only a few variables are used.

---

## 💻 Implementation (Java)

```java
class Solution {
    public int countGoodNumbers(long n) {
        if(n == 1) return 5;

        long even = (n + 1) / 2;
        long odd = n / 2;
        long mod = 1000000007;

        return (int)((helper(5, even, mod) * helper(4, odd, mod)) % mod);
    }

    private long helper(long base, long expo, long mod) {
        long ans = 1;

        while(expo > 0) {
            if(expo % 2 == 0) {
                base = (base * base) % mod;
                expo /= 2;
            } else {
                ans = (ans * base) % mod;
                expo--;
            }
        }

        return ans;
    }
}
```
