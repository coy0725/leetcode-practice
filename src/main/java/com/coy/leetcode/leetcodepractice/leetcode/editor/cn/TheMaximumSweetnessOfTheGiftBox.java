package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.difficulty.Medium;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.WeeklyRace;

/**
 * @author coy
 * @since 2022/12/25
 **/
@Medium
@com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.BinarySearch
@WeeklyRace
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

        private void dfs(LinkedList<Integer> subSet, int[] price, int k, int i) {

            if (subSet.size() == k) {
                int value = caculatemaximumTastiness(subSet);
                maximumTastiness = Math.max(value, maximumTastiness);
                return;
            }
            if (i < price.length) {
                //当前元素加入集合
                subSet.addLast(price[i]);
                dfs(subSet, price, k, i + 1);
                subSet.removeLast();
                //当前元素不加入集合
                dfs(subSet, price, k, i + 1);
            }

        }

        private int caculatemaximumTastiness(LinkedList<Integer> subSet) {
            if (subSet.size() == 1) {
                return subSet.get(0);
            }
            int tastiness = Integer.MAX_VALUE;
            for (int i = 0; i < subSet.size(); i++) {
                for (int j = i + 1; j < subSet.size(); j++) {
                    int abs = Math.abs(subSet.get(i) - subSet.get(j));
                    if (abs < this.maximumTastiness) {
                        return maximumTastiness;

                    }
                    tastiness = Math.min(tastiness, abs);
                }
            }

            System.out.println(subSet.toString() + ":" + tastiness);
            return tastiness;
        }
    }

    /**
     * 将数组排序，设置初始答案为x，若以x为最小差值的情况下能在数组中组合到大于等于k个不同值，
     * 即以gap=x搜索，在数组中能从头到尾找到大于等于k个值，
     * 则以二分方式扩大x继续搜索直到搜索条件不再满足，返回区间左边界（即上一躺的gap值）；
     * 若不能找到则以二分方式缩小x直到满足条件。
     */
    class Solution2 {
        public int maximumTastiness(int[] price, int k) {
            int len = price.length;
            Arrays.sort(price);
            int[] diff = new int[len];
            for (int i = 1; i < len; i++) {
                diff[i] = price[i] - price[i - 1];
            }
            // 使用二分试出能分成超过k组的最大甜蜜度X
            int max = price[price.length - 1];
            int min = 0;
            while (min < max) {
                int mid = (max + min) / 2;
                int count = getTastinessCnt(diff, mid);
                if (count < k) {
                    // 当前组数太少，应减少甜蜜度
                    max = mid;
                } else {
                    // 当前组数足够或过多，应尝试增加甜蜜度
                    min = mid + 1;
                }
            }
            return max - 1;
        }

        /**
         * @return 甜蜜度差值>=tastiness的个数
         */
        private int getTastinessCnt(int[] diff, int tastiness) {
            int cnt = 1;
            int sum = 0;
            for (int d : diff) {
                sum += d;
                if (sum >= tastiness) {
                    cnt++;
                    sum = 0;
                }
            }
            return cnt;
        }
    }


}
