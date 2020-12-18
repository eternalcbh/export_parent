package cn.itcast.domain.system;

import lombok.Data;

/**
 * @author cbh
 * @PackageName:cn.itcast.domain.system
 * @ClassName:Role
 * @Description:
 * @date 2020-12-17 15:28
 */
@Data
public class Role {
	private String id;
	private String name;
	private String remark;
	private String orderNo;
	private String company_id;
	private String company_name;
}
