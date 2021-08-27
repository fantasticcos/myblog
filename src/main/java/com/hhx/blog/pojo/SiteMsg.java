package com.hhx.blog.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class SiteMsg implements Serializable {
    private static final long serialVersionUID = -5514139686858156155L;
    private int visitnum;
    private int totalnum;
    private int comnum;
    private int leftmsgnum;
    private LocalDateTime duration;

    public LocalDateTime getDuration() {
        return duration;
    }

    public void setDuration(LocalDateTime duration) {
        this.duration = duration;
    }

    public int getVisitnum() {
        return visitnum;
    }

    public void setVisitnum(int visitnum) {
        this.visitnum = visitnum;
    }

    public int getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(int totalnum) {
        this.totalnum = totalnum;
    }

    public int getComnum() {
        return comnum;
    }

    public void setComnum(int comnum) {
        this.comnum = comnum;
    }

    public int getLeftmsgnum() {
        return leftmsgnum;
    }

    public void setLeftmsgnum(int leftmsgnum) {
        this.leftmsgnum = leftmsgnum;
    }
}
