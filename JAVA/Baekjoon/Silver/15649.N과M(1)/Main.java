import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N];
        int[] arr = new int[M];

        combi(N, M, arr, visited, 0);
    }

    public static void combi(int N, int M, int[] arr, boolean[] visited, int depth) {
        // M개 만큼 다 고른 경우
        if (depth == M) {
            for (int i = 0; i < M; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            // 아직 방문 안함
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                combi(N, M, arr, visited, depth + 1);
                visited[i] = false;
            }
        }
        return;
    }
}