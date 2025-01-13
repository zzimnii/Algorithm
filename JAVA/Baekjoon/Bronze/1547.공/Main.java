import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int[] cups = {1, -1, -1};

        for (int i = 0; i < M; i++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            swap(cups, X, Y);
        }

        for (int i = 0; i < cups.length; i++)
            if (cups[i] == 1) System.out.println(i + 1);

        sc.close();
    }

    public static void swap(int[] cups, int x, int y) {
        int tmp;

        tmp = cups[x - 1];
        cups[x - 1] = cups[y - 1];
        cups[y - 1] = tmp;
    }
}