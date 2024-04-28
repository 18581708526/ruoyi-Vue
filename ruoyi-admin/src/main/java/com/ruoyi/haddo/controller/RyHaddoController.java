package com.ruoyi.haddo.controller;

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
import com.ruoyi.haddo.domain.RyHaddo;
import com.ruoyi.haddo.service.IRyHaddoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 我的已办Controller
 * 
 * @author ruoyi
 * @date 2024-04-21
 */
@RestController
@RequestMapping("/haddo/haddo")
public class RyHaddoController extends BaseController
{
    @Autowired
    private IRyHaddoService ryHaddoService;

    /**
     * 查询我的已办列表
     */
    @PreAuthorize("@ss.hasPermi('haddo:haddo:list')")
    @GetMapping("/list")
    public TableDataInfo list(RyHaddo ryHaddo)
    {
        startPage();
        List<RyHaddo> list = ryHaddoService.selectRyHaddoList(ryHaddo);
        return getDataTable(list);
    }

    /**
     * 导出我的已办列表
     */
    @PreAuthorize("@ss.hasPermi('haddo:haddo:export')")
    @Log(title = "我的已办", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RyHaddo ryHaddo)
    {
        List<RyHaddo> list = ryHaddoService.selectRyHaddoList(ryHaddo);
        ExcelUtil<RyHaddo> util = new ExcelUtil<RyHaddo>(RyHaddo.class);
        util.exportExcel(response, list, "我的已办数据");
    }

    /**
     * 获取我的已办详细信息
     */
    @PreAuthorize("@ss.hasPermi('haddo:haddo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(ryHaddoService.selectRyHaddoById(id));
    }

    /**
     * 新增我的已办
     */
    @PreAuthorize("@ss.hasPermi('haddo:haddo:add')")
    @Log(title = "我的已办", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RyHaddo ryHaddo)
    {
        return toAjax(ryHaddoService.insertRyHaddo(ryHaddo));
    }

    /**
     * 修改我的已办
     */
    @PreAuthorize("@ss.hasPermi('haddo:haddo:edit')")
    @Log(title = "我的已办", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RyHaddo ryHaddo)
    {
        return toAjax(ryHaddoService.updateRyHaddo(ryHaddo));
    }

    /**
     * 删除我的已办
     */
    @PreAuthorize("@ss.hasPermi('haddo:haddo:remove')")
    @Log(title = "我的已办", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ryHaddoService.deleteRyHaddoByIds(ids));
    }
}
