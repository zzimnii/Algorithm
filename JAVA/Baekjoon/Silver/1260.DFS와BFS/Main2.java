import java.io.*;
import java.util.*;

public class Main2 {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N + 1];

        // 인접 리스트 생성 및 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 각 노드 연결 리스트를 정렬 (작은 번호부터 방문 보장)
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        // DFS로 탐색 및 출력
        DFS(graph, visited, V);
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
        System.out.println();

        visited = new boolean[N + 1]; // 방문 여부 초기화

        // BFS로 탐색 및 출력
        BFS(graph, visited, V);
    }

    public static void DFS(List<List<Integer>> graph, boolean[] visited, int i) {
        visited[i] = true;
        list.add(i);

        // 연결된 모든 노드를 탐색
        for (int neighbor : graph.get(i)) {
            if (!visited[neighbor]) {
                DFS(graph, visited, neighbor);
            }
        }
    }

    public static void BFS(List<List<Integer>> graph, boolean[] visited, int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = true;

        while (!q.isEmpty()) {
            int temp = q.poll();
            System.out.print(temp + " ");

            // 연결된 모든 노드를 탐색
            for (int neighbor : graph.get(temp)) {
                if (!visited[neighbor]) {
                    q.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        System.out.println();
    }
}