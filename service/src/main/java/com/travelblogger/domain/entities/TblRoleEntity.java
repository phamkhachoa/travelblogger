package com.travelblogger.domain.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_role", schema = "travelbloggerapi", catalog = "")
public class TblRoleEntity {
    private Integer id;
    private String nameRole;
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
    @Column(name = "name_role")
    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
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
        TblRoleEntity that = (TblRoleEntity) o;
        return Objects.equals(id, that.id) &&
            Objects.equals(nameRole, that.nameRole) &&
            Objects.equals(activeFlag, that.activeFlag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameRole, activeFlag);
    }
}
