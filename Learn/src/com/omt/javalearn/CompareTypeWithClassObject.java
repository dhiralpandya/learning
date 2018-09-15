package com.omt.javalearn;

import com.omt.factory.Article;
import com.omt.factory.Bio;

public class CompareTypeWithClassObject {

    public static void main(String... args) {

        System.out.println(verify(Article.class, new Bio()));

    }

    public static <T> boolean verify(Class<T> tClass, Object o) {
        System.out.println(tClass.getTypeName());
        return tClass.getTypeName().equals(o.getClass().getTypeName());
    }

}
