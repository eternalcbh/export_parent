package cn.itcast.domain.vo;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Set;

@XmlRootElement(name="export")
public class ExportResult implements Serializable{
	private String exportId;
	private Integer state;
	private String remark;
	private Set<ExportProductResult> products;

	public ExportResult() {
	}

	public ExportResult(String exportId, Integer state, String remark, Set<ExportProductResult> products) {
		this.exportId = exportId;
		this.state = state;
		this.remark = remark;
		this.products = products;
	}

	public String getExportId() {
		return exportId;
	}
	public void setExportId(String exportId) {
		this.exportId = exportId;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Set<ExportProductResult> getProducts() {
		return products;
	}
	public void setProducts(Set<ExportProductResult> products) {
		this.products = products;
	}

	public String toString() {
		return "ExportResult{exportId = " + exportId + ", stat = " + state + ", remark = " + remark + ", products = " + products + "}";
	}
}
