import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int X = sc.nextInt();

        int[] result = new int[N];
        int cnt = 0;
        for (int i = 0; i < N; i++){
            int inputNum = sc.nextInt();

            if(X > inputNum){//X보다 작은 수를 입력받은 경우
                result[cnt] = inputNum;
                cnt++;
            }
        }

        for(int i = 0; i < N; i++){
            if(result[i] == 0) {
                break;
            }
            System.out.print(result[i] + " ");
        }
        System.out.println();


        sc.close();
    }
}
