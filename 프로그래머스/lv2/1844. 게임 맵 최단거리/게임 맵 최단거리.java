import java.util.*;

class Solution {
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int answer;
    
    public int solution(int[][] maps) {
        answer = Integer.MAX_VALUE;
        
        bfs(maps);
        
        return answer;
    }
    
    static void bfs(int[][] maps){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});//(x,y,cnt)
        
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        visited[0][0] = true;
        
        int endX = maps.length - 1, endY = maps[0].length - 1;
        boolean checkEnd = false;
       
        
        while(!queue.isEmpty()){
            int[] tmp = queue.poll(); 
            int nowX = tmp[0];
            int nowY = tmp[1];
            int nowCnt = tmp[2];
            
            if(nowX == endX && nowY == endY){
                answer = Math.min(answer, nowCnt);
                checkEnd = true;
                continue;
            }
            
            for(int d = 0; d < dir.length; d++){
                int nextX = nowX + dir[d][0];
                int nextY = nowY + dir[d][1];
                
                //이미 방문했거나 벽인 경우
                if(nextX < 0 || nextX >= maps.length 
                   || nextY < 0 || nextY >= maps[0].length 
                   || maps[nextX][nextY] == 0 || visited[nextX][nextY]) continue;
                
                queue.add(new int[]{nextX, nextY, nowCnt+1});
                visited[nextX][nextY] = true;
            }
        }
        
        if(!checkEnd){
            answer = -1;
        }
    }
    
}