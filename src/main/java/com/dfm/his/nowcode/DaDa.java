package com.dfm.his.nowcode;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author dfm
 * @create 2020-10-29 18:51
 */
public class DaDa {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int sum = num;
        while (num >= 10){
            sum  =0;
            while (num != 0){
                int rest = num % 10;
                sum+=rest;
                num /= 10;
            }
            num = sum;
        }
        System.out.println(num);


//        String str = in.next();
//        int res = solution(str);
//        System.out.println(res);
//        NODE node1 = null;
//        NODE node2 = null;
//        String s1 = "";
//        String s2 = "";
//        boolean flag = true;
//        for(int i=0;i<str.length();i++){
//            char t = str.charAt(i);
//            if(t == '|'){
//                flag = false;
//                continue;
//            }
//            if(flag){
//                s1+=t;
//            }else s2+=t;
//        }
//        String[] split = s1.split(",");
//        for(int i=0;i<split.length;i++){
//            node1 = insertNODE(node1,Integer.valueOf(split[i]));
//        }
//
//        String[] split2 = s2.split(",");
//        for(int i=0;i<split2.length;i++){
//            node2 = insertNODE(node2,Integer.valueOf(split2[i]));
//        }
//        NODE res = merge(node1,node2);
//        print(res);
    }

//    private static int solution(String str) {
//        if(str.length() == 1)return Integer.valueOf(str);
//        while (str.length() != 1){
//            int sum = 0;
//            for(int i=0;i<str.length();i++){
//                sum += Integer.valueOf(str.charAt(i));
//            }
//        }
//    }

    private static NODE merge(NODE node1, NODE node2) {
        NODE p1 = node1;
        NODE p2 = node2;
        NODE ans = null;
        while (p1 !=null && p2!=null){
            if(p1.val < p2.val){
                ans =  insertNODE(ans,p1.val);
                p1 = p1.next;
            }else {
                ans = insertNODE(ans,p2.val);
                p2 = p2.next;
            }
        }
        while (p1 !=null){
            ans = insertNODE(ans,p1.val);
            p1 = p1.next;
        }
        while (p2 != null){
            ans = insertNODE(ans,p2.val);
            p2 = p2.next;
        }
        return ans;
    }

    public static NODE insertNODE(NODE head,int val){
        if(head == null){
            head=new NODE(val);
            return head;
        }
        NODE p = head;
        while ( p.next != null){
            p=p.next;
        }
        p.next = new NODE(val);
        return head;
    }

    public static void print(NODE head){
        NODE p = head;
        StringBuilder sb = new StringBuilder();
        while (p != null){
            sb.append(p.val+",");
            p = p.next;
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }

    private static boolean isValid(String str) {
        if(str == null || str.length() == 0)return false;
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<str.length();i++){
            Character t = str.charAt(i);
            if (t == '(' || t=='{' || t=='[' ){
                stack.push(t);
            }
            else {
                Character pop = stack.pop();
                if(t == ')' ){
                    if(pop != '(')return  false;
                }
                if(t == ']' ){
                    if(pop != '[')return  false;
                }
                if(t == '}' ){
                    if(pop != '{')return  false;
                }
            }
        }
        if(stack.empty())return true;
        else  return false;
    }
}

class NODE{
    int val;
    NODE next;
    NODE(int x){val = x;}

    public NODE() {

    }
}