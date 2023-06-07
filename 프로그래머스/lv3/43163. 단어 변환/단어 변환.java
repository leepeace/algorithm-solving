import java.util.*;

class Solution {
    static int answer;
    
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        
        search(0, begin, target, words, new boolean[words.length]);
        
        //answer = answer == Integer.MAX_VALUE ? 0 : answer;
        
        return answer;
    }
    
    static void search(int cnt, String prev, String target, 
                       String[] words, boolean[] visited){
        //target과 같을 때
        if(prev.equals(target)){
            answer = cnt;
            return;
        }
        
        for(int i = 0; i < words.length; i++){
            if(visited[i]) continue;
            //prev와 한 개의 단어만 다른 경우
            if(checkWord(prev, words[i])){
                visited[i] = true;
                search(cnt+1, words[i], target, words, visited);
                visited[i] = false;
            }
            
        }
        
    }
    
    static boolean checkWord(String before, String after){
        int cnt = 0;
        
        for(int i = 0; i < before.length(); i++){
            if(before.charAt(i) != after.charAt(i)){
                cnt++;
            }
        }
        
        if(cnt == 1) return true;
        
        return false;
    }
    
}