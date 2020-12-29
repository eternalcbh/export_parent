package cn.itcast.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author cbh
 * @PackageName:cn.itcast.service
 * @ClassName:ContractService
 * @Description:
 * @date 2020-12-28 22:12
 */
public class ContractProvider {
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/applicationContext-*.xml");
		context.start();
		System.in.read();


	}
}
