package com.ruoyi.approval.controller;

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
import com.ruoyi.approval.domain.RyApproval;
import com.ruoyi.approval.service.IRyApprovalService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 我的审批Controller
 * 
 * @author ruoyi
 * @date 2024-04-21
 */
@RestController
@RequestMapping("/approval/approval")
public class RyApprovalController extends BaseController
{
    @Autowired
    private IRyApprovalService ryApprovalService;

    /**
     * 查询我的审批列表
     */
    @PreAuthorize("@ss.hasPermi('approval:approval:list')")
    @GetMapping("/list")
    public TableDataInfo list(RyApproval ryApproval)
    {
        startPage();
        List<RyApproval> list = ryApprovalService.selectRyApprovalList(ryApproval);
        return getDataTable(list);
    }

    /**
     * 导出我的审批列表
     */
    @PreAuthorize("@ss.hasPermi('approval:approval:export')")
    @Log(title = "我的审批", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RyApproval ryApproval)
    {
        List<RyApproval> list = ryApprovalService.selectRyApprovalList(ryApproval);
        ExcelUtil<RyApproval> util = new ExcelUtil<RyApproval>(RyApproval.class);
        util.exportExcel(response, list, "我的审批数据");
    }

    /**
     * 获取我的审批详细信息
     */
    @PreAuthorize("@ss.hasPermi('approval:approval:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(ryApprovalService.selectRyApprovalById(id));
    }

    /**
     * 新增我的审批
     */
    @PreAuthorize("@ss.hasPermi('approval:approval:add')")
    @Log(title = "我的审批", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RyApproval ryApproval)
    {
        Long userId = getUserId();
        return toAjax(ryApprovalService.insertRyApproval(ryApproval,userId));
    }

    /**
     * 修改我的审批
     */
    @PreAuthorize("@ss.hasPermi('approval:approval:edit')")
    @Log(title = "我的审批", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RyApproval ryApproval)
    {
        return toAjax(ryApprovalService.updateRyApproval(ryApproval));
    }

    /**
     * 删除我的审批
     */
    @PreAuthorize("@ss.hasPermi('approval:approval:remove')")
    @Log(title = "我的审批", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ryApprovalService.deleteRyApprovalByIds(ids));
    }
}
