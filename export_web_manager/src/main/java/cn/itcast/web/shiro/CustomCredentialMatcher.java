package cn.itcast.web.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author cbh
 * @PackageName:cn.itcast.web.shiro
 * @ClassName:CustomCredentialMatcher
 * @Description:
 * @date 2020-12-25 21:17
 */
public class CustomCredentialMatcher extends SimpleCredentialsMatcher {
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
//		1.先将token转为user
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)token;

		//2.得到用户输入的账户和密码
		String salt = usernamePasswordToken.getUsername();
		String password = new String(usernamePasswordToken.getPassword());

		//3.对用户输入的密码进行加盐加密
		Md5Hash md5Hash = new Md5Hash(password, salt);
		String slatPassword = md5Hash.toString();

		//4.取出数据库的密码进行比对
		String dbPassword = (String) info.getCredentials();

		return slatPassword.equals(dbPassword);
	}
}
