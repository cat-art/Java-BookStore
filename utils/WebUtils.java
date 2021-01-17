package com.bookStore.utils;
import com.bookStore.pojo.Book;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {
    /**
     * 把Map的值注入到对应的JavaBean属性当中
     * @param value
     * @param bean
     * @throws IllegalAccessException
     */
    public static <T> T copyParamToBean(Map value, T bean) throws IllegalAccessException {

        System.out.println("注入之前:"+bean);
        try {
            BeanUtils.populate(bean,value);
            System.out.println("注入之后:" +bean);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转化称为int类型的数据
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt, int defaultValue) {
        try {
            return  Integer.parseInt(strInt);
        }catch (Exception e) {
        //    e.printStackTrace();
        }
        return defaultValue;
    }
}
