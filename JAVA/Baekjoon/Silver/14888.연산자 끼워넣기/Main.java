import java.io.*;
import java.util.*;

public class Main {

    static int max = Integer.MIN_VALUE; // 최댓값
    static int min = Integer.MAX_VALUE; // 최솟값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        int[] op = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
            num[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++)
            op[i] = Integer.parseInt(st.nextToken());

        dfs(N, num, op, num[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int N, int[] num, int[] op, int result, int depth) {
        // 연산자가 다 들어간 경우 계산 진행
        if (depth == N) {
            max = Math.max(max, result);
            min = Math.min(min, result);
        }

        // 연산자 끼워넣기
        for (int i = 0; i < 4; i++) {
            // 사용할 연산자가 남아 있는 경우
            if (op[i] > 0) {
                op[i]--;
                switch (i) {
                    case 0:
                        dfs(N, num, op, result + num[depth], depth + 1);
                        break;
                    case 1:
                        dfs(N, num, op, result - num[depth], depth + 1);
                        break;
                    case 2:
                        dfs(N, num, op, result * num[depth], depth + 1);
                        break;
                    case 3:
                        dfs(N, num, op, result / num[depth], depth + 1);
                        break;
                    default:
                        break;
                }
                op[i]++;
            }
        }
    }
}