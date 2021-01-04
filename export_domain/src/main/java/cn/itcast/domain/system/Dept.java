package cn.itcast.domain.system;

import lombok.Data;
/**
 pe_dept 部门表
 dept_id      主键
 dept_name    名称
 stat        状态
 company_id   部门的所属企业（查询列表需要根据企业id查询）       【重点：关联字段】
 company_name 企业名称（冗余字段，减少表连接查询，提高查询效率）
 parent_id    当前部门的父部门                               【重点：关联字段】
 */

@Data
public class Dept {
    /**
     *部门id
     */
    private String id;

    /**
     * 部门名字
     */
    private String deptName;

    /**
     * 启用状态
     */
    private Integer state;

    /**
     * 公司id
     */
    private String companyId;

    /**
     * 公司名字
     */
    private String companyName;

    /**
     * 当前部门关联的父部门
     */
    private Dept parent;
}
