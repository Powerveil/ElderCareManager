package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 房间管理对象 room
 * 
 * @author ruoyi
 * @date 2023-11-29
 */
public class Room extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 房间id */
    private Long id;

    /** 房间编号（M01-501） */
    @Excel(name = "房间编号", readConverterExp = "M=01-501")
    private String roomNo;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 房间类型（'01'：普通类型） */
    @Excel(name = "房间类型", readConverterExp = "'=01'：普通类型")
    private String type;

    /** 可以有多少人 */
    @Excel(name = "可以有多少人")
    private Integer count;

    /** 现在数量 */
    @Excel(name = "现在数量")
    private Integer nowCount;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRoomNo(String roomNo) 
    {
        this.roomNo = roomNo;
    }

    public String getRoomNo() 
    {
        return roomNo;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setCount(Integer count) 
    {
        this.count = count;
    }

    public Integer getCount() 
    {
        return count;
    }
    public void setNowCount(Integer nowCount) 
    {
        this.nowCount = nowCount;
    }

    public Integer getNowCount() 
    {
        return nowCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("roomNo", getRoomNo())
            .append("price", getPrice())
            .append("type", getType())
            .append("count", getCount())
            .append("nowCount", getNowCount())
            .toString();
    }
}
