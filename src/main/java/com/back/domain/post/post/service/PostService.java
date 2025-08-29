package com.back.domain.post.post.service;

import com.back.domain.post.post.dto.Post;
import com.back.domain.post.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }


    public Post findById(int id) {
        return postRepository.findById(id);
    }

    public int create(String title, String content, int memberId) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setMemberId(memberId);
        postRepository.create(post);
        return post.getId();
    }

    public void createV2(String title, String content, int memberId) {
        postRepository.createV2(title, content, memberId);
    }

    public int getLastInsertId() {
        return postRepository.getLastInsertId();
    }

    public void deleteById(int id) {
        postRepository.deleteById(id);
    }

    public void update(int id, String title, String content) {
        postRepository.update(id, title, content);
    }

    public List<Post> search(String title, String s) {
        return postRepository.search(title, s);
    }

    public int deleteByIds(List<Object> ids) {
        if(ids == null || ids.isEmpty()) return 0;

        return postRepository.deleteByIds(ids);
    }

    public List<Post> findAllOrdered(String orderBy, String orderByDirection) {
        return postRepository.findAllOrdered(orderBy, orderByDirection);
    }

    public Post findByIdWithAuthorName(int id) {
        return postRepository.findByIdWithAuthorName(id);
    }

    public List<Post> searchWithAuthorName(String kwType, String kw) {
        return postRepository.searchWithAuthorName(kwType, kw);
    }
}
