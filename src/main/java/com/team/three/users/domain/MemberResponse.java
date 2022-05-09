package com.team.three.users.domain;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponse {

    private String userid;

    private String role;

    private String accessToken;

    private String refreshToken;

}
