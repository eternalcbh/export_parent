package cn.itcast.domain.system;

import lombok.Data;

/**
 * @author cbh
 * @PackageName:cn.itcast.domain.company
 * @ClassName:Module
 * @Description:
 * @date 2020-12-21 19:52
 */
@Data
public class Module {
	private String id;
	/**
	 * 父模块id
	 */
	private String parentId;
	/**
	 * 父模块名
	 */
	private String parentName;
	/**
	 * 模块名称
	 */
	private String name;
	private Double layerNum;
	private Double isLeaf;
	private String ico;
	private String cpermission;
	private String curl;
	/**
	 * /0主菜单 /1左侧菜单 /2按钮
	 */
	private Double ctype;
	private Double state;
	/**
	 * 从属关系：
	 *  0：saas系统内部菜单
	 *  1：租用企业菜单
	 */
	private String belong;
	private String cwhich;
	private Double quoteNum;
	private String remark;
	private Double orderNo;
}
