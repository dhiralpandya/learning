package com.omt.temp.practice;

import java.util.HashSet;
import java.util.Set;

public class PrintAllSubString {

	
	public static void main(String[] args) {
	
		subString("", "abc").forEach(s->{
			System.out.println(s);
		});
		
	}
	
	public static Set<String> subString(String r, String s) {
		
		Set<String> set = new HashSet();
		
		if(s.isEmpty()) {
			set.add(r);
			return set;
		}
		
		for(int i = 0; i < s.length(); i++) {
			
			set.addAll(subString(r+s.charAt(i), s.substring(i+1)));
			
		}
		set.add(r);
		return set;
		
	}

}
