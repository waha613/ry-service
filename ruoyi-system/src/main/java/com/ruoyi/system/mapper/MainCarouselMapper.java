package com.ruoyi.webMgt.mapper;

import java.util.List;
import com.ruoyi.webMgt.domain.MainCarousel;

/**
 * 首页-轮播图Mapper接口
 * 
 * @author liuzihao
 * @date 2025-01-10
 */
public interface MainCarouselMapper 
{
    /**
     * 查询首页-轮播图
     * 
     * @param id 首页-轮播图主键
     * @return 首页-轮播图
     */
    public MainCarousel selectMainCarouselById(Long id);

    /**
     * 查询首页-轮播图列表
     * 
     * @param mainCarousel 首页-轮播图
     * @return 首页-轮播图集合
     */
    public List<MainCarousel> selectMainCarouselList(MainCarousel mainCarousel);

    /**
     * 新增首页-轮播图
     * 
     * @param mainCarousel 首页-轮播图
     * @return 结果
     */
    public int insertMainCarousel(MainCarousel mainCarousel);

    /**
     * 修改首页-轮播图
     * 
     * @param mainCarousel 首页-轮播图
     * @return 结果
     */
    public int updateMainCarousel(MainCarousel mainCarousel);

    /**
     * 删除首页-轮播图
     * 
     * @param id 首页-轮播图主键
     * @return 结果
     */
    public int deleteMainCarouselById(Long id);

    /**
     * 批量删除首页-轮播图
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMainCarouselByIds(String[] ids);
}
