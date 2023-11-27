package com.ruoyi.system.domain.vo;

import com.ruoyi.system.domain.PhysicalExamination;

/**
 * @author Powerveil
 * @Date 2023/11/27 23:05
 */
public class PhysicalExaminationVo extends PhysicalExamination {

    /**
     * 受检人姓名
     */
    private String examineeName;
    /**
     * 医生姓名
     */
    private String doctorName;


    public String getExamineeName() {
        return examineeName;
    }

    public void setExamineeName(String examineeName) {
        this.examineeName = examineeName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}
