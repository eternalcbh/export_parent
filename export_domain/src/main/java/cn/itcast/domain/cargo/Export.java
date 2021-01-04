package cn.itcast.domain.cargo;

import cn.itcast.domain.BaseEntity;
import com.sun.xml.internal.rngom.parse.host.Base;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 报运单实体类
 * @author cbh
 */
public class Export extends BaseEntity {
    private String id;

    /**
     * 制单日期
     */
    private Date inputDate;

    /**
     * 打断字段，报运相关的多个合同的id集合串
     */
    private String contractIds;

    /**
     * 合同以及确认书号
     */
    private String customerContract;

    /**
     * 信用证书
     */
    private String lcno;

    /**
     * 收货人以及地址
     */
    private String consignee;

    /**
     * 码头
     */
    private String marks;

    /**
     * 装船港
     */
    private String shipmentPort;

    /**
     * 目的港
     */
    private String destinationPort;

    /**
     * 船运SEA/空运Air 运输方式
     */
    private String transportMode;

    /**
     * FBO/CIF价格条件
     */
    private String priceCondition;

    /**
     * 备注
     */
    private String remark;

    /**
     * 冗余，为委托服务，一个报运的总箱数
     */
    private Long boxNums;

    /**
     * 冗余，为委托服务，一个报运的总毛重
     */
    private Double grossWeights;

    /**
     *冗余，为委托服务，一个报运的总体积
     */
    private Double measurements;

    /**
     * //0-草稿 1-已上报 2-装箱 3-委托 4-发票 5-财务
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

    List<ExportProduct> exportProducts;

    public Export() {
    }

    public Export(String id, Date inputDate, String contractIds, String customerContract, String lcno, String consignee, String marks, String shipmentPort, String destinationPort, String transportMode, String priceCondition, String remark, Long boxNums, Double grossWeights, Double measurements, Integer state, Integer proNum, Integer extNum, List<ExportProduct> exportProducts) {
        this.id = id;
        this.inputDate = inputDate;
        this.contractIds = contractIds;
        this.customerContract = customerContract;
        this.lcno = lcno;
        this.consignee = consignee;
        this.marks = marks;
        this.shipmentPort = shipmentPort;
        this.destinationPort = destinationPort;
        this.transportMode = transportMode;
        this.priceCondition = priceCondition;
        this.remark = remark;
        this.boxNums = boxNums;
        this.grossWeights = grossWeights;
        this.measurements = measurements;
        this.state = state;
        this.proNum = proNum;
        this.extNum = extNum;
        this.exportProducts = exportProducts;
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
     * @return inputDate
     */
    public Date getInputDate() {
        return inputDate;
    }

    /**
     * 设置
     * @param inputDate
     */
    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    /**
     * 获取
     * @return contractIds
     */
    public String getContractIds() {
        return contractIds;
    }

    /**
     * 设置
     * @param contractIds
     */
    public void setContractIds(String contractIds) {
        this.contractIds = contractIds;
    }

    /**
     * 获取
     * @return customerContract
     */
    public String getCustomerContract() {
        return customerContract;
    }

    /**
     * 设置
     * @param customerContract
     */
    public void setCustomerContract(String customerContract) {
        this.customerContract = customerContract;
    }

    /**
     * 获取
     * @return lcno
     */
    public String getLcno() {
        return lcno;
    }

    /**
     * 设置
     * @param lcno
     */
    public void setLcno(String lcno) {
        this.lcno = lcno;
    }

    /**
     * 获取
     * @return consignee
     */
    public String getConsignee() {
        return consignee;
    }

    /**
     * 设置
     * @param consignee
     */
    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    /**
     * 获取
     * @return marks
     */
    public String getMarks() {
        return marks;
    }

    /**
     * 设置
     * @param marks
     */
    public void setMarks(String marks) {
        this.marks = marks;
    }

    /**
     * 获取
     * @return shipmentPort
     */
    public String getShipmentPort() {
        return shipmentPort;
    }

    /**
     * 设置
     * @param shipmentPort
     */
    public void setShipmentPort(String shipmentPort) {
        this.shipmentPort = shipmentPort;
    }

    /**
     * 获取
     * @return destinationPort
     */
    public String getDestinationPort() {
        return destinationPort;
    }

    /**
     * 设置
     * @param destinationPort
     */
    public void setDestinationPort(String destinationPort) {
        this.destinationPort = destinationPort;
    }

    /**
     * 获取
     * @return transportMode
     */
    public String getTransportMode() {
        return transportMode;
    }

    /**
     * 设置
     * @param transportMode
     */
    public void setTransportMode(String transportMode) {
        this.transportMode = transportMode;
    }

    /**
     * 获取
     * @return priceCondition
     */
    public String getPriceCondition() {
        return priceCondition;
    }

    /**
     * 设置
     * @param priceCondition
     */
    public void setPriceCondition(String priceCondition) {
        this.priceCondition = priceCondition;
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
     * @return boxNums
     */
    public Long getBoxNums() {
        return boxNums;
    }

    /**
     * 设置
     * @param boxNums
     */
    public void setBoxNums(Long boxNums) {
        this.boxNums = boxNums;
    }

    /**
     * 获取
     * @return grossWeights
     */
    public Double getGrossWeights() {
        return grossWeights;
    }

    /**
     * 设置
     * @param grossWeights
     */
    public void setGrossWeights(Double grossWeights) {
        this.grossWeights = grossWeights;
    }

    /**
     * 获取
     * @return measurements
     */
    public Double getMeasurements() {
        return measurements;
    }

    /**
     * 设置
     * @param measurements
     */
    public void setMeasurements(Double measurements) {
        this.measurements = measurements;
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
     * @return exportProducts
     */
    public List<ExportProduct> getExportProducts() {
        return exportProducts;
    }

    /**
     * 设置
     * @param exportProducts
     */
    public void setExportProducts(List<ExportProduct> exportProducts) {
        this.exportProducts = exportProducts;
    }

    public String toString() {
        return "Export{id = " + id + ", inputDate = " + inputDate + ", contractIds = " + contractIds + ", customerContract = " + customerContract + ", lcno = " + lcno + ", consignee = " + consignee + ", marks = " + marks + ", shipmentPort = " + shipmentPort + ", destinationPort = " + destinationPort + ", transportMode = " + transportMode + ", priceCondition = " + priceCondition + ", remark = " + remark + ", boxNums = " + boxNums + ", grossWeights = " + grossWeights + ", measurements = " + measurements + ", stat = " + state + ", proNum = " + proNum + ", extNum = " + extNum + ", exportProducts = " + exportProducts + "}";
    }
}