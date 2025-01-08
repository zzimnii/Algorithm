import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] eureka = new int[1001];
        List<Integer> kList = new ArrayList<Integer>();

        for(int i = 0; i < n; i++) {
            kList.add(Integer.parseInt(br.readLine()));
            Eureka(eureka, kList.get(i));
        }

        for(int i = 0; i < n; i++) {
            System.out.println(findEureka(eureka, kList.get(i)));
        }
    }

    public static int[] Eureka(int[] eureka, int n) {
        for (int i = 0; i < n; i++) {
            if (eureka[i] == 0) {
                eureka[i] = i * (i + 1) / 2;
            }
        }
        return eureka;
    }

    public static int findEureka(int[] eureka, int n) {
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                int m = n-(eureka[i] + eureka[j]);
                for(int k = 1; k < n; k++) {
                    if(eureka[k] == m)
                        return 1;
                }
            }
        }
        return 0;
    }
}
