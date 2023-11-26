package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Allocation;
import org.apache.ibatis.annotations.Param;

/**
 * 护工分配Mapper接口
 * 
 * @author Powerveil
 * @date 2023-11-22
 */
public interface AllocationMapper 
{
    /**
     * 查询护工分配
     * 
     * @param id 护工分配主键
     * @return 护工分配
     */
    public Allocation selectAllocationById(Long id);

    /**
     * 查询护工分配列表
     * 
     * @param allocation 护工分配
     * @return 护工分配集合
     */
    public List<Allocation> selectAllocationList(Allocation allocation);

    /**
     * 新增护工分配
     * 
     * @param allocation 护工分配
     * @return 结果
     */
    public int insertAllocation(Allocation allocation);

    /**
     * 修改护工分配
     * 
     * @param allocation 护工分配
     * @return 结果
     */
    public int updateAllocation(Allocation allocation);

    /**
     * 删除护工分配
     * 
     * @param id 护工分配主键
     * @return 结果
     */
    public int deleteAllocationById(Long id);

    /**
     * 批量删除护工分配
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAllocationByIds(Long[] ids);

    /**
     * 查询老人被分配人数
     */
    Integer count();

    /**
     *
     * @param supportWorkerId 护工id
     * @param elderIdListSub 老人idList
     * @return
     */
    int insertAllocationBatch01(@Param("supportWorkerId") Long supportWorkerId,
                                @Param("elderIdListSub") List<Long> elderIdListSub);
}
