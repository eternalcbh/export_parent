package cn.itcast.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 抽取共用的字段
 * @author cbh
 */
public class BaseEntity implements Serializable {
	/**
	 * 创建者的id
	 */
	protected String createBy;
	/**
	 * 创建者所在部门的id
	 */
	protected String createDept;
	/**
	 * 创建时间
	 */
	protected Date   createTime;
	/**
	 * 修改者的用户id
	 */
	protected String updateBy;
	/**
	 * 更新时间
	 */
	protected Date   updateTime;
	/**
	 * 公司id
	 */
	protected String companyId;
	/**
	 * 公司名
	 */
	protected String companyName;
	
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getCreateDept() {
		return createDept;
	}
	public void setCreateDept(String createDept) {
		this.createDept = createDept;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}
