package offersword.realq13movingRobot;

/**
 * 面试题q13 机器人的运动范围
 * 深度优先
 * @author yancy0109
 */
public class Solution1 {
    public int movingCount(int m, int n, int k) {
        // 起始位置
        int x = 0, y = 0;
        // 记录是否访问过
        int[][] visited = new int[m][n];
        return goNext(x, y, visited, k);
    }

    public int goNext(int x, int y, int[][] visited, int k) {
        // 符合经过条件
        if (x/10 + x%10 + y/10 + y%10 > k) {
            return 0;
        }
        // 可达
        int count = 1;
        visited[x][y] = 1;
        int nextCount = 0;
        // 只需要向下/向右
        int[][] step = {{1,0}, {0, 1}};
        for (int[] ints : step) {
            int newX = x + ints[0];
            int newY = y + ints[1];
            // 未超出范围
            if (newX>=0 && newX < visited.length && newY >= 0 && newY < visited[0].length) {
                // 没有经过
                if (visited[newX][newY] == 0) {
                    nextCount += goNext(newX, newY, visited, k);
                }
            }
        }
        return count + nextCount;
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 6;
        int k = 3;
        System.out.println(new Solution1().movingCount(m, n, k));
    }
}
