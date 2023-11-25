package com.ruoyi.web.controller.system;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.AllocationVo;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Allocation;
import com.ruoyi.system.service.IAllocationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 护工分配Controller
 * 
 * @author Powerveil
 * @date 2023-11-22
 */
@RestController
@RequestMapping("/system/allocation")
public class AllocationController extends BaseController
{
    @Autowired
    private IAllocationService allocationService;

    @Autowired
    private ISysUserService userService;

    /**
     * 查询护工分配列表
     */
    @PreAuthorize("@ss.hasPermi('system:allocation:list')")
    @GetMapping("/list")
    public TableDataInfo list(Allocation allocation)
    {
        startPage();
        List<Allocation> list = allocationService.selectAllocationList(allocation);
        // 返回特定数据（Vo包含姓名、电话号）
        List<AllocationVo> allocationVoList =
                BeanUtils.copyBeanList(list, AllocationVo.class);


        Collections.sort(allocationVoList, new Comparator<AllocationVo>() {
            @Override
            public int compare(AllocationVo o1, AllocationVo o2) {
                int compare = o1.getSupportWorkerId().compareTo(o2.getSupportWorkerId());
                if (compare != 0) {
                    return compare;
                }
                return o1.getElderId().compareTo(o2.getElderId());
            }
        });

        allocationVoList.forEach(item -> {
            // 护工id
            Long supportWorkerId = item.getSupportWorkerId();
            // 查询护工信息
            SysUser supportWorkerUser = userService.selectUserById(supportWorkerId);
            // 添加护工信息
            item.setSupportWorkerName(supportWorkerUser.getUserName());
            item.setSupportWorkerPhonenumber(supportWorkerUser.getPhonenumber());

            // 老人id
            Long elderId = item.getElderId();
            // 查询老人信息
            SysUser elderUser = userService.selectUserById(elderId);
            // 添加老人信息
            item.setElderName(elderUser.getUserName());
            item.setElderPhonenumber(elderUser.getPhonenumber());
        });

        return getDataTable(allocationVoList);
    }

    /**
     * 导出护工分配列表
     */
    @PreAuthorize("@ss.hasPermi('system:allocation:export')")
    @Log(title = "护工分配", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Allocation allocation)
    {
        List<Allocation> list = allocationService.selectAllocationList(allocation);
        ExcelUtil<Allocation> util = new ExcelUtil<Allocation>(Allocation.class);
        util.exportExcel(response, list, "护工分配数据");
    }

    /**
     * 获取护工分配详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:allocation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(allocationService.selectAllocationById(id));
    }

    /**
     * 新增护工分配
     */
    @PreAuthorize("@ss.hasPermi('system:allocation:add')")
    @Log(title = "护工分配", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Allocation allocation)
    {
        return toAjax(allocationService.insertAllocation(allocation));
    }

    /**
     * 修改护工分配
     */
    @PreAuthorize("@ss.hasPermi('system:allocation:edit')")
    @Log(title = "护工分配", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Allocation allocation)
    {
        return toAjax(allocationService.updateAllocation(allocation));
    }

    /**
     * 删除护工分配
     */
    @PreAuthorize("@ss.hasPermi('system:allocation:remove')")
    @Log(title = "护工分配", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(allocationService.deleteAllocationByIds(ids));
    }


    /**
     * 查询老人被分配人数
     */
    @GetMapping("/count")
    public Integer count()
    {
        Integer allocationCount = allocationService.count();
        Integer totalCount = userService.count();
        return totalCount - allocationCount;//getAllocationCount
    }
}
