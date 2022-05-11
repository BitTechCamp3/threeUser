package com.team.three.users.service;

import com.team.three.users.domain.Member;
import com.team.three.users.domain.MemberResponse;
import reactor.core.publisher.Mono;

import java.security.NoSuchAlgorithmException;

public interface MemberService {

    Mono<Member> registerMember(Member member) throws NoSuchAlgorithmException;

    Mono<MemberResponse> getMember(Member member) throws NoSuchAlgorithmException;
}
