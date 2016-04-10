package com.omt.factory;

import java.util.Map;
import java.util.TreeMap;

public abstract class ObjectCounter {

	private static Map<String, Long> classNameCount = new TreeMap<String, Long>();

	public ObjectCounter() {
		String key = this.getClass().getName();
		if (classNameCount.containsKey(key)) {
			classNameCount.put(key, classNameCount.get(key) + 1);
		} else {
			classNameCount.put(key, 1L);
		}
	}

	public static <T extends ObjectCounter> long getCount(Class<T> c) {
		String key = c.getName();
		if (classNameCount.containsKey(key)) {
			return classNameCount.get(key);
		} else {
			return 0;
		}
	}

	public static long totalObjectsCreated() {
		long totalCount = 0;

		for (long count : classNameCount.values()) {
			totalCount += count;
		}

		return totalCount;
	}

}
