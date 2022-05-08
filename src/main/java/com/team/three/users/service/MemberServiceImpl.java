package com.team.three.users.service;

import com.team.three.users.domain.Member;
import com.team.three.users.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public Mono<Member> registerMember(Member member) {
        return null;
    }
}
