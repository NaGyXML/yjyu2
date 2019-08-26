package com.yangjiayu.entity;

import java.util.Date;
import java.util.Objects;

/**
 * Created by 86188 on 2019/8/8.
 */
public class User extends BaseEntity{
    private static final long serialVersionUID = -462292808694244027L;
    private Integer uid;
    private String username;
    private String password;
    private String salt;
    private Integer gender;
    private String phone;
    private String email;
    private String avatar;
    private Integer isDelete;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(uid, user.uid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid);
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    @Override
    public String getCreatedUser() {
        return super.getCreatedUser();
    }


    @Override
    public void setCreatedUser(String createdUser) {
        super.setCreatedUser(createdUser);
    }

    @Override
    public Date getCreatedTime() {
        return super.getCreatedTime();
    }

    @Override
    public void setCreatedTime(Date createdTime) {
        super.setCreatedTime(createdTime);
    }

    @Override
    public String getModifiedUser() {
        return super.getModifiedUser();
    }

    @Override
    public void setModifiedUser(String modifiedUser) {
        super.setModifiedUser(modifiedUser);
    }

    @Override
    public Date getModifiedTime() {
        return super.getModifiedTime();
    }

    @Override
    public void setModifiedTime(Date modifiedTime) {
        super.setModifiedTime(modifiedTime);
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", isDelete=" + isDelete +
                "} " + super.toString();
    }
}
