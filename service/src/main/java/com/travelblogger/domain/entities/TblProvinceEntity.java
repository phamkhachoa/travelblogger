package com.travelblogger.domain.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_province", schema = "travelbloggerapi", catalog = "")
public class TblProvinceEntity {
    private Integer id;
    private String nameProvince;
    private String imgProvince;
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
    @Column(name = "name_province")
    public String getNameProvince() {
        return nameProvince;
    }

    public void setNameProvince(String nameProvince) {
        this.nameProvince = nameProvince;
    }

    @Basic
    @Column(name = "img_province")
    public String getImgProvince() {
        return imgProvince;
    }

    public void setImgProvince(String imgProvince) {
        this.imgProvince = imgProvince;
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
        TblProvinceEntity that = (TblProvinceEntity) o;
        return Objects.equals(id, that.id) &&
            Objects.equals(nameProvince, that.nameProvince) &&
            Objects.equals(imgProvince, that.imgProvince) &&
            Objects.equals(activeFlag, that.activeFlag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameProvince, imgProvince, activeFlag);
    }
}
