import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 퇴사 일
        List<Integer> T = new ArrayList<>();    // 상담 기간
        List<Integer> P = new ArrayList<>();    // 수익

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            T.add(Integer.parseInt(st.nextToken()));
            P.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(profit(N, T, P));
    }

    public static int profit(int N, List<Integer> T, List<Integer> P) {
        int[] dp = new int[N + 1];    // 수익 저장 dp
        Arrays.fill(dp, 0);

        for (int i = 0; i < N; i++) {
            // 상담을 하는 경우 ->(상담 완료되는 날의 최대 이익 + 상담 이익 추가)
            if (i + T.get(i) <= N)
                dp[i + T.get(i)] = Math.max(dp[i + T.get(i)], dp[i] + P.get(i));
            // 상담을 못하는 경우 -> 현재까지의 최대 이익을 다음 날로 유지
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }
        return dp[N];
    }
}