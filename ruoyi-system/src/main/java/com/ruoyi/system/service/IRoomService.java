package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Room;

/**
 * 房间管理Service接口
 * 
 * @author ruoyi
 * @date 2023-11-29
 */
public interface IRoomService 
{
    /**
     * 查询房间管理
     * 
     * @param id 房间管理主键
     * @return 房间管理
     */
    public Room selectRoomById(Long id);

    /**
     * 查询房间管理列表
     * 
     * @param room 房间管理
     * @return 房间管理集合
     */
    public List<Room> selectRoomList(Room room);

    /**
     * 新增房间管理
     * 
     * @param room 房间管理
     * @return 结果
     */
    public int insertRoom(Room room);

    /**
     * 修改房间管理
     * 
     * @param room 房间管理
     * @return 结果
     */
    public int updateRoom(Room room);

    /**
     * 批量删除房间管理
     * 
     * @param ids 需要删除的房间管理主键集合
     * @return 结果
     */
    public int deleteRoomByIds(Long[] ids);

    /**
     * 删除房间管理信息
     * 
     * @param id 房间管理主键
     * @return 结果
     */
    public int deleteRoomById(Long id);
}
