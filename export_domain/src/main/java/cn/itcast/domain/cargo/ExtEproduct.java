package cn.itcast.domain.cargo;

import cn.itcast.domain.BaseEntity;

import java.io.Serializable;

/**
 * 报运单下的附件
 * @author cbh
 */
public class ExtEproduct extends BaseEntity implements Serializable {
    private String id;

    private String exportProductId;

    private String exportId;

    private String factoryId;

    private String productNo;

    private String productImage;

    private String productDesc;

    private Long cnumber;

    private String packingUnit;

    private Double price;

    private Double amount;

    private Long orderNo;

    private String companyId;

    private String companyName;

    private String productRequest;

    private String factoryName;

    public ExtEproduct() {
    }

    public ExtEproduct(String id, String exportProductId, String exportId, String factoryId, String productNo, String productImage, String productDesc, Long cnumber, String packingUnit, Double price, Double amount, Long orderNo, String companyId, String companyName, String productRequest, String factoryName) {
        this.id = id;
        this.exportProductId = exportProductId;
        this.exportId = exportId;
        this.factoryId = factoryId;
        this.productNo = productNo;
        this.productImage = productImage;
        this.productDesc = productDesc;
        this.cnumber = cnumber;
        this.packingUnit = packingUnit;
        this.price = price;
        this.amount = amount;
        this.orderNo = orderNo;
        this.companyId = companyId;
        this.companyName = companyName;
        this.productRequest = productRequest;
        this.factoryName = factoryName;
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
     * @return exportProductId
     */
    public String getExportProductId() {
        return exportProductId;
    }

    /**
     * 设置
     * @param exportProductId
     */
    public void setExportProductId(String exportProductId) {
        this.exportProductId = exportProductId;
    }

    /**
     * 获取
     * @return exportId
     */
    public String getExportId() {
        return exportId;
    }

    /**
     * 设置
     * @param exportId
     */
    public void setExportId(String exportId) {
        this.exportId = exportId;
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
     * @return price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取
     * @return amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * 设置
     * @param amount
     */
    public void setAmount(Double amount) {
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

    public String toString() {
        return "ExtEproduct{id = " + id + ", exportProductId = " + exportProductId + ", exportId = " + exportId + ", factoryId = " + factoryId + ", productNo = " + productNo + ", productImage = " + productImage + ", productDesc = " + productDesc + ", cnumber = " + cnumber + ", packingUnit = " + packingUnit + ", price = " + price + ", amount = " + amount + ", orderNo = " + orderNo + ", companyId = " + companyId + ", companyName = " + companyName + ", productRequest = " + productRequest + ", factoryName = " + factoryName + "}";
    }
}