package com.yk.zapt_annotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 注解示例
 * @author: liuzhixiang
 * @date: 2021/3/19
 * @mail: liuzhixiang@em-data.com.cn
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.CLASS)
public @interface Autowired {

    String name() default "";

    String dest() default "";
}
