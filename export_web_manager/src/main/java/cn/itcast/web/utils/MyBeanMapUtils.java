package cn.itcast.web.utils;

import org.apache.poi.ss.formula.functions.T;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cbh
 * @PackageName:cn.itcast.web.utils
 * @ClassName:MyBeanMapUtils
 * @Description:
 * @date 2021-01-05 22:40
 */
public class MyBeanMapUtils {
	public static <T> Map<String, Object> getMap(T object) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {

		if (object == null){
			return null;
		}


		HashMap<String, Object> map = new HashMap<>();

		//获取反射Class
		Class<?> aClass = Class.forName(object.getClass().getName());

		//获取成员字段
		Field[] fields = aClass.getDeclaredFields();

		//赋值
		for (Field field : fields) {
			StringBuilder stringBuilder = new StringBuilder();
			String first = String.valueOf(field.getName().charAt(0)).toUpperCase();
			String methodName = stringBuilder.append(first + field.getName().substring(1)).toString();
			Method method = aClass.getMethod("get"+methodName);
			map.put(field.getName(), method.invoke(object));
		}

		return map;
	}
}
