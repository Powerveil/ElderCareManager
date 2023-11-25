package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;

/**
 * @author Powerveil
 * @Date 2023/11/22 18:23
 */
public class AllocationVo extends Allocation {
    @Excel(name = "护工姓名")
    String supportWorkerName;

    @Excel(name = "护工手机号")
    String supportWorkerPhonenumber;

    @Excel(name = "老人姓名")
    String elderName;
    @Excel(name = "老人手机号")
    String elderPhonenumber;

    public String getSupportWorkerName() {
        return supportWorkerName;
    }

    public void setSupportWorkerName(String supportWorkerName) {
        this.supportWorkerName = supportWorkerName;
    }

    public String getSupportWorkerPhonenumber() {
        return supportWorkerPhonenumber;
    }

    public void setSupportWorkerPhonenumber(String supportWorkerPhonenumber) {
        this.supportWorkerPhonenumber = supportWorkerPhonenumber;
    }

    public String getElderName() {
        return elderName;
    }

    public void setElderName(String elderName) {
        this.elderName = elderName;
    }

    public String getElderPhonenumber() {
        return elderPhonenumber;
    }

    public void setElderPhonenumber(String elderPhonenumber) {
        this.elderPhonenumber = elderPhonenumber;
    }
}
