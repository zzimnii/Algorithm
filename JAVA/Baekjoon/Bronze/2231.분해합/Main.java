import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 1; i < N; i++) {
            int sum = i;
            int x = i;
            while(x > 0){
                sum += (x % 10);
                x /= 10;
            }

            if (sum==N) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}