package com.ruoyi.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.EmployeeLeaveLog;
import com.ruoyi.system.domain.dto.LeaveLogDto;
import com.ruoyi.system.service.EmployeeLeaveLogService;
import com.ruoyi.system.mapper.EmployeeLeaveLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
* @author power
* @description 针对表【employee_leave_log】的数据库操作Service实现
* @createDate 2023-11-17 22:05:17
*/
@Service
public class EmployeeLeaveLogServiceImpl extends ServiceImpl<EmployeeLeaveLogMapper, EmployeeLeaveLog>
    implements EmployeeLeaveLogService{

    @Autowired
    private EmployeeLeaveLogMapper employeeLeaveLogMapper;

    @Override
    public List<EmployeeLeaveLog> selectLeaveLogList(SysUser user) {
        LambdaQueryWrapper<EmployeeLeaveLog> queryWrapper = new LambdaQueryWrapper<>();
//        List<EmployeeLeaveLog> list = baseMapper.selectLeaveLogList(user);
        Map<String, Object> params = user.getParams();
        String beginTime = (String) params.get("beginTime");
        String endTime = (String) params.get("endTime");
        if (StringUtils.hasText(beginTime) && StringUtils.hasText(endTime)) {
            queryWrapper.between(EmployeeLeaveLog::getLeaveStartTime, beginTime, endTime);
        }
        queryWrapper.orderByDesc(EmployeeLeaveLog::getLeaveStartTime);
        return list(queryWrapper);
    }

    @Override
    public int deleteLeaveLogByIds(Long[] userIds) {
        List<Long> list = Arrays.asList(userIds);
        LambdaQueryWrapper<EmployeeLeaveLog> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(EmployeeLeaveLog::getId, list);
        return baseMapper.delete(queryWrapper);
    }

    @Override
    public int agreeLeaveLog(Long[] leaveLogIds) {
        Integer count = baseMapper.agreeLeaveLog(leaveLogIds);
        return count;
    }

    @Override
    public int undoLeaveLog(Long[] leaveLogIds) {
        Integer count = baseMapper.undoLeaveLogByIds(leaveLogIds);
        return count;
    }

    @Override
    public int disagreeLeaveLog(Long[] leaveLogIds) {
        Integer count = baseMapper.disagreeLeaveLog(leaveLogIds);
        return count;
    }

    @Override
    public int insertLeaveLog(LeaveLogDto leaveLogDto) throws ParseException {

        List<String> addLeaveLogDateRange = leaveLogDto.getAddLeaveLogDateRange();

        Map<String, Object> params = leaveLogDto.getParams();
        String beginTime = addLeaveLogDateRange.get(0);
        String endTime = addLeaveLogDateRange.get(1);

        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd");
        // 将字符串转为日期
        Date beginDateTime = sdf.parse(beginTime);
        Date endDateTime = sdf.parse(endTime);

        // 获取用户id
        Long userId = SecurityUtils.getUserId();

        // 封装插入数据
        EmployeeLeaveLog employeeLeaveLog = new EmployeeLeaveLog();
        employeeLeaveLog.setLeaveStartTime(beginDateTime);
        employeeLeaveLog.setLeaveEndTime(endDateTime);
        employeeLeaveLog.setStatus(0);
        employeeLeaveLog.setLeaveReason(leaveLogDto.getReason());
//        employeeLeaveLog.setUserId(userId);
        // TODO 这里需要改变
        Long user = 106L;
        employeeLeaveLog.setUserId(user);

        // 执行插入
        int count = baseMapper.insert(employeeLeaveLog);


        return count;
    }


}




