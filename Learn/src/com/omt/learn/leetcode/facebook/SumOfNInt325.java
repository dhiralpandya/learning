package com.omt.learn.leetcode.facebook;

import java.util.HashMap;
import java.util.Map;

public class SumOfNInt325 {

    public static void main(String args[]) {
        int[] i = {1,3,2};
        System.out.println(maxSubArrayLen(i,5));
    
    }

    
        public static int maxSubArrayLen(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            int sum = 0;
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (sum == k) {
                    max = i + 1;
                } else if (map.containsKey(sum - k)) {
                    max = Math.max(max, i - map.get(sum - k));
                }
                if (!map.containsKey(sum)) {
                    map.put(sum, i);
                }
            }
            return max;
        }
    
    

}
