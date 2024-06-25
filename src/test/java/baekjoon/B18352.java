package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 특정 거리의 도시 찾기
 * https://www.acmicpc.net/problem/18352
 *
 * # 접근 방법
 * 인접 행렬이 구현이 쉽지만 최대 3만개의 노드까지만 배열 생성이 가능해서 인접 리스트로 접근
 *
 * [input]
 * 1: 도시의 개수(노드의 수)
 * 2: 도로의 개수(엣지의 수)
 * 3: 거리 정보(노드에서 순회했을때 나올 결과값)
 * 4: 시작 도시(시작 노드)
 */
public class B18352 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] inputs = br.readLine().split(" ");

        final int node = Integer.parseInt(inputs[0]);
        final int edge = Integer.parseInt(inputs[1]);
        final int target = Integer.parseInt(inputs[2]);
        final int startNode = Integer.parseInt(inputs[3]);

        // type[array]
        List<Integer>[] links = getLinkedListInArray(node, edge, br);

        // 초기값 설정
        int[] visited = new int[node + 1];
        Arrays.fill(visited, -1);

        // [1, 2, 3, 3, 4]
        // 1: [1]       - push
        // 2: []        - pop
        // 3: [2]       - push
        // 3: [2, 3]    - push
        // 4: [3]       - pop
        // 5: [3, 3]    - push
        // 6: [3, 3, 4] - push
        // 7: [3, 4]    - pop
        // 8: [4]       - pop
        // 9: []        - pop
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode]++;

        while (!queue.isEmpty()) {
            final Integer pop = queue.poll();

            for (Integer road : links[pop]) {
                if(visited[road] == -1) { // 탐색을 한 번도 안한 도시인지
                    visited[road] = visited[pop] + 1; // 이전 방문 도시 값에 1 증가
                    queue.add(road);      // 탐색 예정인 도시 큐에 저장
                }
            }
        }

        // 목표 거리인 도시 번호 저장
        List<Integer> targets = new ArrayList<>();
        for (int i = 0; i <= node; i++) {
            if(visited[i] == target) {
                targets.add(i);
            }
        }

        // 오름차순 정렬
        Collections.sort(targets);

        if (targets.isEmpty()) {
            System.out.println("-1");
        } else {
            targets.forEach(System.out::println);
        }
    }

    private static List<Integer>[] getLinkedListInArray(
            final int node,
            final int edge,
            final BufferedReader br
    ) throws IOException {
        final List<Integer>[] links = new ArrayList[node + 1];

        // 배열 엘리먼트별로 리스트 설정
        for (int i = 1; i <= node; i++) {
            links[i] = new ArrayList<>();
        }
        for (int i = 0; i < edge; i++) {
            final String[] road = br.readLine().split(" ");

            final int startEdge = Integer.parseInt(road[0]);
            final int endEdge = Integer.parseInt(road[1]);

            links[startEdge].add(endEdge);
        }
        return links;
    }

}

