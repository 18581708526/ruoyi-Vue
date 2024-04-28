package com.ruoyi.approval.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 我的审批对象 ry_approval
 * 
 * @author ruoyi
 * @date 2024-04-21
 */
public class RyApproval extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 工作流编号 */
    @Excel(name = "工作流编号")
    private String workCode;

    /** 工作流名称 */
    @Excel(name = "工作流名称")
    private String workName;

    /** 流程发起人 */
    @Excel(name = "流程发起人")
    private Long creater;

    /** 流程审批人 */
    @Excel(name = "流程审批人")
    private Long targetUser;

    /** 审批状态 */
    @Excel(name = "审批状态")
    private Long status;

    /** 审批人姓名 */
    @Excel(name = "审批人姓名")
    private String targetUsername;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setWorkCode(String workCode) 
    {
        this.workCode = workCode;
    }

    public String getWorkCode() 
    {
        return workCode;
    }
    public void setWorkName(String workName) 
    {
        this.workName = workName;
    }

    public String getWorkName() 
    {
        return workName;
    }
    public void setCreater(Long creater) 
    {
        this.creater = creater;
    }

    public Long getCreater() 
    {
        return creater;
    }
    public void setTargetUser(Long targetUser) 
    {
        this.targetUser = targetUser;
    }

    public Long getTargetUser() 
    {
        return targetUser;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setTargetUsername(String targetUsername) 
    {
        this.targetUsername = targetUsername;
    }

    public String getTargetUsername() 
    {
        return targetUsername;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("workCode", getWorkCode())
            .append("workName", getWorkName())
            .append("creater", getCreater())
            .append("targetUser", getTargetUser())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .append("targetUsername", getTargetUsername())
            .toString();
    }
}
