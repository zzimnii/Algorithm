import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = sc.nextLine().toCharArray();
        }

        int totalCount = 32;    // 최악의 경우 32개 다시 칠하기
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int wCount = 0;
                int bCount = 0;
                for (int n = i; n < i + 8; n++) {
                    for (int m = j; m < j + 8; m++) {
                        if ((n + m) % 2 == 0) {
                            if (board[n][m] != 'W') wCount++; // 1번 경우
                            if (board[n][m] != 'B') bCount++; // 2번 경우
                        } else {
                            if (board[n][m] != 'B') wCount++; // 1번 경우
                            if (board[n][m] != 'W') bCount++; // 2번 경우
                        }
                    }
                }
                totalCount = Math.min(totalCount, Math.min(wCount, bCount));
            }
        }
        System.out.println(totalCount);
    }
}