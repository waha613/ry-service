package com.ruoyi.webMgt.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.webMgt.mapper.MainCarouselMapper;
import com.ruoyi.webMgt.domain.MainCarousel;
import com.ruoyi.webMgt.service.IMainCarouselService;
import com.ruoyi.common.core.text.Convert;

/**
 * 首页-轮播图Service业务层处理
 * 
 * @author liuzihao
 * @date 2025-01-10
 */
@Service
public class MainCarouselServiceImpl implements IMainCarouselService 
{
    @Autowired
    private MainCarouselMapper mainCarouselMapper;

    /**
     * 查询首页-轮播图
     * 
     * @param id 首页-轮播图主键
     * @return 首页-轮播图
     */
    @Override
    public MainCarousel selectMainCarouselById(Long id)
    {
        return mainCarouselMapper.selectMainCarouselById(id);
    }

    /**
     * 查询首页-轮播图列表
     * 
     * @param mainCarousel 首页-轮播图
     * @return 首页-轮播图
     */
    @Override
    public List<MainCarousel> selectMainCarouselList(MainCarousel mainCarousel)
    {
        return mainCarouselMapper.selectMainCarouselList(mainCarousel);
    }

    /**
     * 新增首页-轮播图
     * 
     * @param mainCarousel 首页-轮播图
     * @return 结果
     */
    @Override
    public int insertMainCarousel(MainCarousel mainCarousel)
    {
        mainCarousel.setCreateTime(DateUtils.getNowDate());
        return mainCarouselMapper.insertMainCarousel(mainCarousel);
    }

    /**
     * 修改首页-轮播图
     * 
     * @param mainCarousel 首页-轮播图
     * @return 结果
     */
    @Override
    public int updateMainCarousel(MainCarousel mainCarousel)
    {
        mainCarousel.setUpdateTime(DateUtils.getNowDate());
        return mainCarouselMapper.updateMainCarousel(mainCarousel);
    }

    /**
     * 批量删除首页-轮播图
     * 
     * @param ids 需要删除的首页-轮播图主键
     * @return 结果
     */
    @Override
    public int deleteMainCarouselByIds(String ids)
    {
        return mainCarouselMapper.deleteMainCarouselByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除首页-轮播图信息
     * 
     * @param id 首页-轮播图主键
     * @return 结果
     */
    @Override
    public int deleteMainCarouselById(Long id)
    {
        return mainCarouselMapper.deleteMainCarouselById(id);
    }
}
