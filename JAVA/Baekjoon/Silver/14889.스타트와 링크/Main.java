import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 최솟값 갱신
        int result = combi(N, visited, map, 0, 0, Integer.MAX_VALUE);
        System.out.println(result); // 최솟값 출력
    }

    public static int combi(int N, boolean[] visited, int[][] map, int idx, int depth, int minDiff) {
        // 팀 조합이 완성된 경우
        if (depth == N / 2) {
            int startTeam = 0, linkTeam = 0;

            // 두 팀의 능력치 계산
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (visited[i] && visited[j]) {
                        startTeam += map[i][j];
                        startTeam += map[j][i];
                    } else if (!visited[i] && !visited[j]) {
                        linkTeam += map[i][j];
                        linkTeam += map[j][i];
                    }
                }
            }

            // 능력치 차이 계산
            int diff = Math.abs(startTeam - linkTeam);
            return Math.min(minDiff, diff); // 최솟값 반환
        }

        // 조합 탐색
        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true; // 방문 표시
                // 현재 재귀에서 최솟값 구하기
                minDiff = combi(N, visited, map, i + 1, depth + 1, minDiff);
                visited[i] = false; // 복구
            }
        }

        return minDiff; // 최솟값 반환
    }
}