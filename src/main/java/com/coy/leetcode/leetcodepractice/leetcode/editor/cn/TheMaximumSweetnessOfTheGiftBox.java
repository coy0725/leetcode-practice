package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.LinkedList;

/**
 * @author coy
 * @since 2022/12/25
 **/
public class TheMaximumSweetnessOfTheGiftBox {
    public static void main(String[] args) {
        Solution solution = new TheMaximumSweetnessOfTheGiftBox().new Solution();
        System.out.println(solution.maximumTastiness(new int[] {13, 5, 1, 8, 21, 2}, 3));
    }
    class Solution {
        private int maximumTastiness = 0;
        public int maximumTastiness(int[] price, int k) {
            LinkedList<Integer> subSet = new LinkedList<>();
            dfs(subSet, price, k, 0);
            return maximumTastiness;

        }
        private void dfs(LinkedList<Integer> subSet,int[] price,  int k, int i) {

            if (subSet.size() == k) {
                int value = caculatemaximumTastiness(subSet);
                maximumTastiness = Math.max(value, maximumTastiness);
                return;
            }
            if (i < price.length) {
                //当前元素加入集合
                subSet.addLast(price[i]);
                dfs( subSet, price, k, i + 1);
                subSet.removeLast();
                //当前元素不加入集合
                dfs( subSet, price, k, i + 1);
            }



        }

        private int caculatemaximumTastiness(LinkedList<Integer> subSet) {
            if (subSet.size() == 1) {
                return subSet.get(0);
            }
            int tastiness = Integer.MAX_VALUE;
            for (int i = 0; i < subSet.size(); i++) {
                for (int j = i + 1; j < subSet.size(); j++) {
                    tastiness = Math.min(tastiness, Math.abs(subSet.get(i) - subSet.get(j)));
                }
            }

            System.out.println(subSet.toString()+":"+tastiness);
            return tastiness;
        }
    }
}
