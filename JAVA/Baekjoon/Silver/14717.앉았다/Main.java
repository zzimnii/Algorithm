import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int count = 0;
        int yh = (A + B) % 10;

        // 땡인 경우
        if (A == B) {
            count = 153 - (10 - A);
        }
        // 끗일 경우
        else {
            for (int i = 1; i <= 10; i++) {
                for (int j = i + 1; j <= 10; j++) {
                    if (yh > (i + j) % 10) {
                        if (i == A && j == B) continue;
                        else if (i == A || j == A || i == B || j == B) {
                            count += 2;
                        }
                        else {
                            count += 4;
                        }
                    }
                }
            }
        }
        System.out.println(String.format("%.3f", (double) count / 153));
        sc.close();
    }
}