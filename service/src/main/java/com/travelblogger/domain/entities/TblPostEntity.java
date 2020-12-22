package com.travelblogger.domain.entities;

import com.travelblogger.service.dto.PostDTO;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "tbl_post", schema = "travelbloggerapi", catalog = "")
@SqlResultSetMappings(value = {
    @SqlResultSetMapping(name = "mapping1", classes = {
        @ConstructorResult(targetClass = PostDTO.class, columns = {
            @ColumnResult(name = "id", type = Integer.class),
            @ColumnResult(name = "description", type = String.class),
            @ColumnResult(name = "content", type = String.class)
        })
    })
})
public class TblPostEntity {
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

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "img_post")
    public String getImgPost() {
        return imgPost;
    }

    public void setImgPost(String imgPost) {
        this.imgPost = imgPost;
    }

    @Basic
    @Column(name = "create_date")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "likes")
    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @Basic
    @Column(name = "district")
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Basic
    @Column(name = "id_province")
    public Integer getIdProvince() {
        return idProvince;
    }

    public void setIdProvince(Integer idProvince) {
        this.idProvince = idProvince;
    }

    @Basic
    @Column(name = "id_account")
    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    @Basic
    @Column(name = "id_topic")
    public Integer getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(Integer idTopic) {
        this.idTopic = idTopic;
    }

    @Basic
    @Column(name = "name_place")
    public String getNamePlace() {
        return namePlace;
    }

    public void setNamePlace(String namePlace) {
        this.namePlace = namePlace;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "active_flag")
    public Integer getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Integer activeFlag) {
        this.activeFlag = activeFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblPostEntity that = (TblPostEntity) o;
        return Objects.equals(id, that.id) &&
            Objects.equals(description, that.description) &&
            Objects.equals(content, that.content) &&
            Objects.equals(imgPost, that.imgPost) &&
            Objects.equals(createDate, that.createDate) &&
            Objects.equals(likes, that.likes) &&
            Objects.equals(district, that.district) &&
            Objects.equals(idProvince, that.idProvince) &&
            Objects.equals(idAccount, that.idAccount) &&
            Objects.equals(idTopic, that.idTopic) &&
            Objects.equals(namePlace, that.namePlace) &&
            Objects.equals(title, that.title) &&
            Objects.equals(activeFlag, that.activeFlag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, content, imgPost, createDate, likes, district, idProvince, idAccount, idTopic, namePlace, title, activeFlag);
    }
}
