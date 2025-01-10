package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FeeServiceMapper;
import com.ruoyi.system.domain.FeeService;
import com.ruoyi.system.service.IFeeServiceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 缴费服务Service业务层处理
 * 
 * @author liuzihao
 * @date 2025-01-11
 */
@Service
public class FeeServiceServiceImpl implements IFeeServiceService 
{
    @Autowired
    private FeeServiceMapper feeServiceMapper;

    /**
     * 查询缴费服务
     * 
     * @param id 缴费服务主键
     * @return 缴费服务
     */
    @Override
    public FeeService selectFeeServiceById(Long id)
    {
        return feeServiceMapper.selectFeeServiceById(id);
    }

    /**
     * 查询缴费服务列表
     * 
     * @param feeService 缴费服务
     * @return 缴费服务
     */
    @Override
    public List<FeeService> selectFeeServiceList(FeeService feeService)
    {
        return feeServiceMapper.selectFeeServiceList(feeService);
    }

    /**
     * 新增缴费服务
     * 
     * @param feeService 缴费服务
     * @return 结果
     */
    @Override
    public int insertFeeService(FeeService feeService)
    {
        feeService.setCreateTime(DateUtils.getNowDate());
        return feeServiceMapper.insertFeeService(feeService);
    }

    /**
     * 修改缴费服务
     * 
     * @param feeService 缴费服务
     * @return 结果
     */
    @Override
    public int updateFeeService(FeeService feeService)
    {
        feeService.setUpdateTime(DateUtils.getNowDate());
        return feeServiceMapper.updateFeeService(feeService);
    }

    /**
     * 批量删除缴费服务
     * 
     * @param ids 需要删除的缴费服务主键
     * @return 结果
     */
    @Override
    public int deleteFeeServiceByIds(String ids)
    {
        return feeServiceMapper.deleteFeeServiceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除缴费服务信息
     * 
     * @param id 缴费服务主键
     * @return 结果
     */
    @Override
    public int deleteFeeServiceById(Long id)
    {
        return feeServiceMapper.deleteFeeServiceById(id);
    }
}
