package cn.itcast.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author cbh
 * @PackageName:cn.itcast.service
 * @ClassName:state
 * @Description:
 * @date 2021-01-04 8:57
 */
public class StateProvider {
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:spring/applicationContext-*.xml");
		applicationContext.start();
		System.in.read();
	}
}
