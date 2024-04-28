package com.ruoyi.haddo.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.haddo.mapper.RyHaddoMapper;
import com.ruoyi.haddo.domain.RyHaddo;
import com.ruoyi.haddo.service.IRyHaddoService;

/**
 * 我的已办Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-21
 */
@Service
public class RyHaddoServiceImpl implements IRyHaddoService 
{
    @Autowired
    private RyHaddoMapper ryHaddoMapper;

    /**
     * 查询我的已办
     * 
     * @param id 我的已办主键
     * @return 我的已办
     */
    @Override
    public RyHaddo selectRyHaddoById(Long id)
    {
        return ryHaddoMapper.selectRyHaddoById(id);
    }

    /**
     * 查询我的已办列表
     * 
     * @param ryHaddo 我的已办
     * @return 我的已办
     */
    @Override
    public List<RyHaddo> selectRyHaddoList(RyHaddo ryHaddo)
    {
        return ryHaddoMapper.selectRyHaddoList(ryHaddo);
    }

    /**
     * 新增我的已办
     * 
     * @param ryHaddo 我的已办
     * @return 结果
     */
    @Override
    public int insertRyHaddo(RyHaddo ryHaddo)
    {
        ryHaddo.setCreateTime(DateUtils.getNowDate());
        return ryHaddoMapper.insertRyHaddo(ryHaddo);
    }

    /**
     * 修改我的已办
     * 
     * @param ryHaddo 我的已办
     * @return 结果
     */
    @Override
    public int updateRyHaddo(RyHaddo ryHaddo)
    {
        ryHaddo.setUpdateTime(DateUtils.getNowDate());
        return ryHaddoMapper.updateRyHaddo(ryHaddo);
    }

    /**
     * 批量删除我的已办
     * 
     * @param ids 需要删除的我的已办主键
     * @return 结果
     */
    @Override
    public int deleteRyHaddoByIds(Long[] ids)
    {
        return ryHaddoMapper.deleteRyHaddoByIds(ids);
    }

    /**
     * 删除我的已办信息
     * 
     * @param id 我的已办主键
     * @return 结果
     */
    @Override
    public int deleteRyHaddoById(Long id)
    {
        return ryHaddoMapper.deleteRyHaddoById(id);
    }
}
