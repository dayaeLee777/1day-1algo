class Solution {
    static int[][] array;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        array = new int[rows][columns];
        
        // 초기 배열 생성
        int value = 1;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < columns; c++) {
                array[r][c] = value++;
            }
        }
        
        for(int q = 0; q < queries.length; q++){
            int r1 = queries[q][0] - 1;
            int c1 = queries[q][1] - 1;
            int r2 = queries[q][2] - 1;
            int c2 = queries[q][3] - 1;
            answer[q] = rotate(r1, c1, r2, c2);
        }
        
        return answer;
    }
    //회전하고 가장 작은 값을 return한다.
    private int rotate(int r1, int c1, int r2, int c2) {
        
        int temp = array[r1][c1];
        int min = Math.min(temp, Integer.MAX_VALUE);
        // 좌
        for(int r = r1; r < r2; r++) {
            array[r][c1] = array[r + 1][c1];
            min = Math.min(min, array[r][c1]);
        }
        // 하
        for(int c = c1; c < c2; c++) {
            array[r2][c] = array[r2][c + 1];
            min = Math.min(min, array[r2][c]);
        }
        // 우
        for(int r = r2; r > r1; r--) {
            array[r][c2] = array[r - 1][c2];
            min = Math.min(min, array[r][c2]);
        }
        // 상
        for(int c = c2; c > c1; c--) {
            array[r1][c] = array[r1][c - 1];
            min = Math.min(min, array[r1][c]);
        }
        array[r1][c1 + 1] = temp;
        
        
        return min;
    }
}