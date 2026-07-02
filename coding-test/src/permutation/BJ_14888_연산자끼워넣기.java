package permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 어차피 최대값, 최솟값을 반환하므로 중복된 식이어도 괜찮긴하다.
// 다만 문제는 중복된 식을 제거하는 것으로 간다.
// 연산자 나열의 모든 경우의 수를 찾아야하기 때문에 완전 탐색으로 진행한다.
// 백트래킹을 사용하면 가지치기를 할수있어서 비용을 줄일수있다.
// 숫자는 백트래킹의 깊이로 가져올수있다.
public class BJ_14888_연산자끼워넣기 {
    static int[] NUMS;
    static int[] OPERS;
    static int N;
    static int MAX = 0;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        NUMS = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            NUMS[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());

        OPERS = new int[4];
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            OPERS[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(1, NUMS[0]);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void backtracking(int depth, int result) {
        if (depth == N) {
            MAX = Math.max(MAX, result);
            MIN = Math.min(MIN, result);
            return;
        }

        // depth마다 연산자를 종류별로 4개 분한
        for (int i = 0; i < 4; i++) {
            if (OPERS[i] <= 0) continue;
            OPERS[i]--;
            backtracking(depth + 1, calculate(result, NUMS[depth], getOperator(i)));
            OPERS[i]++;
        }
    }

    private static char getOperator(int idx) {
        if (idx == 0) return '+';
        else if (idx == 1) return '-';
        else if (idx == 2) return '*';
        else if (idx == 3) return '/';
        throw new IllegalArgumentException();
    }

    private static int calculate(int result, int num, char c) {
        if (c == '+') {
            return result + num;
        } else if (c == '-') {
            return result - num;
        } else if (c == '*') {
            return result * num;
        } else if (c == '/') {
            return result / num;
        }
        throw new IllegalArgumentException();
    }
}
