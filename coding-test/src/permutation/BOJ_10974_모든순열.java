package permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10974_모든순열 {
    static int N;
    static int[] input; // 숫자의 순차적인 저장을 위한 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[N];
        input = new int[N];
        dfs(0, visited);
    }

    private static void dfs(int depth, boolean[] visited) {
        if (depth == N) {
            StringBuilder sb = new StringBuilder();

            // 모든 수 출력
            for (int i = 0; i < N; i++) {
                sb.append(input[i]).append(" ");
            }

            System.out.println(sb.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            input[depth] = i+1;
            dfs(depth+1, visited);
            visited[i] = false;
        }
    }


}
