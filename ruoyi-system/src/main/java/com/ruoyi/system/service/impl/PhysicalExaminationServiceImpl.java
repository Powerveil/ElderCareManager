package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PhysicalExaminationMapper;
import com.ruoyi.system.domain.PhysicalExamination;
import com.ruoyi.system.service.IPhysicalExaminationService;

/**
 * 体检管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-11-27
 */
@Service
public class PhysicalExaminationServiceImpl implements IPhysicalExaminationService 
{
    @Autowired
    private PhysicalExaminationMapper physicalExaminationMapper;

    /**
     * 查询体检管理
     * 
     * @param id 体检管理主键
     * @return 体检管理
     */
    @Override
    public PhysicalExamination selectPhysicalExaminationById(Long id)
    {
        return physicalExaminationMapper.selectPhysicalExaminationById(id);
    }

    /**
     * 查询体检管理列表
     * 
     * @param physicalExamination 体检管理
     * @return 体检管理
     */
    @Override
    public List<PhysicalExamination> selectPhysicalExaminationList(PhysicalExamination physicalExamination)
    {
        return physicalExaminationMapper.selectPhysicalExaminationList(physicalExamination);
    }

    /**
     * 新增体检管理
     * 
     * @param physicalExamination 体检管理
     * @return 结果
     */
    @Override
    public int insertPhysicalExamination(PhysicalExamination physicalExamination)
    {
        physicalExamination.setCreateTime(DateUtils.getNowDate());
        return physicalExaminationMapper.insertPhysicalExamination(physicalExamination);
    }

    /**
     * 修改体检管理
     * 
     * @param physicalExamination 体检管理
     * @return 结果
     */
    @Override
    public int updatePhysicalExamination(PhysicalExamination physicalExamination)
    {
        physicalExamination.setUpdateTime(DateUtils.getNowDate());
        return physicalExaminationMapper.updatePhysicalExamination(physicalExamination);
    }

    /**
     * 批量删除体检管理
     * 
     * @param ids 需要删除的体检管理主键
     * @return 结果
     */
    @Override
    public int deletePhysicalExaminationByIds(Long[] ids)
    {
        return physicalExaminationMapper.deletePhysicalExaminationByIds(ids);
    }

    /**
     * 删除体检管理信息
     * 
     * @param id 体检管理主键
     * @return 结果
     */
    @Override
    public int deletePhysicalExaminationById(Long id)
    {
        return physicalExaminationMapper.deletePhysicalExaminationById(id);
    }
}
