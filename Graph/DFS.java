import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class DFS {

    // Function to perform DFS traversal
    public static void dfs(ArrayList<ArrayList<Integer>> adjList, int startNode) {
        boolean[] visited = new boolean[adjList.size()];
        Stack<Integer> stack = new Stack<>();

        stack.push(startNode);

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();
            if (!visited[currentNode]) {
                visited[currentNode] = true;
                System.out.print((currentNode + 1) + " "); // Adjust index to 1-indexed

                // Push all unvisited neighbors to the stack
                for (int neighbor : adjList.get(currentNode)) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter the edges (format: vertex1 vertex2): ");
        for (int i = 0; i < edges; i++) {
            int vertex1 = scanner.nextInt() - 1; // Adjust index to 0-indexed
            int vertex2 = scanner.nextInt() - 1; // Adjust index to 0-indexed

            // Add edges to the adjacency list (assuming undirected graph)
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
        }

        System.out.print("Enter the starting node for DFS: ");
        int startNode = scanner.nextInt() - 1; // Adjust index to 0-indexed

        System.out.println("DFS traversal starting from node " + (startNode + 1) + ": "); // Adjust index to 1-indexed
        dfs(adjList, startNode);

        scanner.close();
    }
}
