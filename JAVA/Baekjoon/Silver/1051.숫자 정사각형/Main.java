import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] charArr = sc.nextLine().toCharArray();
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(charArr[j]));
            }
        }

        int maxSize = 1;    // 최대 변의 길이
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for(int size = 1; i + size < N && j + size < M; size++) {
                    if(board[i][j]==board[i+size][j] && board[i][j]==board[i][j+size] && board[i][j]==board[i+size][j+size])
                        maxSize = Math.max(maxSize, size+1);
                }
            }
        }
        System.out.println(maxSize*maxSize);
        sc.close();
    }
}