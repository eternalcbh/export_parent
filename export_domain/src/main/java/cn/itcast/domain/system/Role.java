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
	private Long orderNo;
	private String companyId;
	private String companyName;
}
