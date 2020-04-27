package leetcode;

import java.util.*;

/**
 * LEETCODE 200题 DFS解法
 * @author hongyanbo
 * @date 2020/4/10
 * @version 1.0.0
 * @since 1.0.0
 */
public class LeetCode200 {

    /**
     * 扫描过的节点
     */
    private Set<Node> used = new HashSet<>();
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                char c = grid[i][j];
                Node node = new Node(i, j);
                if(c== '1' && !used.contains(node)){
                    findGround(node,grid);
                    result ++;
                }
            }
        }
        return result;
    }

    /**
     * 查找附近的陆地
     * @param node
     */
    private void findGround(Node node,char[][] grid) {
        if(used.contains(node)){
            return;
        }
        if(grid[node.x][node.y] == '1'){
            used.add(node);
            int xlen = grid.length;
            if(node.x!=0){
                findGround(new Node(node.x-1,node.y),grid);
            }
            if(node.x+1 < xlen){ //向下
                findGround(new Node(node.x+1,node.y),grid);
            }
            int ylen = grid[node.x].length;
            if(node.y !=0){ // 向左
                findGround(new Node(node.x,node.y-1),grid);
            }
            if(node.y+1 < ylen){// 向右
                findGround(new Node(node.x,node.y+1),grid);

            }
        }



    }

    private class Node{
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        int x;
        int y;
    }
}

