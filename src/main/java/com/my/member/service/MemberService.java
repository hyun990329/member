package com.my.member.service;

import com.my.member.dto.MemberDto;
import com.my.member.entity.Member;
import com.my.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    // Repository 를 생성자 주입 방법으로 가져오기
    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    // Repository 를 통해 MemberList 가져오기
    public List<MemberDto> gerAllList() {
        List<Member> memberList = repository.findAll();
        System.out.println(memberList);

        // 비어있는 Dto List 만들기
//        List<MemberDto> dtoList = new ArrayList<>();
//
//        // Entity List 를 Dto List 로 변환
//        for(int i = 0; i < memberList.size(); i++) {
//            // List 에 있는 Entity 를 하나씩 읽어서
//            // Dto 에 담는다
//            MemberDto dto = new MemberDto();
//            dto.setId(memberList.get(i).getId());
//            dto.setName(memberList.get(i).getName());
//            dto.setAge(memberList.get(i).getAge());
//            dto.setAddress(memberList.get(i).getAddress());
//            dtoList.add(dto);
//        }

        // fromMemberEntity method로 작업하기
        return memberList
                .stream()
                .map(x -> MemberDto.fromMemberEntity(x))
                .toList();
//        return dtoList;
    }
}
