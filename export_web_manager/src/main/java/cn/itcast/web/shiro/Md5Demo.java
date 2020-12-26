package cn.itcast.web.shiro;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author cbh
 * @PackageName:cn.itcast.web.shiro
 * @ClassName:Md5Demo
 * @Description:
 * @date 2020-12-25 21:31
 */
public class Md5Demo {
	public static void main(String[] args) {
		String salt = "1@qq.com";
		String password = "1";
		Md5Hash md5Hash = new Md5Hash(password, salt);
		System.out.println(md5Hash.toString());
	}
}

