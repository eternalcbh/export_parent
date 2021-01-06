package cn.itcast.web.task;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author cbh
 * @PackageName:cn.itcast.web.task
 * @ClassName:MyTask
 * @Description:
 * @date 2021-01-05 23:54
 */
public class MyTask {
	public void showTime(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("当前时间" + simpleDateFormat.format(new Date()));
	}
}
