package com.back.global.Rq;

import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
public class Rq {

    @Getter
    private int count;

    public void increateCount(){
        count++;
    }
}
