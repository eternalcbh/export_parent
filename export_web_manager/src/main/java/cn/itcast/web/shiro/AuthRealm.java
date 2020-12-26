package cn.itcast.web.shiro;

import cn.itcast.domain.system.Module;
import cn.itcast.domain.system.User;
import cn.itcast.service.system.ModuleService;
import cn.itcast.service.system.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author cbh
 * @PackageName:cn.itcast.web.shiro
 * @ClassName:AuthRealm
 * @Description:
 * @date 2020-12-25 16:18
 */
public class AuthRealm extends AuthorizingRealm {

	/**
	 * 用户业务类
	 */
	@Autowired
	private UserService userService;

	/**
	 * 注入模块业务层
	 */
	@Autowired
	private ModuleService moduleService;
	/**
	 * Retrieves the AuthorizationInfo for the given principals from the underlying data store.  When returning
	 * an instance from this method, you might want to consider using an instance of
	 * {@link SimpleAuthorizationInfo SimpleAuthorizationInfo}, as it is suitable in most cases.
	 *
	 * @param principals the primary identifying principals of the AuthorizationInfo that should be retrieved.
	 * @return the AuthorizationInfo associated with this principals.
	 * @see SimpleAuthorizationInfo
	 */
	/**
	 * 授权
	 *
	 * @param principals
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//1.得到登录成功的用户
		User loginUser = (User) principals.getPrimaryPrincipal();

		//2. 根据登录成功用户查询该用户对应的权限
		List<Module> moduleList = moduleService.findModuleByUser(loginUser);

		//3.遍历权限将权限加入session中
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

		for (Module module : moduleList) {
			simpleAuthorizationInfo.addStringPermission(module.getName());
		}

		return simpleAuthorizationInfo;
	}

	/**
	 * Retrieves authentication data from an implementation-specific datasource (RDBMS, LDAP, etc) for the given
	 * authentication token.
	 * <p/>
	 * For most datasources, this means just 'pulling' authentication data for an associated subject/user and nothing
	 * more and letting Shiro do the rest.  But in some systems, this method could actually perform EIS specific
	 * log-in logic in addition to just retrieving data - it is up to the Realm implementation.
	 * <p/>
	 * A {@code null} return value means that no account could be associated with the specified token.
	 *
	 * @param token the authentication token containing the user's principal and credentials.
	 * @return an {@link AuthenticationInfo} object containing account data resulting from the
	 * authentication ONLY if the lookup is successful (i.e. account exists and is valid, etc.)
	 * @throws AuthenticationException if there is an error acquiring data or performing
	 *                                 realm-specific authentication logic for the specified <tt>token</tt>
	 */
	/**
	 * 登录认证
	 *
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//1.先把token强制转换为UsernamePasswordToken
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

		//2.得到用户输入的邮箱(账号)与密码
		String email = usernamePasswordToken.getUsername();

		//3.根据邮箱查询用户
		User user = userService.findByEmail(email);

		//4.如果根据邮箱查找到用户为null 直接return null
		if (null == user) {
			return null;
		}

		//5.创建SimpleAuthenticationInfo对象，把登录成功的对象还有该用户在数据库的密码封装到里面即可，shiro会自行对比密码
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), "");
		return simpleAuthenticationInfo;
	}
}
