import java.util.*;

class Solution {
    static int answer;
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        search(dungeons, new boolean[dungeons.length], 0, 
               new int[dungeons.length], k);
        return answer;
    }
    
    static void search(int[][] maps, boolean[] visited, int cnt, 
                       int[] output, int k){
        if(cnt >= maps.length){
            int tmpCnt = 0;
            int total = k;
            for(int i = 0; i < output.length; i++){
                if(total >= maps[output[i]][0]){
                    total -= maps[output[i]][1];
                    tmpCnt++;
                }else{
                    break;
                }
            }
            answer = Math.max(answer, tmpCnt);
            
            return;
        }
        
        for(int i = 0; i < maps.length; i++){
            if(!visited[i]){
                visited[i] = true;
                output[cnt] = i;
                search(maps, visited, cnt+1, output, k);
                visited[i] = false;
            }
        }
        
    }
    
}