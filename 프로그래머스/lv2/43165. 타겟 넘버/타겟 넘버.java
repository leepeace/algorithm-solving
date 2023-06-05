import java.util.*;

class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        solve(0, numbers, numbers.length, 0, target);
        
        return answer;
    }
    
    static void solve(int sum, int[] numbers, int length, int cnt, int target){
        if(cnt == length){
            if(sum == target){
                answer++;
            }
            return;
        }
       
        //더하기
        solve(sum + numbers[cnt], numbers, length, cnt+1, target);
        //뺄샘
        solve(sum - numbers[cnt], numbers, length, cnt+1, target);
        
    }
    
}