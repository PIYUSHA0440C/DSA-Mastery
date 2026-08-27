# 2390. Removing Stars From a String (Medium)


## 📝 Problem Statement


Given a string `s` containing lowercase English letters and stars `*`, remove the closest non-star character to the left of every star along with the star itself.


Return the resulting string after all stars have been removed.


## 💡 Intuition & Approach


We can simulate the removal process using a **StringBuilder as a stack**.


While traversing the string:


- If the current character is not a star, append it to the `StringBuilder`.
- If the current character is a star, remove the last character from the `StringBuilder`, which represents the closest non-star character to its left.


Because each star removes the most recently added character, this naturally follows **Last-In-First-Out (LIFO)** behavior.


### 🛠️ The Strategy:


1. Create an empty `StringBuilder`.
2. Traverse the string character by character.
3. If the character is not `*`, append it to the `StringBuilder`.
4. If the character is `*`, remove the last character from the `StringBuilder`.
5. Continue until the entire string is processed.
6. Return the resulting `StringBuilder` as a string.


## 📊 Complexity Analysis


* **Time Complexity:** O(n) - Each character is processed once.


* **Space Complexity:** O(n) - The `StringBuilder` can store up to n characters.


## 💻 Implementation (Java)


```java
class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(char ch: s.toCharArray()){
            if(ch == '*') sb.deleteCharAt(sb.length() - 1);
            else sb.append(ch);
        }

        return sb.toString();
    }
}
