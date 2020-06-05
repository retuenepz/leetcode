package leetcode;

import java.util.*;

/**
 * 
 * @description 01矩阵
 * @author hongyanbo
 * @date 2020/6/5
 * @version 1.0.0
 * @since 1.0.0
 */
public class LeetCode542 {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            int[] matrix1 = matrix[i];
            for (int j = 0; j < matrix1.length; j++) {
                if(matrix[i][j] != 0){
                    result[i][j] = bfs(i,j,matrix);
                }
            }
        }
        return result;
    }

    /**
     * 返回到最近的0 的距离
     * @param i
     * @param j
     * @param matrix
     * @return
     */
    private int bfs(int i, int j, int[][] matrix) {
        Set<Node> visted = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        int step = 0;
        queue.offer(new Node(i,j));
        visted.add(new Node(i,j));
        int length = matrix.length;
        int length1 = matrix[0].length;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i1 = 0; i1 < size; i1++) {
                Node poll = queue.poll();
                int x = poll.getX();
                int y = poll.getY();
                if(matrix[x][y]==0){
                    return step;
                }else{
                    if(x >0 && !visted.contains(new Node(x -1,y))){
                        visted.add(new Node(x-1,y));
                        queue.offer(new Node(x-1,y));
                    }
                    if(y >0 && !visted.contains(new Node(x,y-1))){
                        visted.add(new Node(x,y-1));
                        queue.offer(new Node(x,y-1));
                    }
                    if(x < length-1 && !visted.contains(new Node(x+1,y))){
                        visted.add(new Node(x+1,y));
                        queue.offer(new Node(x+1,y));
                    }
                    if(y < length1-1 && !visted.contains(new Node(x,y+1))){
                        visted.add(new Node(x,y+1));
                        queue.offer(new Node(x,y+1));
                    }
                }
            }
            step++;
        }
        return step;
    }
    /**
     * 一个点
     */
    private class Node{
        private int x ;
        private int y ;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
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
    }

    public static void main(String[] args) {
        int[][] ints = {{0,1,0},{0,1,0}};
        new LeetCode542().updateMatrix(ints);
    }
}
