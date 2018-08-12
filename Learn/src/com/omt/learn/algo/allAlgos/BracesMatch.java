package com.omt.learn.algo.allAlgos;

import java.io.BufferedWriter;
import java.util.Scanner;
import java.util.Stack;

public class BracesMatch {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//final String fileName = System.getenv("OUTPUT_PATH");
		//BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		String[] res;

		int _values_size = 0;
		_values_size = Integer.parseInt(in.nextLine().trim());
		String[] _values = new String[_values_size];
		String _values_item;
		for (int _values_i = 0; _values_i < _values_size; _values_i++) {
			try {
				_values_item = in.nextLine();
			} catch (Exception e) {
				_values_item = null;
			}
			_values[_values_i] = _values_item;
		}

		res = braces(_values);
		
		
		for(String v : res) {
			System.out.println(v);
		}

	}

	static String[] braces(String[] values) {

		String[] s = new String[values.length];
		
		int ansCount = 0;
		for(String input : values) {
			
			if(input.length()%2 == 1) {
				s[ansCount++]= "NO";
				continue;
			}
			
			boolean isValid = true;
			for(int count = 0; count < input.length()/2; count++) {
				if(!((input.charAt(count) == '(' && input.charAt(input.length()-1-count) == ')')
						|| (input.charAt(count) == '{' && input.charAt(input.length()-1-count) == '}') 
						|| (input.charAt(count) == '[' && input.charAt(input.length()-1-count) == ']'))) {
					isValid = false;
					break;
				}
			}
			
			if(isValid || bracesWithStack(input)) {
				s[ansCount++]= "YES";
			} else  {
				s[ansCount++]= "NO";
			}
			
		}
		
		return s;
		

    }
	
	public static boolean bracesWithStack(String input)
	{
	   

	    Stack<Character> resultStack = new Stack<Character>();
	    for (int count = 0; count < input.length(); count++)
	    {
	        char current = input.charAt(count);
	        if (current == '{' || current == '(' || current == '[')
	        {
	        	resultStack.push(current);
	        }


	        if (current == '}' || current == ')' || current == ']')
	        {
	            if (resultStack.isEmpty())
	                return false;

	            char last = resultStack.peek();
	            if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[')
	            	resultStack.pop();
	            else 
	                return false;
	        }

	    }

	    return resultStack.isEmpty();
	}

}
