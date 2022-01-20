package com.dfm.his.exam;


import java.util.*;

/**
 * @author dfm
 * @create 2020-12-02 19:29
 */
public class YunQue {
    public static void main(String[] args) {
        Node node = new Node(1,2);
        Node node1 = new Node(5,9);
        List<Node> list = new ArrayList<>();

        list.add(node);
        list.add(node1);
        Node insert = new Node(2,5);
        List<Node> res = solution(list,insert);
        res.forEach(x-> System.out.println(x));
    }

    /**
     * 1.将 插入 node 加入 list
     * 2.按照 start排序
     * 3.合并
     * @param list
     * @param insert
     * @return
     */
    private static List<Node> solution(List<Node> list,Node insert) {
        List<Node> res = new ArrayList<>();
        list.add(insert);
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.start-o2.start;
            }
        });
        for(int i=0;i<list.size();i++){
            Node t = list.get(i);
            int start = t.start;
            int end = t.end;
            if (res.size() == 0 || res.get(res.size() - 1).end < start) {
                res.add(new Node(start,end));
            } else {
                res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, end);
            }
//
//
//
//相交 需要的情形 过于 复杂，需要关注 已经 进入 res 的 边界。
//            if(insert.start > t.start && insert.end < t.end ){
//                res.add(t);
//            }else if(start > t.start && end > t.start){
//                res.add(new Node(t.start,end));//需要维护
//            }else if()
        }
        return res;
    }

}
class Node{
    int start;
    int end;
    Node (int x,int y){
        this.start = x;
        this.end = y;
    }

    @Override
    public String toString() {
        return "Node{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}