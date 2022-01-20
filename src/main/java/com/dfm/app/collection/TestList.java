package com.dfm.app.collection;

import com.dfm.app.collection.pojo.Org;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:fengming.dai
 */
public class TestList {
    public static void main(String[] args) {
        retainAllofList();
    }

    public static void retainAllofList(){
        List<String> listA = new ArrayList<>();
        listA.add("a");
        listA.add("b");
        listA.add("c");
        listA.add("d");
        List<String> listB = new ArrayList<>();
        listB.add("b");
        listB.add("c");
        listB.add("d");
        listB.add("e");
        boolean b = listA.retainAll(listB);
        System.out.println("b = " + b);
        listA.forEach(x-> System.out.println(x));
//        listB.forEach(x-> System.out.println(x));

//        Org org2 = new Org("uuid2", null, "code2");
//        Org org3 = new Org("uuid3", null, "code3");
//
//        Org org4 = new Org("uuid4", null, "code4");
//        Org org5 = new Org("uuid5", null, "code5");
//        Org org6 = new Org("uuid6", null, "code6");
//
//        Org org3copy = new Org("uuid3", null, "code3");
//        Org org4copy = new Org("uuid4", null, "code4");
//        List<Org> orgListA = new ArrayList<>();
//        List<Org> orgListB = new ArrayList<>();
//
//        orgListA.add(org2);
//        orgListA.add(org3);
//        orgListA.add(org4copy);
//        orgListA.add(org5);
//
//        orgListB.add(org3copy);
//        orgListB.add(org4);
//        orgListB.add(org5);
//        orgListB.add(org6);
//
//        List<Org> orgListC = new ArrayList<>();
//        List<Org> orgListD = new ArrayList<>();
//
//        orgListC.add(org2);
//        orgListC.add(org4copy);
//        orgListC.add(org5);
//
//        orgListD.add(org3copy);
//        orgListD.add(org4copy);
//        orgListD.add(org2);
//
//        List<List<Org>> all = new ArrayList<>();
//        all.add(orgListA);
//        all.add(orgListB);
//        all.add(orgListC);
//        all.add(orgListD);
//
//        List<Org> orgList = all.get(0);
//        for(int i=1;i<all.size();i++){
//            orgList.retainAll(all.get(i));
//        }
//        orgList.forEach(x-> System.out.println(x));

    }
}
