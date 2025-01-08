import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] eureka = new int[45];
        List<Integer> kList = new ArrayList<Integer>();

        int n = Integer.parseInt(br.readLine());
        Eureka(eureka, 45);

        for(int i = 0; i < n; i++) {
            kList.add(Integer.parseInt(br.readLine()));
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
        for(int i = 1; i < eureka.length; i++) {
            for(int j = 1; j < eureka.length; j++) {
                for(int k = 1; k < eureka.length; k++) {
                    if(eureka[i] + eureka[j] + eureka[k] == n)
                        return 1;
                }
            }
        }
        return 0;
    }
}