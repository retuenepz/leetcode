package datastructure.queue;

import leetcode.LeetCode200;
import org.junit.Test;

/**
 * @description TODO
 * @author hongyanbo
 * @date 2020/4/10
 * @version 1.0.0
 * @since 1.0.0
 *         [
 *         ["1","0","1","1","1"],
 *         ["1","0","1","0","1"],
 *         ["1","1","1","0","1"]
 *         ]
 */
public class SolutionTest {
    char [][] grid = {
            {'1','0','1','1','1'},
            {'1','0','1','0','1'},
            {'1','1','1','0','1'}
    };
    @Test
    public void test01(){
        int i = new LeetCode200().numIslands(grid);
        System.out.println(i);
    }
}
