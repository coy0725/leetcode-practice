package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

/**
 * @author coy
 * @since 2022/12/25
 **/
public class TheShortestDistanceToTheTargetString {

    public static void main(String[] args) {
        Solution solution =
            new TheShortestDistanceToTheTargetString().new Solution();
        System.out
            .println(solution.closetTarget(new String[] {"i", "eat", "leetcode"}, "ate", 0));

        System.out.println(solution.closetTarget(new String[] {"hello","i","am","leetcode","hello"}, "hello", 1));

    }
    class Solution {
        public int closetTarget(String[] words, String target, int startIndex) {
            if (words[startIndex] == target) {
                return 0;
            }
            //从目标位置开始移动 有两种移动方向,向左移动，向右移动，最多移动words.length 步
            int rightStep = 0, leftStep = 0;
            int leftIndex = startIndex, rightIndex = startIndex;
            int maxStep = words.length-1;
            //往右移动
            for (int i = 0; i < maxStep+1; i++) {
                rightStep++;
                if (words[rightIndex].equals(target)) {
                    break;
                }
                rightIndex++;
                if (rightStep > maxStep) {
                    break;
                }
                if (rightIndex==maxStep) {
                    rightIndex = 0;
                }
            }

            //往左移动
            for (int i = 0; i < maxStep+1; i++) {
                leftStep++;
                if (words[rightIndex].equals(target)) {
                    break;
                }
                leftIndex--;
                if (leftStep > maxStep) {
                    break;
                }
                if (leftIndex < 0) {
                    leftIndex = maxStep - 1;
                }
            }

            if (leftStep > maxStep) {
                return -1;
            }
            if (rightStep > maxStep) {
                return -1;
            }
            return Math.min(leftStep, rightStep);
        }
    }
}
