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
import com.ruoyi.system.domain.ProdCenter;
import com.ruoyi.system.service.IProdCenterService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 产品中心数据Controller
 * 
 * @author ruoyi
 * @date 2025-01-10
 */
@Controller
@RequestMapping("/webMgt/mainProdCenter")
public class ProdCenterController extends BaseController
{
    private String prefix = "webMgt/mainProdCenter";

    @Autowired
    private IProdCenterService prodCenterService;

    @RequiresPermissions("webMgt:mainProdCenter:view")
    @GetMapping()
    public String mainProdCenter()
    {
        return prefix + "/mainProdCenter";
    }

    /**
     * 查询产品中心数据列表
     */
    @RequiresPermissions("webMgt:mainProdCenter:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProdCenter prodCenter)
    {
        startPage();
        List<ProdCenter> list = prodCenterService.selectProdCenterList(prodCenter);
        return getDataTable(list);
    }

    /**
     * 查询首页产品中心列表
     */
    @PostMapping("/mainList")
    @ResponseBody
    @Anonymous
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    public ResultData mainList(ProdCenter prodCenter)
    {
        prodCenter.setFlag1("0");
        List<ProdCenter> list = prodCenterService.selectProdCenterList(prodCenter);
        return new ResultData<>(200, "success", list) ;
    }

    /**
     * 查询首页产品海报列表
     */
    @PostMapping("/mainPostersList")
    @ResponseBody
    @Anonymous
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    public ResultData mainPostersList(ProdCenter prodCenter)
    {
        prodCenter.setFlag2("0");
        List<ProdCenter> list = prodCenterService.selectProdCenterList(prodCenter);
        return new ResultData<>(200, "success", list) ;
    }

    /**
     * 导出产品中心数据列表
     */
    @RequiresPermissions("webMgt:mainProdCenter:export")
    @Log(title = "产品中心数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProdCenter prodCenter)
    {
        List<ProdCenter> list = prodCenterService.selectProdCenterList(prodCenter);
        ExcelUtil<ProdCenter> util = new ExcelUtil<ProdCenter>(ProdCenter.class);
        return util.exportExcel(list, "产品中心数据数据");
    }

    /**
     * 新增产品中心数据
     */
    @RequiresPermissions("webMgt:mainProdCenter:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存产品中心数据
     */
    @RequiresPermissions("webMgt:mainProdCenter:add")
    @Log(title = "产品中心数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProdCenter prodCenter)
    {
        return toAjax(prodCenterService.insertProdCenter(prodCenter));
    }

    /**
     * 修改产品中心数据
     */
    @RequiresPermissions("webMgt:mainProdCenter:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ProdCenter prodCenter = prodCenterService.selectProdCenterById(id);
        mmap.put("prodCenter", prodCenter);
        return prefix + "/edit";
    }

    /**
     * 修改保存产品中心数据
     */
    @RequiresPermissions("webMgt:mainProdCenter:edit")
    @Log(title = "产品中心数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProdCenter prodCenter)
    {
        return toAjax(prodCenterService.updateProdCenter(prodCenter));
    }

    /**
     * 删除产品中心数据
     */
    @RequiresPermissions("webMgt:mainProdCenter:remove")
    @Log(title = "产品中心数据", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(prodCenterService.deleteProdCenterByIds(ids));
    }
}
