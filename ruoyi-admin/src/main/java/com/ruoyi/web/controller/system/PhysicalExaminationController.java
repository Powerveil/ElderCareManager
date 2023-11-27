package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.vo.PhysicalExaminationVo;
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
import com.ruoyi.system.domain.PhysicalExamination;
import com.ruoyi.system.service.IPhysicalExaminationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 体检管理Controller
 * 
 * @author ruoyi
 * @date 2023-11-27
 */
@RestController
@RequestMapping("/system/examination")
public class PhysicalExaminationController extends BaseController
{
    @Autowired
    private IPhysicalExaminationService physicalExaminationService;

    @Autowired
    private ISysUserService userService;

    /**
     * 查询体检管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:examination:list')")
    @GetMapping("/list")
    public TableDataInfo list(PhysicalExamination physicalExamination)
    {
        startPage();
        List<PhysicalExamination> list = physicalExaminationService.selectPhysicalExaminationList(physicalExamination);

        List<PhysicalExaminationVo> physicalExaminationVos = BeanUtils.copyBeanList(list, PhysicalExaminationVo.class);

        physicalExaminationVos.forEach(item -> {

            // 受检人id
            Long examineeId = item.getExamineeId();
            SysUser examinee = userService.selectUserById(examineeId);
            // 医生姓名
            Long doctorId = item.getDoctorId();
            SysUser doctor = userService.selectUserById(doctorId);

            item.setExamineeName(examinee.getUserName());
            item.setDoctorName(doctor.getUserName());
        });
        return getDataTable(physicalExaminationVos);
    }

    /**
     * 导出体检管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:examination:export')")
    @Log(title = "体检管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PhysicalExamination physicalExamination)
    {
        List<PhysicalExamination> list = physicalExaminationService.selectPhysicalExaminationList(physicalExamination);
        ExcelUtil<PhysicalExamination> util = new ExcelUtil<PhysicalExamination>(PhysicalExamination.class);
        util.exportExcel(response, list, "体检管理数据");
    }

    /**
     * 获取体检管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:examination:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(physicalExaminationService.selectPhysicalExaminationById(id));
    }

    /**
     * 新增体检管理
     */
    @PreAuthorize("@ss.hasPermi('system:examination:add')")
    @Log(title = "体检管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PhysicalExamination physicalExamination)
    {
        return toAjax(physicalExaminationService.insertPhysicalExamination(physicalExamination));
    }

    /**
     * 修改体检管理
     */
    @PreAuthorize("@ss.hasPermi('system:examination:edit')")
    @Log(title = "体检管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PhysicalExamination physicalExamination)
    {
        return toAjax(physicalExaminationService.updatePhysicalExamination(physicalExamination));
    }


    /**
     * 修改体检管理
     */
    @PreAuthorize("@ss.hasPermi('system:examination:edit')")
    @Log(title = "体检管理", businessType = BusinessType.UPDATE)
    @PutMapping("/result")
    public AjaxResult writeResult(@RequestBody PhysicalExamination physicalExamination)
    {

        PhysicalExamination physicalExamination1 = new PhysicalExamination();
        physicalExamination1.setId(physicalExamination.getId());
        physicalExamination1.setExaminationResult(physicalExamination.getExaminationResult());
        return toAjax(physicalExaminationService.updatePhysicalExamination(physicalExamination1));
    }

    /**
     * 删除体检管理
     */
    @PreAuthorize("@ss.hasPermi('system:examination:remove')")
    @Log(title = "体检管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(physicalExaminationService.deletePhysicalExaminationByIds(ids));
    }
}
