class Solution {
    
    static int dir[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int M, N, numberOfArea, maxSizeOfOneArea, tmp;
    static long map[][];
    
    public int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        M = m;
        N = n;
        tmp = 0;
        boolean[][] isVisited = new boolean[M][N];
        map = new long[M][N];
        for(int r = 0; r < M; r++) {
            for(int c = 0; c < N; c++) {
                map[r][c] = (long) picture[r][c];
            }
        }
        
        for(int r = 0; r < M; r++) {
            for(int c = 0; c < N; c++) {
                if(!isVisited[r][c] && map[r][c] != 0){
                    numberOfArea++;
                    findArea(r, c, isVisited);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, tmp);
                    tmp = 0;
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    private static void findArea(int r, int c, boolean[][] visited) {
        if(visited[r][c]) return;
        
        visited[r][c] = true;
        tmp++;
        
        for(int d = 0; d < 4; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            
            if(nr >= 0 && nr < M && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] == map[r][c]) {
                findArea(nr, nc, visited);
            }
        }
    }
}