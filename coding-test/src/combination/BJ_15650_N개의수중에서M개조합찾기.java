package combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15650_N개의수중에서M개조합찾기 {
    static int N;
    static int M;
    static int[] mark;

    // 1 ~ N개의 수중에 M개 조합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mark = new int[N];
        combination(1, 0);
    }

    private static void combination(int start, int cnt) {
        if (cnt >= M) {
            // 2개 조합
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(mark[i]).append(" ");
            }
            System.out.println(sb.toString());
            return;
        }

        for (int i=start; i<=N; i++) {
            mark[cnt] = i;
            combination(i + 1, cnt+1);
        }
    }
}
