package com.omt.learn.algo.allAlgos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class IndicesOfNumbers {

	public static void main(String[] args) {

		int[] a = { 2, 7, 11, 15, 17, 20 };
		int target = 9;
		for(int i : twoSum(a, target)) {
			System.out.println(i);
		}

	}

	public static int[] twoSum(int[] nums, int target) {

		int[] indexList = new int[2];
		Map<Integer, Integer> dataMap = new TreeMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (dataMap.containsKey(target - nums[i])) {
				System.out.println("Two indices are :[" + dataMap.get(target - nums[i]) + "," + i + "]");
				indexList[0] = dataMap.get(target - nums[i]);
				indexList[1] =  i;
				break;
			}
			dataMap.put(nums[i], i);
		}
		return indexList;
	}

}
