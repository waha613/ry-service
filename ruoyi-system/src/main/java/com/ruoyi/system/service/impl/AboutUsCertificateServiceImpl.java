package com.ruoyi.webMgt.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.webMgt.mapper.AboutUsCertificateMapper;
import com.ruoyi.webMgt.domain.AboutUsCertificate;
import com.ruoyi.webMgt.service.IAboutUsCertificateService;
import com.ruoyi.common.core.text.Convert;

/**
 * 资质证书Service业务层处理
 * 
 * @author liuzihao
 * @date 2025-01-10
 */
@Service
public class AboutUsCertificateServiceImpl implements IAboutUsCertificateService 
{
    @Autowired
    private AboutUsCertificateMapper aboutUsCertificateMapper;

    /**
     * 查询资质证书
     * 
     * @param id 资质证书主键
     * @return 资质证书
     */
    @Override
    public AboutUsCertificate selectAboutUsCertificateById(Long id)
    {
        return aboutUsCertificateMapper.selectAboutUsCertificateById(id);
    }

    /**
     * 查询资质证书列表
     * 
     * @param aboutUsCertificate 资质证书
     * @return 资质证书
     */
    @Override
    public List<AboutUsCertificate> selectAboutUsCertificateList(AboutUsCertificate aboutUsCertificate)
    {
        return aboutUsCertificateMapper.selectAboutUsCertificateList(aboutUsCertificate);
    }

    /**
     * 新增资质证书
     * 
     * @param aboutUsCertificate 资质证书
     * @return 结果
     */
    @Override
    public int insertAboutUsCertificate(AboutUsCertificate aboutUsCertificate)
    {
        aboutUsCertificate.setCreateTime(DateUtils.getNowDate());
        return aboutUsCertificateMapper.insertAboutUsCertificate(aboutUsCertificate);
    }

    /**
     * 修改资质证书
     * 
     * @param aboutUsCertificate 资质证书
     * @return 结果
     */
    @Override
    public int updateAboutUsCertificate(AboutUsCertificate aboutUsCertificate)
    {
        aboutUsCertificate.setUpdateTime(DateUtils.getNowDate());
        return aboutUsCertificateMapper.updateAboutUsCertificate(aboutUsCertificate);
    }

    /**
     * 批量删除资质证书
     * 
     * @param ids 需要删除的资质证书主键
     * @return 结果
     */
    @Override
    public int deleteAboutUsCertificateByIds(String ids)
    {
        return aboutUsCertificateMapper.deleteAboutUsCertificateByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除资质证书信息
     * 
     * @param id 资质证书主键
     * @return 结果
     */
    @Override
    public int deleteAboutUsCertificateById(Long id)
    {
        return aboutUsCertificateMapper.deleteAboutUsCertificateById(id);
    }
}
