import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Parent_Bfs {
    private int vertices;
    private ArrayList<ArrayList<Integer>> adjacencyList;
    private int[] parent;

    public Parent_Bfs(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<ArrayList<Integer>>();
        parent = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<Integer>());
            parent[i] = -1;
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

        Queue<Integer> queue = new LinkedList<Integer>();
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (int adjacent : adjacencyList.get(currentVertex)) {
                if (!visited[adjacent]) {
                    visited[adjacent] = true;
                    queue.add(adjacent);
                    parent[adjacent] = currentVertex;
                }
            }
        }
    }

    public int getParent(int vertex) {
        return parent[vertex];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        System.out.println("Enter the number of edges: ");int edges = scanner.nextInt();

        Parent_Bfs graph = new Parent_Bfs(vertices);

        System.out.println("Enter the edges (source destination):");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }

        System.out.print("Enter the starting vertex for BFS traversal: ");
        int startVertex = scanner.nextInt();

        graph.BFS(startVertex);

        System.out.println("Parent of each vertex:");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Vertex " + i + " has parent " + graph.getParent(i));
        }
    }
}