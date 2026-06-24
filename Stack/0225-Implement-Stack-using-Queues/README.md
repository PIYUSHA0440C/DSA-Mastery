# 225. Implement Stack using Queues (Easy)

## 📝 Problem Statement
Implement a last-in-first-out (LIFO) stack using queues. The implemented stack should support all the functions of a normal stack (`push`, `top`, `pop`, and `empty`).

## 💡 Intuition & Approach
A stack operates on a Last-In-First-Out (LIFO) basis, whereas a queue operates on a First-In-First-Out (FIFO) basis. The follow-up challenge asks to implement this using only **one queue**.

By using a single queue, we can simulate LIFO behavior by rotating the queue elements during retrieval operations (`pop` and `top`). When we need to access the most recently added element (which is sitting at the very back of the queue), we cyclically shift the first `size - 1` elements by removing them from the front and adding them back to the rear. This repositioning pushes the last inserted element directly to the front of the queue, making it immediately accessible.

### 🛠️ The Strategy:
1. **Push (O(1)):** Simply add the element to the back of the queue.
2. **Pop (O(N)):** Find the queue's size $N$. Loop $N - 1$ times to remove elements from the front and re-queue them at the back. The target element is now at the front; remove and return it.
3. **Top (O(N)):** Follow the exact same rotation mechanism as `pop` to bring the target element to the front. Capture its value using `peek()`, then perform one final rotation (`q.add(q.remove())`) to restore the queue's original structural order.
4. **Empty (O(1)):** Return true if the internal queue size equals 0.

## 📊 Complexity Analysis
* **Time Complexity:**-
  * `push`: O(1) - Direct appending to the back of the queue.
  * `pop` / `top`: O(N) - Requires rotating $N-1$ elements to access the back item.
  * `empty`: O(1) - Simple size attribute evaluation.
* **Space Complexity:** O(N) - Linear space used to store stack elements within a single queue structure.

## 💻 Implementation (Java)
```java
class MyStack {
    Queue<Integer> q = new LinkedList<>();
    
    public MyStack() {    
    }
    
    public void push(int x) {
        q.add(x); // O(1) insertion
    }
    
    public int pop() {
        int n = q.size();
        // Rotate the first n-1 elements to the back
        for (int i = 0; i < n - 1; i++) {
            q.add(q.remove());
        }
        return q.remove(); // Remove and return the original last element
    }
    
    public int top() {
        int n = q.size();
        // Rotate the first n-1 elements to the back
        for (int i = 0; i < n - 1; i++) {
            q.add(q.remove());
        }
        int R = q.peek(); // Capture the top element value
        q.add(q.remove()); // Rotate it to restore original queue order
        return R;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}
