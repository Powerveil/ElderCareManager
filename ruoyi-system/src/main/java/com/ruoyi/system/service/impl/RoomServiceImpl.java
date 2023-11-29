package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.RoomMapper;
import com.ruoyi.system.domain.Room;
import com.ruoyi.system.service.IRoomService;

/**
 * 房间管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-11-29
 */
@Service
public class RoomServiceImpl implements IRoomService 
{
    @Autowired
    private RoomMapper roomMapper;

    /**
     * 查询房间管理
     * 
     * @param id 房间管理主键
     * @return 房间管理
     */
    @Override
    public Room selectRoomById(Long id)
    {
        return roomMapper.selectRoomById(id);
    }

    /**
     * 查询房间管理列表
     * 
     * @param room 房间管理
     * @return 房间管理
     */
    @Override
    public List<Room> selectRoomList(Room room)
    {
        return roomMapper.selectRoomList(room);
    }

    /**
     * 新增房间管理
     * 
     * @param room 房间管理
     * @return 结果
     */
    @Override
    public int insertRoom(Room room)
    {
        room.setNowCount(0);
        return roomMapper.insertRoom(room);
    }

    /**
     * 修改房间管理
     * 
     * @param room 房间管理
     * @return 结果
     */
    @Override
    public int updateRoom(Room room)
    {
        return roomMapper.updateRoom(room);
    }

    /**
     * 批量删除房间管理
     * 
     * @param ids 需要删除的房间管理主键
     * @return 结果
     */
    @Override
    public int deleteRoomByIds(Long[] ids)
    {
        return roomMapper.deleteRoomByIds(ids);
    }

    /**
     * 删除房间管理信息
     * 
     * @param id 房间管理主键
     * @return 结果
     */
    @Override
    public int deleteRoomById(Long id)
    {
        return roomMapper.deleteRoomById(id);
    }
}
