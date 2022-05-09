package com.team.three.users.router;

import com.team.three.users.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class UserRouter {
    @Bean
    public RouterFunction<ServerResponse> route(UserHandler userHandler) {
        return RouterFunctions
                .route(POST("/user/join").and(accept(MediaType.APPLICATION_JSON)), userHandler::userJoin) // 가입
                .andRoute(POST("/user/login").and(accept(MediaType.APPLICATION_JSON)), userHandler::userLogin) // 로그인
                ;
    }
}
