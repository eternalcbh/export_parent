package cn.itcast.domain.cargo;

import cn.itcast.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 附件实体类
 * @author cbh
 */
public class ExtCproduct extends BaseEntity {
    private String id;

    /**
     * 所属货物id
     */
    private String contractProductId;

    /**
     * 购销合同id
     */
    private String contractId;

    private String factoryId;

    /**
     * 工厂名
     */
    private String factoryName;

    /**
     * 、产品号
     */
    private String productNo;

    /**
     * 图片
     */
    private String productImage;

    /**
     * 产品描诉
     */
    private String productDesc;

    /**
     * 包装单位
     */
    private String packingUnit;

    /**
     * 数量
     */
    private Long cnumber;

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

    private String productRequest;


    public ExtCproduct() {
    }

    public ExtCproduct(String id, String contractProductId, String contractId, String factoryId, String factoryName, String productNo, String productImage, String productDesc, String packingUnit, Long cnumber, BigDecimal price, BigDecimal amount, Long orderNo, String productRequest) {
        this.id = id;
        this.contractProductId = contractProductId;
        this.contractId = contractId;
        this.factoryId = factoryId;
        this.factoryName = factoryName;
        this.productNo = productNo;
        this.productImage = productImage;
        this.productDesc = productDesc;
        this.packingUnit = packingUnit;
        this.cnumber = cnumber;
        this.price = price;
        this.amount = amount;
        this.orderNo = orderNo;
        this.productRequest = productRequest;
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
     * @return contractProductId
     */
    public String getContractProductId() {
        return contractProductId;
    }

    /**
     * 设置
     * @param contractProductId
     */
    public void setContractProductId(String contractProductId) {
        this.contractProductId = contractProductId;
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

    public String toString() {
        return "ExtCproduct{id = " + id + ", contractProductId = " + contractProductId + ", contractId = " + contractId + ", factoryId = " + factoryId + ", factoryName = " + factoryName + ", productNo = " + productNo + ", productImage = " + productImage + ", productDesc = " + productDesc + ", packingUnit = " + packingUnit + ", cnumber = " + cnumber + ", price = " + price + ", amount = " + amount + ", orderNo = " + orderNo + ", productRequest = " + productRequest + "}";
    }
}