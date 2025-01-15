import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int[][] board = new int[5][5];
        int[] host = new int[25];

        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                board[i][j] = sc.nextInt();

        for (int i = 0; i < 25; i++)
            host[i] = sc.nextInt();

        System.out.println(isBingo(board, host));
        sc.close();
    }

    public static int isBingo(int[][] board, int[] host) {
        int x, y;

        // 빙고 체크하기
        for (int h = 0; h < host.length; h++) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (host[h] == board[i][j]) {
                        board[i][j] = 0;    // 숫자가 불리면 0으로 바꿈
                        break;
                    }
                }
            }
            if (checkBingo(board, host, h))
                return h+1;
            }

        return 25; // 마지막으로 빙고 완성
    }

    public static boolean checkBingo(int[][] board, int[] host, int h) {
        int count = 0;

        // 가로 빙고
        for(int i = 0; i < 5; i++)
            if (board[i][0] + board[i][1] + board[i][2] + board[i][3] + board[i][4] == 0) count++;
        // 세로 빙고
        for(int j = 0; j < 5; j++)
            if (board[0][j] + board[1][j] + board[2][j] + board[3][j] + board[4][j] == 0) count++;
        // 우하향 빙고
        if(board[0][0] + board[1][1] + board[2][2] + board[3][3] + board[4][4] == 0) count++;
        // 좌상향 빙고
        if (board[0][4] + board[1][3] + board[2][2] + board[3][1] + board[4][0] == 0) count++;

        if(count >= 3) return true;

        return false;
    }
}