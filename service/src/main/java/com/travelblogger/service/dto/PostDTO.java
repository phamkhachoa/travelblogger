package com.travelblogger.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class PostDTO implements Serializable {
    private Integer id;
    private String description;
    private String content;
    private String imgPost;
    private Date createDate;
    private Integer likes;
    private String district;
    private Integer idProvince;
    private Integer idAccount;
    private Integer idTopic;
    private String namePlace;
    private String title;
    private Integer activeFlag;

    public PostDTO() {}

    public PostDTO(Integer id, String description, String content) {
        this.id = id;
        this.description = description;
        this.content = content;
    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public String getImgPost() {
//        return imgPost;
//    }
//
//    public void setImgPost(String imgPost) {
//        this.imgPost = imgPost;
//    }
//
//    public Date getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(Date createDate) {
//        this.createDate = createDate;
//    }
//
//    public Integer getLikes() {
//        return likes;
//    }
//
//    public void setLikes(Integer likes) {
//        this.likes = likes;
//    }
//
//    public String getDistrict() {
//        return district;
//    }
//
//    public void setDistrict(String district) {
//        this.district = district;
//    }
//
//    public Integer getIdProvince() {
//        return idProvince;
//    }
//
//    public void setIdProvince(Integer idProvince) {
//        this.idProvince = idProvince;
//    }
//
//    public Integer getIdAccount() {
//        return idAccount;
//    }
//
//    public void setIdAccount(Integer idAccount) {
//        this.idAccount = idAccount;
//    }
//
//    public Integer getIdTopic() {
//        return idTopic;
//    }
//
//    public void setIdTopic(Integer idTopic) {
//        this.idTopic = idTopic;
//    }
//
//    public String getNamePlace() {
//        return namePlace;
//    }
//
//    public void setNamePlace(String namePlace) {
//        this.namePlace = namePlace;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public Integer getActiveFlag() {
//        return activeFlag;
//    }
//
//    public void setActiveFlag(Integer activeFlag) {
//        this.activeFlag = activeFlag;
//    }
}
