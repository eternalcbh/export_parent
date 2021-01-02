package cn.itcast.web.handler;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cbh
 * @PackageName:cn.itcast.web.handler
 * @ClassName:Factory
 * @Description:工厂设计模式
 * @date 2021-01-01 19:17
 */
public class Factory {
	/**
	 * 1.设计一个Map来存储对应的等级实现的策略
	 */
	private static Map<Integer, Handler> strategyMap = new HashMap<>();

	/**
	 * 2.获取相对应的策略方法
	 */
	public static Handler getInvokeStrategy(Integer degree){
		return strategyMap.get(degree);
	}

	/**
	 * 注册不同等级所对应的策略
	 * @param degree
	 * @param handler
	 */
	public static void register(Integer degree, Handler handler){
		if (StringUtils.isEmpty(degree) || null == handler){
			return;
		}
		strategyMap.put(degree, handler);
	}
}
