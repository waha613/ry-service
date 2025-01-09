package com.ruoyi.web.controller.webMgt;

import java.util.List;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.system.domain.ResultData;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.webMgt.domain.MainCarousel;
import com.ruoyi.webMgt.service.IMainCarouselService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 首页-轮播图Controller
 * 
 * @author liuzihao
 * @date 2025-01-10
 */
@Controller
@RequestMapping("/webMgt/carousel")
public class MainCarouselController extends BaseController
{
    private String prefix = "webMgt/carousel";

    @Autowired
    private IMainCarouselService mainCarouselService;

    @RequiresPermissions("webMgt:carousel:view")
    @GetMapping()
    public String carousel()
    {
        return prefix + "/carousel";
    }

    /**
     * 查询首页-轮播图列表
     */
    @RequiresPermissions("webMgt:carousel:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MainCarousel mainCarousel)
    {
        startPage();
        List<MainCarousel> list = mainCarouselService.selectMainCarouselList(mainCarousel);
        return getDataTable(list);
    }

    /**
     * 导出首页-轮播图列表
     */
    @RequiresPermissions("webMgt:carousel:export")
    @Log(title = "首页-轮播图", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MainCarousel mainCarousel)
    {
        List<MainCarousel> list = mainCarouselService.selectMainCarouselList(mainCarousel);
        ExcelUtil<MainCarousel> util = new ExcelUtil<MainCarousel>(MainCarousel.class);
        return util.exportExcel(list, "首页-轮播图数据");
    }

    /**
     * 新增首页-轮播图
     */
    @RequiresPermissions("webMgt:carousel:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存首页-轮播图
     */
    @RequiresPermissions("webMgt:carousel:add")
    @Log(title = "首页-轮播图", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MainCarousel mainCarousel)
    {
        return toAjax(mainCarouselService.insertMainCarousel(mainCarousel));
    }

    /**
     * 修改首页-轮播图
     */
    @RequiresPermissions("webMgt:carousel:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        MainCarousel mainCarousel = mainCarouselService.selectMainCarouselById(id);
        mmap.put("mainCarousel", mainCarousel);
        return prefix + "/edit";
    }

    /**
     * 修改保存首页-轮播图
     */
    @RequiresPermissions("webMgt:carousel:edit")
    @Log(title = "首页-轮播图", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MainCarousel mainCarousel)
    {
        return toAjax(mainCarouselService.updateMainCarousel(mainCarousel));
    }

    /**
     * 删除首页-轮播图
     */
    @RequiresPermissions("webMgt:carousel:remove")
    @Log(title = "首页-轮播图", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(mainCarouselService.deleteMainCarouselByIds(ids));
    }

    /**
     * 查询首页-关于我们数据
     */
    @PostMapping("/mainList")
    @ResponseBody
    @Anonymous
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    public ResultData mainList(MainCarousel mainCarousel)
    {
        mainCarousel.setStatus("Y");
        List<MainCarousel> list = mainCarouselService.selectMainCarouselList(mainCarousel);
        return new ResultData<>(200, "success", list) ;
    }
}
