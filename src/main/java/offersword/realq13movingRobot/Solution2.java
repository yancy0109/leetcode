package offersword.realq13movingRobot;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题q13 机器人的运动范围
 * 广度优先
 * @author yancy0109
 */
public class Solution2 {
    public int movingCount(int m, int n, int k) {
        // 起始位置
        int x, y;
        // 记录是否访问过
        int[][] visited = new int[m][n];
        // 记录可达位置
        int count = 1;
        // 记录宽度遍历节点
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        // 只向右/下 其他方向将有其他遍历情况下进行
        int[] stepX = {1, 0}, stepY = {0, 1};
        while (!queue.isEmpty()) {
            int[] step = queue.poll();
            // 更新当前位置
            x = step[0];
            y = step[1];
            for (int i = 0; i < stepX.length; i++) {
                int newX = x + stepX[i];
                int newY = y + stepY[i];
                // 未超出范围
                if (newX>=0 && newX < visited.length && newY >= 0 && newY < visited[0].length
                        && visited[newX][newY] == 0
                        && !(newX / 10 + newX % 10 + newY / 10 + newY % 10 > k)) {
                    queue.offer(new int[]{newX, newY});
                    visited[newX][newY] = 1;
                    // 可达
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 10;
        int k = 10;
        System.out.println(new Solution2().movingCount(m, n, k));
    }
}
