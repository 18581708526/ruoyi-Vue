package com.ruoyi.needdo.mapper;

import java.util.List;
import com.ruoyi.needdo.domain.RyNeeddo;

/**
 * 我的待办Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-21
 */
public interface RyNeeddoMapper 
{
    /**
     * 查询我的待办
     * 
     * @param id 我的待办主键
     * @return 我的待办
     */
    public RyNeeddo selectRyNeeddoById(Long id);

    /**
     * 查询我的待办列表
     * 
     * @param ryNeeddo 我的待办
     * @return 我的待办集合
     */
    public List<RyNeeddo> selectRyNeeddoList(RyNeeddo ryNeeddo );

    /**
     * 新增我的待办
     * 
     * @param ryNeeddo 我的待办
     * @return 结果
     */
    public int insertRyNeeddo(RyNeeddo ryNeeddo);

    /**
     * 修改我的待办
     * 
     * @param ryNeeddo 我的待办
     * @return 结果
     */
    public int updateRyNeeddo(RyNeeddo ryNeeddo);

    /**
     * 删除我的待办
     * 
     * @param id 我的待办主键
     * @return 结果
     */
    public int deleteRyNeeddoById(Long id);

    /**
     * 批量删除我的待办
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRyNeeddoByIds(Long[] ids);
}
