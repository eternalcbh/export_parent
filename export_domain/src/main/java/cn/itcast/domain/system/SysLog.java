package cn.itcast.domain.system;

import java.util.Date;

/**
 * @author cbh
 * @PackageName:cn.itcast.domain.system
 * @ClassName:SysLog
 * @Description:
 * @date 2020-12-24 23:45
 */
public class SysLog {
	private String id;
	private String userName;
	private String ip;
	private Date time;
	private String method;
	private String action;
	private String companyId;
	private String companyName;

	public SysLog() {
	}

	public SysLog(String id, String userName, String ip, Date time, String method, String action, String companyId, String companyName) {
		this.id = id;
		this.userName = userName;
		this.ip = ip;
		this.time = time;
		this.method = method;
		this.action = action;
		this.companyId = companyId;
		this.companyName = companyName;
	}

	/**
	 * 获取
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 获取
	 * @return ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * 设置
	 * @param ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * 获取
	 * @return time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * 设置
	 * @param time
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	/**
	 * 获取
	 * @return method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * 设置
	 * @param method
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * 获取
	 * @return action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * 设置
	 * @param action
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * 获取
	 * @return companyId
	 */
	public String getCompanyId() {
		return companyId;
	}

	/**
	 * 设置
	 * @param companyId
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	/**
	 * 获取
	 * @return companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * 设置
	 * @param companyName
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String toString() {
		return "SysLog{id = " + id + ", userName = " + userName + ", ip = " + ip + ", time = " + time + ", method = " + method + ", action = " + action + ", companyId = " + companyId + ", companyName = " + companyName + "}";
	}
}
