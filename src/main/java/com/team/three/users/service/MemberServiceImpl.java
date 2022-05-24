package com.team.three.users.service;

import com.team.three.users.domain.Member;
import com.team.three.users.domain.MemberResponse;
import com.team.three.users.jwt.JwtProvider;
import com.team.three.users.repository.MemberRepository;
import com.team.three.users.util.UserEncrypt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.security.NoSuchAlgorithmException;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    JwtProvider provider;

    @Value("${jwt.accessExpires}")
    private String accessExpiresString;

    @Value("${jwt.refreshExpires}")
    private String refreshExpiresString;

    @Override
    public Mono<Member> registerMember(Member member) throws NoSuchAlgorithmException {
        UserEncrypt en = new UserEncrypt();
        String pwd = en.encrypt(member.getPassword());
        member.setPassword(pwd);
        member.setRole("USER");
        return memberRepository.save(member);
    }

    @Override
    public Mono<MemberResponse> getMember(Member member) throws NoSuchAlgorithmException {
        UserEncrypt en = new UserEncrypt();
        Mono<Member> mem = memberRepository.findByUseridAndPassword(member.getUserid(), en.encrypt(member.getPassword()));

        return mem.flatMap( i -> {
            String accessToken = provider.createJwtToken(i, Long.parseLong(accessExpiresString));
            String refreshToken = provider.createJwtToken(i, Long.parseLong(refreshExpiresString));

            return Mono.just(new MemberResponse(i.getUserid(), i.getRole(), accessToken, refreshToken));
        });
    }
}
