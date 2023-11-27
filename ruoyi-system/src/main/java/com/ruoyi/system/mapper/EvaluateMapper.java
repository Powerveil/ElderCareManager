package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Evaluate;
import org.apache.ibatis.annotations.Mapper;

/**
 * 评价管理Mapper接口
 * 
 * @author ruoyi
 * @date 2023-11-26
 */
@Mapper
public interface EvaluateMapper 
{
    /**
     * 查询评价管理
     * 
     * @param id 评价管理主键
     * @return 评价管理
     */
    public Evaluate selectEvaluateById(Long id);

    /**
     * 查询评价管理列表
     * 
     * @param evaluate 评价管理
     * @return 评价管理集合
     */
    public List<Evaluate> selectEvaluateList(Evaluate evaluate);

    /**
     * 新增评价管理
     * 
     * @param evaluate 评价管理
     * @return 结果
     */
    public int insertEvaluate(Evaluate evaluate);

    /**
     * 修改评价管理
     * 
     * @param evaluate 评价管理
     * @return 结果
     */
    public int updateEvaluate(Evaluate evaluate);

    /**
     * 删除评价管理
     * 
     * @param id 评价管理主键
     * @return 结果
     */
    public int deleteEvaluateById(Long id);

    /**
     * 批量删除评价管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEvaluateByIds(Long[] ids);
}
