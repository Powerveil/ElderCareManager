package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AllocationMapper;
import com.ruoyi.system.domain.Allocation;
import com.ruoyi.system.service.IAllocationService;

/**
 * 护工分配Service业务层处理
 * 
 * @author Powerveil
 * @date 2023-11-22
 */
@Service
public class AllocationServiceImpl implements IAllocationService 
{
    @Autowired
    private AllocationMapper allocationMapper;


    /**
     * 查询护工分配
     * 
     * @param id 护工分配主键
     * @return 护工分配
     */
    @Override
    public Allocation selectAllocationById(Long id)
    {
        return allocationMapper.selectAllocationById(id);
    }

    /**
     * 查询护工分配列表
     * 
     * @param allocation 护工分配
     * @return 护工分配
     */
    @Override
    public List<Allocation> selectAllocationList(Allocation allocation)
    {
        return allocationMapper.selectAllocationList(allocation);
    }

    /**
     * 新增护工分配
     * 
     * @param allocation 护工分配
     * @return 结果
     */
    @Override
    public int insertAllocation(Allocation allocation)
    {
        allocation.setCreateTime(DateUtils.getNowDate());
        return allocationMapper.insertAllocation(allocation);
    }

    /**
     * 修改护工分配
     * 
     * @param allocation 护工分配
     * @return 结果
     */
    @Override
    public int updateAllocation(Allocation allocation)
    {
        allocation.setUpdateTime(DateUtils.getNowDate());
        return allocationMapper.updateAllocation(allocation);
    }

    /**
     * 批量删除护工分配
     * 
     * @param ids 需要删除的护工分配主键
     * @return 结果
     */
    @Override
    public int deleteAllocationByIds(Long[] ids)
    {
        return allocationMapper.deleteAllocationByIds(ids);
    }

    /**
     * 删除护工分配信息
     * 
     * @param id 护工分配主键
     * @return 结果
     */
    @Override
    public int deleteAllocationById(Long id)
    {
        return allocationMapper.deleteAllocationById(id);
    }

    /**
     * 查询老人被分配人数
     */
    @Override
    public Integer count() {
        return allocationMapper.count();
    }

    /**
     *
     * @param supportWorkerId 护工id
     * @param elderIdListSub 老人idList
     * @return
     */
    @Override
    public int insertAllocationBatch01(Long supportWorkerId, List<Long> elderIdListSub) {
        return allocationMapper.insertAllocationBatch01(supportWorkerId, elderIdListSub);
    }
}
