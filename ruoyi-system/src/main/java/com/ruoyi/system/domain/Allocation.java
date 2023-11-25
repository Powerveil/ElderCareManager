package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 护工分配对象 allocation
 * 
 * @author Powerveil
 * @date 2023-11-22
 */
public class Allocation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 护工id */
    @Excel(name = "护工id")
    private Long supportWorkerId;

    /** 老人id */
    @Excel(name = "老人id")
    private Long elderId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSupportWorkerId(Long supportWorkerId) 
    {
        this.supportWorkerId = supportWorkerId;
    }

    public Long getSupportWorkerId() 
    {
        return supportWorkerId;
    }
    public void setElderId(Long elderId) 
    {
        this.elderId = elderId;
    }

    public Long getElderId() 
    {
        return elderId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("supportWorkerId", getSupportWorkerId())
            .append("elderId", getElderId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
