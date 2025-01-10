package com.ruoyi.webMgt.service;

import java.util.List;
import com.ruoyi.webMgt.domain.AboutUsCertificate;

/**
 * 资质证书Service接口
 * 
 * @author liuzihao
 * @date 2025-01-10
 */
public interface IAboutUsCertificateService 
{
    /**
     * 查询资质证书
     * 
     * @param id 资质证书主键
     * @return 资质证书
     */
    public AboutUsCertificate selectAboutUsCertificateById(Long id);

    /**
     * 查询资质证书列表
     * 
     * @param aboutUsCertificate 资质证书
     * @return 资质证书集合
     */
    public List<AboutUsCertificate> selectAboutUsCertificateList(AboutUsCertificate aboutUsCertificate);

    /**
     * 新增资质证书
     * 
     * @param aboutUsCertificate 资质证书
     * @return 结果
     */
    public int insertAboutUsCertificate(AboutUsCertificate aboutUsCertificate);

    /**
     * 修改资质证书
     * 
     * @param aboutUsCertificate 资质证书
     * @return 结果
     */
    public int updateAboutUsCertificate(AboutUsCertificate aboutUsCertificate);

    /**
     * 批量删除资质证书
     * 
     * @param ids 需要删除的资质证书主键集合
     * @return 结果
     */
    public int deleteAboutUsCertificateByIds(String ids);

    /**
     * 删除资质证书信息
     * 
     * @param id 资质证书主键
     * @return 结果
     */
    public int deleteAboutUsCertificateById(Long id);
}
