package cn.itcast.domain.cargo;

import cn.itcast.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 报运货物实体类
 * @author cbh
 */
public class ExportProduct extends BaseEntity {
    private String id;
    private String productNo;
    /**
     * PCS/SETS
     */
    private String packingUnit;
    private Integer cnumber;
    private Integer boxNum;
    /**
     * 毛重
     */
    private Double grossWeight;
    /**
     * 净重
     */
    private Double netWeight;
    private Double sizeLength;
    private Double sizeWidth;
    private Double sizeHeight;
    /**
     * sales confirmation 中的价格（手填）
     */
    private Double exPrice;
    private Double price;
    /**
     * 收购单价=合同单价
     */
    private Double tax;
    private Integer orderNo;
    /**
     * 报运货物和报运的关系，多对一
     */
    private String exportId;
    /**
     * 厂家名称，冗余字段
     */
    private String factoryName;
    private String factoryId;
    /**
     * 报运货物和报运附件的关系，一对多
     */
    private List<ExtEproduct> extEproducts = new ArrayList<>();


    public ExportProduct() {
    }

    public ExportProduct(String id, String productNo, String packingUnit, Integer cnumber, Integer boxNum, Double grossWeight, Double netWeight, Double sizeLength, Double sizeWidth, Double sizeHeight, Double exPrice, Double price, Double tax, Integer orderNo, String exportId, String factoryName, String factoryId, List<ExtEproduct> extEproducts) {
        this.id = id;
        this.productNo = productNo;
        this.packingUnit = packingUnit;
        this.cnumber = cnumber;
        this.boxNum = boxNum;
        this.grossWeight = grossWeight;
        this.netWeight = netWeight;
        this.sizeLength = sizeLength;
        this.sizeWidth = sizeWidth;
        this.sizeHeight = sizeHeight;
        this.exPrice = exPrice;
        this.price = price;
        this.tax = tax;
        this.orderNo = orderNo;
        this.exportId = exportId;
        this.factoryName = factoryName;
        this.factoryId = factoryId;
        this.extEproducts = extEproducts;
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
     * @return boxNum
     */
    public Integer getBoxNum() {
        return boxNum;
    }

    /**
     * 设置
     * @param boxNum
     */
    public void setBoxNum(Integer boxNum) {
        this.boxNum = boxNum;
    }

    /**
     * 获取
     * @return grossWeight
     */
    public Double getGrossWeight() {
        return grossWeight;
    }

    /**
     * 设置
     * @param grossWeight
     */
    public void setGrossWeight(Double grossWeight) {
        this.grossWeight = grossWeight;
    }

    /**
     * 获取
     * @return netWeight
     */
    public Double getNetWeight() {
        return netWeight;
    }

    /**
     * 设置
     * @param netWeight
     */
    public void setNetWeight(Double netWeight) {
        this.netWeight = netWeight;
    }

    /**
     * 获取
     * @return sizeLength
     */
    public Double getSizeLength() {
        return sizeLength;
    }

    /**
     * 设置
     * @param sizeLength
     */
    public void setSizeLength(Double sizeLength) {
        this.sizeLength = sizeLength;
    }

    /**
     * 获取
     * @return sizeWidth
     */
    public Double getSizeWidth() {
        return sizeWidth;
    }

    /**
     * 设置
     * @param sizeWidth
     */
    public void setSizeWidth(Double sizeWidth) {
        this.sizeWidth = sizeWidth;
    }

    /**
     * 获取
     * @return sizeHeight
     */
    public Double getSizeHeight() {
        return sizeHeight;
    }

    /**
     * 设置
     * @param sizeHeight
     */
    public void setSizeHeight(Double sizeHeight) {
        this.sizeHeight = sizeHeight;
    }

    /**
     * 获取
     * @return exPrice
     */
    public Double getExPrice() {
        return exPrice;
    }

    /**
     * 设置
     * @param exPrice
     */
    public void setExPrice(Double exPrice) {
        this.exPrice = exPrice;
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
     * @return tax
     */
    public Double getTax() {
        return tax;
    }

    /**
     * 设置
     * @param tax
     */
    public void setTax(Double tax) {
        this.tax = tax;
    }

    /**
     * 获取
     * @return orderNo
     */
    public Integer getOrderNo() {
        return orderNo;
    }

    /**
     * 设置
     * @param orderNo
     */
    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
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
     * @return extEproducts
     */
    public List<ExtEproduct> getExtEproducts() {
        return extEproducts;
    }

    /**
     * 设置
     * @param extEproducts
     */
    public void setExtEproducts(List<ExtEproduct> extEproducts) {
        this.extEproducts = extEproducts;
    }

    public String toString() {
        return "ExportProduct{id = " + id + ", productNo = " + productNo + ", packingUnit = " + packingUnit + ", cnumber = " + cnumber + ", boxNum = " + boxNum + ", grossWeight = " + grossWeight + ", netWeight = " + netWeight + ", sizeLength = " + sizeLength + ", sizeWidth = " + sizeWidth + ", sizeHeight = " + sizeHeight + ", exPrice = " + exPrice + ", price = " + price + ", tax = " + tax + ", orderNo = " + orderNo + ", exportId = " + exportId + ", factoryName = " + factoryName + ", factoryId = " + factoryId + ", extEproducts = " + extEproducts + "}";
    }
}