package com.travelblogger.domain.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_comment_post", schema = "travelbloggerapi", catalog = "")
public class TblCommentPostEntity {
    private Integer id;
    private Integer idPost;
    private Integer idAccount;
    private String comment;
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
    @Column(name = "id_post")
    public Integer getIdPost() {
        return idPost;
    }

    public void setIdPost(Integer idPost) {
        this.idPost = idPost;
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
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        TblCommentPostEntity that = (TblCommentPostEntity) o;
        return Objects.equals(id, that.id) &&
            Objects.equals(idPost, that.idPost) &&
            Objects.equals(idAccount, that.idAccount) &&
            Objects.equals(comment, that.comment) &&
            Objects.equals(activeFlag, that.activeFlag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idPost, idAccount, comment, activeFlag);
    }
}
