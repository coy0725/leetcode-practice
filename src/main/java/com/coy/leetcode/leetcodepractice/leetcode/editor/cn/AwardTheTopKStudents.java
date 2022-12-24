package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 给你两个字符串数组 positive_feedback 和 negative_feedback ，分别包含表示正面的和负面的词汇。不会 有单词同时是正面的和负面的。
 *
 * 一开始，每位学生分数为 0 。每个正面的单词会给学生的分数 加 3 分，每个负面的词会给学生的分数 减  1 分。
 *
 * 给你 n 个学生的评语，用一个下标从 0 开始的字符串数组 report 和一个下标从 0 开始的整数数组 student_id 表示，其中 student_id[i] 表示这名学生的 ID ，这名学生的评语是 report[i] 。每名学生的 ID 互不相同。
 *
 * 给你一个整数 k ，请你返回按照得分 从高到低 最顶尖的 k 名学生。如果有多名学生分数相同，ID 越小排名越前。
 *
 * @author coy
 * @since 2022/12/24
 **/
public class AwardTheTopKStudents {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {



        Set<String> positive;
        Set<String> negative;

        public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback,
            String[] report, int[] student_id, int k) {
            this.positive = new HashSet<>(Arrays.asList(positive_feedback));
            this.negative = new HashSet<>(Arrays.asList(negative_feedback));

            List<Student> students = new ArrayList<>();
            for (int i = 0; i < student_id.length; i++) {
                Student student = new Student();
                student.id = student_id[i];
                student.report = report[i];
                calculateScore(student);
                students.add(student);
            }
            return students.stream().sorted((e1, e2) -> {
                    if (e1.getScore() != e2.getScore()) {
                        // 按照 a 字段从大到小排序
                        return Integer.compare(e2.getScore(), e1.getScore());
                    } else {
                        // 如果 a 字段相同，则按照 b 字段从小到大排序
                        return Integer.compare(e1.getId(), e2.getId());
                    }
                }
            ).map(Student::getId).collect(Collectors.toList()).subList(0, k);

        }

        private void calculateScore(Student student) {
            int score = 0;
            String[] reports = student.report.split(" ");
            for (int i = 0; i < reports.length; i++) {
                if (negative.contains(reports[i])) {
                    score = score - 1;
                } else if (positive.contains(reports[i])) {
                    score = score + 3;
                }
            }
            student.score = score;
        }

    }

    class Student {
        int score;
        int id;
        String report;

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getReport() {
            return report;
        }

        public void setReport(String report) {
            this.report = report;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}
