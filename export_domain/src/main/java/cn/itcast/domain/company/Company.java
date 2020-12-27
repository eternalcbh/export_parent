package cn.itcast.domain.company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company implements Serializable {
    /**
     * 对象唯一标记,对应数据库主键
     */
    private String id;
    /**
     * 公司名称
     */
    private String name;
    /**
     * 到期时间
     */
    private Date expirationDate;
    /**
     * 公司地址
     */
    private String address;
    /**
     * 营业执照
     */
    private String licenseId;
    /**
     * 法人代表
     */
    private String representative;
    /**
     * 公司电话
     */
    private String phone;
    /**
     * 公司规模
     */
    private String companySize;
    /**
     * 所属行业
     */
    private String industry;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 状态
     */
    private Integer state;
    /**
     * 当前余额
     */
    private Double balance;
    /**
     * 城市
     */
    private String city;
}
