package org.epoch.mybatis.util;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.Id;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Marshal
 * @date : 2019/3/9
 */
public class DomainUtil {

    /**
     * 主键是否为空
     *
     * @param record
     * @return
     */
    public static boolean isPrimaryKeyNull(Object record) {
        Class clazz = record.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Id.class)) {
                try {
                    Method method = clazz.getMethod("get" + StringUtils.capitalize(field.getName()));
                    if (method.invoke(record) == null) {
                        return true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

}
