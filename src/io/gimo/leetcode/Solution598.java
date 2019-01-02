package io.gimo.leetcode;

/**
 * Created by zmxie on 2019/1/2.
 */
public class Solution598 {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) {
            return m * n;
        }
        int mina = ops[0][0];
        int minb = ops[0][1];

        for (int[] op : ops) {
            if (op[0] < mina) {
                mina = op[0];
            }
            if ((op[1]) < minb) {
                minb = op[1];
            }
        }
        return mina * minb;
    }
}
