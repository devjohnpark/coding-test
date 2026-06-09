package combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3035_9개중에서_조건에맞는7개찾기 {
    static int N = 9, R = 7; // N : 모수, R : 추출할 갯수
    static int [] input = new int[N]; // 모수 저장 배열
    static int [] number = new int[R]; // 추출 결과 저장 배열

    private static void combination(int idx, int strt, int sum) {
        if (sum > 100) return; // 조기 재귀 탈출 (최적화)

        if (idx >= R) {
            if(sum == 100) {
                for (int i = 0; i < R; i++) System.out.println(number[i]);
            }
            return;
        }

        for (int i = strt; i < N; i++) {
            number[idx] = input[i]; // 순회한값 저장
            combination( idx + 1, i + 1, sum + input[i] );
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < N; i++) input[i] = Integer.parseInt(br.readLine());

        combination(0, 0, 0);
    }
}
