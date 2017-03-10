package com.omt.learn.algo;

public class StringToInt {

    public StringToInt() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {

        int a = '0';
        System.out.println("Zero At :" + a);

        a = '9';
        System.out.println("Nine At :" + a);

        String s = "10923";

        int d = 0;
        for (int i = 0; i < s.length(); i++) {
            int dig = Character.digit(s.charAt(i), 10);
            System.out.println(dig);
            d *= 10;
            d -= dig;// This is IMP line
        }

        d = -d;
        System.out.println(d);
    }

}
