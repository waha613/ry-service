package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.ProdCenter;
import com.ruoyi.system.mapper.ProdCenterMapper;
import com.ruoyi.system.service.IProdCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ruoyi.common.core.text.Convert;

/**
 * 产品中心Service业务层处理
 * 
 * @author liuzihao
 * @date 2025-01-11
 */
@Service
public class ProdCenterServiceImpl implements IProdCenterService
{
    @Autowired
    private ProdCenterMapper prodCenterMapper;

    /**
     * 查询产品中心
     * 
     * @param id 产品中心主键
     * @return 产品中心
     */
    @Override
    public ProdCenter selectProdCenterById(Long id)
    {
        return prodCenterMapper.selectProdCenterById(id);
    }

    /**
     * 查询产品中心列表
     * 
     * @param prodCenter 产品中心
     * @return 产品中心
     */
    @Override
    public List<ProdCenter> selectProdCenterList(ProdCenter prodCenter)
    {
        return prodCenterMapper.selectProdCenterList(prodCenter);
    }

    /**
     * 新增产品中心
     * 
     * @param prodCenter 产品中心
     * @return 结果
     */
    @Override
    public int insertProdCenter(ProdCenter prodCenter)
    {
        prodCenter.setCreateTime(DateUtils.getNowDate());
        return prodCenterMapper.insertProdCenter(prodCenter);
    }

    /**
     * 修改产品中心
     * 
     * @param prodCenter 产品中心
     * @return 结果
     */
    @Override
    public int updateProdCenter(ProdCenter prodCenter)
    {
        prodCenter.setUpdateTime(DateUtils.getNowDate());
        return prodCenterMapper.updateProdCenter(prodCenter);
    }

    /**
     * 批量删除产品中心
     * 
     * @param ids 需要删除的产品中心主键
     * @return 结果
     */
    @Override
    public int deleteProdCenterByIds(String ids)
    {
        return prodCenterMapper.deleteProdCenterByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除产品中心信息
     * 
     * @param id 产品中心主键
     * @return 结果
     */
    @Override
    public int deleteProdCenterById(Long id)
    {
        return prodCenterMapper.deleteProdCenterById(id);
    }
}
