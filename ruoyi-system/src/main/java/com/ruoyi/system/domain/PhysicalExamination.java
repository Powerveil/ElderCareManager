package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 体检管理对象 physical_examination
 * 
 * @author ruoyi
 * @date 2023-11-27
 */
public class PhysicalExamination extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 受检人id */
    @Excel(name = "受检人id")
    private Long examineeId;

    /** 医生id */
    @Excel(name = "医生id")
    private Long doctorId;

    /** 体检结果 */
    @Excel(name = "体检结果")
    private String examinationResult;

    /** 体检地点 */
    @Excel(name = "体检地点")
    private String examinationLocation;

    /** 体检时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "体检时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date examinationDate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setExamineeId(Long examineeId) 
    {
        this.examineeId = examineeId;
    }

    public Long getExamineeId() 
    {
        return examineeId;
    }
    public void setDoctorId(Long doctorId) 
    {
        this.doctorId = doctorId;
    }

    public Long getDoctorId() 
    {
        return doctorId;
    }
    public void setExaminationResult(String examinationResult) 
    {
        this.examinationResult = examinationResult;
    }

    public String getExaminationResult() 
    {
        return examinationResult;
    }
    public void setExaminationLocation(String examinationLocation) 
    {
        this.examinationLocation = examinationLocation;
    }

    public String getExaminationLocation() 
    {
        return examinationLocation;
    }
    public void setExaminationDate(Date examinationDate) 
    {
        this.examinationDate = examinationDate;
    }

    public Date getExaminationDate() 
    {
        return examinationDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("examineeId", getExamineeId())
            .append("doctorId", getDoctorId())
            .append("examinationResult", getExaminationResult())
            .append("examinationLocation", getExaminationLocation())
            .append("examinationDate", getExaminationDate())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
