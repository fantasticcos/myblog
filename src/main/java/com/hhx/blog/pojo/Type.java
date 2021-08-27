package com.hhx.blog.pojo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Type implements Serializable {
    private static final long serialVersionUID = -5514139686858156155L;
    private long tid;
    private String tname;

    private List<Blog> blogs = new LinkedList<>();

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
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

    @Override
    public String toString() {
        return "Type{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                '}';
    }
}
