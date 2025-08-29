package com.back.domain.post.post.repository;

import com.back.domain.post.post.dto.PostWithAuthor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostWithAuthorRepository {
    List<PostWithAuthor> findAllWithAuthor();
    PostWithAuthor findByIdWithAuthor(int id);
}
