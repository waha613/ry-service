package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产品中心对象 prod_center
 * 
 * @author liuzihao
 * @date 2025-01-11
 */
public class ProdCenter extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String prodTitle;

    /** 规格 */
    @Excel(name = "规格")
    private String prodCommon1;

    /** 剂型 */
    @Excel(name = "剂型")
    private String prodCommon2;

    /** 批准文号 */
    @Excel(name = "批准文号")
    private String prodCommon3;

    /** 执行标准 */
    @Excel(name = "执行标准")
    private String prodCommon4;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String prodImgAddress;

    /** 产品类型 */
    @Excel(name = "产品类型")
    private String prodType;

    /** 是否展示在首页产品中心 */
    @Excel(name = "是否展示在首页产品中心")
    private String flag1;

    /** 是否展示在首页产品海报 */
    @Excel(name = "是否展示在首页产品海报")
    private String flag2;

    /** 是否启用 */
    @Excel(name = "是否启用")
    private String status;

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

    public void setProdType(String prodType) 
    {
        this.prodType = prodType;
    }

    public String getProdType() 
    {
        return prodType;
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

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
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
            .append("prodType", getProdType())
            .append("flag1", getFlag1())
            .append("flag2", getFlag2())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
