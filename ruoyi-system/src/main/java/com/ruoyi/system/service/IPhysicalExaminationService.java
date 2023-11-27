package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.PhysicalExamination;

/**
 * 体检管理Service接口
 * 
 * @author ruoyi
 * @date 2023-11-27
 */
public interface IPhysicalExaminationService 
{
    /**
     * 查询体检管理
     * 
     * @param id 体检管理主键
     * @return 体检管理
     */
    public PhysicalExamination selectPhysicalExaminationById(Long id);

    /**
     * 查询体检管理列表
     * 
     * @param physicalExamination 体检管理
     * @return 体检管理集合
     */
    public List<PhysicalExamination> selectPhysicalExaminationList(PhysicalExamination physicalExamination);

    /**
     * 新增体检管理
     * 
     * @param physicalExamination 体检管理
     * @return 结果
     */
    public int insertPhysicalExamination(PhysicalExamination physicalExamination);

    /**
     * 修改体检管理
     * 
     * @param physicalExamination 体检管理
     * @return 结果
     */
    public int updatePhysicalExamination(PhysicalExamination physicalExamination);

    /**
     * 批量删除体检管理
     * 
     * @param ids 需要删除的体检管理主键集合
     * @return 结果
     */
    public int deletePhysicalExaminationByIds(Long[] ids);

    /**
     * 删除体检管理信息
     * 
     * @param id 体检管理主键
     * @return 结果
     */
    public int deletePhysicalExaminationById(Long id);
}
