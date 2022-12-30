/**
 * 考场就座
 */
//在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。 
//
// 当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，
//那么学生就坐在 0 号座位上。) 
//
// 返回 ExamRoom(int N) 类，它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），代表学生坐的位
//置；函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。每次调用 ExamRoom.leave(p) 时都保证有学生坐在
//座位 p 上。 
//
// 
//
// 示例： 
//
// 输入：["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[]
//,[4],[]]
//输出：[null,0,9,4,2,null,5]
//解释：
//ExamRoom(10) -> null
//seat() -> 0，没有人在考场里，那么学生坐在 0 号座位上。
//seat() -> 9，学生最后坐在 9 号座位上。
//seat() -> 4，学生最后坐在 4 号座位上。
//seat() -> 2，学生最后坐在 2 号座位上。
//leave(4) -> null
//seat() -> 5，学生最后坐在 5 号座位上。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 10^9 
// 在所有的测试样例中 ExamRoom.seat() 和 ExamRoom.leave() 最多被调用 10^4 次。 
// 保证在调用 ExamRoom.leave(p) 时有学生正坐在座位 p 上。 
// 
// Related Topics 设计 有序集合 堆（优先队列） 
// 👍 206 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.difficulty.Medium;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.solution.BeHelped;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.solveDate.December2022;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.Heap;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.OrderedSet;

/**
 * 855
 */
@Heap
@Medium
@OrderedSet
@December2022
@BeHelped
public class ExamRooma {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class ExamRoom {
        int[] seats;
        int studentNums;

        public ExamRoom(int n) {
            seats = new int[n];
            studentNums = 0;
        }

        public int seat() {
            //如果教室是空的，则做第一排
            int index = findSeatIndex();
            seats[index] = 1;
            studentNums++;
            return index;
        }

        //they must sit in the seat that maximizes the distance to the closest person.
        // If there are multiple such seats, they sit in the seat with the lowest number
        private int findSeatIndex() {
            if (studentNums == 0) {
                return 0;
            }

            //转化为一个求数组中连续0最多的空间,这个题目的标签有heap.怎么使用heap呢？？
            //可不可计算出下一个人做的位置呢？

            return 0;
        }

        public void leave(int p) {
            studentNums--;
            seats[p] = 0;
        }
    }

    /**
     * Your ExamRoom object will be instantiated and called as such:
     * ExamRoom obj = new ExamRoom(n);
     * int param_1 = obj.seat();
     * obj.leave(p);
     */
    //leetcode submit region end(Prohibit modification and deletion)

    /**
     * 我是用一个数组来表示考场的作为，元素为0代表该座位没有人坐，元素为1表示该座位有人坐
     * 该解法使用一个整形数组作为一个有序对，表示两个人，使用TreeSet数据结构保证第一个元素是间隔最多的两个人坐的座位
     */
    class ExamRoom2 {

        private TreeSet<int[]> treeSet = new TreeSet<>((a, b) -> {
            int d1 = dist(a), d2 = dist(b);
            return d1 == d2 ? a[0] - b[0] : d2 - d1;
        });
        private Map<Integer, Integer> left = new HashMap<>();
        private Map<Integer, Integer> right = new HashMap<>();
        private int n;

        public ExamRoom2(int n) {
            this.n = n;
            add(new int[] {-1, n});
        }

        public int seat() {
            //获取间隔最大的一组座位
            int[] s = treeSet.first();
            int p = (s[0] + s[1]) >> 1;
            if (s[0] == -1) {
                p = 0;
            } else if (s[1] == n) {
                p = n - 1;
            }
            del(s);
            add(new int[] {s[0], p});
            add(new int[] {p, s[1]});
            return p;
        }

        private int dist(int[] s) {
            int left = s[0], right = s[1];

            return left == -1 || right == n ? right - left - 1 : (right - left) >> 1;
        }

        private void add(int[] seats) {
            treeSet.add(seats);
            left.put(seats[1], seats[0]);
            right.put(seats[0], seats[1]);
        }

        private void del(int[] s) {
            treeSet.remove(s);
            left.remove(s[1]);
            right.remove(s[0]);
        }

        public void leave(int p) {
            int l = left.get(p), r = right.get(p);
            del(new int[] {l, p});
            del(new int[] {p, r});
            add(new int[] {l, r});
        }
    }

}