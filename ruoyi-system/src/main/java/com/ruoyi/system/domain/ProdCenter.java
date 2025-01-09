package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产品中心数据对象 prod_center
 * 
 * @author ruoyi
 * @date 2025-01-10
 */
public class ProdCenter extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 产品id */
    private Long id;

    /** 产品标题 */
    @Excel(name = "产品标题")
    private String prodTitle;

    /** 产品规格 */
    @Excel(name = "产品规格")
    private String prodCommon1;

    /** 产品剂型 */
    @Excel(name = "产品剂型")
    private String prodCommon2;

    /** 产品批准文号 */
    @Excel(name = "产品批准文号")
    private String prodCommon3;

    /** 产品执行标准 */
    @Excel(name = "产品执行标准")
    private String prodCommon4;

    /** 产品图片地址 */
    @Excel(name = "产品图片地址")
    private String prodImgAddress;

    /** 是否在首页产品中心展示 */
    @Excel(name = "是否在首页产品中心展示")
    private String flag1;

    /** 是否在首页产品海报展示 */
    @Excel(name = "是否在首页产品海报展示")
    private String flag2;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setProdTitle(String prodTitle) 
    {
        this.prodTitle = prodTitle;
    }

    public String getProdTitle() 
    {
        return prodTitle;
    }

    public void setProdCommon1(String prodCommon1) 
    {
        this.prodCommon1 = prodCommon1;
    }

    public String getProdCommon1() 
    {
        return prodCommon1;
    }

    public void setProdCommon2(String prodCommon2) 
    {
        this.prodCommon2 = prodCommon2;
    }

    public String getProdCommon2() 
    {
        return prodCommon2;
    }

    public void setProdCommon3(String prodCommon3) 
    {
        this.prodCommon3 = prodCommon3;
    }

    public String getProdCommon3() 
    {
        return prodCommon3;
    }

    public void setProdCommon4(String prodCommon4) 
    {
        this.prodCommon4 = prodCommon4;
    }

    public String getProdCommon4() 
    {
        return prodCommon4;
    }

    public void setProdImgAddress(String prodImgAddress) 
    {
        this.prodImgAddress = prodImgAddress;
    }

    public String getProdImgAddress() 
    {
        return prodImgAddress;
    }

    public void setFlag1(String flag1) 
    {
        this.flag1 = flag1;
    }

    public String getFlag1() 
    {
        return flag1;
    }

    public void setFlag2(String flag2) 
    {
        this.flag2 = flag2;
    }

    public String getFlag2() 
    {
        return flag2;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("prodTitle", getProdTitle())
            .append("prodCommon1", getProdCommon1())
            .append("prodCommon2", getProdCommon2())
            .append("prodCommon3", getProdCommon3())
            .append("prodCommon4", getProdCommon4())
            .append("prodImgAddress", getProdImgAddress())
            .append("flag1", getFlag1())
            .append("flag2", getFlag2())
            .toString();
    }
}
