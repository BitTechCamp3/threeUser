package com.team.three.users.handler;

import com.team.three.users.domain.Member;
import com.team.three.users.domain.MemberResponse;
import com.team.three.users.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.security.NoSuchAlgorithmException;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserHandler {

    private final MemberService memberService;

    public Mono<ServerResponse> userJoin(ServerRequest request) {
        Mono<Member> userMono = request.bodyToMono(Member.class)
                .flatMap(mem -> {
                    try {
                        return memberService.registerMember(mem);
                    } catch (NoSuchAlgorithmException e) {
                        throw new RuntimeException(e);
                    }
                })
                .log("register : ");

        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(userMono, MemberResponse.class).log(">>>>>memeber");
    }

    public Mono<ServerResponse> userLogin(ServerRequest request) {
        Mono<MemberResponse> mono = request.bodyToMono(Member.class)
                .flatMap(r -> {
                    try {
                        return memberService.getMember(r);
                    } catch (NoSuchAlgorithmException e) {
                        throw new RuntimeException(e);
                    }
                })
                .log();

        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(mono, MemberResponse.class).log(">>>>>memeber");
    }

}
