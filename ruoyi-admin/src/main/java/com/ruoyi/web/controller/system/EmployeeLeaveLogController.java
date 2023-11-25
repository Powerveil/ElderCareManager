package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.EmployeeLeaveLog;
import com.ruoyi.system.domain.dto.LeaveLogDto;
import com.ruoyi.system.domain.query.UserQuery;
import com.ruoyi.system.domain.vo.EmployeeLeaveLogVo;
import com.ruoyi.system.service.EmployeeLeaveLogService;
import com.ruoyi.system.service.ISysUserService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Powerveil
 * @Date 2023/11/17 22:19
 */
@RestController
@RequestMapping("/system/leavelog")
// TODO 先都不要权限
public class EmployeeLeaveLogController extends BaseController {

    @Autowired
    private EmployeeLeaveLogService employeeLeaveLogService;

    @Autowired
    private ISysUserService userService;

    /**
     * 获取请假单列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SysUser user) {
        startPage();
        List<EmployeeLeaveLog> list = employeeLeaveLogService.selectLeaveLogList(user);
        // 封装查询条件
        UserQuery userQuery = BeanUtils.copyBean(user, UserQuery.class);
        boolean flag = userQuery.isEmpty();
        String userQueryUserName = Objects.isNull(userQuery.getUserName()) ? "" : userQuery.getUserName();
        String userQueryPhonenumber = Objects.isNull(userQuery.getPhonenumber()) ? "" : userQuery.getPhonenumber();

        List<EmployeeLeaveLogVo> result = list.stream().map(item -> {
                    EmployeeLeaveLogVo employeeLeaveLogVO = BeanUtils.copyBean(item, EmployeeLeaveLogVo.class);
                    return employeeLeaveLogVO;
                })
                // 过滤条件查询，如果没有被过滤掉就填充值
                .filter(item -> {
                    SysUser sysUser = userService.selectUserById(item.getUserId());
                    // 不能为空并要求user_type的类型是护工（“10”）
                    if (Objects.isNull(sysUser) ||
                        !sysUser.getUserType().equals(UserConstants.USER_TYPE_EM)) {
                        return false;
                    }
                    String userName = sysUser.getUserName();
                    String phonenumber = sysUser.getPhonenumber();
                    if (!flag && (!userName.contains(userQueryUserName)
                            || !phonenumber.contains(userQueryPhonenumber))) {
                        return false;
                    }
                    item.setJobId(sysUser.getJobId());
                    item.setUserName(userName);
                    item.setDept(sysUser.getDept());
                    item.setPhonenumber(phonenumber);
                    return true;
                })
                .collect(Collectors.toList());
        return getDataTable(result);
    }

        // TODO 暂时不开放删除接口
//    /**
//     * 删除请假单
//     */
//    @Log(title = "请假及登记管理", businessType = BusinessType.DELETE)
//    @DeleteMapping("/{userIds}")
//    @Transactional
//    public AjaxResult remove(@PathVariable Long[] userIds) {
//        if (ArrayUtils.contains(userIds, getUserId())) {
//            return error("当前用户不能删除");
//        }
//        return toAjax(employeeLeaveLogService.deleteLeaveLogByIds(userIds));
//    }


    /**
     * 销假
     */
    @Log(title = "请假及登记管理", businessType = BusinessType.UPDATE)
    @PutMapping("/undo/{leaveLogIds}")
    @Transactional
    public AjaxResult undoLeaveLog(@PathVariable Long[] leaveLogIds) {
        System.out.println();
        return toAjax(employeeLeaveLogService.undoLeaveLog(leaveLogIds));
    }

    /**
     * 审核请假单(同意)
     * TODO 可以创建一个接口，然后再接收一个参数，但是我想让状态由后端调整，而不是前端传入
     */
    @Log(title = "请假及登记管理", businessType = BusinessType.UPDATE)
    @PutMapping("/agree/{leaveLogIds}")
    @Transactional
    public AjaxResult agreeLeaveLog(@PathVariable Long[] leaveLogIds) {
        System.out.println();
        return toAjax(employeeLeaveLogService.agreeLeaveLog(leaveLogIds));
    }

    /**
     * 审核请假单(不同意)
     */
    @Log(title = "请假及登记管理", businessType = BusinessType.UPDATE)
    @PutMapping("/disagree/{leaveLogIds}")
    @Transactional
    public AjaxResult disagreeLeaveLog(@PathVariable Long[] leaveLogIds) {
        System.out.println();
        return toAjax(employeeLeaveLogService.disagreeLeaveLog(leaveLogIds));
    }


    /**
     * 新增用户
     */
    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody LeaveLogDto leaveLogDto) throws ParseException {
        return toAjax(employeeLeaveLogService.insertLeaveLog(leaveLogDto));
    }
}
