package com.back.domain.post.post.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;


@RequiredArgsConstructor
@Data
public class Post {
    private int id;
    private String title;
    private String content;

    private int memberId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;


    public Post(String title, String content) {
    }
}
