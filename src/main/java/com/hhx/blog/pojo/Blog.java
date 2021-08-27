package com.hhx.blog.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Blog implements Serializable {
    private static final long serialVersionUID = -5514139686858156155L;

    private Long bid;
    private String btitle;
    private String bcontent;
    private String firstpicture;
    private String bflag;
    private int bview;
    private boolean bprice;
    private boolean bstatus;
    private boolean commentable;
    private boolean published;
    private boolean recomend;
    private Date createtime;
    private Date updateTime;
    private Long type;
    private String bdes;
    private String typename;


    private List<Comment> comments = new LinkedList<>();

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "bid=" + bid +
                ", btitle='" + btitle + '\'' +
                ", bcontent='" + bcontent + '\'' +
                ", firstpictrue='" + firstpicture + '\'' +
                ", bflag='" + bflag + '\'' +
                ", bview=" + bview +
                ", bprice=" + bprice +
                ", bstatus=" + bstatus +
                ", commentable=" + commentable +
                ", published=" + published +
                ", recomend=" + recomend +
                ", createTime=" + createtime +
                ", updateTime=" + updateTime +
                ", type=" + type +
                '}';
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getBdes() {
        return bdes;
    }

    public void setBdes(String bdes) {
        this.bdes = bdes;
    }

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }

    public String getBcontent() {
        return bcontent;
    }

    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }

    public String getFirstpicture() {
        return firstpicture;
    }

    public void setFirstpicture(String firstpictrue) {
        this.firstpicture = firstpictrue;
    }

    public String getBflag() {
        return bflag;
    }

    public void setBflag(String bflag) {
        this.bflag = bflag;
    }

    public int getBview() {
        return bview;
    }

    public void setBview(int bview) {
        this.bview = bview;
    }

    public boolean isBprice() {
        return bprice;
    }

    public void setBprice(boolean bprice) {
        this.bprice = bprice;
    }

    public boolean isBstatus() {
        return bstatus;
    }

    public void setBstatus(boolean bstatus) {
        this.bstatus = bstatus;
    }

    public boolean isCommentable() {
        return commentable;
    }

    public void setCommentable(boolean commentable) {
        this.commentable = commentable;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public boolean isRecomend() {
        return recomend;
    }

    public void setRecomend(boolean recomend) {
        this.recomend = recomend;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createTime) {
        this.createtime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }
}
