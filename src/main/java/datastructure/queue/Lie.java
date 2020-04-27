package datastructure.queue;

import java.util.*;

/**
 * @description TODO
 * @author hongyanbo
 * @date 2020/4/10
 * @version 1.0.0
 * @since 1.0.0
 */
public class Lie {
    // 组长
    private static List<String> aList = Arrays.asList("A", "B", "C");
    // 组员
    private static List<String> bList = Arrays.asList("X","Y","Z");
    /**
     * 组队的可能性
     */
    private static Set<String> allGroupPossible = new HashSet<>();
    public static void main(String[] args) {
        for (String b : bList) {
            group(aList.get(0),b, new ArrayList<>(aList),new ArrayList<>(bList),aList.get(0)+b);
        }
        for (String poss : allGroupPossible) {
            if(!poss.contains("AX") &&!poss.contains("CX") && !poss.contains("CZ")){
                System.out.println(poss);
            }
        }
    }
    /**
     * 自由组队
     * @param a
     * @param b
     */
    private static void group(String a, String b,List<String> aList,List<String> bList,String groupResult) {
        aList.remove(a);
        bList.remove(b);
        if(!aList.isEmpty()){
            for (String bb : bList) {
                group(aList.get(0),bb,new ArrayList<>(aList),new ArrayList<>(bList),groupResult+aList.get(0)+bb);
            }
        }else if (!allGroupPossible.contains(groupResult)){
            allGroupPossible.add(groupResult);
        }
    }
}
