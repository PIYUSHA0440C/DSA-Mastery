# 709. To Lower Case (Easy)

## 📝 Problem Statement
Given a string `s`, return the string after replacing every uppercase letter with the same lowercase letter.

## 💡 Intuition & Approach
In Java, the `String` class provides a built-in `toLowerCase()` method. This is the most efficient and readable way to handle locale-insensitive string conversions.

### 🛠️ The Strategy:
1. **Leverage Standard Library:** Use the built-in `s.toLowerCase()` which is highly optimized by the JVM.
2. **Handling Immutability:** Since strings in Java are immutable, the method returns a brand-new string with the characters converted.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - Every character in the string must be checked/converted.
* **Space Complexity:** 𝙊(𝗻) - A new string object is created to store the result.

## 💻 Implementation (Java)
```java
class Solution {
    public String toLowerCase(String s) {
        // Direct use of Java's built-in String manipulation
        return s.toLowerCase();
    }
}
