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
import com.ruoyi.system.domain.ContactUs;
import com.ruoyi.system.service.IContactUsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 联系我们Controller
 * 
 * @author liuzihao
 * @date 2025-01-11
 */
@Controller
@RequestMapping("/webMgt/contactUs")
public class ContactUsController extends BaseController
{
    private String prefix = "webMgt/contactUs";

    @Autowired
    private IContactUsService contactUsService;

    @RequiresPermissions("webMgt:contactUs:view")
    @GetMapping()
    public String contactUs()
    {
        return prefix + "/contactUs";
    }

    /**
     * 查询联系我们列表
     */
    @RequiresPermissions("webMgt:contactUs:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ContactUs contactUs)
    {
        startPage();
        List<ContactUs> list = contactUsService.selectContactUsList(contactUs);
        return getDataTable(list);
    }

    /**
     * 导出联系我们列表
     */
    @RequiresPermissions("webMgt:contactUs:export")
    @Log(title = "联系我们", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ContactUs contactUs)
    {
        List<ContactUs> list = contactUsService.selectContactUsList(contactUs);
        ExcelUtil<ContactUs> util = new ExcelUtil<ContactUs>(ContactUs.class);
        return util.exportExcel(list, "联系我们数据");
    }

    /**
     * 新增联系我们
     */
    @RequiresPermissions("webMgt:contactUs:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存联系我们
     */
    @RequiresPermissions("webMgt:contactUs:add")
    @Log(title = "联系我们", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ContactUs contactUs)
    {
        ContactUs param = new ContactUs();
        param.setStatus("Y");
        List<ContactUs> contactUsList = contactUsService.selectContactUsList(param);
        if (contactUsList != null && contactUsList.size() >= 1 && "Y".equals(contactUs.getStatus())) {
            return AjaxResult.error("同一时间只能有一条数据在启用状态");
        }
        return toAjax(contactUsService.insertContactUs(contactUs));
    }

    /**
     * 修改联系我们
     */
    @RequiresPermissions("webMgt:contactUs:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ContactUs contactUs = contactUsService.selectContactUsById(id);
        mmap.put("contactUs", contactUs);
        return prefix + "/edit";
    }

    /**
     * 修改保存联系我们
     */
    @RequiresPermissions("webMgt:contactUs:edit")
    @Log(title = "联系我们", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ContactUs contactUs)
    {
        ContactUs param = new ContactUs();
        param.setStatus("Y");
        List<ContactUs> contactUsList = contactUsService.selectContactUsList(param);
        if (contactUsList != null && contactUsList.size() >= 1 && "Y".equals(contactUs.getStatus())
                && !Objects.equals(contactUsList.get(0).getId(), contactUs.getId())) {

            return AjaxResult.error("同一时间只能有一条数据在启用状态");
        }
        return toAjax(contactUsService.updateContactUs(contactUs));
    }

    /**
     * 删除联系我们
     */
    @RequiresPermissions("webMgt:contactUs:remove")
    @Log(title = "联系我们", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(contactUsService.deleteContactUsByIds(ids));
    }

    /**
     * 查询联系我们数据
     */
    @PostMapping("/mainList")
    @ResponseBody
    @Anonymous
    @CrossOrigin(origins = "http://101.200.63.144", maxAge = 3600)
    public ResultData mainList(ContactUs contactUs)
    {
        contactUs.setStatus("Y");
        List<ContactUs> list = contactUsService.selectContactUsList(contactUs);
        return new ResultData<>(200, "success", list == null ? null : list.get(0)) ;
    }
}
