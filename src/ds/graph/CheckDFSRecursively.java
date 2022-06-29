package ds.graph;

import ds.linkedlist.DoublyLinkedList;

class CheckDFSRecursively {
    public static String dfs(Graph g) {
        String result = "";
        if (g.vertices < 1) {
            return result;
        }

        boolean[] visited = new boolean[g.vertices];

        for (int i = 0; i < g.vertices; i++) {
            //Checking whether the node is visited or not
            if (!visited[i]) {
                result = result + dfsVisit(g, i, visited);
            }
        }
        return result;
    }

    public static String dfsVisit(Graph g, int i, boolean[] visited) {
        String result = String.valueOf(i);
        visited[i] = true;
        DoublyLinkedList<Integer>.Node temp = null;
        if (g.adjacencyList[i] != null)
            temp = g.adjacencyList[i].headNode;

        while (temp != null) {
            if (!visited[temp.data])
                result += dfsVisit(g, temp.data, visited);

            temp = temp.nextNode;
        }
        return result;
    }

    public static void main(String[] args) {

        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        System.out.println("Graph1:");
        g.printGraph();
        System.out.println("DFS traversal of Graph1 : " + dfs(g));
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 4);
        g2.addEdge(1, 2);
        g2.addEdge(4, 3);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("DFS traversal of Graph2 : " + dfs(g2));
    }
}
