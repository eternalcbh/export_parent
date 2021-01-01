package cn.itcast.domain.cargo;

import cn.itcast.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.List;

/**
 * 货物实体类
 * @author cbh
 */
public class ContractProduct extends BaseEntity {
    private String id;

    /**
     * 合同号
     */
    private String contractId;

    private String factoryId;

    private String factoryName;
    /**
     * 货号
     */
    private String productNo;

    /**
     * 图片路径
     */
    private String productImage;

    /**
     * 货描
     */
    private String productDesc;

    /**
     * 报运：装率
     */
    private String loadingRate;

    /**
     * 报运箱数
     */
    private Long boxNum;

    /**
     * 包装单位
     */
    private String packingUnit;

    /**
     * 数量
     */
    private Long cnumber;

    /**
     * 出货数量
     */
    private Long outNumber;

    /**
     * 是否完成
     */
    private Long finished;

    /**
     * 要求
     */
    private String productRequest;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 总金额
     */
    private BigDecimal amount;

    /**
     * 排序号
     */
    private Long orderNo;

    /**
     * 一对多
     */
    private List<ExtCproduct> extCproducts;


    public ContractProduct() {
    }

    public ContractProduct(String id, String contractId, String factoryId, String factoryName, String productNo, String productImage, String productDesc, String loadingRate, Long boxNum, String packingUnit, Long cnumber, Long outNumber, Long finished, String productRequest, BigDecimal price, BigDecimal amount, Long orderNo, List<ExtCproduct> extCproducts) {
        this.id = id;
        this.contractId = contractId;
        this.factoryId = factoryId;
        this.factoryName = factoryName;
        this.productNo = productNo;
        this.productImage = productImage;
        this.productDesc = productDesc;
        this.loadingRate = loadingRate;
        this.boxNum = boxNum;
        this.packingUnit = packingUnit;
        this.cnumber = cnumber;
        this.outNumber = outNumber;
        this.finished = finished;
        this.productRequest = productRequest;
        this.price = price;
        this.amount = amount;
        this.orderNo = orderNo;
        this.extCproducts = extCproducts;
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
     * @return contractId
     */
    public String getContractId() {
        return contractId;
    }

    /**
     * 设置
     * @param contractId
     */
    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    /**
     * 获取
     * @return factoryId
     */
    public String getFactoryId() {
        return factoryId;
    }

    /**
     * 设置
     * @param factoryId
     */
    public void setFactoryId(String factoryId) {
        this.factoryId = factoryId;
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
     * @return productImage
     */
    public String getProductImage() {
        return productImage;
    }

    /**
     * 设置
     * @param productImage
     */
    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    /**
     * 获取
     * @return productDesc
     */
    public String getProductDesc() {
        return productDesc;
    }

    /**
     * 设置
     * @param productDesc
     */
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    /**
     * 获取
     * @return loadingRate
     */
    public String getLoadingRate() {
        return loadingRate;
    }

    /**
     * 设置
     * @param loadingRate
     */
    public void setLoadingRate(String loadingRate) {
        this.loadingRate = loadingRate;
    }

    /**
     * 获取
     * @return boxNum
     */
    public Long getBoxNum() {
        return boxNum;
    }

    /**
     * 设置
     * @param boxNum
     */
    public void setBoxNum(Long boxNum) {
        this.boxNum = boxNum;
    }

    /**
     * 获取
     * @return packingUnit
     */
    public String getPackingUnit() {
        return packingUnit;
    }

    /**
     * 设置
     * @param packingUnit
     */
    public void setPackingUnit(String packingUnit) {
        this.packingUnit = packingUnit;
    }

    /**
     * 获取
     * @return cnumber
     */
    public Long getCnumber() {
        return cnumber;
    }

    /**
     * 设置
     * @param cnumber
     */
    public void setCnumber(Long cnumber) {
        this.cnumber = cnumber;
    }

    /**
     * 获取
     * @return outNumber
     */
    public Long getOutNumber() {
        return outNumber;
    }

    /**
     * 设置
     * @param outNumber
     */
    public void setOutNumber(Long outNumber) {
        this.outNumber = outNumber;
    }

    /**
     * 获取
     * @return finished
     */
    public Long getFinished() {
        return finished;
    }

    /**
     * 设置
     * @param finished
     */
    public void setFinished(Long finished) {
        this.finished = finished;
    }

    /**
     * 获取
     * @return productRequest
     */
    public String getProductRequest() {
        return productRequest;
    }

    /**
     * 设置
     * @param productRequest
     */
    public void setProductRequest(String productRequest) {
        this.productRequest = productRequest;
    }

    /**
     * 获取
     * @return price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取
     * @return amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 设置
     * @param amount
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 获取
     * @return orderNo
     */
    public Long getOrderNo() {
        return orderNo;
    }

    /**
     * 设置
     * @param orderNo
     */
    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 获取
     * @return extCproducts
     */
    public List<ExtCproduct> getExtCproducts() {
        return extCproducts;
    }

    /**
     * 设置
     * @param extCproducts
     */
    public void setExtCproducts(List<ExtCproduct> extCproducts) {
        this.extCproducts = extCproducts;
    }

    public String toString() {
        return "ContractProduct{id = " + id + ", contractId = " + contractId + ", factoryId = " + factoryId + ", factoryName = " + factoryName + ", productNo = " + productNo + ", productImage = " + productImage + ", productDesc = " + productDesc + ", loadingRate = " + loadingRate + ", boxNum = " + boxNum + ", packingUnit = " + packingUnit + ", cnumber = " + cnumber + ", outNumber = " + outNumber + ", finished = " + finished + ", productRequest = " + productRequest + ", price = " + price + ", amount = " + amount + ", orderNo = " + orderNo + ", extCproducts = " + extCproducts + "}";
    }
}