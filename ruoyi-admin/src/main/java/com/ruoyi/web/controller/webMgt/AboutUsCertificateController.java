package com.ruoyi.webMgt.controller;

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
import com.ruoyi.webMgt.domain.AboutUsCertificate;
import com.ruoyi.webMgt.service.IAboutUsCertificateService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 资质证书Controller
 * 
 * @author liuzihao
 * @date 2025-01-10
 */
@Controller
@RequestMapping("/webMgt/certificate")
public class AboutUsCertificateController extends BaseController
{
    private String prefix = "webMgt/certificate";

    @Autowired
    private IAboutUsCertificateService aboutUsCertificateService;

    @RequiresPermissions("webMgt:certificate:view")
    @GetMapping()
    public String certificate()
    {
        return prefix + "/certificate";
    }

    /**
     * 查询资质证书列表
     */
    @RequiresPermissions("webMgt:certificate:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AboutUsCertificate aboutUsCertificate)
    {
        startPage();
        List<AboutUsCertificate> list = aboutUsCertificateService.selectAboutUsCertificateList(aboutUsCertificate);
        return getDataTable(list);
    }

    /**
     * 导出资质证书列表
     */
    @RequiresPermissions("webMgt:certificate:export")
    @Log(title = "资质证书", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AboutUsCertificate aboutUsCertificate)
    {
        List<AboutUsCertificate> list = aboutUsCertificateService.selectAboutUsCertificateList(aboutUsCertificate);
        ExcelUtil<AboutUsCertificate> util = new ExcelUtil<AboutUsCertificate>(AboutUsCertificate.class);
        return util.exportExcel(list, "资质证书数据");
    }

    /**
     * 新增资质证书
     */
    @RequiresPermissions("webMgt:certificate:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存资质证书
     */
    @RequiresPermissions("webMgt:certificate:add")
    @Log(title = "资质证书", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AboutUsCertificate aboutUsCertificate)
    {
        return toAjax(aboutUsCertificateService.insertAboutUsCertificate(aboutUsCertificate));
    }

    /**
     * 修改资质证书
     */
    @RequiresPermissions("webMgt:certificate:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AboutUsCertificate aboutUsCertificate = aboutUsCertificateService.selectAboutUsCertificateById(id);
        mmap.put("aboutUsCertificate", aboutUsCertificate);
        return prefix + "/edit";
    }

    /**
     * 修改保存资质证书
     */
    @RequiresPermissions("webMgt:certificate:edit")
    @Log(title = "资质证书", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AboutUsCertificate aboutUsCertificate)
    {
        return toAjax(aboutUsCertificateService.updateAboutUsCertificate(aboutUsCertificate));
    }

    /**
     * 删除资质证书
     */
    @RequiresPermissions("webMgt:certificate:remove")
    @Log(title = "资质证书", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(aboutUsCertificateService.deleteAboutUsCertificateByIds(ids));
    }

    /**
     * 查询资质证书数据
     */
    @PostMapping("/mainList")
    @ResponseBody
    @Anonymous
    @CrossOrigin(origins = "http://101.200.63.144", maxAge = 3600)
    public ResultData mainList(AboutUsCertificate aboutUsCertificate)
    {
        aboutUsCertificate.setStatus("Y");
        List<AboutUsCertificate> list = aboutUsCertificateService.selectAboutUsCertificateList(aboutUsCertificate);
        return new ResultData<>(200, "success", list) ;
    }
}
