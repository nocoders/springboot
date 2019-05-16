package com.run.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class User {
    public User(String pwd, String phone, Date createTime) {
        this.pwd = pwd;
        this.phone = phone;
        this.createTime = createTime;
    }


    private int age;
    /**
     * 密码
     */
    @JsonIgnore
    private String pwd;
    public User(int age, String pwd, Date createTime) {
        this.age = age;
        this.pwd = pwd;
        this.createTime = createTime;
    }

    //    数据库字段起别名
    @JsonProperty("account")
    //    空字段不返回
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String phone;
//    时间格式修改
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",locale="zh",timezone = "GMT+8")
    private Date createTime;


    public User(int age, String pwd, String phone, Date createTime) {
        this.age = age;
        this.pwd = pwd;
        this.phone = phone;
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public User() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
