package cn.itcast.domain.vo;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@XmlRootElement(name="exportProduct")
public class ExportProductVo implements Serializable{
	private String id;	  	
	private String eid;
	
	private String exportProductId;		
/*	@JSONField(serialize=false)
	private Export export ;*/
	private String exportId;	
	private String factoryId;			
	private String productNo;			
	private String packingUnit;			//PCS/SETS
	private Integer cnumber;			
	private Integer boxNum;			
	private Double grossWeight;			
	private Double netWeight;			
	private Double sizeLength;			
	private Double sizeWidth;			
	private Double sizeHeight;			
	private Double exPrice;			//sales confirmation 中的价格（手填）
	private Double price;			
	private Double tax;			//收购单价=合同单价
	private Integer orderNo;

	public ExportProductVo() {
	}

	public ExportProductVo(String id, String eid, String exportProductId, String exportId, String factoryId, String productNo, String packingUnit, Integer cnumber, Integer boxNum, Double grossWeight, Double netWeight, Double sizeLength, Double sizeWidth, Double sizeHeight, Double exPrice, Double price, Double tax, Integer orderNo) {
		this.id = id;
		this.eid = eid;
		this.exportProductId = exportProductId;
		this.exportId = exportId;
		this.factoryId = factoryId;
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
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getExportProductId() {
		return this.exportProductId;
	}
	public void setExportProductId(String exportProductId) {
		this.exportProductId = exportProductId;
	}	
	
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getExportId() {
		return this.exportId;
	}
	public void setExportId(String exportId) {
		this.exportId = exportId;
	}
	
	public String getFactoryId() {
		return this.factoryId;
	}
	public void setFactoryId(String factoryId) {
		this.factoryId = factoryId;
	}	
	
	public String getProductNo() {
		return this.productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}	
	
	public String getPackingUnit() {
		return this.packingUnit;
	}
	public void setPackingUnit(String packingUnit) {
		this.packingUnit = packingUnit;
	}	
	
	public Integer getCnumber() {
		return this.cnumber;
	}
	public void setCnumber(Integer cnumber) {
		this.cnumber = cnumber;
	}	
	
	public Integer getBoxNum() {
		return this.boxNum;
	}
	public void setBoxNum(Integer boxNum) {
		this.boxNum = boxNum;
	}	
	
	public Double getGrossWeight() {
		return this.grossWeight;
	}
	public void setGrossWeight(Double grossWeight) {
		this.grossWeight = grossWeight;
	}	
	
	public Double getNetWeight() {
		return this.netWeight;
	}
	public void setNetWeight(Double netWeight) {
		this.netWeight = netWeight;
	}	
	
	public Double getSizeLength() {
		return this.sizeLength;
	}
	public void setSizeLength(Double sizeLength) {
		this.sizeLength = sizeLength;
	}	
	
	public Double getSizeWidth() {
		return this.sizeWidth;
	}
	public void setSizeWidth(Double sizeWidth) {
		this.sizeWidth = sizeWidth;
	}	
	
	public Double getSizeHeight() {
		return this.sizeHeight;
	}
	public void setSizeHeight(Double sizeHeight) {
		this.sizeHeight = sizeHeight;
	}	
	
	public Double getExPrice() {
		return this.exPrice;
	}
	public void setExPrice(Double exPrice) {
		this.exPrice = exPrice;
	}	
	
	public Double getPrice() {
		return this.price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}	
	
	public Double getTax() {
		return this.tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}	
	
	public Integer getOrderNo() {
		return this.orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public String toString() {
		return "ExportProductVo{id = " + id + ", eid = " + eid + ", exportProductId = " + exportProductId + ", exportId = " + exportId + ", factoryId = " + factoryId + ", productNo = " + productNo + ", packingUnit = " + packingUnit + ", cnumber = " + cnumber + ", boxNum = " + boxNum + ", grossWeight = " + grossWeight + ", netWeight = " + netWeight + ", sizeLength = " + sizeLength + ", sizeWidth = " + sizeWidth + ", sizeHeight = " + sizeHeight + ", exPrice = " + exPrice + ", price = " + price + ", tax = " + tax + ", orderNo = " + orderNo + "}";
	}
	/*public Export getExport() {
		return export;
	}
	public void setExport(Export export) {
		this.export = export;
	}*/
	
}
