package com.ruoyi.haddo.service;

import java.util.List;
import com.ruoyi.haddo.domain.RyHaddo;

/**
 * 我的已办Service接口
 * 
 * @author ruoyi
 * @date 2024-04-21
 */
public interface IRyHaddoService 
{
    /**
     * 查询我的已办
     * 
     * @param id 我的已办主键
     * @return 我的已办
     */
    public RyHaddo selectRyHaddoById(Long id);

    /**
     * 查询我的已办列表
     * 
     * @param ryHaddo 我的已办
     * @return 我的已办集合
     */
    public List<RyHaddo> selectRyHaddoList(RyHaddo ryHaddo);

    /**
     * 新增我的已办
     * 
     * @param ryHaddo 我的已办
     * @return 结果
     */
    public int insertRyHaddo(RyHaddo ryHaddo);

    /**
     * 修改我的已办
     * 
     * @param ryHaddo 我的已办
     * @return 结果
     */
    public int updateRyHaddo(RyHaddo ryHaddo);

    /**
     * 批量删除我的已办
     * 
     * @param ids 需要删除的我的已办主键集合
     * @return 结果
     */
    public int deleteRyHaddoByIds(Long[] ids);

    /**
     * 删除我的已办信息
     * 
     * @param id 我的已办主键
     * @return 结果
     */
    public int deleteRyHaddoById(Long id);
}
