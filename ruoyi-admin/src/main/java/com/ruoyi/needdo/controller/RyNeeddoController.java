package com.ruoyi.needdo.controller;

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
import com.ruoyi.needdo.domain.RyNeeddo;
import com.ruoyi.needdo.service.IRyNeeddoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 我的待办Controller
 * 
 * @author ruoyi
 * @date 2024-04-21
 */
@RestController
@RequestMapping("/needdo/needdo")
public class RyNeeddoController extends BaseController
{
    @Autowired
    private IRyNeeddoService ryNeeddoService;

    /**
     * 查询我的待办列表
     */
    @PreAuthorize("@ss.hasPermi('needdo:needdo:list')")
    @GetMapping("/list")
    public TableDataInfo list(RyNeeddo ryNeeddo)
    {
        startPage();
        String username = getUsername();
        List<RyNeeddo> list = ryNeeddoService.selectRyNeeddoList(ryNeeddo,username);
        return getDataTable(list);
    }

    /**
     * 导出我的待办列表
     */
    @PreAuthorize("@ss.hasPermi('needdo:needdo:export')")
    @Log(title = "我的待办", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RyNeeddo ryNeeddo)
    {
        String username = getUsername();
        List<RyNeeddo> list = ryNeeddoService.selectRyNeeddoList(ryNeeddo,username);
        ExcelUtil<RyNeeddo> util = new ExcelUtil<RyNeeddo>(RyNeeddo.class);
        util.exportExcel(response, list, "我的待办数据");
    }

    /**
     * 获取我的待办详细信息
     */
    @PreAuthorize("@ss.hasPermi('needdo:needdo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(ryNeeddoService.selectRyNeeddoById(id));
    }

    /**
     * 新增我的待办
     */
    @PreAuthorize("@ss.hasPermi('needdo:needdo:add')")
    @Log(title = "我的待办", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RyNeeddo ryNeeddo)
    {
        return toAjax(ryNeeddoService.insertRyNeeddo(ryNeeddo));
    }

    /**
     * 修改我的待办
     */
    @PreAuthorize("@ss.hasPermi('needdo:needdo:edit')")
    @Log(title = "我的待办", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RyNeeddo ryNeeddo)
    {
        return toAjax(ryNeeddoService.updateRyNeeddo(ryNeeddo));
    }

    /**
     * 删除我的待办
     */
    @PreAuthorize("@ss.hasPermi('needdo:needdo:remove')")
    @Log(title = "我的待办", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ryNeeddoService.deleteRyNeeddoByIds(ids));
    }
}
