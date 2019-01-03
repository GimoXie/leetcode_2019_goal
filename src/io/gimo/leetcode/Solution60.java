package io.gimo.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by zmxie on 2019/1/3.
 */
public class Solution60 {

    public String getPermutation(int n, int k) {
        int[] numbers = new int[n + 1];
        for (int i = 1 ; i < numbers.length ; i++) {
            numbers[i] = i;
        }
        Set<String> set = new TreeSet<>();
        // 从第一个数开始递归
        recurse(numbers, 1, n, set);
        List<String> list = new ArrayList<>(set);
        return list.get(k - 1);
    }

    private void recurse(int[] numbers, int from, int to, Set<String> set) {
        // 递归出口：当递归到只有一位数的时候
        if (from == to) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1 ; i <= to ; i++) {
                sb.append(numbers[i]);
            }
            set.add(sb.toString());
        } else {
            for (int i = from; i <= to ; i ++) {
                swap(numbers, from, i);
                recurse(numbers, from + 1, to, set);
                swap(numbers, from, i);
            }
        }
    }

    private void swap(int[] numbers, int from, int to) {
        if (from == to) {
            return;
        }
        int temp = numbers[from];
        numbers[from] = numbers[to];
        numbers[to] = temp;
    }

    public static void main(String[] args) {
        Solution60 solution60 = new Solution60();
        System.out.println(solution60.getPermutation(3, 3));
    }
}
