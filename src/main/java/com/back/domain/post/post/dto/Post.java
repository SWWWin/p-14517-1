package com.back.domain.post.post.dto;

import lombok.Data;
import lombok.Getter;


@Data
public class Post {
    private int id;
    private String title;
    private String content;
}
