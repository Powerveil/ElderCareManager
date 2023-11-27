package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.SecurityUtils;
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
import com.ruoyi.system.domain.Evaluate;
import com.ruoyi.system.service.IEvaluateService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 评价管理Controller
 * 
 * @author ruoyi
 * @date 2023-11-26
 */
@RestController
@RequestMapping("/system/evaluate")
public class EvaluateController extends BaseController
{
    @Autowired
    private IEvaluateService evaluateService;

    /**
     * 查询评价管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:evaluate:list')")
    @GetMapping("/list")
    public TableDataInfo list(Evaluate evaluate)
    {
        startPage();
        List<Evaluate> list = evaluateService.selectEvaluateList(evaluate);
        return getDataTable(list);
    }

    /**
     * 导出评价管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:evaluate:export')")
    @Log(title = "评价管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Evaluate evaluate)
    {
        List<Evaluate> list = evaluateService.selectEvaluateList(evaluate);
        ExcelUtil<Evaluate> util = new ExcelUtil<Evaluate>(Evaluate.class);
        util.exportExcel(response, list, "评价管理数据");
    }

    /**
     * 获取评价管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:evaluate:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(evaluateService.selectEvaluateById(id));
    }

    /**
     * 新增评价管理
     */
    @PreAuthorize("@ss.hasPermi('system:evaluate:add')")
    @Log(title = "评价管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Evaluate evaluate)
    {
        return toAjax(evaluateService.insertEvaluate(evaluate));
    }

    /**
     * 修改评价管理
     */
    @PreAuthorize("@ss.hasPermi('system:evaluate:edit')")
    @Log(title = "评价管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Evaluate evaluate)
    {
        return toAjax(evaluateService.updateEvaluate(evaluate));
    }

    /**
     * 修改评价管理
     */
    @PreAuthorize("@ss.hasPermi('system:evaluate:edit')")
    @Log(title = "评价管理", businessType = BusinessType.UPDATE)
    @PutMapping("/updateResult")
    public AjaxResult edit2(@RequestBody Evaluate evaluate)
    {
        Evaluate evaluate1 = new Evaluate();
        evaluate1.setId(evaluate.getId());
        evaluate1.setResult(evaluate.getResult());
        return toAjax(evaluateService.updateEvaluate(evaluate));
    }

    /**
     * 删除评价管理
     */
    @PreAuthorize("@ss.hasPermi('system:evaluate:remove')")
    @Log(title = "评价管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(evaluateService.deleteEvaluateByIds(ids));
    }
}
