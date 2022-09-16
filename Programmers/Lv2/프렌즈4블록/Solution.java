class Solution {
    
    static char[][] newMap;
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char[][] map = new char[m][n];
        newMap = new char[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        
        newMap = copy(map, m, n);
        while(true) {
            int count = 0;
            for(int i = 0; i < m - 1; i++) {
                for(int j = 0; j < n - 1; j++) {
                    if(findCube(map, m, n, i, j))
                        count++;
                }
            }
            if(count == 0)
                break;
            
            fall(newMap, m, n);
            map = copy(newMap, m, n);
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == '0') answer++;
            }
        }
        
        return answer;
    }
    
    private char[][] copy(char[][] origin, int m, int n) {
        char[][] copyMap = new char[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                copyMap[i][j] = origin[i][j];
            }
        }
        return copyMap;
    }
    
    private void fall(char[][] map, int m, int n) {
        for(int j = 0; j < n; j++) {
            for(int i = m - 1; i >= 0; i--) {
                if(map[i][j] == '0') {
                    int index = i - 1;
                    while(index >= 0) {
                        if(map[index][j] =='0')
                            index--;
                        else {
                            map[i][j] = map[index][j];
                            map[index][j] = '0';
                            break;
                        }
                    }
                }
            }
        }
    }
    
    private boolean findCube(char[][] map, int m, int n, int x, int y) {
        char character = map[x][y];
        
        if(character == '0')
            return false;
        
        if(x + 1 >= m || y + 1 >= n)
            return false;
        
        if(map[x + 1][y] == character && map[x][y + 1] == character && map[x + 1][y + 1] == character) {
            newMap[x][y] = '0';
            newMap[x + 1][y] = '0';
            newMap[x][y + 1] = '0';
            newMap[x + 1][y + 1] = '0';
            return true;
        }
        
        return false;
    }
}