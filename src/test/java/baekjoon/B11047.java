package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 동전 0
 * https://www.acmicpc.net/problem/11047
 */
public class B11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringTokenizer tokenizer = new StringTokenizer(input);
        int coinCount = Integer.parseInt(tokenizer.nextToken());
        int targetPrice = Integer.parseInt(tokenizer.nextToken());

        // 동전의 가격 설정
        int[] coins = new int[coinCount];
        for (int i = 0; i < coinCount; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // 동전 가격 오름차순 정렬
        Arrays.sort(coins);

        // 필요한 코인 개수 구하기
        int necessaryCoinCount = getMinimumNumberOfCoins(coins, targetPrice);

        System.out.println(necessaryCoinCount);
    }

    private static int getMinimumNumberOfCoins(final int[] coins, int targetPrice) {
        int numberOfCoins = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            if(coins[i] <= targetPrice) {
                numberOfCoins += targetPrice / coins[i];
                targetPrice = targetPrice % coins[i];
            }
        }
        return numberOfCoins;
    }

}
