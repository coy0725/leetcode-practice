package com.coy.leetcode.leetcodepractice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

/**
 * @author coy
 * @since 2021/9/26
 **/
public class BIllCodeProcess {
    public static void main(String[] args) {
        //
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");list.add("3");list.add("4");

        List<String> updated = new ArrayList<>();
        List<String> deleted = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (0==i){
                updated.add(list.get(i));
            }else deleted.add(list.get(i));
        }
        System.out.println(updated);
        System.out.println(deleted);
    }
}
