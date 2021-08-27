package com.hhx.blog.hadler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotfoundException extends RuntimeException {
    public NotfoundException() {
        super();
    }

    public NotfoundException(String s) {
        super(s);
    }

    public NotfoundException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NotfoundException(Throwable throwable) {
        super(throwable);
    }

    protected NotfoundException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
