package com.ruoyi.webMgt.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.webMgt.mapper.MainAboutUsMapper;
import com.ruoyi.webMgt.domain.MainAboutUs;
import com.ruoyi.webMgt.service.IMainAboutUsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 首页-关于我们Service业务层处理
 * 
 * @author liuzihao
 * @date 2025-01-10
 */
@Service
public class MainAboutUsServiceImpl implements IMainAboutUsService 
{
    @Autowired
    private MainAboutUsMapper mainAboutUsMapper;

    /**
     * 查询首页-关于我们
     * 
     * @param id 首页-关于我们主键
     * @return 首页-关于我们
     */
    @Override
    public MainAboutUs selectMainAboutUsById(Long id)
    {
        return mainAboutUsMapper.selectMainAboutUsById(id);
    }

    /**
     * 查询首页-关于我们列表
     * 
     * @param mainAboutUs 首页-关于我们
     * @return 首页-关于我们
     */
    @Override
    public List<MainAboutUs> selectMainAboutUsList(MainAboutUs mainAboutUs)
    {
        return mainAboutUsMapper.selectMainAboutUsList(mainAboutUs);
    }

    /**
     * 新增首页-关于我们
     * 
     * @param mainAboutUs 首页-关于我们
     * @return 结果
     */
    @Override
    public int insertMainAboutUs(MainAboutUs mainAboutUs)
    {
        mainAboutUs.setCreateTime(DateUtils.getNowDate());
        return mainAboutUsMapper.insertMainAboutUs(mainAboutUs);
    }

    /**
     * 修改首页-关于我们
     * 
     * @param mainAboutUs 首页-关于我们
     * @return 结果
     */
    @Override
    public int updateMainAboutUs(MainAboutUs mainAboutUs)
    {
        mainAboutUs.setUpdateTime(DateUtils.getNowDate());
        return mainAboutUsMapper.updateMainAboutUs(mainAboutUs);
    }

    /**
     * 批量删除首页-关于我们
     * 
     * @param ids 需要删除的首页-关于我们主键
     * @return 结果
     */
    @Override
    public int deleteMainAboutUsByIds(String ids)
    {
        return mainAboutUsMapper.deleteMainAboutUsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除首页-关于我们信息
     * 
     * @param id 首页-关于我们主键
     * @return 结果
     */
    @Override
    public int deleteMainAboutUsById(Long id)
    {
        return mainAboutUsMapper.deleteMainAboutUsById(id);
    }
}
