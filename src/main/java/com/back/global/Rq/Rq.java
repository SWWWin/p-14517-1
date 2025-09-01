package com.back.global.Rq;

import com.back.domain.member.member.dto.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
    private final HttpSession session;

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

    public String getLoginedMemberName() {
        return (String) session.getAttribute("loginedMemberName");
    }

    public void setLoginDone(Member member) {
        session.setAttribute("loginMemberId", member.getId());
        session.setAttribute("loginMemberUsername", member.getUsername());
        session.setAttribute("loginMemberName", member.getName());
        session.setAttribute("loginMemberEmail", member.getEmail());
    }

    public void setLogoutDone() {
        session.removeAttribute("loginMemberId");
        session.removeAttribute("loginMemberUsername");
        session.removeAttribute("loginMemberName");
        session.removeAttribute("loginMemberEmail");
    }

    private final HttpSession httpSession;
}