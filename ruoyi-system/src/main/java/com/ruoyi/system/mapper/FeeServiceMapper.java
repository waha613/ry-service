package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.FeeService;

/**
 * 缴费服务Mapper接口
 * 
 * @author liuzihao
 * @date 2025-01-11
 */
public interface FeeServiceMapper 
{
    /**
     * 查询缴费服务
     * 
     * @param id 缴费服务主键
     * @return 缴费服务
     */
    public FeeService selectFeeServiceById(Long id);

    /**
     * 查询缴费服务列表
     * 
     * @param feeService 缴费服务
     * @return 缴费服务集合
     */
    public List<FeeService> selectFeeServiceList(FeeService feeService);

    /**
     * 新增缴费服务
     * 
     * @param feeService 缴费服务
     * @return 结果
     */
    public int insertFeeService(FeeService feeService);

    /**
     * 修改缴费服务
     * 
     * @param feeService 缴费服务
     * @return 结果
     */
    public int updateFeeService(FeeService feeService);

    /**
     * 删除缴费服务
     * 
     * @param id 缴费服务主键
     * @return 结果
     */
    public int deleteFeeServiceById(Long id);

    /**
     * 批量删除缴费服务
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFeeServiceByIds(String[] ids);
}
