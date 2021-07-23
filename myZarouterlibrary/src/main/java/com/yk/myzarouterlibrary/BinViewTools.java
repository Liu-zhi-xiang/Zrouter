package com.yk.myzarouterlibrary;

import android.app.Activity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description:
 * @author: liuzhixiang
 * @date: 2021/4/2
 * @mail: liuzhixiang@em-data.com.cn
 */
public class BinViewTools {
    public static void bind(Activity activity){
        Class classx=activity.getClass();
        try {
            Class  bindviewClass=Class.forName(classx.getName()+"_ViewBinding");
            Method method =bindviewClass.getMethod("bind",activity.getClass());
            method.invoke(bindviewClass.newInstance(),activity);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
