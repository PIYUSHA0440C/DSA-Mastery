# 207. Course Schedule (Medium)

## 📝 Problem Statement
There are a total of `numCourses` courses labeled from `0` to `numCourses - 1`.

You are given an array `prerequisites` where `prerequisites[i] = [a, b]` indicates that you must complete course `b` before taking course `a`.

Return `true` if it is possible to finish all courses; otherwise, return `false`.

---

## 💡 Intuition & Approach

This problem can be modeled as a **Directed Graph**, where each course represents a node and every prerequisite forms a directed edge.

- An edge `b → a` means course `b` must be completed before course `a`.
- If the graph contains a **cycle**, the courses involved in that cycle can never satisfy all prerequisite requirements.
- Therefore, the task reduces to determining whether the directed graph is **acyclic**.

To detect cycles efficiently, we apply **Kahn's Algorithm (Topological Sorting using BFS)**.

### 🛠️ The Strategy

1. **Build the Graph**
   - Create an adjacency list representing prerequisite dependencies.
   - Compute the indegree (number of incoming edges) for every course.

2. **Initialize the Queue**
   - Insert every course having an indegree of `0` into a queue.
   - These courses have no prerequisites and can be taken immediately.

3. **Perform BFS (Topological Sort)**
   - Remove a course from the queue.
   - Count it as completed.
   - Reduce the indegree of all dependent courses.
   - Whenever a dependent course reaches indegree `0`, add it to the queue.

4. **Cycle Detection**
   - If every course gets processed, all prerequisites can be satisfied.
   - Otherwise, some courses remain locked inside a cycle, making completion impossible.

---

## 📊 Complexity Analysis

- **Time Complexity:** **O(V + E)**, where `V` is the number of courses and `E` is the number of prerequisite relations. Every course and dependency is processed exactly once.

- **Space Complexity:** **O(V + E)** for storing the adjacency list, indegree array, and BFS queue.

---

## 💻 Implementation (Java)

```java
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        int[] indegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0)
                q.add(i);

        int count = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            count++;

            for (int next : adj.get(node)) {
                indegree[next]--;

                if (indegree[next] == 0)
                    q.add(next);
            }
        }

        return count == numCourses;
    }
}
```
