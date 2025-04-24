import java.util.*;

public class PathFinder {

    static class Edge {
        int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    // Depth First Search to find all paths
    static void dfs(List<List<Edge>> graph, int u, int w, int length, List<Integer> path, boolean[] visited) {
        visited[u] = true;
        path.add(u);

        // If length of path is 7, print path
        if (path.size() == length + 1 && u == w) {
            System.out.println(path);
        }
        else if (path.size() <= length) {
            for (Edge e : graph.get(u)) {
                if (!visited[e.to]) {
                    dfs(graph, e.to, w, length, path, visited);
                }
            }
        }

        visited[u] = false;
        path.removeLast();
    }

    public static void main(String[] args) {
        int V = 4;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Edge(0, 1, 1));
        graph.get(0).add(new Edge(0, 2, 1));
        graph.get(1).add(new Edge(1, 2, 1));
        graph.get(1).add(new Edge(1, 3, 1));
        graph.get(2).add(new Edge(2, 3, 1));

        int u = 0;
        int w = 3;
        int length = 7;

        int u2 = 0;
        int w2 = 3;
        int length2 = 3;

        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[V];

        dfs(graph, u, w, length, path, visited);
        dfs(graph,u2,w2,length2,path,visited);
    }
}
