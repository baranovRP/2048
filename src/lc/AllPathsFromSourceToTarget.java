package lc;

import java.util.*;

public class AllPathsFromSourceToTarget {

    // T = O(2^V * V)
    // S = O(V)
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        if (graph == null || graph.length == 0) return result;

        allPathsHelper(graph, 0, new ArrayList<>(), result);
        return result;
    }

    private void allPathsHelper(int[][] graph, int node, ArrayList<Integer> path, List<List<Integer>> paths) {
        path.add(node);
        if (node == graph.length - 1) {
            paths.add(new ArrayList<>(path));
            return;
        }
        int[] nextNodes = graph[node];
        for (int nextNode : nextNodes) {
            allPathsHelper(graph, nextNode, path, paths);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        AllPathsFromSourceToTarget fpg = new AllPathsFromSourceToTarget();
        System.out.println(fpg.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));
        System.out.println(fpg.allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}}));
    }
}
