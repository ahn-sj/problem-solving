package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 트리의 부모 찾기
 * https://www.acmicpc.net/problem/11725
 */
public class B11725 {

    private static List<Integer>[] tree;
    private static boolean[] visited;
    private static int[] answers;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int node = Integer.parseInt(br.readLine());

        visited = new boolean[node + 1];
        answers = new int[node + 1];

        tree = new ArrayList[node + 1];
        for (int i = 1; i <= node; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < node; i++) {
            final StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            final int start = Integer.parseInt(tokenizer.nextToken());
            final int end = Integer.parseInt(tokenizer.nextToken());

            tree[start].add(end);
            tree[end].add(start);
        }

        dfs(1);

        for (int i = 2; i < answers.length; i++) {
            System.out.println(answers[i]);
        }
    }

    private static void dfs(final int start) {
        visited[start] = true;

        for (Integer node : tree[start]) {
            if(!visited[node]) {
                answers[node] = start;
                dfs(node);
            }
        }
    }
}
