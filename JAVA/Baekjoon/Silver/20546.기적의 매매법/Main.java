import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 현금, 주가 입력
        int cash = Integer.parseInt(br.readLine());
        List<Integer> stocks = new ArrayList<>();
        for (String str : br.readLine().split(" ")) {
            stocks.add(Integer.parseInt(str));
        }

        int bnp = BNP(cash, stocks);
        int timing = TIMING(cash, stocks);
//        System.out.println(bnp + ","+timing);
        if(bnp > timing)
            System.out.println("BNP");
        else if(bnp < timing)
            System.out.println("TIMING");
        else System.out.println("SAMESAME");
    }

    public static int BNP(int cash, List<Integer> stocks) {
        int num = 0; // 총 주식 수
        for (int i = 0; i < stocks.size(); i++) {
            if (cash >= stocks.get(i)) {
                num += cash / stocks.get(i);
                cash -= num * stocks.get(i);
            }
        }
        return cash + num * stocks.get(13);
    }

    public static int TIMING(int cash, List<Integer> stocks) {
        List<Integer> flow = flowOfStock(stocks);
        int num = 0; // 총 주식 수
        for (int i = 2; i < flow.size(); i++) {
            int n = flow.get(i-2) + flow.get(i-1) + flow.get(i);    // 3일 동안 상승/하락
            // 하락 3일(-3 이면) -> 전량 매수
            if (n == -3) {
                if (cash >= stocks.get(i)) {
                    num += cash / stocks.get(i + 1);
                    cash -= num * stocks.get(i + 1);
                    flow.set(i, 0); // 3일째 흐름 값을 변경해 흐름 끊기
                }
            }
            // 상승 3일(3 이면) -> 전량 매도
            else if (n == 3) {
                if (cash >= stocks.get(i)) {
                    cash += num * stocks.get(i + 1);
                    num = 0;
                }
            }
        }
        return cash + num * stocks.get(13);
    }

    // 주가 상승/하락 흐름
    public static List<Integer> flowOfStock(List<Integer> stocks) {
        List<Integer> flow = new ArrayList<>();
        for (int i = 1; i < stocks.size(); i++) {
            // 전날보다 오늘이 더 크면 -> 상승
            if (stocks.get(i - 1) < stocks.get(i)) flow.add(1);
            // 전날보다 오늘이 더 작으면 -> 하락
            else if (stocks.get(i - 1) > stocks.get(i)) flow.add(-1);
            // 똑같으면 -> 0
            else flow.add(0);
        }
        return flow;
    }
}