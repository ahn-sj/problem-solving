package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2558 {

    @Test
    public static void main(String[] args) {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.lines()
                .map(String::valueOf)
                .forEach(System.out::println);

    }

}
