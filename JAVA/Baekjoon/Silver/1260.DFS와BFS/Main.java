import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N + 1][N + 1];
        boolean[] visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u][v] = graph[v][u] = 1;
        }

        // DFS로 탐색 및 출력
        DFS(N, graph, visited, V);
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
        System.out.println();

        visited = new boolean[N+1]; // 방문여부 초기화
        // BFS로 탐색 및 출력
        BFS(N, graph, visited, V);
    }

    public static void DFS(int N, int[][] graph, boolean[] visited, int i) {
        visited[i] = true;
        list.add(i);
        for (int j = 1; j < N + 1; j++)
            if (graph[i][j] == 1 && !visited[j])
                DFS(N, graph, visited, j);
    }

    public static void BFS(int N, int[][] graph, boolean[] visited, int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = true;

        while (!q.isEmpty()) {
            int temp = q.poll();
            System.out.print(temp + " ");
            for (int j = 1; j < N + 1; j++) {
                if(graph[temp][j] == 1 && !visited[j]){
                    q.add(j);
                    visited[j] = true;
                }
            }
        }
    }
}