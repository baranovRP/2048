package ds.graph;

import ds.linkedlist.DoublyLinkedList;
import ds.stack_queue.Queue;

class CheckBFS {

    // Since this algorithm traverses the whole graph once
    // Time = O(V + E)
    public static String bfs(Graph g) {

        String result = "";
        //Checking if the graph has no vertices
        if (g.vertices < 1) {
            return result;
        }

        //Boolean Array to hold the history of visited nodes (by default-false)
        boolean[] visited = new boolean[g.vertices];

        for (int i = 0; i < g.vertices; i++) {
            //Checking whether the node is visited or not
            if (!visited[i]) {
                result = result + bfsVisit(g, i, visited);
            }
        }
        return result;
    }

    public static String bfsVisit(Graph g, int source, boolean[] visited) {

        String result = "";

        //Create Queue for Breadth First Traversal and enqueue source in it
        Queue<Integer> queue = new Queue<>(g.vertices);

        queue.enqueue(source);
        visited[source] = true;

        //Traverse while queue is not empty
        while (!queue.isEmpty()) {

            //Dequeue a vertex/node from queue and add it to result
            int currentNode = queue.dequeue();

            result += String.valueOf(currentNode);

            //Get adjacent vertices to the currentNode from the array,
            //and if they are not already visited then enqueue them in the Queue
            DoublyLinkedList<Integer>.Node temp = null;
            if (g.adjacencyList[currentNode] != null)
                temp = g.adjacencyList[currentNode].headNode;

            while (temp != null) {

                if (!visited[temp.data]) {
                    queue.enqueue(temp.data);
                    visited[temp.data] = true; //Visit the current Node
                }
                temp = temp.nextNode;
            }
        }//end of while
        return result;
    }

    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        System.out.println("Graph1:");
        g.printGraph();
        System.out.println("BFS traversal of Graph1 : " + bfs(g));
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 4);
        g2.addEdge(1, 2);
        g2.addEdge(3, 4);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("BFS traversal of Graph2 : " + bfs(g2));
    }
}
