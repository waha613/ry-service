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
import com.ruoyi.system.domain.FeeService;
import com.ruoyi.system.service.IFeeServiceService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 缴费服务Controller
 * 
 * @author liuzihao
 * @date 2025-01-11
 */
@Controller
@RequestMapping("/webMgt/feeService")
public class FeeServiceController extends BaseController
{
    private String prefix = "webMgt/feeService";

    @Autowired
    private IFeeServiceService feeServiceService;

    @RequiresPermissions("webMgt:feeService:view")
    @GetMapping()
    public String feeService()
    {
        return prefix + "/feeService";
    }

    /**
     * 查询缴费服务列表
     */
    @RequiresPermissions("webMgt:feeService:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FeeService feeService)
    {
        startPage();
        List<FeeService> list = feeServiceService.selectFeeServiceList(feeService);
        return getDataTable(list);
    }

    /**
     * 导出缴费服务列表
     */
    @RequiresPermissions("webMgt:feeService:export")
    @Log(title = "缴费服务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FeeService feeService)
    {
        List<FeeService> list = feeServiceService.selectFeeServiceList(feeService);
        ExcelUtil<FeeService> util = new ExcelUtil<FeeService>(FeeService.class);
        return util.exportExcel(list, "缴费服务数据");
    }

    /**
     * 新增缴费服务
     */
    @RequiresPermissions("webMgt:feeService:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存缴费服务
     */
    @RequiresPermissions("webMgt:feeService:add")
    @Log(title = "缴费服务", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FeeService feeService)
    {
        FeeService param = new FeeService();
        param.setStatus("Y");
        List<FeeService> feeServices = feeServiceService.selectFeeServiceList(param);
        if (feeServices != null && feeServices.size() >= 1 && "Y".equals(feeService.getStatus())) {
            return AjaxResult.error("同一时间只能有一条数据在启用状态");
        }
        return toAjax(feeServiceService.insertFeeService(feeService));
    }

    /**
     * 修改缴费服务
     */
    @RequiresPermissions("webMgt:feeService:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FeeService feeService = feeServiceService.selectFeeServiceById(id);
        mmap.put("feeService", feeService);
        return prefix + "/edit";
    }

    /**
     * 修改保存缴费服务
     */
    @RequiresPermissions("webMgt:feeService:edit")
    @Log(title = "缴费服务", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FeeService feeService)
    {
        FeeService param = new FeeService();
        param.setStatus("Y");
        List<FeeService> feeServices = feeServiceService.selectFeeServiceList(param);
        if (feeServices != null && feeServices.size() >= 1 && "Y".equals(feeService.getStatus())
                && !Objects.equals(feeServices.get(0).getId(), feeService.getId())) {

            return AjaxResult.error("同一时间只能有一条数据在启用状态");
        }
        return toAjax(feeServiceService.updateFeeService(feeService));
    }

    /**
     * 删除缴费服务
     */
    @RequiresPermissions("webMgt:feeService:remove")
    @Log(title = "缴费服务", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(feeServiceService.deleteFeeServiceByIds(ids));
    }

    /**
     * 查询缴费服务数据
     */
    @PostMapping("/mainList")
    @ResponseBody
    @Anonymous
    @CrossOrigin(origins = "http://101.200.63.144", maxAge = 3600)
    public ResultData mainList(FeeService feeService)
    {
        feeService.setStatus("Y");
        List<FeeService> list =feeServiceService.selectFeeServiceList(feeService);
        return new ResultData<>(200, "success", list == null ? null : list.get(0)) ;
    }
}
