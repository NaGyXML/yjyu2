package com.yangjiayu.entity;

import java.util.Date;
import java.util.Objects;

/**
 * Created by 86188 on 2019/8/22.
 */
public class Cart extends  BaseEntity {
    private static final long serialVersionUID = -5715956314312490334L;
    private Integer cid;
    private Integer uid;
    private Integer pid;
    private Integer num;
    private Long price;
    private String createdUser;
    private Date createdTime;
    private String modifiedUser;
    private Date modifiedTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart)) return false;
        Cart cart = (Cart) o;
        return Objects.equals(cid, cart.cid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", pid=" + pid +
                ", num=" + num +
                ", price=" + price +
                ", createdUser='" + createdUser + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", modifiedTime=" + modifiedTime +
                "} " + super.toString();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String getCreatedUser() {
        return createdUser;
    }

    @Override
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    @Override
    public Date getCreatedTime() {
        return createdTime;
    }

    @Override
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String getModifiedUser() {
        return modifiedUser;
    }

    @Override
    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    @Override
    public Date getModifiedTime() {
        return modifiedTime;
    }

    @Override
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
