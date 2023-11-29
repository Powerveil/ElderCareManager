package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.system.domain.Room;
import com.ruoyi.system.service.IRoomService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 房间管理Controller
 * 
 * @author ruoyi
 * @date 2023-11-29
 */
@RestController
@RequestMapping("/system/room")
public class RoomController extends BaseController
{
    @Autowired
    private IRoomService roomService;

    /**
     * 查询房间管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:room:list')")
    @GetMapping("/list")
    public TableDataInfo list(Room room)
    {
        startPage();
        List<Room> list = roomService.selectRoomList(room);
        return getDataTable(list);
    }

    /**
     * 导出房间管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:room:export')")
    @Log(title = "房间管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Room room)
    {
        List<Room> list = roomService.selectRoomList(room);
        ExcelUtil<Room> util = new ExcelUtil<Room>(Room.class);
        util.exportExcel(response, list, "房间管理数据");
    }

    /**
     * 获取房间管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:room:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(roomService.selectRoomById(id));
    }

    /**
     * 新增房间管理
     */
    @PreAuthorize("@ss.hasPermi('system:room:add')")
    @Log(title = "房间管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Room room)
    {
        return toAjax(roomService.insertRoom(room));
    }

    /**
     * 修改房间管理
     */
    @PreAuthorize("@ss.hasPermi('system:room:edit')")
    @Log(title = "房间管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Room room)
    {
        return toAjax(roomService.updateRoom(room));
    }

    /**
     * 删除房间管理
     */
    @PreAuthorize("@ss.hasPermi('system:room:remove')")
    @Log(title = "房间管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(roomService.deleteRoomByIds(ids));
    }
}
