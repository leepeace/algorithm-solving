class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[computers.length];
        
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]) {
                solve(i, visited, computers);
                answer++;
            }
            
        }
        
        return answer;
    }
    
    static void solve(int now, boolean[] visited, int[][] computers){
        visited[now] = true;
        
        for(int i = 0; i < computers[now].length; i++){
            //인접한 노드 방문
            if(computers[now][i] == 1 && !visited[i]){
                solve(i, visited, computers);
            }
        }
        
    }
    
}