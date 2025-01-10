package com.ruoyi.webMgt.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.webMgt.mapper.AboutUsCompanyInfoMapper;
import com.ruoyi.webMgt.domain.AboutUsCompanyInfo;
import com.ruoyi.webMgt.service.IAboutUsCompanyInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 公司简介Service业务层处理
 * 
 * @author liuzihao
 * @date 2025-01-10
 */
@Service
public class AboutUsCompanyInfoServiceImpl implements IAboutUsCompanyInfoService 
{
    @Autowired
    private AboutUsCompanyInfoMapper aboutUsCompanyInfoMapper;

    /**
     * 查询公司简介
     * 
     * @param id 公司简介主键
     * @return 公司简介
     */
    @Override
    public AboutUsCompanyInfo selectAboutUsCompanyInfoById(Long id)
    {
        return aboutUsCompanyInfoMapper.selectAboutUsCompanyInfoById(id);
    }

    /**
     * 查询公司简介列表
     * 
     * @param aboutUsCompanyInfo 公司简介
     * @return 公司简介
     */
    @Override
    public List<AboutUsCompanyInfo> selectAboutUsCompanyInfoList(AboutUsCompanyInfo aboutUsCompanyInfo)
    {
        return aboutUsCompanyInfoMapper.selectAboutUsCompanyInfoList(aboutUsCompanyInfo);
    }

    /**
     * 新增公司简介
     * 
     * @param aboutUsCompanyInfo 公司简介
     * @return 结果
     */
    @Override
    public int insertAboutUsCompanyInfo(AboutUsCompanyInfo aboutUsCompanyInfo)
    {
        aboutUsCompanyInfo.setCreateTime(DateUtils.getNowDate());
        return aboutUsCompanyInfoMapper.insertAboutUsCompanyInfo(aboutUsCompanyInfo);
    }

    /**
     * 修改公司简介
     * 
     * @param aboutUsCompanyInfo 公司简介
     * @return 结果
     */
    @Override
    public int updateAboutUsCompanyInfo(AboutUsCompanyInfo aboutUsCompanyInfo)
    {
        aboutUsCompanyInfo.setUpdateTime(DateUtils.getNowDate());
        return aboutUsCompanyInfoMapper.updateAboutUsCompanyInfo(aboutUsCompanyInfo);
    }

    /**
     * 批量删除公司简介
     * 
     * @param ids 需要删除的公司简介主键
     * @return 结果
     */
    @Override
    public int deleteAboutUsCompanyInfoByIds(String ids)
    {
        return aboutUsCompanyInfoMapper.deleteAboutUsCompanyInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除公司简介信息
     * 
     * @param id 公司简介主键
     * @return 结果
     */
    @Override
    public int deleteAboutUsCompanyInfoById(Long id)
    {
        return aboutUsCompanyInfoMapper.deleteAboutUsCompanyInfoById(id);
    }
}
