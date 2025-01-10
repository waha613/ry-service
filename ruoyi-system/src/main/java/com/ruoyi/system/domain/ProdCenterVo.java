package com.ruoyi.system.domain;

import java.util.List;

public class ProdCenterVo {
    private String prodType;
    private List<ProdCenter> details;

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public List<ProdCenter> getDetails() {
        return details;
    }

    public void setDetails(List<ProdCenter> details) {
        this.details = details;
    }
}
