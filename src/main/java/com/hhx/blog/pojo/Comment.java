package com.hhx.blog.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Comment implements Serializable {
    private static final long serialVersionUID = -5514139686858156155L;

    private Long cid;
    private String cnickname;
    private String cemail;
    private String ccontent;
    private String avatar;
    private Long parentid;
    private Date ccreatetime;
    private Long bid;
    private Long loc;

    public Long getLoc() {
        return loc;
    }

    public void setLoc(Long loc) {
        this.loc = loc;
    }

    private List<Comment>  children;

    private Comment father;
    @Override
    public String toString() {
        return "Comment{" +
                "cid=" + cid +
                ", cnickname='" + cnickname + '\'' +
                ", cemail='" + cemail + '\'' +
                ", ccontent='" + ccontent + '\'' +
                ", avatar='" + avatar + '\'' +
                ", parentid=" + parentid +
                ", loc=" + loc +
                ", createtime=" + ccreatetime +
                '}';
    }

    public List<Comment> getChildren() {
        return children;
    }

    public void setChildren(List<Comment> children) {
        this.children = children;
    }

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public Comment getFather() {
        return father;
    }

    public void setFather(Comment father) {
        this.father = father;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public String getCnickname() {
        return cnickname;
    }

    public void setCnickname(String cnickname) {
        this.cnickname = cnickname;
    }

    public String getCemail() {
        return cemail;
    }

    public void setCemail(String cemail) {
        this.cemail = cemail;
    }

    public String getCcontent() {
        return ccontent;
    }

    public void setCcontent(String ccontent) {
        this.ccontent = ccontent;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCcreatetime() {
        return ccreatetime;
    }

    public void setCcreatetime(Date createtime) {
        this.ccreatetime = createtime;
    }
}
