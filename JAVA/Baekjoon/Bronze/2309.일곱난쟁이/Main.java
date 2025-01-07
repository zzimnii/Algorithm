import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> dwarfs = new ArrayList<>();
        int total = 0;

        for(int i = 0; i < 9; i++) {
            dwarfs.add(Integer.parseInt(br.readLine()));
            total += dwarfs.get(i);
        }

        for(int i = 0; i < 9; i++) {
            int n = total - 100;
            n -= dwarfs.get(i);
            if(dwarfs.contains(n) && (dwarfs.get(i) != n)) {
                dwarfs.remove(i);
                dwarfs.remove(dwarfs.indexOf(n));
                break;
            }
        }

        Collections.sort(dwarfs);
        for(int i = 0; i < 7; i++){
            System.out.println(dwarfs.get(i));
        }
    }
}