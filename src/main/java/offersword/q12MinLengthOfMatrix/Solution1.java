package offersword.q12MinLengthOfMatrix;

/**
 * 矩阵中的路径
 * @author yancy0109
 */
public class Solution1 {

    public boolean exist(char[][] board, String word) {
        char[] wordArray = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (findDeep(board, wordArray, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findDeep(char[][] board, char[] wordArray, boolean[][] visited, int x, int y, int index) {
        // 当前非正确结果
        if (board[x][y] != wordArray[index]) {
            return false;
        }
        visited[x][y] = true;
        // 如果已经完全匹配
        if (index == wordArray.length - 1) {
            return true;
        }
        // 尝试下一步
        int[][]steps = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        for (int[] step : steps) {
            int newX = x + step[0];
            int newY = y +step[1];
            // 当前X|Y不超出范围
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                // 如果未经过 则尝试
                if (!visited[newX][newY]) {
                    boolean res = findDeep(board, wordArray, visited, newX, newY, index + 1);
                    if (res) {
                        return true;
                    }
                }
            }
        }
        visited[x][y] = false;
        return false;
    }


    public static void main(String[] args) {
//        [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
//        "SEE"
//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[][] board = {{'a'}};
        String target = "a";
        System.out.println(new Solution1().exist(board, target));
    }
}
