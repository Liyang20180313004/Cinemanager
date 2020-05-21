package xyz.changzhen.cinemanager.models;

import androidx.annotation.NonNull;

import net.lzzy.sqllib.Ignored;
import net.lzzy.sqllib.Sqlitable;

/**
 * @author zhen
 * Description: 电影院模型
 */
public class Cinema extends BaseEntity implements Sqlitable {
    private String name;
    private String province;
    private String city;
    private String district;
    private String location;
    @Ignored    /** 不将该字段映射到数据库字段 */
    static final String COL_LOCATION = "location";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @NonNull
    @Override
    public String toString() {
        return location + name;
    }

    @Override
    public boolean needUpdate() {
        return false;
    }
}
