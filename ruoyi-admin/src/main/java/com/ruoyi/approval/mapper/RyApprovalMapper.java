package com.ruoyi.approval.mapper;

import java.util.List;
import com.ruoyi.approval.domain.RyApproval;

/**
 * 我的审批Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-21
 */
public interface RyApprovalMapper 
{
    /**
     * 查询我的审批
     * 
     * @param id 我的审批主键
     * @return 我的审批
     */
    public RyApproval selectRyApprovalById(Long id);

    /**
     * 查询我的审批列表
     * 
     * @param ryApproval 我的审批
     * @return 我的审批集合
     */
    public List<RyApproval> selectRyApprovalList(RyApproval ryApproval);

    /**
     * 新增我的审批
     * 
     * @param ryApproval 我的审批
     * @return 结果
     */
    public int insertRyApproval(RyApproval ryApproval);

    /**
     * 修改我的审批
     * 
     * @param ryApproval 我的审批
     * @return 结果
     */
    public int updateRyApproval(RyApproval ryApproval);

    /**
     * 删除我的审批
     * 
     * @param id 我的审批主键
     * @return 结果
     */
    public int deleteRyApprovalById(Long id);

    /**
     * 批量删除我的审批
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRyApprovalByIds(Long[] ids);
}
