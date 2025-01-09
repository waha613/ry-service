package com.ruoyi.webMgt.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 首页-关于我们对象 main_about_us
 * 
 * @author liuzihao
 * @date 2025-01-10
 */
public class MainAboutUs extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 公告ID */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 内容 */
    @Excel(name = "内容")
    private String descbsion;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String image;

    /** 是否启用（0启用 1不启用） */
    @Excel(name = "是否启用", readConverterExp = "0=启用,1=不启用")
    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setDescbsion(String descbsion) 
    {
        this.descbsion = descbsion;
    }

    public String getDescbsion() 
    {
        return descbsion;
    }

    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
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
            .append("title", getTitle())
            .append("descbsion", getDescbsion())
            .append("image", getImage())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
