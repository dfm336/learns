package com.dfm.his.exam;

/**
 * @author dfm
 * @create 2020-11-19 18:06
 */
public class SC {
    public static void main(String[] args) {
        NODE n1 = new NODE(4);
        NODE n2 = new NODE(2);
        NODE n3 = new NODE(5);
        NODE n4 = new NODE(1);
        NODE n5 = new NODE(3);
        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;
        NODE tail = solution(n1);
        while (tail!=null){
            System.out.println(tail.val);
            tail = tail.left;
        }
    }

    //    4
//  /   \
//  2    5
// /\
//1  3
//- - - - -
//        1<->2<->3<->4<->5
//            ^                          ^
//            |---------------|

    public static NODE solution(NODE root){
        if(root.left == null && root.right==null)return  root;

        NODE pre = (root.left!=null) ? solution(root.left) : null;

        root.left = pre;

        NODE next = (root.right!=null) ? solution(root.right) : null;

        root.right = next;

        return next;

    }

}
class NODE{
    int val;
    NODE left;
    NODE right;
    NODE(int x){val=x;}
}
