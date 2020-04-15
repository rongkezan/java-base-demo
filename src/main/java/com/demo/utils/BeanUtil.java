package com.demo.utils;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

/**
 * 实体工具类
 */
public class BeanUtil {
    /**
     * 将对象的null值和null字符串转换成空字符串
     * @param bean 对象
     */
    public static <T> void nullStringToStringValue(T bean) {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String type = field.getGenericType().toString();
            if (StringUtils.equals(type, "class java.lang.String")){
                try {
                    String value = (String) field.get(bean);
                    if (StringUtils.isBlank(value) || StringUtils.equals(value, "null")){
                        field.set(bean, "");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
