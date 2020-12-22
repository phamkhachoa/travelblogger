package com.travelblogger.domain.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "tbl_save_post", schema = "travelbloggerapi", catalog = "")
public class TblSavePostEntity {
    private Integer id;
    private Integer idAccount;
    private Integer idPost;
    private Date saveDate;
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
    @Column(name = "id_account")
    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    @Basic
    @Column(name = "id_post")
    public Integer getIdPost() {
        return idPost;
    }

    public void setIdPost(Integer idPost) {
        this.idPost = idPost;
    }

    @Basic
    @Column(name = "save_date")
    public Date getSaveDate() {
        return saveDate;
    }

    public void setSaveDate(Date saveDate) {
        this.saveDate = saveDate;
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
        TblSavePostEntity that = (TblSavePostEntity) o;
        return Objects.equals(id, that.id) &&
            Objects.equals(idAccount, that.idAccount) &&
            Objects.equals(idPost, that.idPost) &&
            Objects.equals(saveDate, that.saveDate) &&
            Objects.equals(activeFlag, that.activeFlag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idAccount, idPost, saveDate, activeFlag);
    }
}
