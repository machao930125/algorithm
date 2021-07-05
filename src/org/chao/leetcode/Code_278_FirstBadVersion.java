package org.chao.leetcode;

/**
 * 二分查找
 * <p>
 * 来源：力扣（LeetCode）
 * https://leetcode-cn.com/problems/first-bad-version/
 */
public class Code_278_FirstBadVersion {
    public static final int first_bad_version = 1702766719;

    public static int firstBadVersion(int n){
        if (isBadVersion(1)){
            return 1;
        }
        int left = 1;
        int right = n;
        int mid;
        while (left < right){
            mid = left + ((right - left) >> 1);
            if (left == mid){
                return right;
            }
            if (isBadVersion(mid)){
                right = mid;
            }else {
                left = mid;
            }
        }
        return -1;
    }

    public static boolean isBadVersion(int version){
        if (version >= first_bad_version){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(2126753390));
    }



}
