package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.difficulty.Easy;

/**
 * 给你一个长度为 n ，下标从 0 开始的整数数组 forts ，表示一些城堡。forts[i] 可以是 -1 ，0 或者 1 ，其中：
 *
 * -1 表示第 i 个位置 没有 城堡。
 * 0 表示第 i 个位置有一个 敌人 的城堡。
 * 1 表示第 i 个位置有一个你控制的城堡。
 * 现在，你需要决定，将你的军队从某个你控制的城堡位置 i 移动到一个空的位置 j ，满足：
 *
 * 0 <= i, j <= n - 1
 * 军队经过的位置 只有 敌人的城堡。正式的，对于所有 min(i,j) < k < max(i,j) 的 k ，都满足 forts[k] == 0 。
 * 当军队移动时，所有途中经过的敌人城堡都会被 摧毁 。
 *
 * 请你返回 最多 可以摧毁的敌人城堡数目。如果 无法 移动你的军队，或者没有你控制的城堡，请返回 0 。
 *
 *  
 *
 * @author coy
 * @since 2022/12/24
 **/
@Easy
public class MaximumNumberOfEnemyCastlesThatCanBeDestroyed {
    class Solution {

        int captureForts(int[] forts) {
            int len = forts.length;
            int maxDestroyedCastles = 0;
            for (int i = 0; i < len; i++) {
                if (forts[i] != 1) continue; // 只考虑你控制的城堡
                for (int j = 0; j < len; j++) {
                    if (forts[j] != -1) continue; // 只考虑空的位置
                    if (i == j) continue; // 不能在同一个位置
                    // 检查是否满足条件 min(i,j) < k < max(i,j)
                    boolean valid = true;
                    for (int k = Math.min(i, j) + 1; k < Math.max(i, j); k++) {
                        //确保之间都是敌人的城堡
                        if (forts[k] != 0) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) {
                        // 计算经过的城堡数
                        int destroyed = Math.max(0, Math.max(i, j) - Math.min(i, j) - 1);
                        maxDestroyedCastles = Math.max(maxDestroyedCastles, destroyed);
                    }
                }
            }
            return maxDestroyedCastles;
        }

        public int captureForts2(int[] forts) {
            //将数字1移动到数字-1的位置，该路径上为0的元素的个数则是摧毁敌人的堡垒数
            //使用双指针？首先找到为1的元素 再找到为0的元素
            //用三个链表
            Queue<Integer> me = new LinkedList<>();
            Queue<Integer> empty = new LinkedList<>();
            Queue<Integer> army = new LinkedList<>();
            for (int i = 0; i < forts.length; i++) {
                if (forts[i] == 1) {
                    me.offer(i);
                } else if (forts[i] == 0) {
                    army.offer(i);
                } else {
                    empty.offer(i);
                }
            }
            if (me.size() == 0 || empty.size() == 0) {
                return 0;
            }
            //军队左右都可以移动
            while (!me.isEmpty()) {
                Integer left = me.poll();
                Integer emptyIndex = empty.poll();

            }
            return 0;
        }

    }
}
