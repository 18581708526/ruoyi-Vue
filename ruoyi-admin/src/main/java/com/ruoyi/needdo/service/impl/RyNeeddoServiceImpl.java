package com.ruoyi.needdo.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.needdo.mapper.RyNeeddoMapper;
import com.ruoyi.needdo.domain.RyNeeddo;
import com.ruoyi.needdo.service.IRyNeeddoService;

/**
 * 我的待办Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-21
 */
@Service
public class RyNeeddoServiceImpl implements IRyNeeddoService 
{
    @Autowired
    private RyNeeddoMapper ryNeeddoMapper;

    /**
     * 查询我的待办
     * 
     * @param id 我的待办主键
     * @return 我的待办
     */
    @Override
    public RyNeeddo selectRyNeeddoById(Long id)
    {
        return ryNeeddoMapper.selectRyNeeddoById(id);
    }

    /**
     * 查询我的待办列表
     * 
     * @param ryNeeddo 我的待办
     * @return 我的待办
     */
    @Override
    public List<RyNeeddo> selectRyNeeddoList(RyNeeddo ryNeeddo,String username)
    {
        ryNeeddo.setTargetUsername(username);
        return ryNeeddoMapper.selectRyNeeddoList(ryNeeddo);
    }

    /**
     * 新增我的待办
     * 
     * @param ryNeeddo 我的待办
     * @return 结果
     */
    @Override
    public int insertRyNeeddo(RyNeeddo ryNeeddo)
    {
        ryNeeddo.setCreateTime(DateUtils.getNowDate());
        return ryNeeddoMapper.insertRyNeeddo(ryNeeddo);
    }

    /**
     * 修改我的待办
     * 
     * @param ryNeeddo 我的待办
     * @return 结果
     */
    @Override
    public int updateRyNeeddo(RyNeeddo ryNeeddo)
    {
        ryNeeddo.setUpdateTime(DateUtils.getNowDate());
        return ryNeeddoMapper.updateRyNeeddo(ryNeeddo);
    }

    /**
     * 批量删除我的待办
     * 
     * @param ids 需要删除的我的待办主键
     * @return 结果
     */
    @Override
    public int deleteRyNeeddoByIds(Long[] ids)
    {
        return ryNeeddoMapper.deleteRyNeeddoByIds(ids);
    }

    /**
     * 删除我的待办信息
     * 
     * @param id 我的待办主键
     * @return 结果
     */
    @Override
    public int deleteRyNeeddoById(Long id)
    {
        return ryNeeddoMapper.deleteRyNeeddoById(id);
    }
}
