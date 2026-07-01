package combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ_14889_N개중_짝의합산_최소값구하기 {
    // 팀 조합: N개 중에서 N/2개 팀짓기 -> 팀되지 않은 나머지는 하나의 팀됨
    // 팀 조합은 N 크기의 불리언 마킹
    // 조합중 최소값 갱신: 팀간 ij +ji 원소의 합 비교

    static int[][] map;
    static boolean[] team;
    static int N;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        team = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combination(0,0);
        System.out.println(min);
    }

    private static void combination(int start, int cnt) {

        if (N/2 <= cnt) {
            int red = 0;
            int blue = 0;
            for (int i=0; i<N; i++) {
                for (int j=i+1; j<N; j++) {
                    if (team[i] && team[j]) {
                        red += map[i][j] + map[j][i];
                    }

                    if (!team[j] && !team[i]) {
                        blue += map[i][j] + map[j][i];
                    }
                }
                HashSet<String> set = new HashSet<String>();
                for (String str: set) {

                }
            }
            min = Math.min(min, Math.abs(red - blue));
            return;
        }

        for (int i = start; i < N; i++) {
            team[i] = true;
            combination(i+1, cnt+1);
            team[i] = false;
        }
    }

}
