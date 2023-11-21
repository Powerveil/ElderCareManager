package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 
 * @TableName employee_leave_log
 */
@Data
public class EmployeeLeaveLog implements Serializable {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 用户id
     */
    private Long userId;


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
    @TableField("`desc`")
    private String desc;

    /**
     * 创建时间
     */

//    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除标志（0：存在，2：删除）
     */
    private String delFlag;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        EmployeeLeaveLog other = (EmployeeLeaveLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getLeaveReason() == null ? other.getLeaveReason() == null : this.getLeaveReason().equals(other.getLeaveReason()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLeaveStartTime() == null ? other.getLeaveStartTime() == null : this.getLeaveStartTime().equals(other.getLeaveStartTime()))
            && (this.getLeaveEndTime() == null ? other.getLeaveEndTime() == null : this.getLeaveEndTime().equals(other.getLeaveEndTime()))
            && (this.getUndoTime() == null ? other.getUndoTime() == null : this.getUndoTime().equals(other.getUndoTime()))
            && (this.getDesc() == null ? other.getDesc() == null : this.getDesc().equals(other.getDesc()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getLeaveReason() == null) ? 0 : getLeaveReason().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLeaveStartTime() == null) ? 0 : getLeaveStartTime().hashCode());
        result = prime * result + ((getLeaveEndTime() == null) ? 0 : getLeaveEndTime().hashCode());
        result = prime * result + ((getUndoTime() == null) ? 0 : getUndoTime().hashCode());
        result = prime * result + ((getDesc() == null) ? 0 : getDesc().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", leaveReason=").append(leaveReason);
        sb.append(", status=").append(status);
        sb.append(", leaveStartTime=").append(leaveStartTime);
        sb.append(", leaveEndTime=").append(leaveEndTime);
        sb.append(", undoTime=").append(undoTime);
        sb.append(", desc=").append(desc);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}