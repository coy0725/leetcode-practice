package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

/**
 * @author coy
 * @since 2022/11/9
 **/
public class FindK {

    public static void main(String[] args) {

        FindK findK = new FindK();
        int[] ints = {1, 2, 3, 4};
        int target = 2;
        int i = getI(findK, ints, target);

        System.out.println(i);
    }

    private static int getI(FindK findK, int[] ints, int target) {
        int i = findK.binarySearch(ints, target, 0, ints.length-1);


        int result = i;
        for (int j = i-1; j > 0; j--) {
            if (ints[j]==target){
                result=j;
            }else break;
        }
        return result;
    }

    int binarySearch(int[] nums, int target, int start, int end) {

        int mid = (end-start) / 2+start;

        if (nums[mid] == target) {


            return mid;
        }else if (target < nums[mid]) {
            return binarySearch(nums, target, start, mid - 1);
        }
        else if (target > nums[mid]) {
            return binarySearch(nums, target, mid + 1, end);
        }

        return -1;

    }
}
