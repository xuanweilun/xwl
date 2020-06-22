package com.yh.xuanweilun.entity;


import java.util.ArrayList;
import java.util.List;


public class EquityTypeDTO {
    private String id;

    //推荐权益名字
    private String name;

    //权益套餐类型
    private String equityType;

    private String imgSrc;

    private String imgLink;

    //权益类型：资费权益、业务权益、推荐权益
    private String type;

    private String notGetName;

    private String toGetName;

    private String toGetLink;

    //如果当前权益为推荐权益，会拥有一个大数据id
    private String bigDataId;


    private List<EquityProductDTO> equityProductDTOs;

    private List<EquityDTO> equityDTOs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEquityType() {
        return equityType;
    }

    public void setEquityType(String equityType) {
        this.equityType = equityType;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNotGetName() {
        return notGetName;
    }

    public void setNotGetName(String notGetName) {
        this.notGetName = notGetName;
    }

    public String getToGetName() {
        return toGetName;
    }

    public void setToGetName(String toGetName) {
        this.toGetName = toGetName;
    }

    public String getToGetLink() {
        return toGetLink;
    }

    public void setToGetLink(String toGetLink) {
        this.toGetLink = toGetLink;
    }

    public String getBigDataId() {
        return bigDataId;
    }

    public void setBigDataId(String bigDataId) {
        this.bigDataId = bigDataId;
    }

    public List<EquityProductDTO> getEquityProductDTOs() {
        return equityProductDTOs;
    }

    public void setEquityProductDTOs(List<EquityProductDTO> equityProductDTOs) {
        this.equityProductDTOs = equityProductDTOs;
    }

    public List<EquityDTO> getEquityDTOs() {
        return equityDTOs;
    }

    public void setEquityDTOs(List<EquityDTO> equityDTOs) {
        this.equityDTOs = equityDTOs;
    }

    public void addEquityDTO(EquityDTO equityDTO){
        if(null == this.equityDTOs){
            this.equityDTOs = new ArrayList<>();
        }
        this.equityDTOs.add(equityDTO);
    }
    public void addEquityProduct(EquityProductDTO equityProductDTO){
        if(null == this.equityProductDTOs){
            this.equityProductDTOs = new ArrayList<>();
        }
        this.equityProductDTOs.add(equityProductDTO);
    }
}
