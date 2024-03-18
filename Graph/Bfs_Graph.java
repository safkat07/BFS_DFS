import java.util.ArrayList;
import java.util.Scanner;

public class Bfs_Graph {
    private int vertices;
    private ArrayList<ArrayList<Integer>> adjacencyList;

    public Bfs_Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    public void BFS(int startVertex) {
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            visited[i] = false;
        }

        ArrayList<Integer> queue = new ArrayList<Integer>();
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.remove(0);
            System.out.print(currentVertex + " ");

            for (int adjacent : adjacencyList.get(currentVertex)) {
                if (!visited[adjacent]) {
                    visited[adjacent] = true;
                    queue.add(adjacent);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        System.out.println("Enter the number of edges: ");
        int edges = scanner.nextInt();

        Bfs_Graph graph = new Bfs_Graph(vertices);

        System.out.println("Enter the edges (source destination):");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }

        System.out.print("Enter the starting vertex for BFS traversal: ");
        int startVertex = scanner.nextInt();

        graph.BFS(startVertex);
    }
}