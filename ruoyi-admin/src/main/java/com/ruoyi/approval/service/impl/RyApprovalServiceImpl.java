package com.ruoyi.approval.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.needdo.domain.RyNeeddo;
import com.ruoyi.needdo.mapper.RyNeeddoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.approval.mapper.RyApprovalMapper;
import com.ruoyi.approval.domain.RyApproval;
import com.ruoyi.approval.service.IRyApprovalService;

/**
 * 我的审批Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-21
 */
@Service
public class RyApprovalServiceImpl implements IRyApprovalService 
{
    @Autowired
    private RyApprovalMapper ryApprovalMapper;
    @Autowired
    private RyNeeddoMapper ryNeeddoMapper;

    /**
     * 查询我的审批
     * 
     * @param id 我的审批主键
     * @return 我的审批
     */
    @Override
    public RyApproval selectRyApprovalById(Long id)
    {
        return ryApprovalMapper.selectRyApprovalById(id);
    }

    /**
     * 查询我的审批列表
     * 
     * @param ryApproval 我的审批
     * @return 我的审批
     */
    @Override
    public List<RyApproval> selectRyApprovalList(RyApproval ryApproval)
    {
        return ryApprovalMapper.selectRyApprovalList(ryApproval);
    }

    /**
     * 新增我的审批
     * 
     * @param ryApproval 我的审批
     * @return 结果
     */
    @Override
    public int insertRyApproval(RyApproval ryApproval,Long userId)
    {
        ryApproval.setCreateTime(DateUtils.getNowDate());
        ryApproval.setCreater(userId);
        ryApproval.setStatus(0L);
        //复制到待办数据
        RyNeeddo ryNeeddo = new RyNeeddo();
        BeanUtils.copyProperties(ryApproval,ryNeeddo);
        ryNeeddoMapper.insertRyNeeddo(ryNeeddo);

        return ryApprovalMapper.insertRyApproval(ryApproval);
    }

    /**
     * 修改我的审批
     * 
     * @param ryApproval 我的审批
     * @return 结果
     */
    @Override
    public int updateRyApproval(RyApproval ryApproval)
    {
        ryApproval.setUpdateTime(DateUtils.getNowDate());
        return ryApprovalMapper.updateRyApproval(ryApproval);
    }

    /**
     * 批量删除我的审批
     * 
     * @param ids 需要删除的我的审批主键
     * @return 结果
     */
    @Override
    public int deleteRyApprovalByIds(Long[] ids)
    {
        return ryApprovalMapper.deleteRyApprovalByIds(ids);
    }

    /**
     * 删除我的审批信息
     * 
     * @param id 我的审批主键
     * @return 结果
     */
    @Override
    public int deleteRyApprovalById(Long id)
    {
        return ryApprovalMapper.deleteRyApprovalById(id);
    }
}
