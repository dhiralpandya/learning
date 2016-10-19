package com.omt.temp;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class BigIntTest {

	public static void main(String[] args) {
		
		//ArrayList<String>
		BigDecimal bigInt = null;
				
				try{
					bigInt = new BigDecimal("100-");
				}catch(Exception e) {
					
				}
		bigInt.divide(new BigDecimal(100));

	}

}
