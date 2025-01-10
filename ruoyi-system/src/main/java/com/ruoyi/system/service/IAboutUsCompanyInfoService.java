package com.ruoyi.webMgt.service;

import java.util.List;
import com.ruoyi.webMgt.domain.AboutUsCompanyInfo;

/**
 * 公司简介Service接口
 * 
 * @author liuzihao
 * @date 2025-01-10
 */
public interface IAboutUsCompanyInfoService 
{
    /**
     * 查询公司简介
     * 
     * @param id 公司简介主键
     * @return 公司简介
     */
    public AboutUsCompanyInfo selectAboutUsCompanyInfoById(Long id);

    /**
     * 查询公司简介列表
     * 
     * @param aboutUsCompanyInfo 公司简介
     * @return 公司简介集合
     */
    public List<AboutUsCompanyInfo> selectAboutUsCompanyInfoList(AboutUsCompanyInfo aboutUsCompanyInfo);

    /**
     * 新增公司简介
     * 
     * @param aboutUsCompanyInfo 公司简介
     * @return 结果
     */
    public int insertAboutUsCompanyInfo(AboutUsCompanyInfo aboutUsCompanyInfo);

    /**
     * 修改公司简介
     * 
     * @param aboutUsCompanyInfo 公司简介
     * @return 结果
     */
    public int updateAboutUsCompanyInfo(AboutUsCompanyInfo aboutUsCompanyInfo);

    /**
     * 批量删除公司简介
     * 
     * @param ids 需要删除的公司简介主键集合
     * @return 结果
     */
    public int deleteAboutUsCompanyInfoByIds(String ids);

    /**
     * 删除公司简介信息
     * 
     * @param id 公司简介主键
     * @return 结果
     */
    public int deleteAboutUsCompanyInfoById(Long id);
}
