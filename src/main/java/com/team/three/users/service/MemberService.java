package com.team.three.users.service;

import com.team.three.users.domain.Member;
import reactor.core.publisher.Mono;

public interface MemberService {

    Mono<Member> registerMember(Member member);
}
