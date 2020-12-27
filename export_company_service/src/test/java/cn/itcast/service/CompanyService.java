package cn.itcast.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author cbh
 * @PackageName:cn.itcast.service
 * @ClassName:CompanyService
 * @Description:
 * @date 2020-12-27 18:24
 */
public class CompanyService {
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("classpath*:spring/applicationContext-*.xml");
		application.start();
		System.in.read();
	}
}
