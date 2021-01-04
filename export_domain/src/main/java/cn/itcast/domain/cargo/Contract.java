package cn.itcast.domain.cargo;

import cn.itcast.domain.BaseEntity;

import java.sql.Date;

/**
 * 订单实体类
 * @author cbh
 */
public class Contract extends BaseEntity {
    private String id;

    /**
     * 收购方
     */
    private String offeror;

    /**
     * 合同号
     */
    private String contractNo;

    /**
     * 签单日期
     */
    private Date signingDate;

    /**
     * 签单人
     */
    private String inputBy;

    /**
     * 审单人
     */
    private String checkBy;

    /**
     * 验货员
     */
    private String inspector;

    /**
     * 订单总金额
     */
    private Double totalAmount;

    /**
     * 要求
     */
    private String crequest;

    /**
     * 客户名称
     */
    private String customName;

    /**
     * 船期
     */
    private Date shipTime;

    /**
     * 重要程度
     */
    private Long importNum;

    /**
     * 交货期限
     */
    private Date deliveryPeriod;

    /**
     * 旧的状态，报运
     */
    private Integer oldState;

    /**
     * 出货状态，报运
     */
    private Integer outState;

    /**
     * 贸易条款
     */
    private String tradeTerms;

    /**
     * 打印板式，1打印一个货物2打印两个货物
     */
    private String printStyle;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态：
     * 0草稿
     * 1已上报待报运
     * 2 已报运
     */
    private Integer state;

    /**
     * 货物数量
     */
    private Integer proNum;

    /**
     * 附件数量
     */
    private Integer extNum;

    private String createBy;

    private String createDept;


    private String updateBy;


    public Contract() {
    }

    public Contract(String id, String offeror, String contractNo, Date signingDate, String inputBy, String checkBy, String inspector, Double totalAmount, String crequest, String customName, Date shipTime, Long importNum, Date deliveryPeriod, Integer oldState, Integer outState, String tradeTerms, String printStyle, String remark, Integer state, Integer proNum, Integer extNum, String createBy, String createDept, String updateBy) {
        this.id = id;
        this.offeror = offeror;
        this.contractNo = contractNo;
        this.signingDate = signingDate;
        this.inputBy = inputBy;
        this.checkBy = checkBy;
        this.inspector = inspector;
        this.totalAmount = totalAmount;
        this.crequest = crequest;
        this.customName = customName;
        this.shipTime = shipTime;
        this.importNum = importNum;
        this.deliveryPeriod = deliveryPeriod;
        this.oldState = oldState;
        this.outState = outState;
        this.tradeTerms = tradeTerms;
        this.printStyle = printStyle;
        this.remark = remark;
        this.state = state;
        this.proNum = proNum;
        this.extNum = extNum;
        this.createBy = createBy;
        this.createDept = createDept;
        this.updateBy = updateBy;
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
     * @return offeror
     */
    public String getOfferor() {
        return offeror;
    }

    /**
     * 设置
     * @param offeror
     */
    public void setOfferor(String offeror) {
        this.offeror = offeror;
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
     * @return signingDate
     */
    public Date getSigningDate() {
        return signingDate;
    }

    /**
     * 设置
     * @param signingDate
     */
    public void setSigningDate(Date signingDate) {
        this.signingDate = signingDate;
    }

    /**
     * 获取
     * @return inputBy
     */
    public String getInputBy() {
        return inputBy;
    }

    /**
     * 设置
     * @param inputBy
     */
    public void setInputBy(String inputBy) {
        this.inputBy = inputBy;
    }

    /**
     * 获取
     * @return checkBy
     */
    public String getCheckBy() {
        return checkBy;
    }

    /**
     * 设置
     * @param checkBy
     */
    public void setCheckBy(String checkBy) {
        this.checkBy = checkBy;
    }

    /**
     * 获取
     * @return inspector
     */
    public String getInspector() {
        return inspector;
    }

    /**
     * 设置
     * @param inspector
     */
    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    /**
     * 获取
     * @return totalAmount
     */
    public Double getTotalAmount() {
        return totalAmount;
    }

    /**
     * 设置
     * @param totalAmount
     */
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * 获取
     * @return crequest
     */
    public String getCrequest() {
        return crequest;
    }

    /**
     * 设置
     * @param crequest
     */
    public void setCrequest(String crequest) {
        this.crequest = crequest;
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
     * @return importNum
     */
    public Long getImportNum() {
        return importNum;
    }

    /**
     * 设置
     * @param importNum
     */
    public void setImportNum(Long importNum) {
        this.importNum = importNum;
    }

    /**
     * 获取
     * @return deliveryPeriod
     */
    public Date getDeliveryPeriod() {
        return deliveryPeriod;
    }

    /**
     * 设置
     * @param deliveryPeriod
     */
    public void setDeliveryPeriod(Date deliveryPeriod) {
        this.deliveryPeriod = deliveryPeriod;
    }

    /**
     * 获取
     * @return oldState
     */
    public Integer getOldState() {
        return oldState;
    }

    /**
     * 设置
     * @param oldState
     */
    public void setOldState(Integer oldState) {
        this.oldState = oldState;
    }

    /**
     * 获取
     * @return outState
     */
    public Integer getOutState() {
        return outState;
    }

    /**
     * 设置
     * @param outState
     */
    public void setOutState(Integer outState) {
        this.outState = outState;
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

    /**
     * 获取
     * @return printStyle
     */
    public String getPrintStyle() {
        return printStyle;
    }

    /**
     * 设置
     * @param printStyle
     */
    public void setPrintStyle(String printStyle) {
        this.printStyle = printStyle;
    }

    /**
     * 获取
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取
     * @return stat
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取
     * @return proNum
     */
    public Integer getProNum() {
        return proNum;
    }

    /**
     * 设置
     * @param proNum
     */
    public void setProNum(Integer proNum) {
        this.proNum = proNum;
    }

    /**
     * 获取
     * @return extNum
     */
    public Integer getExtNum() {
        return extNum;
    }

    /**
     * 设置
     * @param extNum
     */
    public void setExtNum(Integer extNum) {
        this.extNum = extNum;
    }

    /**
     * 获取
     * @return createBy
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置
     * @param createBy
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取
     * @return createDept
     */
    public String getCreateDept() {
        return createDept;
    }

    /**
     * 设置
     * @param createDept
     */
    public void setCreateDept(String createDept) {
        this.createDept = createDept;
    }

    /**
     * 获取
     * @return updateBy
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置
     * @param updateBy
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String toString() {
        return "Contract{id = " + id + ", offeror = " + offeror + ", contractNo = " + contractNo + ", signingDate = " + signingDate + ", inputBy = " + inputBy + ", checkBy = " + checkBy + ", inspector = " + inspector + ", totalAmount = " + totalAmount + ", crequest = " + crequest + ", customName = " + customName + ", shipTime = " + shipTime + ", importNum = " + importNum + ", deliveryPeriod = " + deliveryPeriod + ", oldState = " + oldState + ", outState = " + outState + ", tradeTerms = " + tradeTerms + ", printStyle = " + printStyle + ", remark = " + remark + ", stat = " + state + ", proNum = " + proNum + ", extNum = " + extNum + ", createBy = " + createBy + ", createDept = " + createDept + ", updateBy = " + updateBy + "}";
    }
}