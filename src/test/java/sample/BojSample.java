package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BojSample {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String input = br.readLine();

        System.out.println("input = " + input);
    }

}
