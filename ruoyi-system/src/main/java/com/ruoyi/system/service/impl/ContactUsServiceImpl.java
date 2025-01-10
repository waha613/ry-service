package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ContactUsMapper;
import com.ruoyi.system.domain.ContactUs;
import com.ruoyi.system.service.IContactUsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 联系我们Service业务层处理
 * 
 * @author liuzihao
 * @date 2025-01-11
 */
@Service
public class ContactUsServiceImpl implements IContactUsService 
{
    @Autowired
    private ContactUsMapper contactUsMapper;

    /**
     * 查询联系我们
     * 
     * @param id 联系我们主键
     * @return 联系我们
     */
    @Override
    public ContactUs selectContactUsById(Long id)
    {
        return contactUsMapper.selectContactUsById(id);
    }

    /**
     * 查询联系我们列表
     * 
     * @param contactUs 联系我们
     * @return 联系我们
     */
    @Override
    public List<ContactUs> selectContactUsList(ContactUs contactUs)
    {
        return contactUsMapper.selectContactUsList(contactUs);
    }

    /**
     * 新增联系我们
     * 
     * @param contactUs 联系我们
     * @return 结果
     */
    @Override
    public int insertContactUs(ContactUs contactUs)
    {
        contactUs.setCreateTime(DateUtils.getNowDate());
        return contactUsMapper.insertContactUs(contactUs);
    }

    /**
     * 修改联系我们
     * 
     * @param contactUs 联系我们
     * @return 结果
     */
    @Override
    public int updateContactUs(ContactUs contactUs)
    {
        contactUs.setUpdateTime(DateUtils.getNowDate());
        return contactUsMapper.updateContactUs(contactUs);
    }

    /**
     * 批量删除联系我们
     * 
     * @param ids 需要删除的联系我们主键
     * @return 结果
     */
    @Override
    public int deleteContactUsByIds(String ids)
    {
        return contactUsMapper.deleteContactUsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除联系我们信息
     * 
     * @param id 联系我们主键
     * @return 结果
     */
    @Override
    public int deleteContactUsById(Long id)
    {
        return contactUsMapper.deleteContactUsById(id);
    }
}
