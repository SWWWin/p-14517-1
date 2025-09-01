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
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@RequestScope
@Component
@RequiredArgsConstructor
public class Rq {
    private final HttpServletResponse response;
    private final HttpServletRequest request;
    private final HttpSession session;

    @Getter
    private int count;

    @Getter
    @Setter
    private String name;

    public int increaseCount() {
        return count++;
    }


    public String getCurrentUrl() {
        String url = request.getRequestURL().toString();
        String queryString = request.getQueryString();

        if(queryString != null && queryString.length() > 0) {
            return url + "?" + queryString;
        }

        return url;
    }

    public void setLoginDone(Member member) {
        session.setAttribute("loginedMemberId", member.getId());
        session.setAttribute("loginedmemberUsername", member.getUsername());
        session.setAttribute("loginedmemberEmail", member.getEmail());
        session.setAttribute("loginedmemberName", member.getName());
    }
    public boolean isLogout() {
        return isLogined() == false;
    }
    public boolean isLogined() {
        return getLoginedMemberId() > 0;
    }

    public int getLoginedMemberId() {
        Integer loginedMemberId = (Integer)session.getAttribute("loginedMemberId");
        if(loginedMemberId == null) {
            return 0;
        }
        return loginedMemberId;
    }

    public String getLoginedmemberUsername() {
        return (String) session.getAttribute("loginedmemberUsername");
    }

    public String getLoginedmemberEmail() {
        return (String) session.getAttribute("loginedmemberEmail");
    }


    private String getLoginedMemberName() {
        return (String) session.getAttribute("loginedmemberName");
    }

    public Member getLoginedMember() {
        int id = getLoginedMemberId();
        String username = getLoginedmemberUsername();
        String name = getLoginedMemberName();
        String email = getLoginedmemberEmail();

         return new Member(id, username, name, email);
    }

    public void setLogoutDone() {
        session.removeAttribute("loginedMemberId");
        session.removeAttribute("loginedmemberUsername");
        session.removeAttribute("loginedmemberEmail");
        session.removeAttribute("loginedmemberName");
    }


}
