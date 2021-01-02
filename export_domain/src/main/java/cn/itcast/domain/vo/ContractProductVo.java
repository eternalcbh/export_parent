package cn.itcast.domain.vo;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author cbh
 * @PackageName:cn.itcast.domain.cargo
 * @ClassName:ContractProductVo
 * @Description: 出货表清单
 * @date 2021-01-02 9:04
 */
public class ContractProductVo implements Serializable {
	/**
	 * 客户名称
	 */
	private String customName;

	/**
	 * 合同号
	 */
	private String contractNo;

	/**
	 * 货号
	 */
	private String productNo;

	/**
	 * 数量
	 */
	private Integer cnumber;

	/**
	 * 工厂名
	 */
	private String factoryName;

	/**
	 * 交货日期
	 */
	private Date delivertPeriod;

	/**
	 * 船期
	 */
	private Date shipTime;

	/**
	 * 贸易条款
	 */
	private String tradeTerms;

	public ContractProductVo() {
	}

	public ContractProductVo(String customName, String contractNo, String productNo, Integer cnumber, String factoryName, Date delivertPeriod, Date shipTime, String tradeTerms) {
		this.customName = customName;
		this.contractNo = contractNo;
		this.productNo = productNo;
		this.cnumber = cnumber;
		this.factoryName = factoryName;
		this.delivertPeriod = delivertPeriod;
		this.shipTime = shipTime;
		this.tradeTerms = tradeTerms;
	}

	/**
	 * 获取
	 * @return customName
	 */
	public String getCustomName() {
		return customName;
	}

	/**
	 * 设置
	 * @param customName
	 */
	public void setCustomName(String customName) {
		this.customName = customName;
	}

	/**
	 * 获取
	 * @return contractNo
	 */
	public String getContractNo() {
		return contractNo;
	}

	/**
	 * 设置
	 * @param contractNo
	 */
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	/**
	 * 获取
	 * @return productNo
	 */
	public String getProductNo() {
		return productNo;
	}

	/**
	 * 设置
	 * @param productNo
	 */
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	/**
	 * 获取
	 * @return cnumber
	 */
	public Integer getCnumber() {
		return cnumber;
	}

	/**
	 * 设置
	 * @param cnumber
	 */
	public void setCnumber(Integer cnumber) {
		this.cnumber = cnumber;
	}

	/**
	 * 获取
	 * @return factoryName
	 */
	public String getFactoryName() {
		return factoryName;
	}

	/**
	 * 设置
	 * @param factoryName
	 */
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	/**
	 * 获取
	 * @return delivertPeriod
	 */
	public Date getDelivertPeriod() {
		return delivertPeriod;
	}

	/**
	 * 设置
	 * @param delivertPeriod
	 */
	public void setDelivertPeriod(Date delivertPeriod) {
		this.delivertPeriod = delivertPeriod;
	}

	/**
	 * 获取
	 * @return shipTime
	 */
	public Date getShipTime() {
		return shipTime;
	}

	/**
	 * 设置
	 * @param shipTime
	 */
	public void setShipTime(Date shipTime) {
		this.shipTime = shipTime;
	}

	/**
	 * 获取
	 * @return tradeTerms
	 */
	public String getTradeTerms() {
		return tradeTerms;
	}

	/**
	 * 设置
	 * @param tradeTerms
	 */
	public void setTradeTerms(String tradeTerms) {
		this.tradeTerms = tradeTerms;
	}

	public String toString() {
		return "ContractProductVo{customName = " + customName + ", contractNo = " + contractNo + ", productNo = " + productNo + ", cnumber = " + cnumber + ", factoryName = " + factoryName + ", delivertPeriod = " + delivertPeriod + ", shipTime = " + shipTime + ", tradeTerms = " + tradeTerms + "}";
	}
}
