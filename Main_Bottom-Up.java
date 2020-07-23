import java.util.*;

public class Main {
    static long mod = 1000000000;
    static long[][] A;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        A = new long[num+1][10];
        stairNum(num);
        long temp = 0;
        for (int i=0;i<10;i++) {
            temp += A[num][i];
        }
        temp %= mod;
        System.out.println(temp);
    }

    static void stairNum(int n) {
        // Bottom-Up 방식
        // A[i][j] = 길이가 i이고 마지막 숫자가 j인 계단 수의 개수
        // 점화식 : D[i][j] = D[i-1][j-1] + D[i-1][j+1];
        for (int i=1;i<10;i++) {
            A[1][i] = 1;
        }
        for (int i=2;i<n+1;i++) {
            for (int j=0;j<10;j++) {
                A[i][j] = 0;
                if (j-1 >= 0) { // +1로 연속이려면 직전 마지막 수가 0과 같거나 커야함 (음수 나올 수 없기 때문)
                    A[i][j] += A[i-1][j-1];
                }
                if (j+1 <= 9) { // -1로 연속이려면 직전 마지막 수가 9와 같거나 작아야 함
                    A[i][j] += A[i-1][j+1];
                }
                A[i][j] %= mod;
            }
        }
    }
}
