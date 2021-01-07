package cn.itcast.listener;

import cn.itcast.domain.system.User;
import cn.itcast.utils.MailUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.io.IOException;

/**
 * @author cbh
 * @PackageName:cn.itcast.listener
 * @ClassName:EmailListener
 * @Description:
 * @date 2021-01-07 9:54
 */
public class EmailListener implements MessageListener {

	private ObjectMapper objectMapper = new ObjectMapper();
	@Override
	public void onMessage(Message message) {
		byte[] body = message.getBody();
		try {
			User user = objectMapper.readValue(body, User.class);
			MailUtil.sendMsg(user.getEmail(), "欢迎册用户","用户名"+user.getUserName());
			System.out.println("邮件发送完毕");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
