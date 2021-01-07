package cn.itcast.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cbh
 * @PackageName:cn.itcast.consumer
 * @ClassName:EmailConsumer
 * @Description:
 * @date 2021-01-07 9:59
 */
public class EmailConsumer {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-activemq-consumer.xml");
		context.start();
	}
}
