package com.back.global.Rq;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Component
@RequestScope
@RequiredArgsConstructor
public class Rq {
    private final HttpServletResponse res;
    private final HttpServletRequest req;

    @Getter
    private int count;

    @Getter
    @Setter
    private String name;

    public int increaseCount() {
        return count ++;
    }

    public String getCurrentUrl() {
        String url = req.getRequestURL().toString();
        String query = req.getQueryString();

        if(query != null && query.length() > 0) {
            return url + "?" + query;
        }

        return url;
    }
}