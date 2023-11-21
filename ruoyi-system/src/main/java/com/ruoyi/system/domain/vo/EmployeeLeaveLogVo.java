package com.ruoyi.system.domain.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excels;
import com.ruoyi.common.core.domain.entity.SysDept;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Powerveil
 * @Date 2023/11/18 15:42
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeLeaveLogVo {


    /**
     * id
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;

    /** 员工编号（MB-0000001） */
    private String jobId;

    /**
     * 用户昵称
     */
    private String userName;

    /** 部门对象 */
    private SysDept dept;

    /** 手机号码 */
    private String phonenumber;

    /**
     * 请假原因
     */
    private String leaveReason;

    /**
     * 状态（0：待处理，1：同意，2：拒绝，3：销毁）
     */
    private Integer status;

    /**
     * 请假开始时间
     */
    private Date leaveStartTime;

    /**
     * 请假截止时间
     */
    private Date leaveEndTime;

    /**
     * 销假时间
     */
    private Date undoTime;
    /**
     * 描述（拒绝理由）
     */
    private String desc;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
