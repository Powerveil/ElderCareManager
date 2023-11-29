package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Order;

/**
 * 支付管理Mapper接口
 * 
 * @author ruoyi
 * @date 2023-11-28
 */
public interface OrderMapper 
{
    /**
     * 查询支付管理
     * 
     * @param id 支付管理主键
     * @return 支付管理
     */
    public Order selectOrderById(Long id);

    /**
     * 查询支付管理列表
     * 
     * @param order 支付管理
     * @return 支付管理集合
     */
    public List<Order> selectOrderList(Order order);

    /**
     * 新增支付管理
     * 
     * @param order 支付管理
     * @return 结果
     */
    public int insertOrder(Order order);

    /**
     * 修改支付管理
     * 
     * @param order 支付管理
     * @return 结果
     */
    public int updateOrder(Order order);

    /**
     * 删除支付管理
     * 
     * @param id 支付管理主键
     * @return 结果
     */
    public int deleteOrderById(Long id);

    /**
     * 批量删除支付管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOrderByIds(Long[] ids);
}
