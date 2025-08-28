package com.back.domain.member.member.service;


import com.back.domain.member.member.dto.Member;
import com.back.domain.member.member.repository.MemberRepository;
import com.back.domain.post.post.dto.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member findById(int id) {
        return memberRepository.findById(id);
    }

    public Member findByUsername(String user2) {
        return memberRepository.findByUsername(user2);
    }

    public int create(String username, String password, String name, String email) {
        Member member = new Member();
        member.setName(name);
        member.setEmail(email);
        member.setPassword(password);
        member.setUsername(username);
        memberRepository.save(member);
        return member.getId();
    }

    public void deleteById(int id) {
        memberRepository.deleteById(id);
    }

    public void update(int id, String username, String password, String name, String email) {
        memberRepository.update(id, username, password, name, email);
    }

    public List<Member> search(String username, String user1) {
        return memberRepository.search(username, user1);
    }
}
