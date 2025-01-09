package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ProdCenter;

/**
 * 产品中心数据Mapper接口
 * 
 * @author ruoyi
 * @date 2025-01-10
 */
public interface ProdCenterMapper 
{
    /**
     * 查询产品中心数据
     * 
     * @param id 产品中心数据主键
     * @return 产品中心数据
     */
    public ProdCenter selectProdCenterById(Long id);

    /**
     * 查询产品中心数据列表
     * 
     * @param prodCenter 产品中心数据
     * @return 产品中心数据集合
     */
    public List<ProdCenter> selectProdCenterList(ProdCenter prodCenter);

    /**
     * 新增产品中心数据
     * 
     * @param prodCenter 产品中心数据
     * @return 结果
     */
    public int insertProdCenter(ProdCenter prodCenter);

    /**
     * 修改产品中心数据
     * 
     * @param prodCenter 产品中心数据
     * @return 结果
     */
    public int updateProdCenter(ProdCenter prodCenter);

    /**
     * 删除产品中心数据
     * 
     * @param id 产品中心数据主键
     * @return 结果
     */
    public int deleteProdCenterById(Long id);

    /**
     * 批量删除产品中心数据
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProdCenterByIds(String[] ids);
}
