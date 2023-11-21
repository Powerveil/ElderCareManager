package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.EmployeeLeaveLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author power
* @description 针对表【employee_leave_log】的数据库操作Mapper
* @createDate 2023-11-17 22:05:17
* @Entity com.ruoyi.system.domain.EmployeeLeaveLog
*/
@Mapper
public interface EmployeeLeaveLogMapper extends BaseMapper<EmployeeLeaveLog> {

    // 同意请假
    Integer agreeLeaveLog(@Param("leaveLogIds") Long[] leaveLogIds);
    // 不同意请假
    Integer disagreeLeaveLog(@Param("leaveLogIds") Long[] leaveLogIds);

    // 撤销请假
    Integer undoLeaveLogByIds(@Param("leaveLogIds") Long[] leaveLogIds);

}




