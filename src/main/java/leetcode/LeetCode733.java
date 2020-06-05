package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;

/**
 * @description 图像渲染
 * @author hongyanbo
 * @date 2020/6/5
 * @version 1.0.0
 * @since 1.0.0
 */
public class LeetCode733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Set<Node> visted = new HashSet<>();
        LinkedList<Node> list = new LinkedList<>();
        list.add(new Node(sr,sc));
        int orginalColor = image[sr][sc];
        while(!list.isEmpty()){
            Node poll = list.poll();
            int x = poll.getX();
            int y = poll.getY();
            visted.add(poll);
            if(image[x][y] == orginalColor){
                image[x][y] = newColor;
                if(x -1 >=0){
                    if(!visted.contains(new Node(x-1,y))){
                        list.add(new Node(x-1,y));
                    }
                }
                if(x+1 < image.length){
                    if(!visted.contains(new Node(x+1,y))){
                        list.add(new Node(x+1,y));
                    }
                }
                if(y -1 >=0){
                    if(!visted.contains(new Node(x,y-1))){
                        list.add(new Node(x,y-1));
                    }
                }
                if(y+1 < image[x].length){
                    if(!visted.contains(new Node(x,y+1))){
                        list.add(new Node(x,y+1));
                    }
                }
            }

        }
        return image;
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
        int[][] ints = {{0,0,0},{0,0,0}};
        new LeetCode733().floodFill(ints,0,0,2);
    }
}
