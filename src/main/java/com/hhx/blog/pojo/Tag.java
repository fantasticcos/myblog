package com.hhx.blog.pojo;

import java.io.Serializable;

public class Tag implements Serializable {
    private static final long serialVersionUID = -5514139686858156155L;
    private long tid;
    private String tname;

    @Override
    public String toString() {
        return "Tag{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                '}';
    }

    public long getTid() {
        return tid;
    }

    public void setTid(long tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}
