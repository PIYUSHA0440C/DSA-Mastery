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
            if (indegree[i] == 0) q.add(i);

        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;

            for (int next : adj.get(node)) {
                indegree[next]--;
                if (indegree[next] == 0) q.add(next);
            }
        }

        return count == numCourses;
    }
}

