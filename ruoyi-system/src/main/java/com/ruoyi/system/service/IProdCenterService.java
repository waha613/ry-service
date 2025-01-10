package com.ruoyi.system.service;

import com.ruoyi.system.domain.ProdCenter;

import java.util.List;


/**
 * 产品中心Service接口
 * 
 * @author liuzihao
 * @date 2025-01-11
 */
public interface IProdCenterService 
{
    /**
     * 查询产品中心
     * 
     * @param id 产品中心主键
     * @return 产品中心
     */
    public ProdCenter selectProdCenterById(Long id);

    /**
     * 查询产品中心列表
     * 
     * @param prodCenter 产品中心
     * @return 产品中心集合
     */
    public List<ProdCenter> selectProdCenterList(ProdCenter prodCenter);

    /**
     * 新增产品中心
     * 
     * @param prodCenter 产品中心
     * @return 结果
     */
    public int insertProdCenter(ProdCenter prodCenter);

    /**
     * 修改产品中心
     * 
     * @param prodCenter 产品中心
     * @return 结果
     */
    public int updateProdCenter(ProdCenter prodCenter);

    /**
     * 批量删除产品中心
     * 
     * @param ids 需要删除的产品中心主键集合
     * @return 结果
     */
    public int deleteProdCenterByIds(String ids);

    /**
     * 删除产品中心信息
     * 
     * @param id 产品中心主键
     * @return 结果
     */
    public int deleteProdCenterById(Long id);
}
