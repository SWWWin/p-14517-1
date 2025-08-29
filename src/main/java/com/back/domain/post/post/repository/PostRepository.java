package com.back.domain.post.post.repository;

import com.back.domain.post.post.dto.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostRepository {


    List<Post> findAll();

    List<Post> findAllOrdered(
            @Param("orderBy") String orderBy,
            @Param("orderByDirection") String orderByDirection
    );

    Post findById(int id);

    int create(Post post);


    int createV2(String title, String content, int memberId);

    int getLastInsertId();

    void deleteById(int id);

    void update(@Param("id") Integer id,
                @Param("title") String title,
                @Param("content") String content);


    List<Post> search(@Param("kwType") String kwType,
                      @Param("kw") String kw);

    int deleteByIds(@Param("ids") List<Object> ids);


    Post findByIdWithAuthorName(int id);

    List<Post> searchWithAuthorName(String kwType, String kw);
}
