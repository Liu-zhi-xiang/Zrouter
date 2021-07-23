package com.yk.zapt_annotation.annotation;

/**
 * @Description:
 * @author: liuzhixiang
 * @date: 2021/3/19
 * @mail: liuzhixiang@em-data.com.cn
 */
public @interface Aouter {
    int priority();

    String name() default "default";

}
