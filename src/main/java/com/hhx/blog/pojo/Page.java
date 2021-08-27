package com.hhx.blog.pojo;

import org.springframework.stereotype.Component;

@Component
public class Page {
    private int from;
    private int to;

    public int getFrom() {
        return from;
    }

    public void init(int i)
    {
        if(i>0)
        {
            this.to = i * 4;
            this.from = to - 4;
        }
        else
        {
            this.from=0;
            this.to = 4;
        }
    }
    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }
}
