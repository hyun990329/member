package com.my.member.service;

import com.my.member.entity.Member;
import com.my.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MemberService {
    // Repository 를 생성자 주입 방법으로 가져오기
    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    // Repository 를 통해 MemberList 가져오기
    public List<Member> gerAllList() {
        List<Member> memberList = repository.findAll();
        System.out.println(memberList);
        return memberList;
    }
}
