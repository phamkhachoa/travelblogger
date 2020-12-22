package com.travelblogger.domain.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_topics", schema = "travelbloggerapi", catalog = "")
public class TblTopicsEntity {
    private Integer id;
    private String nameTopic;
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
    @Column(name = "name_topic")
    public String getNameTopic() {
        return nameTopic;
    }

    public void setNameTopic(String nameTopic) {
        this.nameTopic = nameTopic;
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
        TblTopicsEntity that = (TblTopicsEntity) o;
        return Objects.equals(id, that.id) &&
            Objects.equals(nameTopic, that.nameTopic) &&
            Objects.equals(activeFlag, that.activeFlag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameTopic, activeFlag);
    }
}
