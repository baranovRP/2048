package lc;

import java.util.*;

public class FindIfPathExistsInGraph {

    public boolean validPathAdjacencyList(int n, int[][] edges, int source, int destination) {
        boolean result = false;
        if (edges == null) return false;
        LinkedList<Integer>[] adjacencyList = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new LinkedList<>();
        }

        for (int[] temp : edges) {
            adjacencyList[temp[0]].add(temp[1]);
            adjacencyList[temp[1]].add(temp[0]);
        }
        boolean[] visited = new boolean[n];
        Stack<Integer> s = new Stack<>();
        s.push(source);

        while (!s.isEmpty()) {
            int temp = s.pop();
            LinkedList<Integer> paths = adjacencyList[temp];
            for (int curr : paths) {
                if (!visited[curr]) {
                    if (curr == destination) return true;
                    s.push(curr);
                }
            }
            visited[temp] = true;
        }
        if (visited[source] && visited[destination]) result = true;
        return result;
    }

    public boolean validPathAdjacencyMatrix(int n, int[][] edges, int source, int destination) {
        boolean result = false;
        if (edges == null) return false;

        int[][] adjm = new int[n][n];
        for (int[] temp : edges) {
            adjm[temp[0]][temp[1]] = 1;
            adjm[temp[1]][temp[0]] = 1;
        }
        boolean[] visited = new boolean[n];
        Stack<Integer> s = new Stack<>();
        s.push(source);

        while (!s.isEmpty()) {
            int temp = s.pop();
            for (int curr = 0; curr < adjm[temp].length; curr++) {
                boolean isConnected = adjm[temp][curr] == 1;
                if (!visited[curr] && isConnected) {
                    if (curr == destination) return true;
                    s.push(curr);
                }
            }
            visited[temp] = true;
        }
        if (visited[source] && visited[destination]) result = true;
        return result;
    }

    // lc solution
    // T = O(V+E)
    // S = O(V+E)
    public boolean validPath(int n, int[][] edges, int start, int end) {
        List<List<Integer>> adjacency_list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacency_list.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacency_list.get(edge[0]).add(edge[1]);
            adjacency_list.get(edge[1]).add(edge[0]);
        }

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        boolean seen[] = new boolean[n];
        Arrays.fill(seen, false);

        while (!stack.isEmpty()) {
            // Get the current node.
            int node = stack.pop();

            // Check if we have reached the target node.
            if (node == end) {
                return true;
            }

            // Check if we've already visited this node.
            if (seen[node]) {
                continue;
            }
            seen[node] = true;

            // Add all neighbors to the stack.
            for (int neighbor : adjacency_list.get(node)) {
                stack.push(neighbor);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        FindIfPathExistsInGraph fpg = new FindIfPathExistsInGraph();
        System.out.println(fpg.validPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2));
        System.out.println(fpg.validPath(6, new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5));
        System.out.println(fpg.validPath(1, new int[][]{}, 0, 0));
        System.out.println(fpg.validPath(10, new int[][]{{4, 3}, {1, 4}, {4, 8}, {1, 7}, {6, 4}, {4, 2}, {7, 4}, {4, 0}, {0, 9}, {5, 4}}, 5, 9));
        System.out.println(fpg.validPath(10, new int[][]{{0, 7}, {0, 8}, {6, 1}, {2, 0}, {0, 4}, {5, 8}, {4, 7}, {1, 3}, {3, 5}, {6, 5}}, 7, 5));
    }
}
