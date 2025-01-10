package com.ruoyi.web.controller.webMgt;

import java.util.List;
import java.util.Objects;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.system.domain.ResultData;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.webMgt.domain.AboutUsCompanyInfo;
import com.ruoyi.webMgt.service.IAboutUsCompanyInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 公司简介Controller
 * 
 * @author liuzihao
 * @date 2025-01-10
 */
@Controller
@RequestMapping("/webMgt/companyInfo")
public class AboutUsCompanyInfoController extends BaseController
{
    private String prefix = "webMgt/companyInfo";

    @Autowired
    private IAboutUsCompanyInfoService aboutUsCompanyInfoService;

    @RequiresPermissions("webMgt:companyInfo:view")
    @GetMapping()
    public String companyInfo()
    {
        return prefix + "/companyInfo";
    }

    /**
     * 查询公司简介列表
     */
    @RequiresPermissions("webMgt:companyInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AboutUsCompanyInfo aboutUsCompanyInfo)
    {
        startPage();
        List<AboutUsCompanyInfo> list = aboutUsCompanyInfoService.selectAboutUsCompanyInfoList(aboutUsCompanyInfo);
        return getDataTable(list);
    }

    /**
     * 导出公司简介列表
     */
    @RequiresPermissions("webMgt:companyInfo:export")
    @Log(title = "公司简介", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AboutUsCompanyInfo aboutUsCompanyInfo)
    {
        List<AboutUsCompanyInfo> list = aboutUsCompanyInfoService.selectAboutUsCompanyInfoList(aboutUsCompanyInfo);
        ExcelUtil<AboutUsCompanyInfo> util = new ExcelUtil<AboutUsCompanyInfo>(AboutUsCompanyInfo.class);
        return util.exportExcel(list, "公司简介数据");
    }

    /**
     * 新增公司简介
     */
    @RequiresPermissions("webMgt:companyInfo:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存公司简介
     */
    @RequiresPermissions("webMgt:companyInfo:add")
    @Log(title = "公司简介", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AboutUsCompanyInfo aboutUsCompanyInfo)
    {
        AboutUsCompanyInfo param = new AboutUsCompanyInfo();
        param.setStatus("Y");
        List<AboutUsCompanyInfo> mainAboutUses = aboutUsCompanyInfoService.selectAboutUsCompanyInfoList(param);
        if (mainAboutUses != null && mainAboutUses.size() >= 1 && "Y".equals(aboutUsCompanyInfo.getStatus())) {
            return AjaxResult.error("同一时间只能有一条数据在启用状态");
        }
        return toAjax(aboutUsCompanyInfoService.insertAboutUsCompanyInfo(aboutUsCompanyInfo));
    }

    /**
     * 修改公司简介
     */
    @RequiresPermissions("webMgt:companyInfo:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AboutUsCompanyInfo aboutUsCompanyInfo = aboutUsCompanyInfoService.selectAboutUsCompanyInfoById(id);
        mmap.put("aboutUsCompanyInfo", aboutUsCompanyInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存公司简介
     */
    @RequiresPermissions("webMgt:companyInfo:edit")
    @Log(title = "公司简介", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AboutUsCompanyInfo aboutUsCompanyInfo)
    {
        AboutUsCompanyInfo param = new AboutUsCompanyInfo();
        param.setStatus("Y");
        List<AboutUsCompanyInfo> mainAboutUses = aboutUsCompanyInfoService.selectAboutUsCompanyInfoList(param);
        if (mainAboutUses != null && mainAboutUses.size() >= 1 && "Y".equals(aboutUsCompanyInfo.getStatus())
                && !Objects.equals(mainAboutUses.get(0).getId(), aboutUsCompanyInfo.getId())) {

            return AjaxResult.error("同一时间只能有一条数据在启用状态");
        }
        return toAjax(aboutUsCompanyInfoService.updateAboutUsCompanyInfo(aboutUsCompanyInfo));
    }

    /**
     * 删除公司简介
     */
    @RequiresPermissions("webMgt:companyInfo:remove")
    @Log(title = "公司简介", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(aboutUsCompanyInfoService.deleteAboutUsCompanyInfoByIds(ids));
    }

    /**
     * 查询公司简介数据
     */
    @PostMapping("/mainList")
    @ResponseBody
    @Anonymous
    @CrossOrigin(origins = "http://101.200.63.144", maxAge = 3600)
    public ResultData mainList(AboutUsCompanyInfo aboutUsCompanyInfo)
    {
        aboutUsCompanyInfo.setStatus("Y");
        List<AboutUsCompanyInfo> list = aboutUsCompanyInfoService.selectAboutUsCompanyInfoList(aboutUsCompanyInfo);
        return new ResultData<>(200, "success", list == null ? null : list.get(0)) ;
    }
}
