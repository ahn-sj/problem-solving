package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * K번째 수 구하기
 */
public class B11004 {

    @Test
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(tokenizer.nextToken());  // 5
        int target = Integer.parseInt(tokenizer.nextToken()); // 2

        final StringTokenizer values = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();
        while (values.hasMoreTokens()) {
            list.add(Integer.parseInt(values.nextToken()));
        }

        System.out.println("input = " + list);
    }

}
