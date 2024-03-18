import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class PathFinderDFS {

    // Function to perform DFS traversal to find path from source to destination
    public static boolean dfs(ArrayList<ArrayList<Integer>> adjList, int source, int destination) {
        boolean[] visited = new boolean[adjList.size()];
        Stack<Integer> stack = new Stack<>();
        int[] parent = new int[adjList.size()];

        stack.push(source);
        parent[source] = -1;

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();
            if (currentNode == destination) {
                // Print the path
                printPath(parent, source, destination);
                return true; // Path found
            }
            if (!visited[currentNode]) {
                visited[currentNode] = true;

                // Push all unvisited neighbors to the stack
                for (int neighbor : adjList.get(currentNode)) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                        parent[neighbor] = currentNode;
                    }
                }
            }
        }
        return false; // Path not found
    }

    // Function to print the path from source to destination
    private static void printPath(int[] parent, int source, int destination) {
        ArrayList<Integer> path = new ArrayList<>();
        int current = destination;
        while (current != -1) {
            path.add(current);
            current = parent[current];
        }
        System.out.print("Path: ");
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + 1);
            if (i > 0) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
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

        System.out.print("Enter the source node: ");
        int source = scanner.nextInt() - 1; // Adjust index to 0-indexed

        System.out.print("Enter the destination node: ");
        int destination = scanner.nextInt() - 1; // Adjust index to 0-indexed

        if (dfs(adjList, source, destination)) {
            System.out.println("Path exists from node " + (source + 1) + " to node " + (destination + 1));
        } else {
            System.out.println("Path does not exist from node " + (source + 1) + " to node " + (destination + 1));
        }

        scanner.close();
    }
}
