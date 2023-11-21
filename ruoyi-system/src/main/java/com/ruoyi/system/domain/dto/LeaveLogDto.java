package com.ruoyi.system.domain.dto;

import com.ruoyi.common.core.domain.BaseEntity;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author Powerveil
 * @Date 2023/11/20 21:18
 */
public class LeaveLogDto extends BaseEntity {

    /**
     * 请假原因
     */
    String reason;

    List<String> addLeaveLogDateRange;



    @NotBlank(message = "请假原因不能为空")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<String> getAddLeaveLogDateRange() {
        return addLeaveLogDateRange;
    }

    public void setAddLeaveLogDateRange(List<String> addLeaveLogDateRange) {
        this.addLeaveLogDateRange = addLeaveLogDateRange;
    }
}
