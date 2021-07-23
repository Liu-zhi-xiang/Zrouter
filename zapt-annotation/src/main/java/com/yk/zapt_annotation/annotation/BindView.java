package com.yk.zapt_annotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description:
 * @author: liuzhixiang
 * @date: 2021/4/2
 * @mail: liuzhixiang@em-data.com.cn
 */
@Retention(RetentionPolicy.CLASS) //表示编译时注解
@Target(ElementType.FIELD) //表示注解范围为类成员（构造方法、成员、成员变量）
public @interface BindView {
    int value();
}
