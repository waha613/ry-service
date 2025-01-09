package com.ruoyi.webMgt.service;

import java.util.List;
import com.ruoyi.webMgt.domain.MainAboutUs;

/**
 * 首页-关于我们Service接口
 * 
 * @author liuzihao
 * @date 2025-01-10
 */
public interface IMainAboutUsService 
{
    /**
     * 查询首页-关于我们
     * 
     * @param id 首页-关于我们主键
     * @return 首页-关于我们
     */
    public MainAboutUs selectMainAboutUsById(Long id);

    /**
     * 查询首页-关于我们列表
     * 
     * @param mainAboutUs 首页-关于我们
     * @return 首页-关于我们集合
     */
    public List<MainAboutUs> selectMainAboutUsList(MainAboutUs mainAboutUs);

    /**
     * 新增首页-关于我们
     * 
     * @param mainAboutUs 首页-关于我们
     * @return 结果
     */
    public int insertMainAboutUs(MainAboutUs mainAboutUs);

    /**
     * 修改首页-关于我们
     * 
     * @param mainAboutUs 首页-关于我们
     * @return 结果
     */
    public int updateMainAboutUs(MainAboutUs mainAboutUs);

    /**
     * 批量删除首页-关于我们
     * 
     * @param ids 需要删除的首页-关于我们主键集合
     * @return 结果
     */
    public int deleteMainAboutUsByIds(String ids);

    /**
     * 删除首页-关于我们信息
     * 
     * @param id 首页-关于我们主键
     * @return 结果
     */
    public int deleteMainAboutUsById(Long id);
}
