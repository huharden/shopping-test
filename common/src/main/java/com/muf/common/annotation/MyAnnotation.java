package com.muf.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * description:
 * @author: hutao
 * @date 2019/6/17 11:56
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAnnotation {

    String hello() default "gege";
    String world();
    int[] array() default { 2, 4, 5, 6 };
    Class style() default String.class;
}
