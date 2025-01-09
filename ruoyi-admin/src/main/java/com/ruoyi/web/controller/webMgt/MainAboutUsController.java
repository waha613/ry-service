package com.ruoyi.webMgt.controller;

import java.util.List;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.system.domain.ProdCenter;
import com.ruoyi.system.domain.ResultData;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.webMgt.domain.MainAboutUs;
import com.ruoyi.webMgt.service.IMainAboutUsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 首页-关于我们Controller
 * 
 * @author liuzihao
 * @date 2025-01-10
 */
@Controller
@RequestMapping("/webMgt/mainAboutUs")
public class MainAboutUsController extends BaseController
{
    private String prefix = "webMgt/mainAboutUs";

    @Autowired
    private IMainAboutUsService mainAboutUsService;

    @RequiresPermissions("webMgt:mainAboutUs:view")
    @GetMapping()
    public String mainAboutUs()
    {
        return prefix + "/mainAboutUs";
    }

    /**
     * 查询首页-关于我们列表
     */
    @RequiresPermissions("webMgt:mainAboutUs:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MainAboutUs mainAboutUs)
    {
        startPage();
        List<MainAboutUs> list = mainAboutUsService.selectMainAboutUsList(mainAboutUs);
        return getDataTable(list);
    }

    /**
     * 导出首页-关于我们列表
     */
    @RequiresPermissions("webMgt:mainAboutUs:export")
    @Log(title = "首页-关于我们", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MainAboutUs mainAboutUs)
    {
        List<MainAboutUs> list = mainAboutUsService.selectMainAboutUsList(mainAboutUs);
        ExcelUtil<MainAboutUs> util = new ExcelUtil<MainAboutUs>(MainAboutUs.class);
        return util.exportExcel(list, "首页-关于我们数据");
    }

    /**
     * 新增首页-关于我们
     */
    @RequiresPermissions("webMgt:mainAboutUs:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存首页-关于我们
     */
    @RequiresPermissions("webMgt:mainAboutUs:add")
    @Log(title = "首页-关于我们", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MainAboutUs mainAboutUs)
    {
        MainAboutUs param = new MainAboutUs();
        param.setStatus("Y");
        List<MainAboutUs> mainAboutUses = mainAboutUsService.selectMainAboutUsList(param);
        if (mainAboutUses != null && mainAboutUses.size() > 1 && "Y".equals(mainAboutUs.getStatus())) {
           return AjaxResult.error("同一时间只能有一条数据在启用状态");
        }

        return toAjax(mainAboutUsService.insertMainAboutUs(mainAboutUs));
    }

    /**
     * 修改首页-关于我们
     */
    @RequiresPermissions("webMgt:mainAboutUs:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        MainAboutUs mainAboutUs = mainAboutUsService.selectMainAboutUsById(id);
        mmap.put("mainAboutUs", mainAboutUs);
        return prefix + "/edit";
    }

    /**
     * 修改保存首页-关于我们
     */
    @RequiresPermissions("webMgt:mainAboutUs:edit")
    @Log(title = "首页-关于我们", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MainAboutUs mainAboutUs)
    {
        MainAboutUs param = new MainAboutUs();
        param.setStatus("Y");
        List<MainAboutUs> mainAboutUses = mainAboutUsService.selectMainAboutUsList(param);
        if (mainAboutUses != null && mainAboutUses.size() > 1 && "Y".equals(mainAboutUs.getStatus())) {
            return AjaxResult.error("同一时间只能有一条数据在启用状态");
        }
        return toAjax(mainAboutUsService.updateMainAboutUs(mainAboutUs));
    }

    /**
     * 删除首页-关于我们
     */
    @RequiresPermissions("webMgt:mainAboutUs:remove")
    @Log(title = "首页-关于我们", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(mainAboutUsService.deleteMainAboutUsByIds(ids));
    }

    /**
     * 查询首页-关于我们数据
     */
    @PostMapping("/mainList")
    @ResponseBody
    @Anonymous
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    public ResultData mainList(MainAboutUs mainAboutUs)
    {
        mainAboutUs.setStatus("Y");
        List<MainAboutUs> list = mainAboutUsService.selectMainAboutUsList(mainAboutUs);
        return new ResultData<>(200, "success", list == null ? null : list.get(0)) ;
    }
}
