package com.ruoyi.system.service;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.domain.EmployeeLeaveLog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.system.domain.dto.LeaveLogDto;

import java.text.ParseException;
import java.util.List;

/**
* @author power
* @description 针对表【employee_leave_log】的数据库操作Service
* @createDate 2023-11-17 22:05:17
*/
public interface EmployeeLeaveLogService extends IService<EmployeeLeaveLog> {

    List<EmployeeLeaveLog> selectLeaveLogList(SysUser user);

    int deleteLeaveLogByIds(Long[] userIds);

    int agreeLeaveLog(Long[] leaveLogIds);

    int insertLeaveLog(LeaveLogDto leaveLogDto) throws ParseException;

    int undoLeaveLog(Long[] leaveLogIds);

    int disagreeLeaveLog(Long[] leaveLogIds);
}
